/*package chapterSix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ValidateSupplierProductTest extends TestShopScenario {

    public void validateSupplierListItem() {
        driver.findElement(By.className("More about AppleStore")).click();
        WebElement dropDown = driver.findElement(By.className("More about AppleStore"));
        List<WebElement> allProducts = dropDown.findElements(By.xpath("//div[@class='product_container']/div/div/a"));
        for (int i=0;i < allProducts.size();i++) {
            List<String> title = allProducts.get(i).getAttribute("title");
            productNames.add(title);
                //Select supplierList = new Select(driver.findElement(By.classname("product_container")));
                //dropDown.selectByVisibleText("VisibleText");
            if (allProducts.selectByVisibleTest)
        }
    }
}*/
