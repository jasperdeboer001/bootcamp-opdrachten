package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

    WebDriver driver;

    @FindBy(css="select[id='id_contact']")
    private WebElement subjectDropdown;

    @FindBy(css="input[id='email']")
    private WebElement emailField;

    @FindBy(css="input[id='id_order']")
    private WebElement orderReferenceField;

    @FindBy(css="textarea[id='message']")
    private WebElement messageField;

    @FindBy(id="submitMessage")
    private WebElement submitButton;

    @FindBy(css="page-heading.bottom-indent")
    private WebElement pageHeading;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void submitForm(String subjectMessage, String email, int orderReference, String message) {
        //WebElement mySelectElement = driver.findElement(By.cssSelector("option[value='2']"));
        Select subjectDropdownField = new Select(driver.findElement(By.name("id_contact")));
        subjectDropdownField.selectByVisibleText(subjectMessage);
        emailField.sendKeys(email);
        orderReferenceField.sendKeys(String.valueOf(orderReference));
        messageField.sendKeys(message);
        submitButton.click();
    }

    public void clickPageHeading() {
        pageHeading.click();
    }

    public void clearData() {
        orderReferenceField.clear();
        emailField.clear();
        messageField.clear();
    }

}
