package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(description = "Проверка добавления товара в корзину",
            testName = "Проверка добавления товара в корзину",
            groups = "smoke"
    )

    @Owner("Kinev")
    @Epic("Sauce Demo")
    @Feature("Cart")
    @Story("add to cart")
    @Description("Проверка корзины")
    @Severity(SeverityLevel.CRITICAL)
    @Flaky
    @Link(name ="Web", url = "https://www.saucedemo.com")
    @TmsLink("SD-01")
    @Issue("BUG-01")
    public void checkAddItemToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        Assert.assertEquals(cartPage.checkCadtItem(), "Sauce Labs Backpack", "The text is not the same");
    }

    @Test(description = "Проверка удаления товара из корзины",
            testName = "Проверка удаления товара из корзины",
            groups = "regression"
    )
    @Owner("Kinev")
    @Epic("Sauce Demo")
    @Feature("Cart")
    @Story("удаление из корзины")
    public void checkRemoveFromCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.removeFromCart("Sauce Labs Backpack");
        Assert.assertTrue(cartPage.isProductNotDisplayed("Sauce Labs Backpack"), "The product is still in the cart!");
    }
}
