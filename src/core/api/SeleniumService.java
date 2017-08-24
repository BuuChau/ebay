package core.api;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import core.model.reponse.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SeleniumService {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        List<ItemCategory> categorys = new ArrayList<>();

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(DateTimeFormatter.ofPattern("hh:mm:ss").format(dateTime));
        // Tổng số page
        int page = 2;

        for (int i = 1; i<= page; i+=5){
            List<Thread> threads = new ArrayList<>();
            int temp = (i + 4 < page ? i + 4 : page);
            for (int j = i; j <= temp ; j++) {
                int finalJ = j;
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        WebDriver driver = new PhantomJSDriver(capabilities());
                        WebDriverWait wait = new WebDriverWait(driver,1);
                        String url = "https://www.ebay.com/sch/i.html?_from=R40&_nkw=iphone&_dmd=1&_ipg=200";
                        String page = "&_pgn=" + finalJ;
                        url = url + page;
                        driver.get(url);
                        try {
                            WebElement webElement = driver.findElement(By.xpath("//div[contains(@id,'ResultSetItems')]/ul[contains(@id,'ListViewInner')]"));
                            List<WebElement> webElements = webElement.findElements(By.xpath("//li/h3[contains(@class,'lvtitle')]/a"));
                            for (WebElement element : webElements){
                                strings.add(element.getAttribute("href"));
                            }
                            System.out.println("==========================");
                        } catch(Exception e) {
                            e.printStackTrace();
                        } finally {
                            driver.quit();
                        }
                    }
                };
                thread.start();
                threads.add(thread);
                while (true && (j == temp)) {
                    if (new SeleniumService().isThread(threads))
                        break;
                }
            }
        }

        for (int i = 1; i < strings.size(); i += 20) {
            List<Thread> threads = new ArrayList<>();
            int temp = i + 19 <= strings.size() ? i + 19 : strings.size();
            for (int j = i; j <= temp; j++) {
                int finalJ = j;
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        ItemCategory category = new ItemCategory();
                        WebDriver driver = new PhantomJSDriver(capabilities());
                        WebDriverWait wait = new WebDriverWait(driver, 1);
                        String url = strings.get(finalJ);
                        driver.get(url);
                        try {
                            // Create an interface WebElement of the div under div with **class as facetContainerDiv**
                            WebElement webElement = driver.findElement(By.xpath("//div[contains(@id,'CenterPanelInternal')]"));
                            // Set Url
                            category.setUrl(url);
                            // Get title
                            String title = webElement.findElement(By.xpath("//div/h1[contains(@id,'itemTitle')]")).getText();
                            category.setTitle(title);
                            // Get condition
//                            String condition = webElement.findElement(By.xpath("//div[contains(@id,'LeftSummaryPanel')]//div[contains(@id,'mainContent')]/form/div[contains(@class,'nonActPanel')]/div/div[contains(@id,'vi-itm-cond')]")).getText();
//                            category.setCondition(condition);
                            // Set type Cup - xep hang
//                            if (webElement.findElements(By.xpath("//div/span[contains(@class,'vi-core-prdReviewCntr')]/span/a[constains(@id,'_rvwlnk')]")).size() > 0)
//                                category.setTypeCup(webElement.findElement(By.xpath("//div/span[contains(@class,'vi-core-prdReviewCntr')]/span/a[constains(@id,'_rvwlnk')]")).getText());
//                            else if (webElement.findElements(By.xpath("//div/div[contains(@class,'vi-hdops-three-clmn-fix')]/div/div[constains(@id,'vi_notification_new')]/span")).size() > 0)
//                                category.setTypeCup(webElement.findElement(By.xpath("//div/div[contains(@class,'vi-hdops-three-clmn-fix')]/div/div[constains(@id,'vi_notification_new')]/span")).getText());
                            System.out.println("==========================" + finalJ);
                            categorys.add(category);
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            driver.quit();
                        }
                    }
                };
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
        caps.setCapability("takesScreenshot", false);
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
