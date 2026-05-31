package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(ProductTest.class);

    @Test(description = "Проверка, что страница товаров не пустая",
            testName = "Проверка, что страница товаров не пустая",
            groups = "regression"
    )
    @Owner("Kinev")
    @Epic("Sauce Demo")
    @Feature("Products")
    @Story("Проверка что страница не пустая")
    public void checkItemInPage() {
        loginStep.authPositive("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.itemIsDisplayed(), "Товары не найдены");
    }
}
