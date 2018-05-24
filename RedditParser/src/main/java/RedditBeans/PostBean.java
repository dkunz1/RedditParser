package RedditBeans;

import net.dean.jraw.models.EmbeddedMedia;
import net.dean.jraw.models.Submission;
import net.dean.jraw.models.SubredditSort;
import net.dean.jraw.models.VoteDirection;

import java.util.Date;

public class PostBean {
    private String id;
    private String author;
    private String authorFlair;
    private String postFlair;
    private String title;
    private String postHint;
    private EmbeddedMedia media;
    private String domain;
    private String selfText;
    private String subreddit;
    private Integer karma;
    private Integer commentCount;
    private Date creationDate;
    private Date editDate;
    private Integer reports;
    private boolean isLocked;
    private boolean isQuarantine;
    private boolean isNsfw;
    private VoteDirection vote;

    public PostBean(Submission p) {
        this.id = p.getId();
        this.author = p.getAuthor();
        this.authorFlair = p.getAuthorFlairText();
        this.postFlair = p.getLinkFlairText();
        this.title = p.getTitle();
        this.postHint = p.getPostHint();
        this.media = p.getEmbeddedMedia();
        this.domain = p.getDomain();
        this.selfText = p.getSelfText();
        this.subreddit = p.getSubreddit();
        this.karma = p.getScore();
        this.commentCount = p.getCommentCount();
        this.creationDate = p.getCreated();
        this.editDate = p.getEdited();
        this.reports = p.getReports();
        this.isLocked = p.isLocked();
        this.isNsfw = p.isNsfw();
        this.vote = p.getVote();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorFlair() {
        return authorFlair;
    }

    public void setAuthorFlair(String authorFlair) {
        this.authorFlair = authorFlair;
    }

    public String getPostFlair() {
        return postFlair;
    }

    public void setPostFlair(String postFlair) {
        this.postFlair = postFlair;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostHint() {
        return postHint;
    }

    public void setPostHint(String postHint) {
        this.postHint = postHint;
    }

    public EmbeddedMedia getMedia() {
        return media;
    }

    public void setMedia(EmbeddedMedia media) {
        this.media = media;
    }

    public String getSelfText() {
        return selfText;
    }

    public void setSelfText(String selfText) {
        this.selfText = selfText;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public Integer getKarma() {
        return karma;
    }

    public void setKarma(Integer karma) {
        this.karma = karma;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public Integer getReports() {
        return reports;
    }

    public void setReports(Integer reports) {
        this.reports = reports;
    }

    public boolean isNsfw() {
        return isNsfw;
    }

    public void setNsfw(boolean nsfw) {
        isNsfw = nsfw;
    }

    public VoteDirection getVote() {
        return vote;
    }

    public void setVote(VoteDirection vote) {
        this.vote = vote;
    }

}
