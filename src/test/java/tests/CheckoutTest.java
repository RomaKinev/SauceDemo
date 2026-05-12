package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkCheckoutSuccess() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.clickCheckout();
        assertEquals(basePage.getTitle(), "Checkout: Your Information","The text is not the same");
    }

    @Test
    public void checkCheckoutFormWithEmptyFirstName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.clickCheckout();
        checkoutPage.checkoutForm("", "last", "123456");
        assertEquals(checkoutPage.getErrorMessage(),
                "Error: First Name is required",
                "Error message incorrect");
    }

    @Test
    public void checkCheckoutFormWithEmptyLastName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.clickCheckout();
        checkoutPage.checkoutForm("first", "", "123456");
        assertEquals(checkoutPage.getErrorMessage(),
                "Error: Last Name is required",
                "Error message incorrect");
    }

    @Test
    public void checkCheckoutFormWithEmptyPostalCode() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.clickCheckout();
        checkoutPage.checkoutForm("first", "last", "");
        assertEquals(checkoutPage.getErrorMessage(),
                "Error: Postal Code is required",
                "Error message incorrect");
    }
}
