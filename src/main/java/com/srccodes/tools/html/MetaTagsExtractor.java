package com.srccodes.tools.html;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author Abhijit Ghosh
 * @version 1.0
 */
public class MetaTagsExtractor {
	public static String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_4) AppleWebKit/536.30.1 (KHTML, like Gecko) Version/6.0.5 Safari/536.30.1";
	
    public static void main(String... args) throws IOException {
        // Fetch the specified URL and parse to a HTML DOM
        Document doc = Jsoup.connect("http://www.yoursite.com/").userAgent(userAgent)
				.timeout(10000)
				.followRedirects(true)
				.get();

        // Get all meta tags
        Elements metaTags = doc.select("meta");
        System.out.println(metaTags);
        
        System.out.println("************************************\n");
        
        // Get a specific (say description) meta tag
        Element descriptionMetaTag = doc.select("meta[name=description]").first();
        System.out.println(descriptionMetaTag);
        
        // Get content of the above description meta tag 
        System.out.println("content : " + descriptionMetaTag.attr("content"));
    }
}
