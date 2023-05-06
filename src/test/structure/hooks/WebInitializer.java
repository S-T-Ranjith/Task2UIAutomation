package src.test.structure.hooks;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebInitializer {
    public static WebDriver webDriver;
    public static ChromeOptions chromeOptions;

    public static WebDriver launchWeb()  {
        System.setProperty("webdriver.chrome.driver", "/Users/ranjithkumart/Documents/Browser/chromedriver");
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("use-fake-ui-for-media-stream",
                "use-fake-device-for-media-stream",
                "--disable-user-media-security",
                "--disable-web-security",
                "--allow-running-insecure-content",
                "--ignore-certificate-errors",
                "--disable-popup-blocking",
                "--always-authorize-plugins",
                "--disable-blink-features=AutomationControlled",
                "--disable-notifications");
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().timeouts().getImplicitWaitTimeout();
        webDriver.manage().window().maximize();
        return webDriver;
    }
}
