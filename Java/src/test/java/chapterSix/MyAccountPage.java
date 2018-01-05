package chapterSix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.By.className;

public class MyAccountPage {

    WebDriver driver;

    @FindBy(id=("email"))
    private WebElement emailFIeld;

    @FindBy(id=("passwd"))
    private WebElement passwdField;

    @FindBy(id=("SubmitLogin"))
    private WebElement submitButton;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }


    public void logIn(String userName, String passwd) {
            emailFIeld.sendKeys(userName);
            passwdField.sendKeys(passwd);
            submitButton.click();
    }

    public void clearFields() {
        emailFIeld.clear();
        passwdField.clear();
    }
}
