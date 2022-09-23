package tests.thingsBoardTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.thingsBoardPages.DeviceProfilesPage;
import pages.thingsBoardPages.DevicesPage;
import pages.thingsBoardPages.HomePage;
import pages.thingsBoardPages.SignInPage;
import tests.AbstractTestInit;

public class AddDeviceProfileTests extends AbstractTestInit {

    public final String signInPageUrl = "https://demo.thingsboard.io";

    @Test
    public void addDeviceProfilePositive() {

        SignInPage signInPage = new SignInPage(driver);
        HomePage homePage = new HomePage(driver);
        DevicesPage devicesPage = new DevicesPage(driver);
        DeviceProfilesPage deviceProfilesPage = new DeviceProfilesPage(driver);

        goToSite(signInPageUrl);
        signInPage.enterSignInCredentials(signInPage.getEmail(), signInPage.getPassword()).clickEnterBtn();
        homePage
                .clickDeviceProfileBtn();
        sleep(2); //Waiting for page reloading
        devicesPage
                .addingNewDeviceProfile()
                .addDeviceProfileCredentials(devicesPage.getDeviceProfileName(), devicesPage.getDeviceProfileQueue(), devicesPage.getDeviceDescription())
                .addDevice();

        Assert.assertTrue(deviceProfilesPage.getCreatedDeviceProfile().getText().contains("New test device profile"));

        deviceProfilesPage.deleteDeviceProfile();
        sleep(1); //Waiting for deleting profiles
    }

    @Test
    public void addDeviceProfileWithTheSameNameNegative() {

        SignInPage signInPage = new SignInPage(driver);
        HomePage homePage = new HomePage(driver);
        DevicesPage devicesPage = new DevicesPage(driver);
        DeviceProfilesPage deviceProfilesPage = new DeviceProfilesPage(driver);

        goToSite(signInPageUrl);
        signInPage.enterSignInCredentials(signInPage.getEmail(), signInPage.getPassword()).clickEnterBtn();
        homePage
                .clickDeviceProfileBtn();
        sleep(2); //Waiting for page reloading
        devicesPage
                .addingNewDeviceProfile()
                .addDeviceProfileCredentials(devicesPage.getDeviceProfileName(), devicesPage.getDeviceProfileQueue(), devicesPage.getDeviceDescription())
                .addDevice();

        Assert.assertTrue(deviceProfilesPage.getCreatedDeviceProfile().getText().contains("New test device profile"));

        sleep(2); //Waiting for page reloading
        devicesPage
                .addingNewDeviceProfile()
                .addDeviceProfileCredentials(devicesPage.getDeviceProfileName(), devicesPage.getDeviceProfileQueue(), devicesPage.getDeviceDescription())
                .addDevice();

        Assert.assertTrue(devicesPage.getAlertMessageAlreadyExists().getText().contains("Device profile with such name already exists!"));

        devicesPage
                .closeWindow()
                .deleteDevice();
        sleep(1); // Waiting for system deleting device
    }

    @Test
    public void addDeviceProfileWithoutNameNegative() {

        SignInPage signInPage = new SignInPage(driver);
        HomePage homePage = new HomePage(driver);
        DevicesPage devicesPage = new DevicesPage(driver);

        goToSite(signInPageUrl);
        signInPage.enterSignInCredentials(signInPage.getEmail(), signInPage.getPassword()).clickEnterBtn();
        homePage
                .clickDeviceProfileBtn();
        sleep(2); //Waiting for page reloading
        devicesPage
                .addingNewDeviceProfile()
                .enterDeviceProfileCredentialsWithoutName(devicesPage.getDeviceProfileQueue(), devicesPage.getDeviceDescription())
                .addDevice();

        Assert.assertTrue(devicesPage.getAlertMessageNameNecessary().getText().contains("Name is required"));
    }
}
