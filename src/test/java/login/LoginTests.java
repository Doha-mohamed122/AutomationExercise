package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AccountCreatedPage;
import pages.AccountInformationPage;
import pages.LoginSignupPage;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test
    public void loginWithValidAccount(){

        LoginSignupPage loginSignupPage = homePage.clickLoginSignup();

        String email = "doha" + System.currentTimeMillis() + "@gmail.com";

        AccountInformationPage accountInformationPage = loginSignupPage.signup("doha", email);

        accountInformationPage.fillAccountInformation(
                "Mrs",
                "123456",
                "7", "November", "2003",
                true,
                false
        );

        accountInformationPage.fillAddressInformation(
                "Doha",
                "Mohamed",
                "personal",
                "10th of Ramadan city",
                "Canada",
                "Cairo",
                "Cairo",
                "12345",
                "01000000000"
        );

        AccountCreatedPage accountCreatedPage = accountInformationPage.clickCreateAccount();
        accountCreatedPage.clickButton();

        homePage.clickLogout();

        loginSignupPage = homePage.clickLoginSignup();
        loginSignupPage.login(email,"123456");


        assertTrue(homePage.getLoggedInUser().contains("doha"),
                "User is not logged in");
    }
}
