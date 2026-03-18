package signup;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AccountInformationPage;
import pages.LoginSignupPage;

public class SignupTests extends BaseTests {
    @Test
    public void validSignup(){
        LoginSignupPage loginSignupPage = homePage.clickLoginSignup();

        String email = "doha" + System.currentTimeMillis() + "@gmail.com";

        AccountInformationPage accountPage =
                loginSignupPage.signup("doham", email);
    }
}
