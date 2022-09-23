package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractBasePage;

public class SignInPageElements extends AbstractBasePage {

    public SignInPageElements(WebDriver driver) {
        super(driver);
    }

    private final static String EMAIL_OR_USERNAME_FIELD = "//input[@id='username-input']";
    private final static String PASSWORD_FIELD = "//input[@id='password-input']";
    private final static String ENTER_BTN = "//button[@type='submit']";
    private final static String ALERT_MESSAGE_AUTHENTICATION = "//div[contains(@class,'error-toast')]/div";
    private final static String ALERT_MESSAGE_INVALID_EMAIL_FORMAT = "//mat-error[@aria-live='polite']";


    public WebElement getEmailOrUsernameField() {
        return waitVisibleOfElement(EMAIL_OR_USERNAME_FIELD);
    }

    public WebElement getPasswordField() {
        return waitVisibleOfElement(PASSWORD_FIELD);
    }

    public WebElement getEnterBtn() {
        return waitClickableElementByXpath(ENTER_BTN);
    }

    public WebElement getAlertAuthenticationMessage() {
        return waitClickableElementByXpath(ALERT_MESSAGE_AUTHENTICATION);
    }

    public WebElement getAlertEmailMessage() {
        return waitClickableElementByXpath(ALERT_MESSAGE_INVALID_EMAIL_FORMAT);
    }
}
