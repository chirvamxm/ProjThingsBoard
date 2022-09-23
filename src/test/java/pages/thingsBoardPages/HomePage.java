package pages.thingsBoardPages;

import elements.HomePageElements;
import org.openqa.selenium.WebDriver;

public class HomePage extends HomePageElements {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Click on Devices button
    public HomePage clickDeviceBtn() {
        getDevicesBtn().click();
        return this;
    }

    // Click on Device Profiles button
    public HomePage clickDeviceProfileBtn() {
        getDeviceProfilesBtn().click();
        return this;
    }
}
