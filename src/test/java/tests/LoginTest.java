package tests;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    @Test
    public void checkLoginWithPositiveCred(){
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        assertEquals(productsPage.getTitle(),
                "Products",
                "error message");
    }

    @Test
    public void checkLoginWithEmptyUserName(){
        loginPage.open();
        loginPage.login("","secret_sauce");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Error message incorrect");
    }

    @Test
    public void checkLoginWithEmptyPassword(){
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Error message incorrect");
    }

    @Test
    public void checkLoginWithNegativeCred(){
        loginPage.open();
        loginPage.login("qwerty","qwerty");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Error message incorrect");
    }
}
