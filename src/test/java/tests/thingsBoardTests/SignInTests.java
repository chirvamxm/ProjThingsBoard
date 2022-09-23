package tests.thingsBoardTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.thingsBoardPages.HomePage;
import pages.thingsBoardPages.SignInPage;
import tests.AbstractTestInit;
import utils.DataProviderCredentials;

public class SignInTests extends AbstractTestInit {

    public final String signInPageUrl = "https://demo.thingsboard.io";

    @Test
    public void signInPositiveTest(){

        SignInPage signInPage = new SignInPage(driver);
        HomePage homePage = new HomePage(driver);

        goToSite(signInPageUrl);
        signInPage
                .enterSignInCredentials(signInPage.getEmail(), signInPage.getPassword())
                .clickEnterBtn();

        Assert.assertTrue(homePage.getProfileIcon().isDisplayed());
        Assert.assertTrue(urlContains("home"));
    }

    @Test(dataProvider = "negativeSignInPassword", dataProviderClass = DataProviderCredentials.class)
    public void signInNegativePasswordTests(String password, String message){

        SignInPage signInPage = new SignInPage(driver);

        goToSite(signInPageUrl);
        signInPage
                .enterSignInCredentials(signInPage.getEmail(), password)
                .clickEnterBtn();

        Assert.assertEquals(signInPage.getAlertAuthenticationMessage().getText(),message);
    }

    @Test
    public void signInNegativeEmptyEmailTest(){

        SignInPage signInPage = new SignInPage(driver);

        goToSite(signInPageUrl);
        signInPage
                .enterSignInCredentials(signInPage.getEmptyEmail(), signInPage.getPassword())
                .clickEnterBtn();

        Assert.assertTrue(signInPage.getAlertEmailMessage().getText().contains("Неправильный формат эл. адреса"));
    }

    @Test
    public void signInNegativeInvalidEmailTest(){

        SignInPage signInPage = new SignInPage(driver);

        goToSite(signInPageUrl);
        signInPage
                .enterSignInCredentials(signInPage.getInvalidEmail(), signInPage.getPassword())
                .clickEnterBtn();

        Assert.assertTrue(signInPage.getAlertAuthenticationMessage().getText().contains("Invalid username or password"));
    }
}
