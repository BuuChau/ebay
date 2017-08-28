package core.service;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
import com.ebay.sdk.call.GetItemCall;
import com.ebay.soap.eBLBaseComponents.*;
import core.common.InitCommon;
import core.model.reponse.ItemCategory;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Created by phuoclt on 8/15/17.
 */
public class SearchService {
    static final String TOKEN = "AgAAAA**AQAAAA**aAAAAA**zfufWQ**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6ACloGkAZCCqAmdj6x9nY+seQ**m94DAA**AAMAAA**qGfV5bguycJAJ1jpqosN9brHLCn6ypjCHBNY6nFTjAiT8C2BEusJD0qSClnVBPBp13TW+iX/8Acq8omBZkTMmwbbjk6m/WlbxWzARNqvZ4Fb3bLRPEpCoCgKJW+2AhQTfcV+Wz0f2Dq9XknV9b0tGnw9Vu8B93A4rwFeErkp2BDVSkx2vTCjZpaYp6tvJFxtZEibNdc73a7JBKPQmBHruL/fiAo7koFxFB2SEAOOyNBrDObvXHu7f9Kvqp/MiWn7TD7krZMkJFKOgRE3R6MUUtJpAf+4+h6+VOGkdykpUEDQ91Ejdi/hd7pEw6ApLCytZ76qyEVAGmts6GWt84gjHT1G5JpvaexJd0E41fXu1z8+AQOUBC40YwGe7zIdIcCxVWMpHbO7tdfV7eCXPtmr0lNuNp6xIg1HiCwVBE7uogCaqxutZYPT8mW6iz0fg7SfcwM0zTnL1CMwVgtQ4mUmUR43bMlOS7c8WJyqsTTzGT3iHc5uXVfnsZFBJas6+h2cyW4eMD+cOLTHfL7woNctjJBcVSGTM3ruZpxBsrF9z4Xzafqomn1mVSLJYVI2u55OBneohXgu7n1l7X1C/81FiXbUjnad8o9+g30A8yxP/0vyet5aoZrr+bDlPu+mFumcAU7n3t7cwS/bQsSYxCne6STzfLzJZ5u+ANBtGHmhqlkkbWmIspoRUmtSFKzIXsuuSbTv7k36FAG6jLLg9OnCj7yzpCZA9ZvuRt3sxw0CiUHV9gW1fM8Skjt6BDaDPnHm";
    static final String WEB_SERVICE = "https://api.ebay.com/wsapi";
    public static void main(String[] args) throws Exception {
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
        DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {
                DetailLevelCodeType.RETURN_ALL,
                DetailLevelCodeType.ITEM_RETURN_ATTRIBUTES,
                DetailLevelCodeType.ITEM_RETURN_DESCRIPTION
        };
        gc.setDetailLevel(detailLevels);

        ItemCategory category = new ItemCategory();
        //Enter ID of the item that you want to get
        ItemType item = gc.getItem("202026662543");
        // [3] Display result.
        System.out.println("===== [3] Display Returned Item Information ====");

        category.setItemType(item.getListingType().toString());
        category.setTitle(item.getTitle());
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
    }
}
