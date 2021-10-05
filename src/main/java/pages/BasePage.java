package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriverWait wait = new WebDriverWait(getDriver(), 5);
    private static ThreadLocal<WebDriver> THREAD_LOCAL_DRIVER = new ThreadLocal<>();

    public static void setThreadLocalDriver(WebDriver driver){
        THREAD_LOCAL_DRIVER.set(driver);
    }

    public static ThreadLocal<WebDriver> getThreadLocalDriver(){
        return THREAD_LOCAL_DRIVER;
    }

    public static WebDriver getDriver(){
        return THREAD_LOCAL_DRIVER.get();
    }
}
