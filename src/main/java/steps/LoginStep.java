package steps;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

@Log4j2
public class LoginStep {

    WebDriver driver;
    LoginPage loginPage;

    public LoginStep(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
    }

    public void authPositive(String email, String password) {
        log.info("Start login process with: email={}, password={}", email, password);
        loginPage.open()
                .isPageOpened()
                .login(email, password);
    }

    public void authNegative(String email, String password) {
        log.info("Start negative login process with: email={}, password={}", email, password);
        loginPage.open()
                .isPageOpened()
                .loginWithNegativeCred(email, password);
    }
}
