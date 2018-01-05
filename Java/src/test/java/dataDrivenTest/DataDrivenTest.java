
package dataDrivenTest;

import browserDrivenTest.TestShopScenarioBrowserDriven;
import chapterSix.HomePage;
import chapterSix.MyAccountPage;
import chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataDrivenTest extends TestShopScenario {

    @Parameters({"loginName", "passwd", "loggedIn"})
    @Test
    public void userLogin(String loginName, String passwd, Boolean loggedIn) {
        HomePage homePage = new HomePage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        if (homePage.userLoggedOut()) {
            homePage.clickLogInButton();
            myAccountPage.logIn(loginName, passwd);
        }
        else {
            System.out.println("Je bent al ingelogd");
        }

        Assertions.assertThat(homePage.userLoggedIn().equals(loggedIn));
    }
}

