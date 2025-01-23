package fis.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class CommonActions {
    WebElement ele;
    public void click(WebDriver driver, String element){
        driver.findElement(By.xpath(element)).click();
    }

    public void type(WebDriver driver, String element,String text){
        ele = driver.findElement(By.xpath(element));
        ele.clear();
        ele.sendKeys(text);
    }

    public void switchToNewTab(WebDriver driver){
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        for(int i=1;i<tabs.size();i++) {
            driver.switchTo().window(tabs.get(i));
        }
    }

    public String getText(WebDriver driver, String element){
        String textReturned;
        ele = driver.findElement(By.xpath(element));
        textReturned = ele.getText();
        return textReturned;
    }
}
