package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage extends BasePage {

    private final By FINISH = By.xpath("//button[@data-test='finish']");
    private final String NAME_ITEM_CART = "//*[text()='Sauce Labs Backpack']//ancestor::div[@class='cart_item']//div[@class='inventory_item_name']";

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step("проверяем информацию о товаре на странице Overview")
    public String checkOverviewItem() {
        return driver.findElement(By.xpath(NAME_ITEM_CART)).getText();
    }

    @Step("Нажатие кнопки  Finish")
    public void clickFinishButton() {
        driver.findElement(FINISH).click();
    }
}
