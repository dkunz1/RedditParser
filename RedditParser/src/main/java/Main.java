import net.dean.jraw.RedditClient;
import net.dean.jraw.http.NetworkAdapter;
import net.dean.jraw.http.OkHttpNetworkAdapter;
import net.dean.jraw.http.UserAgent;
import net.dean.jraw.oauth.Credentials;
import net.dean.jraw.oauth.OAuthHelper;

import java.util.List;
import java.util.concurrent.Executor;

public class Main {

    public static void main(String [] args) {
        UserAgent userAgent = new UserAgent("myscript", "com.test.myscript", "v0.1", "sir_slut");
        Credentials credentials  = Credentials.script("sir_slut", "4ccount4Fun", "UK6BjoRipWi8UA", "mhTYEWWvNboL3uuFeFITr6BzFR0");
        NetworkAdapter adapter = new OkHttpNetworkAdapter(userAgent);
        RedditClient reddit = OAuthHelper.automatic(adapter, credentials);
        CassandraDAO dao = new CassandraDAO();
        RedditCrawler crawler = new RedditCrawler(reddit,dao);

        crawler.crawlSub("de");
        crawler.crawlUser();
//System.out.println("author: "+p.getAuthor()+" title: "+p.getTitle()+" flair: "+p.getAuthorFlairText()+" creationTime: "+p.getCreated())
        //de.comments().limit(Paginator.RECOMMENDED_MAX_LIMIT).build().next().forEach(c ->System.out.println("Bezugs Post: "+c.getSubmissionTitle()+" Autor: "+c.getAuthor()+" erstellt am: "+" text: "+c.getBody()));

    }
}
