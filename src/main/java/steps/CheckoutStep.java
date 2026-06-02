package steps;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;

@Log4j2
public class CheckoutStep {

    WebDriver driver;
    CheckoutPage checkoutPage;

    public CheckoutStep(WebDriver driver) {
        this.driver = driver;
        checkoutPage = new CheckoutPage(driver);
    }

    public void checkoutForm(String firstName, String lastName, String postalCode) {
        log.info("Start checkout process with: firstName={}, lastName={}, postalCode={}", firstName, lastName, postalCode);
        checkoutPage.isPageOpened()
                .checkoutForm(firstName, lastName, postalCode);

    }
}
