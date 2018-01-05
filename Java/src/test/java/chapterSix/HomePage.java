package chapterSix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(className=("login"))
    private WebElement logInButton;

    @FindBy(className=("logout"))
    private WebElement logOutButton;

    @FindBy(css="h4[class='title_block'] a[title='My wishlists']")
    private WebElement wishListLink;

    @FindBy(css=("a[title=contact]"))
    private WebElement contactUsLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public Boolean userLoggedOut() {
        return (logInButton).isDisplayed();
    }

    public Boolean userLoggedIn() {
        return (logOutButton).isDisplayed();
    }

    public void clickLogInButton() {
        logInButton.click();
    }

    public void clickLogOutButton() {
        WebElement logOutButton = driver.findElement(By.className("logout"));
        logOutButton.click();
    }

    public void clickWishList() {
        wishListLink.click();
    }

    public void clickContactUs() {
        contactUsLink.click();
    }
}
