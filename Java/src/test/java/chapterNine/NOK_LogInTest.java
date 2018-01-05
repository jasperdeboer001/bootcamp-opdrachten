
package chapterNine;

import chapterSix.HomePage;
import chapterSix.MyAccountPage;
import chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NOK_LogInTest extends TestShopScenario {

    String correctEmail = "Jasper@deBoer.com";
    String incorrectEmailFormat = "nope";
    String incorrectEmail = "Pietje@Puk.com";
    String correctPasswd = "1qazxsw2";
    String incorrectPasswd = "doemaariets";

    @Test
    public void testIncorrectEmailFormatAndCorrectPassWord() {
        HomePage homePage = new HomePage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        if (homePage.userLoggedOut()) {
            homePage.clickLogInButton();
            myAccountPage.logIn(incorrectEmailFormat, correctPasswd);
            Assertions.assertThat(driver.findElement(By.xpath("//div[contains(@class, 'form-error')]")).getText()).as("").isEqualTo("Email address");
            myAccountPage.clearFields();
            //TODO assert lightbox message
        }
        else {
            System.out.println("Je bent al ingelogd");
        }
    }

    @Test
    public void testIncorrectEmailAndCorrectPassWord() {
        HomePage homePage = new HomePage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        if (homePage.userLoggedOut()) {
            homePage.clickLogInButton();
            myAccountPage.logIn(incorrectEmail, correctPasswd);
            Assertions.assertThat(driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]/ol/li")).getText()).as("").isEqualTo("Authentication failed.");
            myAccountPage.clearFields();
        }
        else {
            System.out.println("Je bent al ingelogd");
        }
    }

    @Test
    public void testNoEmailAndCorrectPassWord() {
        HomePage homePage = new HomePage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        if (homePage.userLoggedOut()) {
            homePage.clickLogInButton();
            myAccountPage.logIn("", incorrectPasswd);
            Assertions.assertThat(driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]/ol/li")).getText()).as("").isEqualTo("An email address required.");
            myAccountPage.clearFields();
        }
        else {
            System.out.println("Je bent al ingelogd");
        }
    }

    @Test
    public void testCorrectEmailAndIncorrectPassWord() {
        HomePage homePage = new HomePage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        if (homePage.userLoggedOut()) {
            homePage.clickLogInButton();
            myAccountPage.logIn(correctEmail, incorrectPasswd);
            Assertions.assertThat(driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]/ol/li")).getText()).as("").isEqualTo("Authentication failed.");
            myAccountPage.clearFields();
        }
        else {
            System.out.println("Je bent al ingelogd");
        }
    }

    @Test
    public void testCorrectEmailAndNoPassWord() {
        HomePage homePage = new HomePage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        if (homePage.userLoggedOut()) {
            homePage.clickLogInButton();
            myAccountPage.logIn(correctEmail, "");
            Assertions.assertThat(driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]/ol/li")).getText()).as("").isEqualTo("Password is required.");
            myAccountPage.clearFields();
        }
        else {
            System.out.println("Je bent al ingelogd");
        }
    }

}

