package Automation;

import fis.base.DriverInitialisation;
import fis.pages.AddToCart;
import fis.pages.SearchBook;
import fis.utility.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestExec {

    private WebDriver driver;
    private SearchBook addBook;
    private AddToCart addToCart;

    String website ="https://www.ebay.com/";
    String textToSearch = "book";


    @BeforeClass
    @Parameters("browser")
    @Test
    public void prerequisiteSetup(String browser){
      driver = DriverInitialisation.getInstance(browser).fetchDriver();
    }

    @Test(priority=0)
    public void launchBrowser(){
        driver.get(website);
    }

    @Test(priority=1)
    public void searchBook(){
        addBook = new SearchBook();
        addBook.bookSearch(driver,textToSearch);

    }


    @Test(priority=2)
    public void openItemAndAddToCart(){
        addToCart = new AddToCart();
        addToCart.switchToNewWindow(driver);
        addToCart.clickOnAddToCart(driver);


    }

     @Test(priority=3)
     public void verifyIfCartIsUpdated(){
         boolean flag = addToCart.verifyIfNewProductGotAdded(driver);
         Assert.assertEquals(flag,true);
         System.out.println("Test Passed");
     }


    @Test(priority=4)
    public void closeThread(){
      driver.quit();
    }
}
