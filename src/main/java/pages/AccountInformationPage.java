package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountInformationPage {
    private WebDriver driver;
    public AccountInformationPage(WebDriver driver){
        this.driver = driver;
    }
    private By titleMr = By.id("id_gender1");
    private By titleMs = By.id("id_gender2");
    private By passwordField = By.id("password");
    private By dayDropdown = By.id("days");
    private By monthDropdown = By.id("months");
    private By yearDropdown = By.id("years");
    private By newsletterCheckbox = By.id("newsletter");
    private By specialOffersCheckbox = By.id("optin");

    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By companyField = By.id("company");
    private By addressField = By.id("address1");
    private By countryDropdown = By.id("country");
    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By zipcodeField = By.id("zipcode");
    private By mobileNumberField = By.id("mobile_number");

    private By createAccountButton = By.cssSelector("button[data-qa='create-account']");


    private void enterText(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }
    private void selectDropdown(By locator, String value){
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByVisibleText(value);
    }
    private void clickElement(By locator){
        driver.findElement(locator).click();
    }


    public void fillAccountInformation(String title, String password, String day,
                                       String month, String year,
                                       boolean newsletter, boolean specialOffers)
    {
        if(title.equalsIgnoreCase("Mr"))
            clickElement(titleMr);
         else if(title.equalsIgnoreCase("Mrs"))
            clickElement(titleMs);

        enterText(passwordField,password);
        selectDropdown(dayDropdown,day);
        selectDropdown(monthDropdown,month);
        selectDropdown(yearDropdown,year);

        if(newsletter)
            clickElement(newsletterCheckbox);
        if(specialOffers)
            clickElement(specialOffersCheckbox);
    }

    public void fillAddressInformation(String firstName, String lastName, String company,
                                       String address, String country, String state,
                                       String city, String zipcode, String mobile)
    {
        enterText(firstNameField, firstName);
        enterText(lastNameField, lastName);
        enterText(companyField, company);
        enterText(addressField, address);

        selectDropdown(countryDropdown, country);

        enterText(stateField, state);
        enterText(cityField, city);
        enterText(zipcodeField, zipcode);
        enterText(mobileNumberField, mobile);
    }

    public AccountCreatedPage clickCreateAccount(){
        clickElement(createAccountButton);
        return new AccountCreatedPage(driver);
    }
}
