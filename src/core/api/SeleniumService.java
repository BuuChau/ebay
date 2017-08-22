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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SeleniumService {

    static List<WebDriver> drivers;
    private static String OS = System.getProperty("os.name").toLowerCase();
    private static Integer model = Integer.parseInt(System.getProperty("sun.arch.data.model"));
    private static String url = "https://www.ebay.com/sch/i.html?_from=R40";
    static List<String> strings = new ArrayList<>();

    static final String TOKEN = "AgAAAA**AQAAAA**aAAAAA**rQGbWQ**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6AAloWnD5SAowmdj6x9nY+seQ**ItsDAA**AAMAAA**s4pjp8Zn/S3D7UlD5ZCarYyoBcccEwYy4pHpakOKt4gO0dfA8ebtxgW2GJDoSw6IIX9ioc++6rkOUfznlZeXk0Jitahvc9U9PnS+9EaNcqDQzgJkxpfrutVYRVblQddl37/7y9LpVJ48JwGHoXiBGQngev14YI3UCFeGenrVAqwe02bfQOyH4WYxsaGm4nRiDCwAGxWZVG9jnyI2m3mLx+UiS8kcEZQCQHyPaW/DP3lhdxovWSgbpxWxfS15GIZMMPHE2zIwTTNMAl8TH1ocO4c2LaFuRrg0Ji1GD+ZtWs2PbVt6rkMWH6qiEAZj9x8G6i0SkGahzgVqhhwrrSG8bamL8bYxv1g32AxisDwNRS6LfuhWqsfA0laitrYvBVsfdpvjfAPmhtvmKHEk+9vJcrmcaCV4w7UrxB90ts339o+bIV4ZX4rcmpO/VER6SiRqGdZOBhYzu3l7eEyShADkJupH7Y0QsKk1yQ1EAi4h4Rf2EaM/w+oLTLYZrZ9ruxe9CkN2TUOQeHdO04RIe73XzE0P//zjsQusCGc9TEHPzYhoDhHNAZjJr/ebwFcU3zR8KWM6lRHDM61oAC4s3sI6EdjHxhgVoBqP036h/mIwQTqhKfnI+bcNXXbLa6xABaage/PX2XFPs2P2x0fU90eNf9vsTqacNjBvYujn9W1mnI/HpaaxFACQ/n9Bs+fW7XOMQm92vaXN2rwVKx1vuB8UxwV59HJaNHVslKki8xQPUqc4zdbVVfajnEizcAT9r1ww";
    static final String WEB_SERVICE = "https://api.ebay.com/wsapi";

    private static DesiredCapabilities capabilities(){
        String file = "";
        if (OS.indexOf("win") >= 0) {
            file = "libs/os/win/phantomjs.exe";
        } else if (OS.indexOf("mac") >= 0) {
            file = "libs/os/mac/phantomjs";
        } else if (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 ) {
            if (model == 32)
                file = "libs/os/linux/32/phantomjs";
            else if (model == 64)
                file = "libs/os/linux/64/phantomjs";
        } else {
            System.out.println("Your OS is not support!!");
        }

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        caps.setCapability("takesScreenshot", true);
        caps.setCapability(
                PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,file);
        return caps;
    }

    public static void main(String[] args) throws InterruptedException {
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(DateTimeFormatter.ofPattern("hh:mm:ss").format(dateTime));

        Thread uiThread = new Thread(() -> getAll(1));
        uiThread.start();
        Thread uiThread1 = new Thread(() -> getAll(2));
        uiThread1.start();
        Thread uiThread2 = new Thread(() -> getAll(3));
        uiThread2.start();
        Thread uiThread3 = new Thread(() -> getAll(4));
        uiThread3.start();
        Thread uiThread5 = new Thread(() -> getAll(5));
        uiThread5.start();

        boolean isThread = true;
        while (isThread){
            if (uiThread.getState()==Thread.State.TERMINATED
                    && uiThread1.getState()==Thread.State.TERMINATED
                    && uiThread2.getState()==Thread.State.TERMINATED
                    && uiThread3.getState()==Thread.State.TERMINATED
                    && uiThread5.getState()==Thread.State.TERMINATED)
            {
                for (WebDriver driver : drivers){
                    driver.close();
                }
                List<ItemCategory> itemCategories = categories(strings);
                isThread = false;

            }
        }
        LocalDateTime dateTime2 = LocalDateTime.now();
        System.out.println(DateTimeFormatter.ofPattern("hh:mm:ss").format(dateTime2));
    }

    private static void getAll(int pageNumber) {
        WebDriver driver;
        driver = new PhantomJSDriver(capabilities());
        new WebDriverWait(driver, 30);

        String keywords = "&_nkw=iphone";
        String view = "&_dmd=2";
        String page = "&_pgn=" + pageNumber;
        String pagesize = "&_ipg=200";

        url = url + keywords + view + pagesize + page;
        driver.get(url);
        try {
            // Create an interface WebElement of the div under div with **class as facetContainerDiv**
            WebElement webElement = driver.findElement(By.xpath("//div[@id='ResultSetItems']/ul[@id='GalleryViewInner']"));
            // Create an IList and intialize it with all the elements of div under div with **class as facetContainerDiv**
            List<WebElement> webElements = webElement.findElements(By.xpath("//li/div[contains(@class, 'mimg') and contains(@class, 'itmcd') and contains(@class, 'img')]"));
            for (WebElement element : webElements){
                strings.add(element.getAttribute("iid"));
            }
            System.err.println("==========================");
            drivers.add(driver);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            drivers.add(driver);
        }
    }

    private static List<ItemCategory> categories(List<String> listItems){
        List<ItemCategory> categoryLists = new ArrayList<>();
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

        for(String s : listItems) {
            try {
                ItemCategory category = new ItemCategory();
                //Enter ID of the item that you want to get
                ItemType item = gc.getItem(s);
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

                categoryLists.add(category);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        return categoryLists;
    }
}
