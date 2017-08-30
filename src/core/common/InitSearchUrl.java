package core.common;

import core.model.search.FeedBack;
import core.model.search.Located;
import core.model.search.Sold;
import core.model.search.SortBy;
import core.model.search.listing.Listing;

import java.io.Serializable;
import java.util.List;

/**
 * Created by phuoclt on 8/29/17.
 */
public class InitSearchUrl implements Serializable {

    public static String url = null;

    public static void reset(){
        url = null;
    }
}
