package core.model.reponse;

import java.io.Serializable;

/**
 * Created by phuoclt on 8/15/17.
 */
public class ItemCategory implements Serializable {

    String url;
    String title;
    String condition;
    String typeCup;

    String itemId;
    String ItemType;

    String StartPrice;
    String Quantity;
    String PrimaryCategory;
    String CurrentPrice;
    String BidCount;
    String QuantitySold;
    String HighBidder;
    String StartTime;
    String EndTime;

    public String getItemId() {
        return itemId;
    }

    public String getTypeCup() {
        return typeCup;
    }

    public void setTypeCup(String typeCup) {
        this.typeCup = typeCup;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public ItemCategory() {
    }

    public String getItemType() {
        return ItemType;
    }

    public String getTitle() {
        return title;
    }

    public String getStartPrice() {
        return StartPrice;
    }

    public String getQuantity() {
        return Quantity;
    }

    public String getPrimaryCategory() {
        return PrimaryCategory;
    }

    public String getCurrentPrice() {
        return CurrentPrice;
    }

    public String getBidCount() {
        return BidCount;
    }

    public String getQuantitySold() {
        return QuantitySold;
    }

    public String getHighBidder() {
        return HighBidder;
    }

    public String getStartTime() {
        return StartTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public ItemCategory(String itemId, String itemType, String title, String startPrice, String quantity, String primaryCategory, String currentPrice, String bidCount, String quantitySold, String highBidder, String startTime, String endTime) {
        this.itemId = itemId;
        ItemType = itemType;
        title = title;

        StartPrice = startPrice;
        Quantity = quantity;
        PrimaryCategory = primaryCategory;
        CurrentPrice = currentPrice;
        BidCount = bidCount;
        QuantitySold = quantitySold;
        HighBidder = highBidder;
        StartTime = startTime;
        EndTime = endTime;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setItemType(String itemType) {
        ItemType = itemType;
    }

    public void setTitle(String title) {
        title = title;
    }

    public void setStartPrice(String startPrice) {
        StartPrice = startPrice;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public void setPrimaryCategory(String primaryCategory) {
        PrimaryCategory = primaryCategory;
    }

    public void setCurrentPrice(String currentPrice) {
        CurrentPrice = currentPrice;
    }

    public void setBidCount(String bidCount) {
        BidCount = bidCount;
    }

    public void setQuantitySold(String quantitySold) {
        QuantitySold = quantitySold;
    }

    public void setHighBidder(String highBidder) {
        HighBidder = highBidder;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }
}
