package traverse;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.IOException;

public class trav {
    public static WebDriver driver;

    public static void main(String[] args) {
        kilDriver();
        openBrowser();
        driver.get("https://www.youtube.com/watch?v=CBW9faMohto");
        try {
            Thread.sleep(1400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        closeBrowser();

    }

    static void kilDriver(){
        try {
            Runtime.getRuntime().exec(new String[] {"cmd", "taskkill/F /IM chromedriver.exe", "Start"});
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    static WebDriver openBrowser(){
    System.setProperty("webdriver.chrome.driver", ".\\target\\classes\\lib\\chromedriver_win32\\chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
    options.setAcceptInsecureCerts(true);
    options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
    options.addArguments("test-type");
    options.addArguments("start-maximized");
    options.addArguments("--js-flags=--expose-gc");
    options.addArguments("--enable-precise-memory-info");
    options.addArguments("--disable-popup-blocking");
    options.addArguments("--disable-default-apps");
    options.addArguments("test-type=browser");
    options.addArguments("disable-infobars");
    options.addArguments("--disable-extensions");
    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    return driver;
}
    static void closeBrowser(){
        driver.close();
        driver.quit();
    }
    static void getReply(WebDriver driver){
      By rep=By.xpath("//*[@id=\"contents\"]/ytd-comment-thread-renderer[1]//*[@id=\"reply-button-end\"]");
      driver.findElement(rep).click();


    }

}
