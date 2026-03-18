package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage {
    private WebDriver driver;
    public AccountCreatedPage(WebDriver driver){
        this.driver = driver;
    }

    private By message = By.cssSelector("h2[class='title text-center'] b");
    private By continueButton = By.cssSelector(".btn.btn-primary");

    public String getMessage(){
        return driver.findElement(message).getText();
    }

    public void clickButton(){
        driver.findElement(continueButton).click();
    }
}
