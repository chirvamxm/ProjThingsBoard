package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractBasePage;

import java.util.List;

public class DeviceProfilesPageElements extends AbstractBasePage {

    public DeviceProfilesPageElements(WebDriver driver) {
        super(driver);
    }

    private final static String CREATED_DEVICE_PROFILE = "//span[text()='New test device profile']";
    private final static String DELETE_DEVICE_PROFILE = "//mat-icon[contains(text(),' delete')]";
    private final static String ACCEPT_DELETING_DEVICE_PROFILE = "//button[@class='mat-focus-indicator mat-button mat-button-base mat-primary'][2]";

    public WebElement getCreatedDeviceProfile() {
        return waitVisibleOfElement(CREATED_DEVICE_PROFILE);
    }

    public List<WebElement> getDeleteDeviceProfile() {
        return waitPresenceOfElementsLocated(DELETE_DEVICE_PROFILE);
    }

    public WebElement getAcceptDeletingDeviceProfile() {
        return waitVisibleOfElement(ACCEPT_DELETING_DEVICE_PROFILE);
    }

}
