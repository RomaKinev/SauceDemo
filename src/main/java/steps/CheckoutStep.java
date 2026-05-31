package steps;

import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;

public class CheckoutStep {

    WebDriver driver;
    CheckoutPage checkoutPage;

    public CheckoutStep(WebDriver driver) {
        this.driver = driver;
        this.checkoutPage = new CheckoutPage(driver);
    }

    public void checkoutForm(String firstName, String lastName, String postalCode) {
        checkoutPage.isPageOpened()
                .checkoutForm(firstName, lastName, postalCode);

    }
}
