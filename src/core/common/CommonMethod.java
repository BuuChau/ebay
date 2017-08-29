package core.common;

import com.ebay.sdk.call.GetItemCall;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.ListingDetailsType;
import com.ebay.soap.eBLBaseComponents.SellingStatusType;
import com.ebay.soap.eBLBaseComponents.UserType;
import core.model.reponse.ItemCategory;

/**
 * Created by phuoclt on 8/29/17.
 */
public class CommonMethod {

    public static ItemCategory category(GetItemCall gc, String itemId) throws Exception {

        ItemCategory category = new ItemCategory();
        //Enter ID of the item that you want to get
        ItemType item = gc.getItem(itemId);
        // [3] Display result.
        System.out.println("===== [3] Display Returned Item Information ====");

        category.setItemType(item.getListingType().toString());
        category.setTitle(item.getTitle());
        category.setUrl(item.getListingDetails().getViewItemURL());
        category.setStartPrice(String.valueOf(item.getStartPrice().getValue()));
        category.setQuantity(item.getQuantity().toString());
        category.setTitle(item.getSeller().getFeedbackScore().toString());
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

        return category;
    }
}
