
package browserDrivenTest;

import chapterSix.HomePage;
import chapterSix.MyAccountPage;
import chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BrowserDrivenTest extends TestShopScenarioBrowserDriven {

    @Test
    public void userLogin() {
        HomePage homePage = new HomePage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        if (homePage.userLoggedOut()) {
            homePage.clickLogInButton();
            myAccountPage.logIn("Jasper@deBoer.com", "1qazxsw2");
        }
        else {
            System.out.println("Je bent al ingelogd");
        }

        Assertions.assertThat(homePage.userLoggedIn().equals(true));
    }
}

