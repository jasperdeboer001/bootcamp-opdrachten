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

public class BrowserFactoryAdvanced {

    static WebDriver driver;

    public enum Browser {
        FIREFOX,
        EDGE,
        CHROME;
    }
    public static WebDriver getDriver(Browser browser) {
        switch (browser) {
            case FIREFOX:
                return getFirefoxDriver();
            case EDGE:
                return getEdgeDriver();
            case CHROME:
            default:
                return getChromeDriver();
        }
    }


//losse methods maken het mogelijk om qua setup te differentieren

    private static WebDriver getFirefoxDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--start-maximized");
        FirefoxDriverManager.getInstance().setup();
        return driver = new FirefoxDriver(firefoxOptions);
    }

    private static WebDriver getChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        ChromeDriverManager.getInstance().setup();
        return driver = new ChromeDriver(chromeOptions);
    }

    private static WebDriver getEdgeDriver() {
        //addArguments zijn niet mogelijk voor Edge, dus capabilities moeten op een andere manier worden gezet
        DesiredCapabilities capabilities = DesiredCapabilities.edge();
        EdgeDriverManager.getInstance().setup();
        capabilities.setCapability("edge switches", "--start-maximized");
        return driver = new EdgeDriver(capabilities);
    }
}
