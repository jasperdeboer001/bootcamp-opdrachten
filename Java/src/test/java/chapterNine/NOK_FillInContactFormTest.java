package chapterNine;

import chapterSix.HomePage;
import chapterSix.MyAccountPage;
import chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class NOK_FillInContactFormTest extends TestShopScenario {

    @Test
    public void testEmailValidation() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        homePage.clickContactUs();

        contactUsPage.submitForm("Customer service", "nope", 4321234, "<Ipod defect while lifting, need new one>");
        Thread.sleep(3000);
        Assertions.assertThat(driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]/ol/li")).getText()).as("Assert that error message is displayed").isEqualTo("Invalid email address.");
        contactUsPage.clearData();
        contactUsPage.submitForm("Customer service", "nope@deBoer.com", 4321234, "<Ipod defect while lifting, need new one>");
        Thread.sleep(3000);
        Assertions.assertThat(driver.findElement(By.xpath("//p[contains(@class, 'alert-success')]")).getText()).as("Assert that confirmation message is displayed").isEqualTo("Your message has been successfully sent to our team.");
    }


}
