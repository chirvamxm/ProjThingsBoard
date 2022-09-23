package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractBasePage;

public class DevicesPageElements extends AbstractBasePage {

    public DevicesPageElements(WebDriver driver) {
        super(driver);
    }

    private final static String ADD_DEVICE_BTN = "//mat-icon[text()='add']";
    private final static String ADD_NEW_DEVICE_BTN = "//button[@role='menuitem'][1]";
    private final static String NEW_DEVICE_FIELD = "//div[contains(@id,'cdk-overlay')]//%s[@formcontrolname='%s']";
    private final static String CREATE_NEW_DEVICE_PROFILE_RADIOBUTTON = "//label[@for='mat-radio-3-input']";
    private final static String NEW_DEVICE_PROFILE_NAME_FIELD = "//input[@formcontrolname='newDeviceProfileTitle']";
    private final static String NEXT_STEP_BUTTON = "//span[contains(text(),'Next')]";
    private final static String NEW_CUSTOMER_FIELD = "//input[@type='text'][@formcontrolname='entity']";
    private final static String ADD_BTN = "//div[@class='mat-dialog-actions']//button[@class='mat-focus-indicator mat-raised-button mat-button-base mat-primary']";
    private final static String CREATED_DEVICE = "//mat-cell[@class='mat-tooltip-trigger mat-cell cdk-cell cdk-column-name mat-column-name ng-star-inserted']";
    private final static String DELETE_DEVICE = "//mat-icon[contains(text(),' delete')]";
    private final static String ACCEPT_DELETING_DEVICE = "//button[@class='mat-focus-indicator mat-button mat-button-base mat-primary'][2]";
    private final static String ALERT_MESSAGE_DEVICE_ALREADY_EXISTS = "//div[text()='Device profile with such name already exists!']";
    private final static String ALERT_MESSAGE_NAME_NECESSARY = "//mat-error[@aria-live='polite']";
    private final static String CLOSE_WINDOW_BTN = "//button[@class='mat-focus-indicator mat-icon-button mat-button-base']//mat-icon[text()='close']";


    public WebElement getAddDeviceBtn() {
        return waitClickableElementByXpath(ADD_DEVICE_BTN);
    }

    public WebElement getAddNewDeviceBtn() {
        return waitClickableElementByXpath(ADD_NEW_DEVICE_BTN);
    }

    public WebElement getNewDeviceNameField() {
        return waitClickableElementByXpath(String.format(NEW_DEVICE_FIELD, "input", "name"));
    }

    public WebElement getNewDeviceLabelField() {
        return waitClickableElementByXpath(String.format(NEW_DEVICE_FIELD, "input", "label"));
    }

    public WebElement getCreateNewDeviceProfileRadioBtn() {
        return waitVisibleOfElement(CREATE_NEW_DEVICE_PROFILE_RADIOBUTTON);
    }

    public WebElement getDescriptionField() {
        return waitVisibleOfElement(String.format(NEW_DEVICE_FIELD, "textarea", "description"));
    }

    public WebElement getNextStepBtn() {
        return waitClickableElementByXpath(NEXT_STEP_BUTTON);
    }

    public WebElement getNewCustomerField() {
        return waitVisibleOfElement(NEW_CUSTOMER_FIELD);
    }

    public WebElement getAddBtn() {
        return waitVisibleOfElement(ADD_BTN);
    }

    public WebElement getCreatedDevice() {
        return waitVisibleOfElement(CREATED_DEVICE);
    }

    public WebElement getDeleteDevice() {
        return waitVisibleOfElement(DELETE_DEVICE);
    }

    public WebElement getAcceptDeletingDevice() {
        return waitVisibleOfElement(ACCEPT_DELETING_DEVICE);
    }

    public WebElement getAlertMessageAlreadyExists() {
        return waitVisibleOfElement(ALERT_MESSAGE_DEVICE_ALREADY_EXISTS);
    }

    public WebElement getNewDeviceProfileNameField() {
        return waitVisibleOfElement(NEW_DEVICE_PROFILE_NAME_FIELD);
    }

    public WebElement getAlertMessageNameNecessary() {
        return waitVisibleOfElement(ALERT_MESSAGE_NAME_NECESSARY);
    }

    public WebElement getCloseWindowBtn() {
        return waitVisibleOfElement(CLOSE_WINDOW_BTN);
    }

    public WebElement getCreateNewDeviceProfileNameField() {
        return waitVisibleOfElement(String.format(NEW_DEVICE_FIELD, "input", "name"));
    }

    public WebElement getCreateNewDeviceProfileDescriptionField() {
        return waitVisibleOfElement(String.format(NEW_DEVICE_FIELD, "textarea", "description"));
    }

    public WebElement getQueueNameField() {
        return waitClickableElementByXpath(String.format(NEW_DEVICE_FIELD, "input", "queueName"));
    }
}
