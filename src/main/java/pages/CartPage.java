package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final String NAME_ITEM_CART = "//*[text()='Sauce Labs Backpack']//ancestor::div[@class='cart_item']//div[@class='inventory_item_name']";
    private final String REMOVE_FROM_CART_PATTERN = "//*[text()='%s']//ancestor::div[@class='cart_item']//button[starts-with(@id, 'remove')]";
    private final By CHECKOUT = By.xpath("//button[@data-test='checkout']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Взятие имени товара")
    public String checkCadtItem() {
        return driver.findElement(By.xpath(NAME_ITEM_CART)).getText();
    }

    @Step("Удаление товара из корзины")
    public void removeFromCart(String product) {
        driver.findElement(By.xpath(String.format(REMOVE_FROM_CART_PATTERN, product))).click();
    }

    @Step("Проверка отсутсвия товара товара")
    public boolean isProductNotDisplayed(String product) {
        return driver.findElements(By.xpath(String.format("//div[@class='cart_item' and text()='%s']", product))).isEmpty();
    }

    @Step("Нажатие кнопки Checkout")
    public void clickCheckout() {
        driver.findElement(CHECKOUT).click();
    }
}
