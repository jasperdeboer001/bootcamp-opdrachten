package chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FillCartTest extends TestShopScenario {

    @Test
    public void addToCart() {
        Assertions.assertThat(driver.findElement(By.className("ajax_cart_no_product")).isDisplayed());
        driver.findElement(By.cssSelector("a[title='More about ipod']")).click();
        //driver.findElement(By.cssSelector("a[title='iPod shuffle']")).click();
        driver.findElement(By.xpath("//a[@class=\"product-name\"][@title=\"iPod shuffle\"]")).click();
        driver.findElement(By.xpath("//p[@id='add_to_cart']/button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title=\"Continue shopping\"]/span")));
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[@class=\"continue btn btn-default button exclusive-medium\"]/span")).click();
        Assertions.assertThat(driver.findElement(By.className("ajax_cart_quantity")).equals(1));

    }
}
