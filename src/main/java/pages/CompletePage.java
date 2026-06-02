package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class CompletePage extends BasePage {

    private final String COMPLETE_MESSAGE = "//h2[@data-test='complete-header']";
    private final By BACK_PRODUCTS = By.xpath("//button[@data-test='back-to-products']");

    public CompletePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CompletePage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(BACK_PRODUCTS));
        } catch (Exception e) {
            log.error("Complete page is not opened: " + e.getMessage());
            Assert.fail("Complete page is not opened: " + e.getMessage());
        }
        return this;
    }

    @Step("Текст сообщения после успешной покупки")
    public String checkMessageAfterOrder() {
        log.info("Get message after order");
        return driver.findElement(By.xpath(COMPLETE_MESSAGE)).getText();
    }

    @Step("Кнопка возвращения на главную после покупки")
    public ProductsPage clickBackHomeButton() {
        log.info("Click on back to products button");
        driver.findElement(BACK_PRODUCTS).click();
        return new ProductsPage(driver);
    }
}
