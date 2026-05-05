import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LocatorsTest  extends BaseTest{

    @Test
    public void checkDifferentsLocators(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("submit-button")).click();
        driver.findElement(By.tagName("button"));
        driver.findElement(By.linkText("Twitter"));
        driver.findElement(By.partialLinkText("Twitt"));
        driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']"));
        driver.findElement(By.xpath("//span[text()='Products']"));
        driver.findElement(By.xpath("//div[contains(@class,'logo')]"));
        driver.findElement(By.xpath("//div[contains(text(),'Swag')]"));
        driver.findElement(By.xpath("//button[text()='Add to cart'][1]//ancestor::div[@class='inventory_item']"));
        driver.findElement(By.xpath("//div[@class='inventory_item'][1]//descendant::button[text()='Add to cart']"));
        driver.findElement(By.xpath("(//div[@class='inventory_item'][2])//following::button[text()='Add to cart']"));
        driver.findElement(By.xpath("(//button[text()='Add to cart'])[1]//parent::div"));
        driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-bike-light']/preceding::button"));
        driver.findElement(By.xpath("//div[@data-test='inventory-item-name' and text()='Sauce Labs Bike Light']"));
        driver.findElement(By.cssSelector(".app_logo"));
        driver.findElement(By.cssSelector(".btn.btn_primary"));
        driver.findElement(By.cssSelector(".header_secondary_container .title"));
        driver.findElement(By.cssSelector("#react-burger-menu-btn"));
        driver.findElement(By.cssSelector("head"));
        driver.findElement(By.cssSelector("div.footer_copy"));
        driver.findElement(By.cssSelector("[data-test=shopping-cart-link]"));
        driver.findElement(By.cssSelector("[class~=btn_primary]"));
        driver.findElement(By.cssSelector("[data-test|='shopping-cart']"));
        driver.findElement(By.cssSelector("[data-test^=shopping]"));
        driver.findElement(By.cssSelector("[data-test$=link]"));
        driver.findElement(By.cssSelector("[data-test*=cart]"));
    }
}
