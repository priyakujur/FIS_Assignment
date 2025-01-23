package fis.pages;

import fis.utility.CommonActions;
import org.openqa.selenium.WebDriver;

public class SearchBook extends CommonActions {

    private static String searchBox = "//div[@class='gh-search-input__wrap']/label[text()='Enter your search keyword']/following-sibling::input[@title='Search']";
    private static String searchButton = "//span[text()='Search']";
    private static String firstItemInListing = "//ul[@class='srp-results srp-list clearfix']/li[1]/div/div/a[@class='s-item__link']";

    CommonActions action = new CommonActions();

    public void bookSearch(WebDriver driver,String text){
      action.click(driver,searchBox);
      action.type(driver,searchBox,text);
      action.click(driver,searchButton);
      action.click(driver,firstItemInListing);
    }



}
