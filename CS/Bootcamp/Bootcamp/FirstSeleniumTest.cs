using System;
using FluentAssertions;
using Microsoft.VisualStudio.TestTools.UnitTesting;


namespace Bootcamp
{
    [TestClass]
    public class FirstSeleniumTest
    {
        [TestMethod]
        public void loginSuccessful()
        {
            WebDriver driver = new ChromeDriver();
            driver.get("https://techblog.polteq.com/testshop/index.php");

            driver.FindElement(By.className("login")).click();

            /*        driver.FindElement(By.id("email_create")).sendKeys("testjasper@polteq.com");
                    driver.FindElement(By.id("SubmitCreate")).click();*/

            driver.FindElement(By.id("email")).sendKeys("testjasper@polteq.com");
            driver.FindElement(By.id("passwd")).sendKeys("Testje");
            driver.FindElement(By.id("SubmitLogin")).click();
            String userName = driver.FindElement(By.className("account")).Text();
            String accountPageHeading = driver.FindElement(By.className("page-heading")).Text();
            Assertions.assertThat(userName).as("Login name displayed in header").isEqualTo("Jasper de Boer");
            Assertions.assertThat(accountPageHeading).as("My account displayed in body").isEqualToIgnoringCase("my account");
            driver.quit();
        }
    }
}