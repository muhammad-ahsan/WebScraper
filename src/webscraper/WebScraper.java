/*
 * MUHAMMAD Ahsan
 * <muhammad.ahsan@gmail.com>
 */
package webscraper;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

public class WebScraper {

    /**
     * @param args 
     */
    public static void main(String[] args) throws IOException {

        String s = ScrapHTML("http://en.wikipedia.org/wiki/Main_Page");
        System.out.println("The content of document ...........");
        System.out.println(s);
        int c =10;
    }

    public static String ScrapHTML(String URI) throws IOException {

        org.jsoup.nodes.Document doc;
        try {
            // Loading the page
            if (URI.isEmpty()) {
                doc = Jsoup.connect("http://en.wikipedia.org/wiki/Algorithm").get();
            } else {
                doc = Jsoup.connect(URI).get();
            }

            // Reading only paragraphs
            Elements ps = doc.select("p");
            return ps.text();
        } catch (Exception e) {
            throw new IllegalArgumentException(e.toString());
        }
    }
}
