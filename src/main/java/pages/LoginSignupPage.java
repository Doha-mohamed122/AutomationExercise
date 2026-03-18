package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSignupPage {

    private WebDriver driver;

    public LoginSignupPage(WebDriver driver){
        this.driver = driver;
    }

    // signup locators
    private By signupNameField = By.name("name");
    private By signupEmailField = By.cssSelector("input[data-qa='signup-email']");
    private By signupButton = By.cssSelector("button[data-qa='signup-button']");

    // login locators
    private By loginEmailField = By.cssSelector("input[data-qa='login-email']");
    private By loginPasswordField = By.cssSelector("input[data-qa='login-password']");
    private By loginButton = By.cssSelector("button[data-qa='login-button']");

    //signup method
    public AccountInformationPage signup(String name, String email){
        driver.findElement(signupNameField).sendKeys(name);
        driver.findElement(signupEmailField).sendKeys(email);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signupBtn = driver.findElement(By.cssSelector("button[data-qa='signup-button']"));
        wait.until(ExpectedConditions.elementToBeClickable(signupBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", signupBtn);
        return new AccountInformationPage(driver);
    }
    // login method
    public void login(String mail, String pass){
        driver.findElement(loginEmailField).sendKeys(mail);
        driver.findElement(loginPasswordField).sendKeys(pass);
        driver.findElement(loginButton).click();
    }

}