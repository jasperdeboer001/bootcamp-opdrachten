package browser;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class BrowserFactory {

    static WebDriver driver;

    public static WebDriver getDriver(String browser) {
        switch(browser.toLowerCase()) {
            case "firefox":
                return getFirefoxDriver();
            case "edge":
                return getEdgeDriver();
            case "chrome": default:
                return getChromeDriver();
        }
    }

//losse methods maken het mogelijk om qua setup te differentieren

    private static WebDriver getFirefoxDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("start-maximized");
        FirefoxDriverManager.getInstance().setup();
        return driver = new FirefoxDriver(firefoxOptions);
    }

    private static WebDriver getChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        ChromeDriverManager.getInstance().setup();
        return driver = new ChromeDriver(chromeOptions);
    }

    private static WebDriver getEdgeDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.edge();
        EdgeDriverManager.getInstance().setup();
        //capabilities.setCapability(edge);
        return driver = new EdgeDriver(capabilities);
    }
}
