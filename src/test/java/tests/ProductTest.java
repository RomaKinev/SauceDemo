package tests;

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
    public void checkItemInPage() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.itemIsDisplayed(), "Товары не найдены");
    }
}
