package core.common;

import core.model.search.*;
import core.model.search.listing.Listing;

import java.util.*;

/**
 * Created by phuoclt on 8/15/17.
 */
public class InitCommon {

    public static Keywords keywords = new Keywords();
    public static Category category = new Category();
    public static PriceFrom priceFrom = new PriceFrom();
    public static PriceTo priceTo = new PriceTo();
    public static Auction auction = new Auction();
    public static BuyItNow buyItNow = new BuyItNow();
    public static Condition condition = new Condition();
    public static Listing listing = new Listing();
    public static Shipping shipping = new Shipping();
    public static List<Located> locateds = new ArrayList<>();
    public static SortBy sortBy = new SortBy();
    public static Sold sold = new Sold();
    public static FeedBack feedBack = new FeedBack();
    public static PageSize pageSize = new PageSize();
}
