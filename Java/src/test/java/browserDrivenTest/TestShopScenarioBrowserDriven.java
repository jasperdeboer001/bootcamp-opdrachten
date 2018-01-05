package browserDrivenTest;

import browser.BrowserFactory;
import browser.BrowserFactoryAdvanced;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestShopScenarioBrowserDriven {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(BrowserFactoryAdvanced.Browser browser) {
        //Onderstaande kun je gebruiken wanneer je een niet geavanceerde BrowserFactory hebt
        //BrowserFactory browserFactory = new BrowserFactory();
        //driver = browserFactory.getDriver("firefox");
        //Onderstaande kun je gebruiken als je method static is
        driver = BrowserFactoryAdvanced.getDriver(browser);
        wait = new WebDriverWait(driver, 5);
        driver.get("https://techblog.polteq.com/testshop/");
        //driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
