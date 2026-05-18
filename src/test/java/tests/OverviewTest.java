package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OverviewTest extends BaseTest {

    @Test(description = "Проверка названия товара на странице Overview",
            testName = "Проверка названия товара на странице Overview",
            groups = {"smoke", "regression"}
    )
    public void checkOverviewInfo() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.clickCheckout();
        checkoutPage.checkoutForm("First", "last", "123456");
        Assert.assertEquals(overviewPage.checkOverviewItem(), "Sauce Labs Backpack", "The text is not the same");
    }
}
