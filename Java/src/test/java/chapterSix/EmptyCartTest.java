package chapterSix;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class EmptyCartTest extends TestShopScenario {

    //FillCartTest fillCartTest = new FillCartTest();
    //fillCartTest.addToCart();

    @Test
    public void removeFromCart() {
        boolean cartIsEmpty = driver.findElement(By.className("ajax_cart_no_product")).isDisplayed();
        Actions hover = new Actions(driver);

        WebElement cart = driver.findElement(By.cssSelector("a[title='View my shopping cart']"));
        hover.moveToElement(cart).build().perform();
        wait.until();
        if (cartIsEmpty) {
            System.out.println("Cart is empty");
        }
        else {
            System.out.println("Cart is not empty");
            driver.findElement(By.className("ajax_cart_block_remove_link")).click();
        }
        Assertions.assertThat(driver.findElement(By.className("ajax_cart_no_product")).isDisplayed());

    }
}
