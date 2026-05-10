package tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(ProductTest.class);

    @Test
    public void checkItemInPage() {
        loginPage.open();
        loginPage.loginStandartUser();
        Assert.assertTrue(productsPage.itemIsDisplayed(), "Товары не найдены");
    }
}
