package steps;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginStep {

    WebDriver driver;
    LoginPage loginPage;

    public LoginStep(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
    }

    public void authPositive(String email, String password) {
        loginPage.open()
                .isPageOpened()
                .login(email, password);
    }

    public void authNegative(String email, String password) {
        loginPage.open()
                .isPageOpened()
                .loginWithNegativeCred(email, password);
    }
}
