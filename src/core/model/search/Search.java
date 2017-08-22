package core.model.search;

import core.model.search.listing.Listing;

import java.io.Serializable;

public class Search implements Serializable {

    Keywords keywords;
    KeywordOptions keywordOptions;
    ExcludeWords excludeWords;
    Category category;
    PriceFrom priceFrom;
    PriceTo priceTo;
    Auction auction;
    BuyItNow buyItNow;
    Condition condition;
    Listing listing;
    Shipping shipping;
    Located located;
    SortBy sortBy;
    PageSize pageSize;

    public Keywords getKeywords() {
        return keywords;
    }

    public void setKeywords(Keywords keywords) {
        this.keywords = keywords;
    }

    public KeywordOptions getKeywordOptions() {
        return keywordOptions;
    }

    public void setKeywordOptions(KeywordOptions keywordOptions) {
        this.keywordOptions = keywordOptions;
    }

    public ExcludeWords getExcludeWords() {
        return excludeWords;
    }

    public void setExcludeWords(ExcludeWords excludeWords) {
        this.excludeWords = excludeWords;
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

    public Located getLocated() {
        return located;
    }

    public void setLocated(Located located) {
        this.located = located;
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
