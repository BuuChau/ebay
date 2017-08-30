package core.api;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
import com.ebay.sdk.call.GetItemCall;
import com.ebay.soap.eBLBaseComponents.*;
import core.common.InitForm;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by phuoclt on 8/29/17.
 */
public class SearchAction {

    public List<ItemCategory> categories(List<String> urlList,String page){
        List<ItemCategory> categorys = Collections.synchronizedList(new ArrayList<>());
        List<String> items = items(urlList,page);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(DateTimeFormatter.ofPattern("hh:mm:ss").format(dateTime));

        // [1] Create ApiContext object.
        System.out.println("===== [1] Collect Account Information ====");
        ApiContext apiContext = new ApiContext();
        ApiCredential cred = apiContext.getApiCredential();

        // Enter your eBay Authentication Token
        cred.seteBayToken(InitForm.TOKEN);

        // Enter eBay SOAP server URL (e.g., https://api.ebay.com/wsapi)
        apiContext.setApiServerUrl(InitForm.WEB_SERVICE);

        // [2] Ask for itemID.
        System.out.println("===== [2] Call GetItemCall ====");

        GetItemCall gc = new GetItemCall(apiContext);
        DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {
                DetailLevelCodeType.RETURN_ALL,
                DetailLevelCodeType.ITEM_RETURN_ATTRIBUTES,
                DetailLevelCodeType.ITEM_RETURN_DESCRIPTION
        };
        gc.setDetailLevel(detailLevels);

        for (int i = 0; i< items.size() ; i+=200) {
            List<Thread> threads = new ArrayList<>();
            int temp = (i + 200 < items.size() ? i + 200 : items.size());

            for (int j = i; j < temp; j++) {
                int finalJ = j;
                Thread thread = new Thread(() -> {
                    try {
                        categorys.add(category(gc,items.get(finalJ)));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                thread.start();
                threads.add(thread);
                while (true && (j == (temp -1) )) {
                    if (isThread(threads))
                        break;
                }
            }
        }
        LocalDateTime dateTime2 = LocalDateTime.now();
        System.out.println(DateTimeFormatter.ofPattern("hh:mm:ss").format(dateTime2));
        System.out.println("Category leng : " + categorys.size());
        return categorys;
    }

    private List<String>items(List<String> urlList,String page){

        List<String> strings = Collections.synchronizedList(new ArrayList<String>());
        urlList.forEach(url ->{
            for (int i = 1; i<= Integer.parseInt(page); i+=10){
                List<Thread> threads = new ArrayList<>();
                int temp = (i + 9 < Integer.parseInt(page) ? i + 9 : Integer.parseInt(page));

                for (int j = i; j <= temp ; j++) {
                    int finalJ = j;
                    Thread thread = new Thread(() -> {
                        WebDriver driver = new PhantomJSDriver(capabilities());
                        WebDriverWait wait = new WebDriverWait(driver,30);
                        driver.get(url +"&_pgn=" + finalJ);
                        try {
                            // Create an interface WebElement of the div under div with **class as facetContainerDiv**
                            WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ResultSetItems']/ul[@id='ListViewInner']")));
                            // Create an IList and intialize it with all the elements of div under div with **class as facetContainerDiv**
                            List<WebElement> webElements = webElement.findElements(By.xpath("//li/div[contains(@class,'lvpic') and contains(@class,'pic') and contains(@class,'img') and contains(@class,'left')]"));
                            for (WebElement element : webElements){
                                strings.add(element.getAttribute("iid"));
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
                        if (isThread(threads))
                            break;
                    }
                }
            }
        });

        return strings;
    }

    private DesiredCapabilities capabilities(){
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

    private ItemCategory category(GetItemCall gc, String itemId) throws Exception {

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
        category.setFeedback(item.getSeller().getFeedbackScore().toString());
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
