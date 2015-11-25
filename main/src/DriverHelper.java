import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by mikhail.dementev on 11/25/2015.
 */
public class DriverHelper {

    private static WebDriver driver;

    public static WebDriverWait wait;

    public synchronized static WebDriver getCurrentDriver() {
        if (driver != null) return driver;
        try {
            System.setProperty("webdriver.chrome.driver", "ChromeDriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, 30);
            return driver;

        } finally {
            Runtime.getRuntime().addShutdownHook(
                    new Thread(new BrowserClose()));
        }
    }

    public static void close() {
        getCurrentDriver().quit();
        driver = null;
    }

    private static class BrowserClose implements Runnable {
        public void run() {
            close();
        }
    }


}
