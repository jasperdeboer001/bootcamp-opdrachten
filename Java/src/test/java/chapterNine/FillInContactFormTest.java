package chapterNine;

import chapterSix.HomePage;
import chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class FillInContactFormTest extends TestShopScenario {

    @Test
    public void fillInContactForm() {
        HomePage homePage = new HomePage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        if (homePage.userLoggedOut().equals(false)) {
            driver.findElement(By.cssSelector("a[title=contact]")).click();
            contactUsPage.submitForm("Customer service", "bootcamper@feelthepain.com", 4321234, "<Ipod defect while lifting, need new one>");
            //wait

            Assertions.assertThat(driver.findElement(By.xpath("//p[@class=\"alert alert-success\"]")).isDisplayed());
        }
        else {
            System.out.println("Je bent nog ingelogd");
        }
    }

/*    public String validationMessage() {
        WebElement alertMessageElement = new WebDriverWait(driver, 10)).until
    }*/
}
