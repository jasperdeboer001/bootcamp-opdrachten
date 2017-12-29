package chapterSix;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(css="a[class='login']")
    private WebElement loginButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public Boolean userLoggedIn() {
        if (loginButton.isDisplayed()) {
            return false;
        } else {
            return true;
        }
    }
}
