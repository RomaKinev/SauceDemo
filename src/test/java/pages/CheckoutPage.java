package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{

    private final By FIRSTNAME = By.xpath("//input[@data-test='firstName']");
    private final By LASTNAME = By.xpath("//input[@data-test='lastName']");
    private final By POSTALCODE = By.xpath("//input[@data-test='postalCode']");
    private final By CONTINUE = By.xpath("//input[@data-test='continue']");
    private final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void checkoutForm(String firstName, String lastName, String postalCode){
        driver.findElement(FIRSTNAME).sendKeys(firstName);
        driver.findElement(LASTNAME).sendKeys(lastName);
        driver.findElement(POSTALCODE).sendKeys(postalCode);
        driver.findElement(CONTINUE).click();
    }

    public void checkoutFormSuccess(){
        driver.findElement(FIRSTNAME).sendKeys("First Name");
        driver.findElement(LASTNAME).sendKeys("Last Name");
        driver.findElement(POSTALCODE).sendKeys("123456");
        driver.findElement(CONTINUE).click();
    }

    public String getErrorMessage(){
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
