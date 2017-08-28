package core.api;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
import com.ebay.sdk.call.GetItemCall;
import com.ebay.soap.eBLBaseComponents.*;
import core.model.reponse.ItemCategory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SeleniumService {

    static List<String> strings = Collections.synchronizedList(new ArrayList<String>());
    // Get item
    static List<ItemCategory> categorys = Collections.synchronizedList(new ArrayList<>());

    static final String TOKEN = "AgAAAA**AQAAAA**aAAAAA**zfufWQ**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6ACloGkAZCCqAmdj6x9nY+seQ**m94DAA**AAMAAA**qGfV5bguycJAJ1jpqosN9brHLCn6ypjCHBNY6nFTjAiT8C2BEusJD0qSClnVBPBp13TW+iX/8Acq8omBZkTMmwbbjk6m/WlbxWzARNqvZ4Fb3bLRPEpCoCgKJW+2AhQTfcV+Wz0f2Dq9XknV9b0tGnw9Vu8B93A4rwFeErkp2BDVSkx2vTCjZpaYp6tvJFxtZEibNdc73a7JBKPQmBHruL/fiAo7koFxFB2SEAOOyNBrDObvXHu7f9Kvqp/MiWn7TD7krZMkJFKOgRE3R6MUUtJpAf+4+h6+VOGkdykpUEDQ91Ejdi/hd7pEw6ApLCytZ76qyEVAGmts6GWt84gjHT1G5JpvaexJd0E41fXu1z8+AQOUBC40YwGe7zIdIcCxVWMpHbO7tdfV7eCXPtmr0lNuNp6xIg1HiCwVBE7uogCaqxutZYPT8mW6iz0fg7SfcwM0zTnL1CMwVgtQ4mUmUR43bMlOS7c8WJyqsTTzGT3iHc5uXVfnsZFBJas6+h2cyW4eMD+cOLTHfL7woNctjJBcVSGTM3ruZpxBsrF9z4Xzafqomn1mVSLJYVI2u55OBneohXgu7n1l7X1C/81FiXbUjnad8o9+g30A8yxP/0vyet5aoZrr+bDlPu+mFumcAU7n3t7cwS/bQsSYxCne6STzfLzJZ5u+ANBtGHmhqlkkbWmIspoRUmtSFKzIXsuuSbTv7k36FAG6jLLg9OnCj7yzpCZA9ZvuRt3sxw0CiUHV9gW1fM8Skjt6BDaDPnHm";
    static final String WEB_SERVICE = "https://api.ebay.com/wsapi";

    private static DesiredCapabilities capabilities(){
        String file = "";
        String OS = System.getProperty("os.name").toLowerCase();
        if (OS.indexOf("win") >= 0) {
            file = "libs/os/win/phantomjs.exe";
        } else if (OS.indexOf("mac") >= 0) {
            file = "libs/os/mac/phantomjs";
        } else {
            System.out.println("Your OS is not support!!");
        }

        DesiredCapabilities caps = new DesiredCapabilities();

        List<String> argsCaps = new ArrayList<>();
        argsCaps.add("--web-security=false");
        argsCaps.add("--ssl-protocol=any");
        argsCaps.add("--ignore-ssl-errors=true");
        argsCaps.add("--webdriver-loglevel=INFO");
        argsCaps.add("--load-images=false");

        caps.setJavascriptEnabled(true);
        caps.setCapability("takesScreenshot", true);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,file);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, argsCaps);
        return caps;
    }

    public static void main(String[] args) throws InterruptedException {

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(DateTimeFormatter.ofPattern("hh:mm:ss").format(dateTime));

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

        int page = 9;
        for (int i = 1; i<= page; i+=10){
            List<Thread> threads = new ArrayList<>();
            int temp = (i + 9 < page ? i + 9 : page);
            for (int j = i; j <= temp ; j++) {
                int finalJ = j;
                Thread thread = new Thread(() -> {
                    WebDriver driver = new PhantomJSDriver(capabilities());
                    WebDriverWait wait = new WebDriverWait(driver,30);
                    String url = "https://www.ebay.com/sch/i.html?_from=R40&_nkw=iphone&_dmd=1&_ipg=200&_pgn=" + finalJ;
                    driver.get(url);
                    try {
                        // Create an interface WebElement of the div under div with **class as facetContainerDiv**
                        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ResultSetItems']/ul[@id='ListViewInner']")));
                        // Create an IList and intialize it with all the elements of div under div with **class as facetContainerDiv**
                        List<WebElement> webElements = webElement.findElements(By.xpath("//li/div[contains(@class,'lvpic') and contains(@class,'pic') and contains(@class,'img') and contains(@class,'left')]"));
                        for (WebElement element : webElements){
                            strings.add(element.getAttribute("iid"));
                            categorys.add(new SeleniumService().category(gc,element.getAttribute("iid")));
                        }
                        System.out.println("==========================");
                    } catch(Exception e) {
                    } finally {
                        driver.quit();
                    }
                });
                thread.start();
                threads.add(thread);
                while (true && (j == temp)) {
                    if (new SeleniumService().isThread(threads))
                        break;
                }
            }
        }

        LocalDateTime dateTime2 = LocalDateTime.now();
        System.out.println(DateTimeFormatter.ofPattern("hh:mm:ss").format(dateTime2));
        System.out.println("String leng : " + strings.size());
        System.out.println("Category leng : " + categorys.size());
    }

    private ItemCategory category(GetItemCall gc,String itemId) throws Exception {

        ItemCategory category = new ItemCategory();
        //Enter ID of the item that you want to get
        ItemType item = gc.getItem(itemId);
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

        return category;
    }

    private boolean isThread(List<Thread> threads){
        // Check if thread success
        while (true){
            int size = 0;
            for (Thread t : threads){
                if (t.getState()==Thread.State.TERMINATED){
                    size++;
                }
            }
            if (size == threads.size()){
                return true;
            }
        }
    }
}
