package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OverviewPage extends BasePage {

    private final By FINISH = By.xpath("//button[@data-test='finish']");
    private final String NAME_ITEM_CART = "//*[text()='Sauce Labs Backpack']//ancestor::div[@class='cart_item']//div[@class='inventory_item_name']";

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public OverviewPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(FINISH));
        return this;
    }

    @Step("проверяем информацию о товаре на странице Overview")
    public String checkOverviewItem() {
        return driver.findElement(By.xpath(NAME_ITEM_CART)).getText();
    }

    @Step("Нажатие кнопки  Finish")
    public CompletePage clickFinishButton() {
        driver.findElement(FINISH).click();
        return new CompletePage(driver);
    }
}
