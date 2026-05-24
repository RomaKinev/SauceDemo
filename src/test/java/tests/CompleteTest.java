package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CompleteTest extends BaseTest {

    @Test(description = "Проверка полного оформления заказа",
            testName = "Проверка полного оформления заказа",
            groups = {"smoke", "regression"}
    )
    @Owner("Kinev")
    @Epic("Sauce Demo")
    @Feature("Complete")
    @Story("Успешный заказ")
    public void checkSuccessOrder() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.clickCheckout();
        checkoutPage.checkoutForm("First", "last", "123456");
        overviewPage.clickFinishButton();
        softAssert.assertEquals(completePage.checkMessageAfterOrder(),
                "Thank you for your order!",
                "The text is not the same");
        completePage.clickBackHomeButton();
        softAssert.assertEquals(basePage.getTitle(),
                "Product",
                "The text is not the same");
        softAssert.assertAll();
    }
}
