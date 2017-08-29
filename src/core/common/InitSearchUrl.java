package core.common;

import core.model.search.FeedBack;
import core.model.search.Sold;
import core.model.search.SortBy;
import core.model.search.listing.Listing;

import java.io.Serializable;

/**
 * Created by phuoclt on 8/29/17.
 */
public class InitSearchUrl implements Serializable {

    public static String url = null;
    public static SortBy sortBy = new SortBy();
    public static Sold sold = new Sold();
    public static FeedBack feedBack = new FeedBack();
    public static Listing listing = new Listing();

    public static void reset(){
        url = null;
        sortBy = new SortBy();
        sold = new Sold();
        feedBack = new FeedBack();
        listing = new Listing();
    }

    public static String searchWithUrl(String located){
        StringBuffer buffer = new StringBuffer();

        String[] strings = url.split("&");
        if (url.contains("&_salic=")) {
            for (String str : strings){
                if (str.contains("&_salic="))
                    buffer.append(located);
                else if (str.equals(strings[0]))
                    buffer.append(str);
                else
                    buffer.append("&"+str);
            }
        }
        else
            buffer.append(url).append(located);
        return buffer.toString();
    }
}
