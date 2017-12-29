package chapterSix;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

public class AdjustPersonalInfoTest extends TestShopScenario {

    public Boolean userLoggedIn() {
        String logInButton = driver.findElement(By.className("login")).getText();
        if (logInButton == "Sign in") {
            return false;
        }
            else {
               return true;
           }
    }

    public void createAccount() {
        if (userLoggedIn = false) {
            driver.findElement(By.className("login")).click();
            driver.findElement(By.id("email")).sendKeys("testjasper@polteq.com");
            driver.findElement(By.id("passwd")).sendKeys("Testje");
            driver.findElement(By.id("SubmitLogin")).click();
            driver.findElement(By.className("account")).click();
            driver.findElement(By.xpath("//ul[@class='myaccount-link-list']/li[5]/a/span")).click();
            String firstName = driver.findElement(By.xpath("//input[@id=firstname][@value]));
            if (firstName == "Jasper") {
                driver.findElement(By.className("first name")).clear();
                driver.findElement(By.className("first name")).sendKeys("Naam2");
            } else if (firstName == "Naam2") {
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
