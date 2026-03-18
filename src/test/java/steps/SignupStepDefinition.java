package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.testng.Assert.assertTrue;

public class SignupStepDefinition {

    private WebDriver driver;
    private HomePage homePage;
    private LoginSignupPage loginSignupPage;
    private AccountInformationPage accountInformationPage;
    private String email;

    @Given("user is on home page")
    public void user_is_on_home_page() {
        driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        homePage = new HomePage(driver);
    }

    @When("user navigates to signup page")
    public void user_navigates_to_signup_page() {
        loginSignupPage = homePage.clickLoginSignup();
    }

    @When("user enters name {string} and email {string} to signup")
    public void user_enters_name_and_email_to_signup(String name, String email) {
        this.email = email;
        accountInformationPage = loginSignupPage.signup(name, email);
    }

    @When("user fills other information with password {string}")
    public void user_fills_other_information_with_password(String password) {
        accountInformationPage.fillAccountInformation(
                "Mrs",
                password,
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

        accountInformationPage.clickCreateAccount();
    }

    @Then("account should be created successfully for {string}")
    public void account_should_be_created_successfully_for(String name) {
        assertTrue(homePage.getLoggedInUser().contains(name));
        driver.quit();
    }
}