package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CompleteTest extends BaseTest{

    @Test
    public void checkSuccessOrder() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.loginStandartUser();
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCart();
        cartPage.clickCheckout();
        checkoutPage.checkoutFormSuccess();
        overviewPage.clickFinishButton();
        softAssert.assertEquals(completePage.checkMessageAfterOrder(),
                "Thank you for your order!",
                "The text is not the same");
        completePage.clickBackHomeButton();
        softAssert.assertEquals(basePage.getTitle(),
                "Products",
                "The text is not the same");
        softAssert.assertAll();
    }
}
