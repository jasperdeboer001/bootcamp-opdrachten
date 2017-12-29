package chapterNine;

import chapterSix.HomePage;
import chapterSix.TestShopScenario;
import org.testng.annotations.Test;

public class LoginTest extends TestShopScenario {

    @Test
    public void userLogin() {
        HomePage homePage = new HomePage(driver);
    }
}
