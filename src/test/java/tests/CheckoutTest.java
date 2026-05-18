package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test(description = "Проверка checkout с позитивными данными",
            testName = "Проверка checkout с позитивными данными",
            groups = "smoke"
    )
    public void checkCheckoutSuccess() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.clickCheckout();
        assertEquals(basePage.getTitle(), "Checkout: Your Information", "The text is not the same");
    }

    @DataProvider(name = "Параметризированный тест для негативного заполнения формы Checkout")
    public Object[][] checkoutData() {
        return new Object[][]{
                {"", "last", "123456", "Error: First Name is required"},
                {"first", "", "123456", "Error: Last Name is required"},
                {"first", "last", "", "Error: Postal Code is required"},
        };
    }

    @Test(dataProvider = "Параметризированный тест для негативного заполнения формы Checkout",
            description = "Проверка checkout с негативными данными",
            testName = "Проверка checkout с негативными данными",
            groups = "regression"
    )
    public void checkCheckoutFormWithNegativeData(String firstName, String lastName, String postalCode, String error) {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.clickCheckout();
        checkoutPage.checkoutForm(firstName, lastName, postalCode);
        assertEquals(checkoutPage.getErrorMessage(),
                error,
                "Error message incorrect");
    }
}
