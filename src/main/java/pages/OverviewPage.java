package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class OverviewPage extends BasePage {

    private final By FINISH = By.xpath("//button[@data-test='finish']");
    private final String NAME_ITEM_CART = "//*[text()='Sauce Labs Backpack']//ancestor::div[@class='cart_item']//div[@class='inventory_item_name']";

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public OverviewPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(FINISH));
        } catch (Exception e) {
            log.error("OverviewPage is not opened within timeout", e);
            Assert.fail("OverviewPage is not opened within timeout");
        }
        return this;
    }

    @Step("проверяем информацию о товаре на странице Overview")
    public String checkOverviewItem() {
        log.info("Get item name on Overview");
        return driver.findElement(By.xpath(NAME_ITEM_CART)).getText();
    }

    @Step("Нажатие кнопки  Finish")
    public CompletePage clickFinishButton() {
        log.info("Click Finish button on Overview page");
        driver.findElement(FINISH).click();
        return new CompletePage(driver);
    }
}
