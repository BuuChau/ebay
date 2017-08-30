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
    public static Shipping shipping = new Shipping();

    public static void reset(){
        keywords = new Keywords();
        category = new Category();
        priceFrom = new PriceFrom();
        priceTo = new PriceTo();
        auction = new Auction();
        buyItNow = new BuyItNow();
        condition = new Condition();
        shipping = new Shipping();
    }
}
