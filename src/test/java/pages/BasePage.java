package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    private final By TITLE = By.cssSelector("[data-test=title]");

    WebDriver driver;

    public final String BASE_URL = "https://www.saucedemo.com";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle(){
        return driver.findElement(TITLE).getText();
    }
}
