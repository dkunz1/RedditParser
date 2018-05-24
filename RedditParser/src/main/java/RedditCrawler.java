import RedditBeans.CommentBean;
import RedditBeans.PostBean;
import net.dean.jraw.RedditClient;
import net.dean.jraw.models.*;
import net.dean.jraw.pagination.DefaultPaginator;
import net.dean.jraw.pagination.Paginator;
import net.dean.jraw.references.OtherUserReference;
import net.dean.jraw.references.SubmissionReference;
import net.dean.jraw.references.SubredditReference;
import net.dean.jraw.tree.CommentNode;

import java.util.*;

public class RedditCrawler {
    private final RedditClient client;
    private  final CassandraDAO dao;

    public RedditCrawler(RedditClient client, CassandraDAO dao) {
        this.client = client;
        this.dao = dao;
    }

    public void crawlSub(String subredditname) {
        SubredditReference subreddit = client.subreddit(subredditname);
        List<DefaultPaginator<Submission>> top = new ArrayList<>();
        DefaultPaginator<Submission> posts = subreddit.posts().limit(Paginator.RECOMMENDED_MAX_LIMIT).sorting(SubredditSort.TOP).timePeriod(TimePeriod.DAY).build();

        List<String> postIds = new ArrayList<>();
        List<PostBean> postList = new ArrayList<>();
        posts.next().forEach(p -> {
            PostBean bean = new PostBean(p);
            System.out.println("post title: "+p.getTitle());
            //System.out.println("postid :"+bean.getId());
            postIds.add(p.getId());
            postList.add(bean);
            //iterator.forEachRemaining(i -> System.out.println(i.getSubject().getAuthor()+": "+i.getSubject().getBody()));
        });
        dao.safePost(postList);
        crawlCommentsForPostIds(postIds);



    }

    public void crawlUser() {
        List<String> userNames = dao.getUserNames();
        List<String> posts = new ArrayList<>();
        List<String> comments = new ArrayList<>();
        userNames.forEach(name->{
            OtherUserReference user = client.user(name);
            //Account about = user.about();
            //about.getCommentKarma();
            //about.getCreated();
            System.out.println("name: "+user.getUsername());
            DefaultPaginator.Builder<PublicContribution<?>, UserHistorySort> submitted = user.history("submitted");
            submitted.limit(Paginator.RECOMMENDED_MAX_LIMIT)
                    .build().iterator().forEachRemaining(r->r.forEach(e ->posts.add(e.getId())));
            DefaultPaginator.Builder<PublicContribution<?>, UserHistorySort> commented = user.history("comments");
            submitted.limit(Paginator.RECOMMENDED_MAX_LIMIT)
                    .build().iterator().forEachRemaining(r->r.forEach(e ->comments.add(e.getId())));
        });
        crawlCommentsForPostIds(comments);
        crawlPostForIds(posts);
    }


    private void crawlPostForIds(List<String> postIds) {
        List<PostBean> postList = new ArrayList<>();
        postIds.forEach(postId->{
            Submission post = client.submission(postId).inspect();
            PostBean bean = new PostBean(post);
            postList.add(bean);
        });
        dao.safePost(postList);
    }

    private void crawlCommentsForPostIds(List<String> commentIds){
        List<CommentBean> commentList = new ArrayList<>();
        commentIds.forEach(commentId ->{
            Iterator<CommentNode<PublicContribution<?>>> iterator = client.submission(commentId).comments().walkTree().iterator();
            iterator.forEachRemaining(i -> {
                PublicContribution<?> subject = i.getSubject();
                if(!subject.getId().equals(commentId)) {
                    CommentBean comment = new CommentBean(commentId,subject,i.getDepth(),i.totalSize());
                    System.out.println("comment id: "+comment.getId());
                    System.out.println("author: "+comment.getAuthor());
                    System.out.println("comment text: "+comment.getCommentText());
                    System.out.println("comment depth: "+i.getDepth());
                    commentList.add(comment);
                }
            });
        });
        dao.safeComments(commentList);
    }
}
