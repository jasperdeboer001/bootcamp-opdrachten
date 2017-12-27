package exercises;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    @Test
    public void loginSuccessful() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://techblog.polteq.com/testshop/index.php");

        driver.findElement(By.className("login")).click();

/*        driver.findElement(By.id("email_create")).sendKeys("testjasper@polteq.com");
        driver.findElement(By.id("SubmitCreate")).click();*/

        driver.findElement(By.id("email")).sendKeys("testjasper@polteq.com");
        driver.findElement(By.id("passwd")).sendKeys("Testje");
        driver.findElement(By.id("SubmitLogin")).click();
        String userName = driver.findElement(By.className("account")).getText();
        String accountPageHeading = driver.findElement(By.className("page-heading")).getText();
        Assertions.assertThat(userName).as("Login name displayed in header").isEqualTo("Jasper de Boer");
        Assertions.assertThat(accountPageHeading).as("My account displayed in body").isEqualToIgnoringCase("my account");
        driver.quit();
    }
}
