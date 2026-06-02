package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static org.testng.Assert.fail;

@Log4j2
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
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CONTINUE));
        } catch (Exception e) {
            log.error("Checkout page is not opened: " + e.getMessage());
            Assert.fail("Checkout page is not opened: " + e.getMessage());
        }
        return this;
    }

    @Step("Заполнение формы checkout данными '{firstName}', '{lastName}', '{postalCode}'")
    public OverviewPage checkoutForm(String firstName, String lastName, String postalCode) {
        log.info("Fill checkout form with data: firstName: " + firstName + ", lastName: " + lastName + ", postalCode: " + postalCode);
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
