package core.common;

import core.model.search.*;
import core.model.search.listing.Listing;

import java.util.*;

/**
 * Created by phuoclt on 8/15/17.
 */
public class InitSearchForm {

    public static Keywords keywords = new Keywords();
    public static Category category = new Category();
    public static PriceFrom priceFrom = new PriceFrom();
    public static PriceTo priceTo = new PriceTo();
    public static Auction auction = new Auction();
    public static BuyItNow buyItNow = new BuyItNow();
    public static Condition condition = new Condition();
    public static Listing listing = new Listing();
    public static Shipping shipping = new Shipping();
    public static SortBy sortBy = new SortBy();
    public static Sold sold = new Sold();
    public static FeedBack feedBack = new FeedBack();
    public static PageSize pageSize = new PageSize();

    public static void reset(){
        keywords = new Keywords();
        category = new Category();
        priceFrom = new PriceFrom();
        priceTo = new PriceTo();
        auction = new Auction();
        buyItNow = new BuyItNow();
        condition = new Condition();
        listing = new Listing();
        shipping = new Shipping();
        sortBy = new SortBy();
        sold = new Sold();
        feedBack = new FeedBack();
        pageSize = new PageSize();
    }

    public static String searchWithCondition(){
        StringBuffer buffer = new StringBuffer();
        buffer.append("https://www.ebay.com/sch/i.html?_from=R40");
        buffer.append(keywords.toString());
        if (category.getValue() != null)
            buffer.append(category.toString());
        if (priceFrom.getValue() != null)
            buffer.append(priceFrom.toString());
        if (priceTo.getValue() != null)
            buffer.append(priceTo.toString());
        if (auction.getValue() != null)
            buffer.append(auction.toString());
        if (buyItNow.getValue() != null)
            buffer.append(buyItNow.toString());
        if (condition.getValue() != null)
            buffer.append(condition.toString());

        // add location
        buffer.append("%s");

        if (sortBy.getValue() != null)
            buffer.append(sortBy.toString());
        if (listing.getTypeTime().getValue() != null)
            buffer.append(listing.getTypeTime().toString());
        if (listing.getListHour().getValue() != null)
            buffer.append(listing.getListHour().toString());

        buffer.append("&_pgn=%s&_skc=200");
        return buffer.toString();
    }
}
