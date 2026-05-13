package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OverviewTest extends BaseTest {

    @Test
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
