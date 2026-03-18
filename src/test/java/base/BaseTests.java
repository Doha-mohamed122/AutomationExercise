package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

public class BaseTests {
    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://automationexercise.com/");
        homePage = new HomePage(driver);
    }
    @AfterMethod
    public void takeScreenshot(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()){
            TakesScreenshot camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            Files.move(
                    screenshot.toPath(),
                    new File("resources/screenshots/" + result.getName() + ".png").toPath()
            );
        }
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }


}
