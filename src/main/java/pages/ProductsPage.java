package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class ProductsPage extends BasePage {

    private final By TITLE = By.cssSelector("[data-test = title]");
    private final By CART = By.cssSelector("[data-test=shopping-cart-link]");
    private final String ADD_TO_CART_PATTERN =
            "//*[text()='%s']//ancestor::div[@class='inventory_item']//button[text()='Add to cart']";
    private final By ITEM = By.xpath("//div[@data-test='inventory-list']//descendant::div[@data-test='inventory-item']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductsPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        } catch (Exception e) {
            log.error("ProductsPage is not opened within timeout", e);
            Assert.fail("ProductsPage is not opened within timeout");
        }
        return this;
    }

    public String getTitle() {
        log.info("Get title");
        return driver.findElement(TITLE).getText();
    }

    @Step("Добавление товара в корзину с именем: '{product}'")
    public ProductsPage addToCart(String product) {
        log.info("Add product to cart: {}", product);
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product))).click();
        return this;
    }

    @Step("Нажатие на кнопку корзины")
    public CartPage clickCart() {
        log.info("Click cart button");
        driver.findElement(CART).click();
        return new CartPage(driver);
    }

    public Boolean itemIsDisplayed() {
        return driver.findElement(ITEM).isDisplayed();
    }
}
