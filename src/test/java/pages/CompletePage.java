package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage extends BasePage {

    private final String COMPLETE_MESSAGE = "//h2[@data-test='complete-header']";
    private final By BACK_PRODUCTS = By.xpath("//button[@data-test='back-to-products']");

    public CompletePage(WebDriver driver) {
        super(driver);
    }

    public String checkMessageAfterOrder() {
        return driver.findElement(By.xpath(COMPLETE_MESSAGE)).getText();
    }

    public void clickBackHomeButton() {
        driver.findElement(BACK_PRODUCTS).click();
    }
}
