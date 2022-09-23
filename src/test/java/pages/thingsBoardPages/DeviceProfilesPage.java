package pages.thingsBoardPages;

import elements.DeviceProfilesPageElements;
import org.openqa.selenium.WebDriver;

public class DeviceProfilesPage extends DeviceProfilesPageElements {

    public DeviceProfilesPage(WebDriver driver) {
        super(driver);
    }

    // Deleting device profiles
    public DeviceProfilesPage deleteDeviceProfile() {
        getDeleteDeviceProfile().get(0).click();
        getAcceptDeletingDeviceProfile().click();
        return this;
    }
}
