package steps;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.Map;

import static org.testng.Assert.assertTrue;

public class SignupStepDefinition {

    private WebDriver driver;
    private HomePage homePage;
    private LoginSignupPage loginSignupPage;
    private AccountInformationPage accountInformationPage;
    private String email;
    private String firstName;
    private String lastName;
    private String company;
    private String address;
    private String country;
    private String state;
    private String city;
    private String zipcode;
    private String mobile;
    private String password;
    private String day;
    private String month;
    private String year;

    @Given("user is on home page")
    public void user_is_on_home_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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

    @When("user fills all required information")
    public void user_fills_all_required_information(DataTable dataTable) {
        Map<String, String> userData = dataTable.asMap();

        fillAccountInformation(userData);

        fillAddressInformation(userData);

        accountInformationPage.clickCreateAccount();
    }

    private void fillAccountInformation(Map<String, String> userData) {

        boolean isTitleMr = userData.get("title").equalsIgnoreCase("Mr");

        password = userData.get("password");
        day = userData.get("day");
        month = userData.get("month");
        year = userData.get("year");

        accountInformationPage.fillAccountInformation(
                String.valueOf(isTitleMr),
                password,
                day, month, year,
                true,  //
                false
        );
    }

    private void fillAddressInformation(Map<String, String> userData) {
        firstName = userData.get("firstName");
        lastName = userData.get("lastName");
        company = userData.get("company");
        address = userData.get("address");
        country = userData.get("country");
        state = userData.get("state");
        city = userData.get("city");
        zipcode = userData.get("zipcode");
        mobile = userData.get("mobile");
        accountInformationPage.fillAddressInformation(
                firstName,
                lastName,
                company,
                address,
                country,
                state,
                city,
                zipcode,
                mobile
        );
    }

    @Then("account should be created successfully for {string}")
    public void account_should_be_created_successfully_for(String name) {
        assertTrue(homePage.getLoggedInUser().contains(name),
                "Account not created successfully for: " + name);
        driver.quit();
    }
}