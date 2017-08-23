package core.api.thread;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
import com.ebay.sdk.call.GetItemCall;
import com.ebay.soap.eBLBaseComponents.*;
import core.model.reponse.ItemCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cuongnv on 8/23/17.
 */
public class SearchItemService implements Runnable {

    final String TOKEN = "AgAAAA**AQAAAA**aAAAAA**rQGbWQ**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6AAloWnD5SAowmdj6x9nY+seQ**ItsDAA**AAMAAA**s4pjp8Zn/S3D7UlD5ZCarYyoBcccEwYy4pHpakOKt4gO0dfA8ebtxgW2GJDoSw6IIX9ioc++6rkOUfznlZeXk0Jitahvc9U9PnS+9EaNcqDQzgJkxpfrutVYRVblQddl37/7y9LpVJ48JwGHoXiBGQngev14YI3UCFeGenrVAqwe02bfQOyH4WYxsaGm4nRiDCwAGxWZVG9jnyI2m3mLx+UiS8kcEZQCQHyPaW/DP3lhdxovWSgbpxWxfS15GIZMMPHE2zIwTTNMAl8TH1ocO4c2LaFuRrg0Ji1GD+ZtWs2PbVt6rkMWH6qiEAZj9x8G6i0SkGahzgVqhhwrrSG8bamL8bYxv1g32AxisDwNRS6LfuhWqsfA0laitrYvBVsfdpvjfAPmhtvmKHEk+9vJcrmcaCV4w7UrxB90ts339o+bIV4ZX4rcmpO/VER6SiRqGdZOBhYzu3l7eEyShADkJupH7Y0QsKk1yQ1EAi4h4Rf2EaM/w+oLTLYZrZ9ruxe9CkN2TUOQeHdO04RIe73XzE0P//zjsQusCGc9TEHPzYhoDhHNAZjJr/ebwFcU3zR8KWM6lRHDM61oAC4s3sI6EdjHxhgVoBqP036h/mIwQTqhKfnI+bcNXXbLa6xABaage/PX2XFPs2P2x0fU90eNf9vsTqacNjBvYujn9W1mnI/HpaaxFACQ/n9Bs+fW7XOMQm92vaXN2rwVKx1vuB8UxwV59HJaNHVslKki8xQPUqc4zdbVVfajnEizcAT9r1ww";
    final String WEB_SERVICE = "https://api.ebay.com/wsapi";

    String itemId;
    List<ItemCategory> itemCategories;
    public SearchItemService(String itemId,List<ItemCategory> itemCategories) {
        this.itemId = itemId;
        this.itemCategories = itemCategories;
    }

    @Override
    public void run() {
        categories(itemId);
    }

    private void categories(String itemId){
        try {
            // [1] Create ApiContext object.
            System.out.println("===== [1] Collect Account Information ====");
            ApiContext apiContext = new ApiContext();
            ApiCredential cred = apiContext.getApiCredential();

            // Enter your eBay Authentication Token
            cred.seteBayToken(TOKEN);

            // Enter eBay SOAP server URL (e.g., https://api.ebay.com/wsapi)
            apiContext.setApiServerUrl(WEB_SERVICE);

            // [2] Ask for itemID.
            System.out.println("===== [2] Call GetItemCall ====");

            GetItemCall gc = new GetItemCall(apiContext);
            DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[]{
                    DetailLevelCodeType.RETURN_ALL,
                    DetailLevelCodeType.ITEM_RETURN_ATTRIBUTES,
                    DetailLevelCodeType.ITEM_RETURN_DESCRIPTION
            };
            gc.setDetailLevel(detailLevels);

            ItemCategory category = new ItemCategory();
            //Enter ID of the item that you want to get
            ItemType item = gc.getItem(itemId);
            // [3] Display result.
            System.out.println("===== [3] Display Returned Item Information ====");

            category.setItemType(item.getListingType().toString());
            category.setTitle(item.getTitle());
            category.setStartPrice(String.valueOf(item.getStartPrice().getValue()));
            category.setQuantity(item.getQuantity().toString());
            category.setPrimaryCategory(item.getPrimaryCategory().getCategoryID());
            SellingStatusType sst = item.getSellingStatus();
            category.setCurrentPrice(String.valueOf(sst.getCurrentPrice().getValue()));
            category.setBidCount(sst.getBidCount().toString());
            category.setQuantitySold(sst.getQuantitySold() == null ? "" : sst.getQuantitySold().toString());

            ListingDetailsType ldt = item.getListingDetails();
            UserType hb = sst.getHighBidder();
            if (hb != null)
                category.setHighBidder(hb.getUserID());

            category.setStartTime(String.valueOf(ldt.getStartTime().getTime()));
            category.setEndTime(String.valueOf(ldt.getEndTime().getTime()));

            itemCategories.add(category);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
