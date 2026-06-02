package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class ProductTest extends BaseTest {

    @Test(description = "Проверка, что страница товаров не пустая",
            testName = "Проверка, что страница товаров не пустая",
            groups = "regression"
    )
    @Owner("Kinev")
    @Epic("Sauce Demo")
    @Feature("Products")
    @Story("Проверка что страница не пустая")
    public void checkItemInPage() {
        log.info("Start test: checkItemInPage");
        loginStep.authPositive("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.itemIsDisplayed(), "Товары не найдены");
    }
}
