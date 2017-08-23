package core.api;

import core.api.thread.SearchItemService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import core.model.reponse.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SeleniumService {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        List<ItemCategory> categorys = new ArrayList<>();

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(DateTimeFormatter.ofPattern("hh:mm:ss").format(dateTime));
        // Tổng SP
        int countsp = 200;
        // Tổng số page
        // 20
        int page = countsp%200 == 0 ? countsp/200 : countsp%200 + 1;

        for (int i = 1; i<= page; i+=5){
            List<Thread> threads = new ArrayList<>();
            for (int j = (i - 4 < 0 ? 1 : i - 4); j <= i ; j++) {
                int finalJ = j;
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        WebDriver driver;
                        String url = "https://www.ebay.com/sch/i.html?_from=R40";
                        driver = new PhantomJSDriver(capabilities());

                        String keywords = "&_nkw=iphone";
                        String view = "&_dmd=1";
                        String page = "&_pgn=" + finalJ;
                        String pagesize = "&_ipg=200";

                        url = url + keywords + view + pagesize + page;
                        driver.get(url);
                        try {
                            List<String> strings = new ArrayList<>();
                            // Create an interface WebElement of the div under div with **class as facetContainerDiv**
                            WebElement webElement = driver.findElement(By.xpath("//div[contains(@id,'ResultSetItems')]/ul[contains(@id,'ListViewInner')]"));
                            // Create an IList and intialize it with all the elements of div under div with **class as facetContainerDiv**
                            List<WebElement> webElements = webElement.findElements(By.cssSelector("//li"));
                            for (WebElement element : webElements){
                                strings.add(element.getAttribute("listingid"));
                            }
                            System.err.println("==========================");
                            driver.close();
                        } catch(Exception e) {
                            driver.close();
                            e.printStackTrace();
                        }
                    }
                };

                thread.start();
                threads.add(thread);

                if (i == j){
                    if(isThread(threads))
                        break;
                }
            }
        }

        for (int i=0;i< strings.size() ;i+= 500) {
            List<Thread> threads = new ArrayList<>();
            for (int j = (i - 500 < 0 ? 0 : i - 500); j < i ; j++){
                try {
                    Thread thread = new Thread(new SearchItemService(strings.get(j),categorys));
                    thread.start();
                    threads.add(thread);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (j == i-1){
                    if (isThread(threads))
                        break;
                }
            }
        }
        LocalDateTime dateTime2 = LocalDateTime.now();
        System.out.println(DateTimeFormatter.ofPattern("hh:mm:ss").format(dateTime2));
    }

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
        caps.setJavascriptEnabled(true);
        caps.setCapability("takesScreenshot", true);
        caps.setCapability(
                PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,file);
        return caps;
    }

    private static boolean isThread(List<Thread> threads){
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
