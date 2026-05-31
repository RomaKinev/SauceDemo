package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test(description = "Проверка checkout с позитивными данными",
            testName = "Проверка checkout с позитивными данными",
            groups = "smoke"
    )
    @Owner("Kinev")
    @Epic("Sauce Demo")
    @Feature("Checkout")
    @Story("Успешный чекаут")
    public void checkCheckoutSuccess() {
        loginStep.authPositive("standard_user", "secret_sauce");
        productsStep.addToCart("Sauce Labs Backpack");
        cartPage.clickCheckout();
        checkoutStep.checkoutForm("Test", "Test", "123456");
        assertEquals(overviewPage.getTitle(), "Checkout: Overview", "The text is not the same");
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
    @Owner("Kinev")
    @Epic("Sauce Demo")
    @Feature("Checkout")
    @Story("Чекаут с негативными данными")
    public void checkCheckoutFormWithNegativeData(String firstName, String lastName, String postalCode, String error) {
        loginStep.authPositive("standard_user", "secret_sauce");
        productsStep.addToCart("Sauce Labs Backpack");
        cartPage.clickCheckout();
        checkoutStep.checkoutForm(firstName, lastName, postalCode);
        assertEquals(checkoutPage.getErrorMessage(),
                error,
                "Error message incorrect");
    }
}
