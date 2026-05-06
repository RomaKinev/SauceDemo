import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartTest extends BaseTest{

    @Test
    public void checkAddItemToCart(){
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("submit-button")).click();
        driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']")).click();
        String nameThingOnMain = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]"))
                .getText();
        String costThingOnMain = driver.findElement(By.xpath("//button[@data-test='remove-sauce-labs-backpack']/preceding::div[@data-test='inventory-item-price']"))
                .getText();
        driver.findElement(By.xpath("//a[@data-test='shopping-cart-link']")).click();
        softAssert.assertEquals(driver.findElement(By.xpath("//div[@data-test='inventory-item-name']"))
                .getText(),nameThingOnMain,
                "The text is not the same");
        softAssert.assertEquals(driver.findElement(By.xpath("//div[@data-test='inventory-item-price']"))
                .getText(),costThingOnMain,
                "The text is not the same");
    }
}
