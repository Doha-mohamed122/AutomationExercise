package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public LoginSignupPage clickLoginSignup(){
        clickLink("Signup / Login");
        return new LoginSignupPage(driver);
    }
    public ProductsPage clickProducts(){
        clickLink("Products");
        return new ProductsPage(driver);
    }
    public LoginSignupPage clickLogout(){
        clickLink("Logout");
        return new LoginSignupPage(driver);
    }
    private By loggedInUser = By.xpath("//a[contains(text(),'Logged in as')]");
    public String getLoggedInUser(){
        return driver.findElement(loggedInUser).getText();
    }


    public  void  clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();

    }
}
