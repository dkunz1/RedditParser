import RedditBeans.CommentBean;
import RedditBeans.PostBean;

import java.util.ArrayList;
import java.util.List;

public class CassandraDAO {
    List<PostBean> postList = new ArrayList<>();
    List<CommentBean> commentList = new ArrayList<>();
    public boolean safePost(List<PostBean> posts) {
        postList = posts;
        return true;
    }

    public boolean safeComments(List<CommentBean> comments) {
        commentList =  comments;
        return true;
    }

    public List<String> getUserNames() {
        List<String> userNames = new ArrayList<>();
        userNames.add("Yoda_Holmes");
        //userNames.add("rrrobot_");
        return userNames;
    }
}
