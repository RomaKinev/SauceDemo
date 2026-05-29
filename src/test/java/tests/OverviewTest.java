package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OverviewTest extends BaseTest {

    @Test(description = "Проверка названия товара на странице Overview",
            testName = "Проверка названия товара на странице Overview",
            groups = {"smoke", "regression"}
    )
    @Owner("Kinev")
    @Epic("Sauce Demo")
    @Feature("Overview")
    @Story("Check success overview form")
    public void checkOverviewInfo() {
        loginPage.open()
                .isPageOpened()
                .login("standard_user", "secret_sauce")
                .addToCart("Sauce Labs Backpack")
                .clickCart()
                .clickCheckout()
                .checkoutForm("First", "last", "123456");
        Assert.assertEquals(overviewPage.checkOverviewItem(), "Sauce Labs Backpack", "The text is not the same");
    }
}
