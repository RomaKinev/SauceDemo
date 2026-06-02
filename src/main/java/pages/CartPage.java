package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class CartPage extends BasePage {

    private final String NAME_ITEM_CART = "//*[text()='Sauce Labs Backpack']//ancestor::div[@class='cart_item']//div[@class='inventory_item_name']";
    private final String REMOVE_FROM_CART_PATTERN = "//*[text()='%s']//ancestor::div[@class='cart_item']//button[starts-with(@id, 'remove')]";
    private final By CHECKOUT = By.xpath("//button[@data-test='checkout']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CartPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NAME_ITEM_CART)));
        } catch (Exception e) {
            log.error("Cart page is not opened: " + e.getMessage());
            Assert.fail("Cart page is not opened: " + e.getMessage());
        }
        return this;
    }

    @Step("Взятие имени товара")
    public String checkCadtItem() {
        log.info("Get item name on card");
        return driver.findElement(By.xpath(NAME_ITEM_CART)).getText();
    }

    @Step("Удаление товара из корзины")
    public CartPage removeFromCart(String product) {
        log.info("Delete item from card");
        driver.findElement(By.xpath(String.format(REMOVE_FROM_CART_PATTERN, product))).click();
        return this;
    }

    @Step("Проверка отсутсвия товара")
    public boolean isProductNotDisplayed(String product) {
        log.info("Check if product is not displayed on card");
        return driver.findElements(By.xpath(String.format("//div[@class='cart_item' and text()='%s']", product))).isEmpty();
    }

    @Step("Нажатие кнопки Checkout")
    public CheckoutPage clickCheckout() {
        log.info("Click on checkout button");
        driver.findElement(CHECKOUT).click();
        return new CheckoutPage(driver);
    }
}
