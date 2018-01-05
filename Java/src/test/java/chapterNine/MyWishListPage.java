package chapterNine;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyWishListPage {
    WebDriver driver;

    public MyWishListPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    void deleteWishListItem(String item) throws InterruptedException {
        //locate table
        WebElement wishListTable = driver.findElement(By.cssSelector(".table.table-bordered"));
        //locate rows
        List<WebElement> tableRows = wishListTable.findElements(By.cssSelector("tbody tr"));
        //cycle through rows and print title
        for (int i = 0; i < tableRows.size(); i++) {
            System.out.println(i);
            String rowId = tableRows.get(i).getAttribute("id");
            List<WebElement> firstColumn = tableRows.get(i).findElements(By.xpath("//td[1]/a"));
            String title = firstColumn.get(i).getText();
            System.out.println("title :" + " " + title);

            //check if a title matches item to delete
            if (title.toLowerCase().equals(item.toLowerCase())) {
                System.out.println("Match found");
                //add rowId
                //tableRows.get(i).
                tableRows.get(i).findElement(By.xpath("//tr[@id='rowId']/td[@class='wishlist_delete']/a")).click();
                Thread.sleep(5000);
                driver.switchTo().alert().accept();
                Thread.sleep(5000);

                break;
            }
            else {
                System.out.println("Match not found");
            }
        }
    }


    void addWishListItem(String item) {
    driver.findElement(By.cssSelector(".inputTxt.form-control")).sendKeys(item);
        driver.findElement(By.cssSelector(".btn.btn-default.button.button-medium")).click();
    }

}


