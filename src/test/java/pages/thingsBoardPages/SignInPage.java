package pages.thingsBoardPages;

import elements.SignInPageElements;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class SignInPage extends SignInPageElements {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    private final String EMAIL = "randomuserforthingsboard@gmail.com";
    private final String PASSWORD = "K24bry1920Aezak";
    private final String EMPTY_EMAIL = "";
    private final String INVALID_EMAIL = "sutulasobaka@ukr.net";

    public String getEmail() {
        return this.EMAIL;
    }

    public String getPassword() {
        return PASSWORD;
    }

    public String getEmptyEmail() {
        return EMPTY_EMAIL;
    }

    public String getInvalidEmail() {
        return INVALID_EMAIL;
    }

    // Enter  valid credentials in SingIn fields
    public SignInPage enterSignInCredentials(String email, String password) {
        getEmailOrUsernameField().sendKeys(email);
        getPasswordField().sendKeys(password);
        return this;
    }

    // Click on enter button
    public SignInPage clickEnterBtn() {
        getEnterBtn().click();
        return this;
    }
}