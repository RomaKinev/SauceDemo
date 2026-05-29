package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CompletePage extends BasePage {

    private final String COMPLETE_MESSAGE = "//h2[@data-test='complete-header']";
    private final By BACK_PRODUCTS = By.xpath("//button[@data-test='back-to-products']");

    public CompletePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CompletePage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BACK_PRODUCTS));
        return this;
    }

    @Step("Текст сообщения после успешной покупки")
    public String checkMessageAfterOrder() {
        return driver.findElement(By.xpath(COMPLETE_MESSAGE)).getText();
    }

    @Step("Кнопка возвращения на главную после покупки")
    public ProductsPage clickBackHomeButton() {
        driver.findElement(BACK_PRODUCTS).click();
        return new ProductsPage(driver);
    }
}
