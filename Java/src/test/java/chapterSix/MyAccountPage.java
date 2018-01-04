package chapterSix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void logIn(String userName, String passwd) {
        driver.findElement(By.id("email")).sendKeys(userName);
        driver.findElement(By.id("passwd")).sendKeys(passwd);
        driver.findElement(By.id("SubmitLogin")).click();
    }
}
