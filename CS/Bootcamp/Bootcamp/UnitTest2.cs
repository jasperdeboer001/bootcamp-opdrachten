using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using FluentAssertions;


public class FirstSeleniumTest
{

    @Test
    public void loginSuccessful()
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://techblog.polteq.com/testshop/index.php");

        driver.FindElement(By.ClassName("login")).click();

        /*        driver.FindElement(By.Id("email_create")).sendKeys("testjasper@polteq.com");
                driver.FindElement(By.Id("SubmitCreate")).click();*/

        driver.FindElement(By.Id("email")).sendKeys("testjasper@polteq.com");
        driver.FindElement(By.Id("passwd")).sendKeys("Testje");
        driver.FindElement(By.Id("SubmitLogin")).click();
        String userName = driver.FindElement(By.ClassName("account")).getText();
        String accountPageHeading = driver.FindElement(By.ClassName("page-heading")).getText();
       // FluentAssertions.AssertionOptions.Equals
        //FluentAssertions(userName).as("Login name displayed in header").IsEqualTo("Jasper de Boer");
        Assertions.assertThat(accountPageHeading).as("My account displayed in body").IsEqualToIgnoringCase("my account");
        driver.quit();
    }
}
