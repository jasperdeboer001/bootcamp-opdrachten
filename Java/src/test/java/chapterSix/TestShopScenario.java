package chapterSix;

import browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestShopScenario {

    protected WebDriver driver;
    protected WebDriverWait wait;


    @BeforeMethod
    public void setUp() {
        //Onderstaande kun je gebruiken
        //BrowserFactory browserFactory = new BrowserFactory();
        //driver = browserFactory.getDriver("firefox");
        //Onderstaande kun je gebruiken als je method static is
        driver = BrowserFactory.getDriver("firefox");
        wait = new WebDriverWait(driver, 5);
        driver.get("https://techblog.polteq.com/testshop/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
