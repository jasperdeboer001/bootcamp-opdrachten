package chapterSix;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

import org.testng.annotations.Test;

public class LogOutTest extends TestShopScenario {

    @Test
    public void signOut() {
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("testjasper@polteq.com");
        driver.findElement(By.id("passwd")).sendKeys("Testje");
        driver.findElement(By.id("SubmitLogin")).click();

        String userName = driver.findElement(By.className("account")).getText();
        String myAccount = driver.findElement(By.className("page-heading")).getText();
        String logOutButton = driver.findElement(By.className("logout")).getText();

        Assertions.assertThat(userName).as("Login name displayed in header").isEqualTo("Jasper de Boer");
        Assertions.assertThat(myAccount).as("My account displayed in body").isEqualToIgnoringCase("my account");
        Assertions.assertThat(logOutButton).as("Sign out is displayed").isEqualTo("Sign out");

        driver.findElement(By.className("logout")).click();

        String header = driver.findElement(By.className("nav")).getText();
        String authentication = driver.findElement(By.className("page-heading")).getText();
        String logInButton = driver.findElement(By.className("login")).getText();


        Assertions.assertThat(header).as("Header does not contain user name").doesNotContain("Jasper de Boer");
        Assertions.assertThat(authentication).as("Authentication displayed in body").isEqualToIgnoringCase("authentication");
        Assertions.assertThat(logInButton).as("Sign in is displayed").isEqualTo("Sign in");
    }
}
