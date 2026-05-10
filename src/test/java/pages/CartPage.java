package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final String NAME_ITEM_CART = "//*[text()='Sauce Labs Backpack']//ancestor::div[@class='cart_item']//div[@class='inventory_item_name']";
    private final String REMOVE_FROM_CART_PATTERN ="//*[text()='%s']//ancestor::div[@class='cart_item']//button[starts-with(@id, 'remove')]";
    private final By CHECKOUT = By.xpath("//button[@data-test='checkout']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String checkCadtItem (){
        return driver.findElement(By.xpath(NAME_ITEM_CART)).getText();
    }

    public void removeFromCart(String product){
        driver.findElement(By.xpath(String.format(REMOVE_FROM_CART_PATTERN,product))).click();
    }

    public boolean isProductNotDisplayed(String product){
        return driver.findElements(By.xpath(String.format("//div[@class='cart_item' and text()='%s']",product))).isEmpty();
    }

    public void clickCheckout(){
        driver.findElement(CHECKOUT).click();
    }
}
