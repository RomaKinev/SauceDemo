package tests;

import io.qameta.allure.*;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Log4j2
public class LoginTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    @Test(priority = 1,
            description = "Проверка логина с позитивными кредами",
            testName = "Проверка логина с позитивными кредами",
            groups = "smoke"
    )
    @Owner("Kinev")
    @Epic("Sauce Demo")
    @Feature("Login")
    @Story("Login with positive cred")
    @Description("Проверка логина с позитивными кредами")
    @Severity(SeverityLevel.CRITICAL)
    @Flaky
    @Link(name = "Web", url = "https://www.saucedemo.com")
    @TmsLink("SD-01")
    @Issue("BUG-01")
    public void checkLoginWithPositiveCred() {
        log.info("Start test: checkLoginWithPositiveCred");
        loginStep.authPositive("standard_user", "secret_sauce");
        productsPage.isPageOpened();
        assertEquals(productsPage.getTitle(),
                "Products",
                "error message");
    }

    @DataProvider(name = "Параметризированный тест для негативного логина")
    public Object[][] loginData() {
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"test", "test", "Epic sadface: Username and password do not match any user in this service"},
        };
    }

    @Test(dataProvider = "Параметризированный тест для негативного логина",
            description = "Проверка логина с негативными кредами",
            testName = "Проверка логина с негативными кредами",
            groups = "regression"
    )
    @Owner("Kinev")
    @Epic("Sauce Demo")
    @Feature("Login")
    @Story("Login with negative cred")
    public void checkLoginWithNegativeCred(String user, String password, String errorMessage) {
        log.info("Start test: checkLoginWithNegativeCred");
        loginStep.authNegative(user, password);
        assertEquals(loginPage.getErrorMessage(),
                errorMessage,
                "Error message incorrect");
    }

}
