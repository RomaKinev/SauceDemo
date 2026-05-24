package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final By CART = By.cssSelector("[data-test=shopping-cart-link]");
    private final String ADD_TO_CART_PATTERN =
            "//*[text()='%s']//ancestor::div[@class='inventory_item']//button[text()='Add to cart']";
    private final By ITEM = By.xpath("//div[@data-test='inventory-list']//descendant::div[@data-test='inventory-item']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Добавление товара в корзину с именем: '{product}'")
    public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product))).click();
    }

    @Step("Нажатие на кнопку корзины")
    public void clickCart() {
        driver.findElement(CART).click();
    }

    public Boolean itemIsDisplayed() {
        return driver.findElement(ITEM).isDisplayed();
    }
}
