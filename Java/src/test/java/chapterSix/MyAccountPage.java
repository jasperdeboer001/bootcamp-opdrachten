package chapterSix;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    WebDriver driver;

    @FindBy(id=("email"))
    private WebElement emailField;

    @FindBy(id=("passwd"))
    private WebElement passwdField;

    @FindBy(id=("SubmitLogin"))
    private WebElement submitButton;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }


    public void logIn(String userName, String passwd) {
            emailField.sendKeys(userName);
            passwdField.sendKeys(passwd);
            submitButton.click();
    }

    public void clearFields() {
        emailField.clear();
        passwdField.clear();
    }
}
