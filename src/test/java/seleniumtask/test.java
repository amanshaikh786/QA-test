package seleniumtask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class test {
	
	WebDriver driver;

    @BeforeClass
    public void setUp() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        // Provide test data - username and password combinations
        return new Object[][] {
            {"Admin", "admin123"},
            // Add more test data as needed
        };
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {
        // Navigate to login page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Find username and password fields and Login button by xpath
        WebElement usernameField = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        //username and password
        usernameField.sendKeys("Admin");
        passwordField.sendKeys("admin123");

        // Click login button
        loginButton.click();

        // Validate login - 
        WebElement homePageTitle = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(homePageTitle.getText(), "Welcome to OrangeHRM.com");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
	}


