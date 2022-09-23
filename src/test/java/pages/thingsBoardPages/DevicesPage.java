package pages.thingsBoardPages;

import elements.DevicesPageElements;
import org.openqa.selenium.WebDriver;

public class DevicesPage extends DevicesPageElements {

    public DevicesPage(WebDriver driver) {
        super(driver);
    }

    private final String DEVICE_NAME = "New test device";
    private final String DEVICE_LABEL = "Test Label";
    private final String DEVICE_DESCRIPTION = "This device is for testing purposes only.";
    private final String DEVICE_PROFILE_NAME = "New test device profile";
    private final String DEVICE_CUSTOMER_NAME = "Test customer";
    private final String DEVICE_PROFILES_QUEUE = "HighPriority";


    public String getDeviceName() {
        return this.DEVICE_NAME;
    }

    public String getDeviceLabel() {
        return DEVICE_LABEL;
    }

    public String getDeviceDescription() {
        return DEVICE_DESCRIPTION;
    }

    public String getDeviceProfileName() {
        return DEVICE_PROFILE_NAME;
    }

    public String getDeviceCustomerName() {
        return DEVICE_CUSTOMER_NAME;
    }

    public String getDeviceProfileQueue() {
        return DEVICE_PROFILES_QUEUE;
    }

    // Go to adding new device
    public DevicesPage addingNewDevice() {
        getAddDeviceBtn().click();
        getAddNewDeviceBtn().click();
        return this;
    }

    // Enter  valid credentials in Device fields
    public DevicesPage enterDeviceCredentials(String deviceName, String deviceLabel, String deviceDescription) {
        getNewDeviceNameField().sendKeys(deviceName);
        getNewDeviceLabelField().sendKeys(deviceLabel);
        getDescriptionField().sendKeys(deviceDescription);
        return this;
    }

    // Enter  valid credentials in Device profiles fields
    public DevicesPage addDeviceProfile(String deviceProfileName) {
        getCreateNewDeviceProfileRadioBtn().click();
        getNewDeviceProfileNameField().sendKeys(deviceProfileName);
        return this;
    }

    // Click to customer fields with device profiles settings
    public DevicesPage goToCustomerField() {
        for (int i = 0; i < 5; i++) {
            getNextStepBtn().click();
        }
        return this;
    }

    // Click to customer without device profile settings
    public DevicesPage goToCustomerFieldWithoutProfiles() {
        for (int i = 0; i < 2; i++) {
            getNextStepBtn().click();
        }
        return this;
    }

    // Adding customer
    public DevicesPage addCustomer(String customerName) {
        getNewCustomerField().sendKeys(customerName);
        return this;
    }

    // Add device to list
    public DevicesPage addDevice() {
        getAddBtn().click();
        return this;
    }

    // Deleting device from list
    public DevicesPage deleteDevice() {
        getDeleteDevice().click();
        getAcceptDeletingDevice().click();
        return this;
    }

    //Enter device credentials without name
    public DevicesPage enterDeviceCredentialsWithoutName(String deviceLabel, String deviceDescription) {
        getNewDeviceLabelField().sendKeys(deviceLabel);
        getDescriptionField().sendKeys(deviceDescription);
        return this;
    }

    // Close window with adding device
    public DevicesPage closeWindow() {
        getCloseWindowBtn().click();
        return this;
    }

    // Adding new device profiles
    public DevicesPage addingNewDeviceProfile() {
        getAddDeviceBtn();
        getAddNewDeviceBtn().click();
        return this;
    }

    // Adding device profiles credentials
    public DevicesPage addDeviceProfileCredentials(String deviceProfileName,String deviceQueue, String deviceDescription) {
        getCreateNewDeviceProfileNameField().sendKeys(deviceProfileName);
        getQueueNameField().sendKeys(deviceQueue);
        getCreateNewDeviceProfileDescriptionField().sendKeys(deviceDescription);
        return this;
    }

    public DevicesPage enterDeviceProfileCredentialsWithoutName(String deviceQueue, String deviceDescription) {
        getQueueNameField().sendKeys(deviceQueue);
        getCreateNewDeviceProfileDescriptionField().sendKeys(deviceDescription);
        return this;
    }
}