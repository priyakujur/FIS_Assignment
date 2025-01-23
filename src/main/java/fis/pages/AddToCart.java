package fis.pages;

import fis.utility.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCart extends CommonActions {
    private static String addToCartButton = "//span[text()='Add to cart']";
    private static String shoppingCartText = "//span[@class='gh-cart__icon']";

    static int itemsInCart;
    int itemsInCartBefore;
    int itemsInCartAfter;

    static CommonActions action = new CommonActions();
    //AddToCart add = new AddToCart();

    public void switchToNewWindow(WebDriver driver) {
        action.switchToNewTab(driver);
        itemsInCartBefore = verifyItemCountAddedToCart(driver);
        System.out.println("Number of items in cart before : " + itemsInCartBefore);

    }

    public void clickOnAddToCart(WebDriver driver) {
        action.click(driver, addToCartButton);
        itemsInCartAfter = verifyItemCountAddedToCart(driver);
        System.out.println("Number of items in cart after : " + itemsInCartAfter);

    }

    public static int verifyItemCountAddedToCart(WebDriver driver) {
        String textReturned = action.getText(driver, shoppingCartText);

        if (textReturned.isEmpty()) {
            return 0;
        } else {
            itemsInCart = Integer.parseInt(textReturned);
            return itemsInCart;

        }
    }

    public boolean verifyIfNewProductGotAdded(WebDriver driver){
        if(itemsInCartAfter>itemsInCartBefore){
            System.out.println("Selected item successfully got added to the cart");
            return true;
        }else{
            return false;
        }
    }
}
