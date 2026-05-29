package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    private final By FIRSTNAME = By.xpath("//input[@data-test='firstName']");
    private final By LASTNAME = By.xpath("//input[@data-test='lastName']");
    private final By POSTALCODE = By.xpath("//input[@data-test='postalCode']");
    private final By CONTINUE = By.xpath("//input[@data-test='continue']");
    private final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CheckoutPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CONTINUE));
        return this;
    }

    @Step("Заполнение формы checkout данными '{firstName}', '{lastName}', '{postalCode}'")
    public OverviewPage checkoutForm(String firstName, String lastName, String postalCode) {
        driver.findElement(FIRSTNAME).sendKeys(firstName);
        driver.findElement(LASTNAME).sendKeys(lastName);
        driver.findElement(POSTALCODE).sendKeys(postalCode);
        driver.findElement(CONTINUE).click();
        return new OverviewPage(driver);
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
