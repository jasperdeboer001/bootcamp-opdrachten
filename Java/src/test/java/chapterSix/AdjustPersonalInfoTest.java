package chapterSix;

import org.assertj.core.api.AbstractBooleanAssert;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AdjustPersonalInfoTest extends TestShopScenario {

    public AbstractBooleanAssert<?> userLoggedIn() {
        String logInButton = driver.findElement(By.className("login")).getText();
        return Assertions.assertThat(logInButton.equals("Sign out"));
    }

    public void createAccount(Boolean userLoggedIn) {
        if (userLoggedIn) {
            driver.findElement(By.className("login")).click();
            driver.findElement(By.id("email")).sendKeys("testjasper@polteq.com");
            driver.findElement(By.id("passwd")).sendKeys("Testje");
            driver.findElement(By.id("SubmitLogin")).click();
            driver.findElement(By.className("account")).click();
            driver.findElement(By.xpath("//ul[@class='myaccount-link-list']/li[5]/a/span")).click();
            WebElement firstName = driver.findElement(By.xpath("//input[@id='firstname']"));
            if (firstName.getAttribute("value").equals("Jasper")) {
                driver.findElement(By.className("first name")).clear();
                driver.findElement(By.className("first name")).sendKeys("Naam2");
            } else if (firstName.getAttribute("value").equals("Naam2")) {
                driver.findElement(By.className("first name")).clear();
                driver.findElement(By.className("first name")).sendKeys("Naamadres");
            } else {
                driver.findElement(By.className("first name")).clear();
                driver.findElement(By.className("first name")).sendKeys("Jasper");
            }
            driver.findElement(By.className("is_required validate form-control")).sendKeys("Testje");
            driver.findElement(By.className("savebutton")).click();
            Assertions.assertThat(driver.findElement(By.className("alert alert-success")).isDisplayed());
        }
    }
}