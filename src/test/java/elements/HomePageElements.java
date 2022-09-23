package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AbstractBasePage;

public class HomePageElements extends AbstractBasePage {

    protected HomePageElements(WebDriver driver) {
        super(driver);
    }

    //HEADER
    private final static String PROFILE_ICON = "//mat-icon[@class='mat-icon notranslate material-icons tb-mini-avatar mat-icon-no-color']";

    //DIRECTORY SECTION
    private final static String DEVICES_BTN = "//a[@href='/devices']";
    private final static String DEVICE_PROFILES_BTN = "//a[@href='/deviceProfiles']";

    public WebElement getProfileIcon() {
        return waitVisibleOfElement(PROFILE_ICON);
    }

    public WebElement getDevicesBtn() {
        return waitClickableElementByXpath(DEVICES_BTN);
    }

    public WebElement getDeviceProfilesBtn() {
        return waitClickableElementByXpath(DEVICE_PROFILES_BTN);
    }
}
