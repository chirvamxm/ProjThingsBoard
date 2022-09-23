package tests.thingsBoardTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.thingsBoardPages.DeviceProfilesPage;
import pages.thingsBoardPages.DevicesPage;
import pages.thingsBoardPages.HomePage;
import pages.thingsBoardPages.SignInPage;
import tests.AbstractTestInit;

public class AddDeviceTests extends AbstractTestInit {

    public final String signInPageUrl = "https://demo.thingsboard.io";

    @Test
    public void addDeviceWithDeviceProfilePositive() {

        SignInPage signInPage = new SignInPage(driver);
        HomePage homePage = new HomePage(driver);
        DevicesPage devicesPage = new DevicesPage(driver);
        DeviceProfilesPage deviceProfilesPage = new DeviceProfilesPage(driver);

        goToSite(signInPageUrl);
        signInPage
                .enterSignInCredentials(signInPage.getEmail(), signInPage.getPassword())
                .clickEnterBtn();
        homePage
                .clickDeviceBtn();
        sleep(2); //Waiting for page reloading
        devicesPage
                .addingNewDevice()
                .enterDeviceCredentials(devicesPage.getDeviceName(), devicesPage.getDeviceLabel(), devicesPage.getDeviceDescription())
                .addDeviceProfile(devicesPage.getDeviceProfileName())
                .goToCustomerField()
                .addCustomer(devicesPage.getDeviceCustomerName())
                .addDevice();

        Assert.assertTrue(devicesPage.getCreatedDevice().getText().contains("New test device"));

        devicesPage.deleteDevice();

        Assert.assertTrue(invisibilityOfElement(String.format(String.valueOf(devicesPage.getCreatedDevice().getText().contains("New test device")))));

        homePage.clickDeviceProfileBtn();

        Assert.assertTrue(deviceProfilesPage.getCreatedDeviceProfile().getText().contains("New test device profile"));

        deviceProfilesPage.deleteDeviceProfile();

        Assert.assertTrue(invisibilityOfElement(String.format(String.valueOf(devicesPage.getCreatedDevice().getText().contains("New test device profile")))));

        sleep(1); // Waiting for system deleting device
    }

    @Test
    public void addDevicePositive() {

        SignInPage signInPage = new SignInPage(driver);
        HomePage homePage = new HomePage(driver);
        DevicesPage devicesPage = new DevicesPage(driver);

        goToSite(signInPageUrl);
        signInPage
                .enterSignInCredentials(signInPage.getEmail(), signInPage.getPassword())
                .clickEnterBtn();
        homePage
                .clickDeviceBtn();
        sleep(2); //Waiting for page reloading
        devicesPage
                .addingNewDevice()
                .enterDeviceCredentials(devicesPage.getDeviceName(), devicesPage.getDeviceLabel(), devicesPage.getDeviceDescription())
                .goToCustomerFieldWithoutProfiles()
                .addCustomer(devicesPage.getDeviceCustomerName())
                .addDevice();

        Assert.assertTrue(devicesPage.getCreatedDevice().getText().contains("New test device"));

        devicesPage.deleteDevice();

        Assert.assertTrue(invisibilityOfElement(String.format(String.valueOf(devicesPage.getCreatedDevice().getText().contains("New test device")))));

        sleep(1); // Waiting for system deleting device
    }

    @Test
    public void addDeviceWithTheSameNameNegative() {

        SignInPage signInPage = new SignInPage(driver);
        HomePage homePage = new HomePage(driver);
        DevicesPage devicesPage = new DevicesPage(driver);

        goToSite(signInPageUrl);
        signInPage
                .enterSignInCredentials(signInPage.getEmail(), signInPage.getPassword())
                .clickEnterBtn();
        homePage
                .clickDeviceBtn();
        sleep(2); //Wait for reloading page
        devicesPage
                .addingNewDevice()
                .enterDeviceCredentials(devicesPage.getDeviceName(), devicesPage.getDeviceLabel(), devicesPage.getDeviceDescription())
                .goToCustomerFieldWithoutProfiles()
                .addCustomer(devicesPage.getDeviceCustomerName())
                .addDevice();

        Assert.assertTrue(devicesPage.getCreatedDevice().getText().contains("New test device"));

        devicesPage
                .addingNewDevice()
                .enterDeviceCredentials(devicesPage.getDeviceName(), devicesPage.getDeviceLabel(), devicesPage.getDeviceDescription())
                .goToCustomerFieldWithoutProfiles()
                .addCustomer(devicesPage.getDeviceCustomerName())
                .addDevice();

        Assert.assertTrue(devicesPage.getAlertMessageAlreadyExists().getText().contains("Device with such name already exists!"));

        devicesPage
                .closeWindow()
                .deleteDevice();
        sleep(1); // Waiting for system deleting device

    }

    @Test
    public void addDeviceWithoutNameNegative() {
        SignInPage signInPage = new SignInPage(driver);
        HomePage homePage = new HomePage(driver);
        DevicesPage devicesPage = new DevicesPage(driver);

        goToSite(signInPageUrl);
        signInPage
                .enterSignInCredentials(signInPage.getEmail(), signInPage.getPassword())
                .clickEnterBtn();
        homePage
                .clickDeviceBtn();
        sleep(2); //Wait for reloading page
        devicesPage
                .addingNewDevice()
                .enterDeviceCredentialsWithoutName(devicesPage.getDeviceLabel(), devicesPage.getDeviceDescription())
                .goToCustomerFieldWithoutProfiles()
                .addDevice();

        Assert.assertTrue(devicesPage.getAlertMessageNameNecessary().getText().contains("Название обязательно"));
    }
}