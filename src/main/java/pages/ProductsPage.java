package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver driver;
    public ProductsPage(WebDriver driver){
        this.driver = driver;
    }
    private By firstProduct = By.cssSelector("a[data-product-id='1']");
    private By viewCartLink = By.cssSelector("a[href='/view_cart']");


}
