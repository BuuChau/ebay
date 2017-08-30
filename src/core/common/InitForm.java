package core.common;

import core.model.reponse.ItemCategory;
import core.model.search.*;
import core.model.search.listing.Listing;

import java.util.ArrayList;
import java.util.List;

public class InitForm {

    public static final String TOKEN = "AgAAAA**AQAAAA**aAAAAA**zfufWQ**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6ACloGkAZCCqAmdj6x9nY+seQ**m94DAA**AAMAAA**qGfV5bguycJAJ1jpqosN9brHLCn6ypjCHBNY6nFTjAiT8C2BEusJD0qSClnVBPBp13TW+iX/8Acq8omBZkTMmwbbjk6m/WlbxWzARNqvZ4Fb3bLRPEpCoCgKJW+2AhQTfcV+Wz0f2Dq9XknV9b0tGnw9Vu8B93A4rwFeErkp2BDVSkx2vTCjZpaYp6tvJFxtZEibNdc73a7JBKPQmBHruL/fiAo7koFxFB2SEAOOyNBrDObvXHu7f9Kvqp/MiWn7TD7krZMkJFKOgRE3R6MUUtJpAf+4+h6+VOGkdykpUEDQ91Ejdi/hd7pEw6ApLCytZ76qyEVAGmts6GWt84gjHT1G5JpvaexJd0E41fXu1z8+AQOUBC40YwGe7zIdIcCxVWMpHbO7tdfV7eCXPtmr0lNuNp6xIg1HiCwVBE7uogCaqxutZYPT8mW6iz0fg7SfcwM0zTnL1CMwVgtQ4mUmUR43bMlOS7c8WJyqsTTzGT3iHc5uXVfnsZFBJas6+h2cyW4eMD+cOLTHfL7woNctjJBcVSGTM3ruZpxBsrF9z4Xzafqomn1mVSLJYVI2u55OBneohXgu7n1l7X1C/81FiXbUjnad8o9+g30A8yxP/0vyet5aoZrr+bDlPu+mFumcAU7n3t7cwS/bQsSYxCne6STzfLzJZ5u+ANBtGHmhqlkkbWmIspoRUmtSFKzIXsuuSbTv7k36FAG6jLLg9OnCj7yzpCZA9ZvuRt3sxw0CiUHV9gW1fM8Skjt6BDaDPnHm";
    public static final String WEB_SERVICE = "https://api.ebay.com/wsapi";

    public static String page = "1";
    public static List<Located> locateds = new ArrayList<>();
    public static SortBy sortBy = new SortBy();
    public static Sold sold = new Sold();
    public static FeedBack feedBack = new FeedBack();
    public static PageSize pageSize = new PageSize();
    public static Listing listing = new Listing();
    public static List<ItemCategory> itemCategories = new ArrayList<>();

}
