//package core.api.thread;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriverService;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class SearchThread implements Runnable {
//    static WebDriver driver;
//    static Wait<WebDriver> wait;
//    private static String OS = System.getProperty("os.name").toLowerCase();
//    private static Integer model = Integer.parseInt(System.getProperty("sun.arch.data.model"));
//    private static String url = "https://www.ebay.com/sch/i.html?_from=R40";
//
//    int pageNumber;
//
//    public SearchThread(int page) {
//        this.pageNumber = page;
//    }
//
//    private static DesiredCapabilities capabilities(){
//        String file = "";
//        if (OS.indexOf("win") >= 0) {
//            file = "libs/os/win/phantomjs.exe";
//        } else if (OS.indexOf("mac") >= 0) {
//            file = "libs/os/mac/phantomjs";
//        } else if (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 ) {
//            if (model == 32)
//                file = "libs/os/linux/32/phantomjs";
//            else if (model == 64)
//                file = "libs/os/linux/64/phantomjs";
//        } else {
//            System.out.println("Your OS is not support!!");
//        }
//
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setJavascriptEnabled(true);
//        caps.setCapability("takesScreenshot", true);
//        caps.setCapability(
//                PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,file);
//        return caps;
//    }
//
//    @Override
//    public void run() {
//        driver = new PhantomJSDriver(capabilities());
//        wait = new WebDriverWait(driver, 30);
//
//        String keywords = "&_nkw=iphone";
//        String view = "&_dmd=2";
//        String page = "&_pgn=" + pageNumber;
//        String pagesize = "&_ipg=200";
//
//        url = url + keywords + view + pagesize + pageNumber;
//        driver.get(url);
//        try {
//            List<String> strings = new ArrayList<>();
//            // Create an interface WebElement of the div under div with **class as facetContainerDiv**
//            WebElement webElement = driver.findElement(By.xpath("//div[@id='ResultSetItems']/ul[@id='GalleryViewInner']"));
//            // Create an IList and intialize it with all the elements of div under div with **class as facetContainerDiv**
//            List<WebElement> webElements = webElement.findElements(By.xpath("//li/div[contains(@class, 'mimg') and contains(@class, 'itmcd') and contains(@class, 'img')]"));
//            for (WebElement element : webElements){
//                strings.add(element.getAttribute("iid"));
//            }
//
//            System.err.println("==========================");
//        } catch(Exception e) {
//            e.printStackTrace();
//        } finally {
//            driver.close();
//        }
//    }
//}
