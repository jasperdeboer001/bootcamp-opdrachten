package chapterSix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(css="a[class='login']")
    private WebElement loginButton;

    @FindBy(css="h4[class='title_block'] a[title='My wishlists']")
    private WebElement wishListLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public Boolean userLoggedIn() {
        return (!loginButton.isDisplayed());
    }

    public void logOut() {
        driver.findElement(By.className("logout")).click();
    }

    public void clickWishList() {
        wishListLink.click();
    }
}
