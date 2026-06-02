package steps;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.ProductsPage;

@Log4j2
public class ProductsStep {

    WebDriver driver;
    ProductsPage productsPage;

    public ProductsStep(WebDriver driver) {
        this.driver = driver;
        productsPage = new ProductsPage(driver);
    }

    public void addToCart(String productName) {
        log.info("Add product to cart: {}", productName);
        productsPage.isPageOpened()
                .addToCart(productName)
                .clickCart();
    }
}
