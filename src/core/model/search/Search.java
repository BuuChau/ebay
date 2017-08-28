package core.model.search;

import core.model.search.listing.Listing;

import java.io.Serializable;
import java.util.List;

public class Search implements Serializable {

    Keywords keywords;
    Category category;
    PriceFrom priceFrom;
    PriceTo priceTo;
    Auction auction;
    BuyItNow buyItNow;
    Condition condition;
    Listing listing;
    Shipping shipping;
    List<Located> locateds;
    SortBy sortBy;
    Sold sold;
    FeedBack feedBack;
    PageSize pageSize;

    public Sold getSold() {
        return sold;
    }

    public FeedBack getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(FeedBack feedBack) {
        this.feedBack = feedBack;
    }

    public void setSold(Sold sold) {
        this.sold = sold;
    }

    public Keywords getKeywords() {
        return keywords;
    }

    public void setKeywords(Keywords keywords) {
        this.keywords = keywords;
    }

    public PriceFrom getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(PriceFrom priceFrom) {
        this.priceFrom = priceFrom;
    }

    public PriceTo getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(PriceTo priceTo) {
        this.priceTo = priceTo;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public BuyItNow getBuyItNow() {
        return buyItNow;
    }

    public void setBuyItNow(BuyItNow buyItNow) {
        this.buyItNow = buyItNow;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Listing getListing() {
        return listing;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public List<Located> getLocateds() {
        return locateds;
    }

    public void setLocateds(List<Located> locateds) {
        this.locateds = locateds;
    }

    public SortBy getSortBy() {
        return sortBy;
    }

    public void setSortBy(SortBy sortBy) {
        this.sortBy = sortBy;
    }

    public PageSize getPageSize() {
        return pageSize;
    }

    public void setPageSize(PageSize pageSize) {
        this.pageSize = pageSize;
    }

    public Search() {

    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
