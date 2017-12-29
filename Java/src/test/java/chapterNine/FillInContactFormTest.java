package chapterNine;

import chapterSix.HomePage;
import chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class FillInContactFormTest extends TestShopScenario {

    @Test
    public void fillInContactForm() {
        HomePage homePage = new HomePage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        Assertions.assertThat(homePage.userLoggedIn().equals(false));

        driver.findElement(By.cssSelector("a[title=contact]")).click();

        //select customer service
        contactUsPage.submitForm("Customer service","bootcamper@feelthepain.com", 4321234, "<Ipod defect while lifting, need new one>");
        Assertions.assertThat(driver.findElement(By.xpath("//p[@class=\"alert alert-success\"]")).isDisplayed());
    }
}
