package utils;

import common.Base;
import org.testng.annotations.DataProvider;

public class DataProviderCredentials extends Base {


    private final static String PASSWORD = "testPass321";
    private final static String EMPTY = "";
    private final static String ALERT_MESSAGE_INVALID_EMAIL_OR_PASSWORD = "Invalid username or password";
    private final static String ALERT_MESSAGE_AUTHENTICATION =  "Authentication failed";

    @DataProvider
    public static Object[][] negativeSignInPassword() {
        return new Object[][]{
                {EMPTY,ALERT_MESSAGE_AUTHENTICATION},
                {PASSWORD,ALERT_MESSAGE_INVALID_EMAIL_OR_PASSWORD}
        };
    }
}
