package core.api;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
import com.ebay.sdk.call.GetItemCall;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import core.common.CommonInit;
import core.common.CommonMethod;
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
public class SearchWithUrl {

    public List<ItemCategory> categories(String url){
        url += "&_pgn=";
        List<ItemCategory> categorys = Collections.synchronizedList(new ArrayList<>());
        int record = 0;
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(DateTimeFormatter.ofPattern("hh:mm:ss").format(dateTime));

        // [1] Create ApiContext object.
        System.out.println("===== [1] Collect Account Information ====");
        ApiContext apiContext = new ApiContext();
        ApiCredential cred = apiContext.getApiCredential();

        // Enter your eBay Authentication Token
        cred.seteBayToken(CommonInit.TOKEN);

        // Enter eBay SOAP server URL (e.g., https://api.ebay.com/wsapi)
        apiContext.setApiServerUrl(CommonInit.WEB_SERVICE);

        // [2] Ask for itemID.
        System.out.println("===== [2] Call GetItemCall ====");

        GetItemCall gc = new GetItemCall(apiContext);
        DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {
                DetailLevelCodeType.RETURN_ALL,
                DetailLevelCodeType.ITEM_RETURN_ATTRIBUTES,
                DetailLevelCodeType.ITEM_RETURN_DESCRIPTION
        };
        gc.setDetailLevel(detailLevels);

        //int page = (record%200 == 0) ? record/200 : (record/200) + 1;

        int page = 1;
        for (int i = 1; i<= page; i+=10){
            List<Thread> threads = new ArrayList<>();
            int temp = (i + 9 < page ? i + 9 : page);
            for (int j = i; j <= temp ; j++) {
                int finalJ = j;
                final String[] finalUrl = {url};
                Thread thread = new Thread(() -> {
                    WebDriver driver = new PhantomJSDriver(capabilities());
                    WebDriverWait wait = new WebDriverWait(driver,30);

                    finalUrl[0] += finalJ;
                    driver.get(finalUrl[0]);
                    try {
                        // Create an interface WebElement of the div under div with **class as facetContainerDiv**
                        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ResultSetItems']/ul[@id='ListViewInner']")));
                        // Create an IList and intialize it with all the elements of div under div with **class as facetContainerDiv**
                        List<WebElement> webElements = webElement.findElements(By.xpath("//li/div[contains(@class,'lvpic') and contains(@class,'pic') and contains(@class,'img') and contains(@class,'left')]"));
                        for (WebElement element : webElements){
                            categorys.add(CommonMethod.category(gc,element.getAttribute("iid")));
                        }
                        System.out.println("==========================");
                    } catch(Exception e) {
                        e.printStackTrace();
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

        LocalDateTime dateTime2 = LocalDateTime.now();
        System.out.println(DateTimeFormatter.ofPattern("hh:mm:ss").format(dateTime2));
        System.out.println("Category leng : " + categorys.size());
        return categorys;
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
}
