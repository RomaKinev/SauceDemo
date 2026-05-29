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
        loginPage.open()
                .login("standard_user", "secret_sauce")
                .addToCart("Sauce Labs Backpack")
                .clickCart()
                .clickCheckout()
                .checkoutForm("First", "last", "123456")
                .clickFinishButton();
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
