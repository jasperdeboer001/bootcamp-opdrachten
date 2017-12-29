package browser;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    static WebDriver driver;

    public static WebDriver getDriver(String browser) {
        switch(browser.toLowerCase()) {
            case "firefox":
                getFirefoxDriver();
                break;
            case "chrome":
                getChromeDriver();
                break;
            case "edge":
                getEdgeDriver();
                break;
            default:
                getChromeDriver();
                break;
        }
        return driver;
    }

//losse methods maken het mogelijk om qua setup te differentieren

    private static WebDriver getFirefoxDriver() {
        FirefoxDriverManager.getInstance().setup();
        return driver = new FirefoxDriver();
    }

    private static WebDriver getChromeDriver() {
        ChromeDriverManager.getInstance().setup();
        return driver = new ChromeDriver();
    }

    private static WebDriver getEdgeDriver() {
        EdgeDriverManager.getInstance().setup();
        return driver = new EdgeDriver();
    }
}
