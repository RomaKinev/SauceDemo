package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage extends BasePage{

    private final By FINISH = By.xpath("//button[@data-test='finish']");
    private final String NAME_ITEM_CART = "//*[text()='Sauce Labs Backpack']//ancestor::div[@class='cart_item']//div[@class='inventory_item_name']";

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public String checkOverviewItem (){
        return driver.findElement(By.xpath(NAME_ITEM_CART)).getText();
    }

    public void clickFinishButton(){
        driver.findElement(FINISH).click();
    }
}
