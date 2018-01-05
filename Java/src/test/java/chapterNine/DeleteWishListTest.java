package chapterNine;

import chapterSix.HomePage;
import chapterSix.MyAccountPage;
import chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DeleteWishListTest extends TestShopScenario {

    @Test
    public void deleteWishListItem() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        MyWishListPage myWishListPage = new MyWishListPage(driver);

        driver.findElement(By.className("login")).click();
        myAccountPage.logIn("Jasper@deBoer.com", "1qazxsw2");
        //Assertions.assertThat(homePage.userLoggedIn().equals(true));

        homePage.clickWishList();

        myWishListPage.deleteWishListItem("Feel the pain");
        Assertions.assertThat(!driver.findElement(By.xpath("//td/a[text() = ' Feel the pain ']")).isDisplayed());
        myWishListPage.addWishListItem("Feel the pain");
        Assertions.assertThat(driver.findElement(By.xpath("//td/a[text() = ' Feel the pain ']")).isDisplayed());
    }

}
