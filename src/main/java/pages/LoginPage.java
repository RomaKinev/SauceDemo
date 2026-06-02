package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class LoginPage extends BasePage {

    private final By USERNAME_FIELD = By.id("user-name");
    private final By PASSWORD_FIELD = By.id("password");
    private final By LOGIN_FIELD = By.id("login-button");
    private final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы LoginPage")
    public LoginPage open() {
        log.info("Open LoginPage");
        driver.get("https://www.saucedemo.com/");
        return this;
    }

    @Step("Вход в систему с именем пользователя: '{user}' и паролем: '{password}'")
    public ProductsPage login(String user, String password) {
        log.info("Login with user: '{}' and password: '{}'", user, password);
        driver.findElement(USERNAME_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_FIELD).click();
        return new ProductsPage(driver);
    }

    @Step("Вход в систему с именем пользователя: '{user}' и паролем: '{password}'")
    public LoginPage loginWithNegativeCred(String user, String password) {
        log.info("Login with negative credentials: user: '{}' and password: '{}'", user, password);
        driver.findElement(USERNAME_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_FIELD).click();
        return this;
    }

    @Step("Страница логин пейдж открыта")
    @Override
    public LoginPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_FIELD));
        } catch (Exception e) {
            log.error("LoginPage is not opened within timeout", e);
            Assert.fail("LoginPage is not opened within timeout");
        }
        return this;
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
