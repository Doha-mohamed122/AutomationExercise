package logout;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AccountCreatedPage;
import pages.AccountInformationPage;
import pages.LoginSignupPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LogoutTests extends BaseTests {
    @Test
    public void logout(){
        LoginSignupPage loginSignupPage = homePage.clickLoginSignup();
        String email = "doha" + System.currentTimeMillis() + "@gmail.com";
        AccountInformationPage accountInformationPage =
                loginSignupPage.signup("doham", email);
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

        assertEquals(accountCreatedPage.getMessage(),"ACCOUNT CREATED!",
                "you in the wrong page!!");
        accountCreatedPage.clickButton();
        homePage.clickLogout();

        assertTrue(driver.getCurrentUrl().contains("login"),
                "User is not redirected to login page");
    }
}
