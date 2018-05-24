package RedditBeans;

import net.dean.jraw.models.PublicContribution;
import net.dean.jraw.models.VoteDirection;

import java.util.Date;

public class CommentBean {
    private String referncepostId;
    private String id;
    private int  depth;
    private String author;
    private String commentText;
    private int childCount;
    private  Date created;
    private Date edited;
    private String subreddit;
    private int score;
    private VoteDirection voteDirection;

    public CommentBean( String postId, PublicContribution<?> comment, int depth, int totalSize ) {
        this.referncepostId = postId;
        this.id = comment.getId();
        this.depth = depth;
        this.author = comment.getAuthor();
        this.commentText = comment.getBody();
        this.childCount = totalSize;
        this.created = comment.getCreated();
        this.edited = comment.getEdited();
        this.subreddit = comment.getSubreddit();
        this.score = comment.getScore();
        this.voteDirection = comment.getVote();
    }

    public String getReferncepostId() {
        return referncepostId;
    }

    public void setReferncepostId(String referncepostId) {
        this.referncepostId = referncepostId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public int getChildCount() {
        return childCount;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getEdited() {
        return edited;
    }

    public void setEdited(Date edited) {
        this.edited = edited;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public VoteDirection getVoteDirection() {
        return voteDirection;
    }

    public void setVoteDirection(VoteDirection voteDirection) {
        this.voteDirection = voteDirection;
    }
}
