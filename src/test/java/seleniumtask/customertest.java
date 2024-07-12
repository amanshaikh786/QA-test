package seleniumtask;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.*;

public class customertest {
	WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Setup WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "customerData")
    public void testAddCustomer(String customerName, String email) {
        // Navigate to add customer page
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Enter customer details
        driver.findElement(By.id("customerName")).sendKeys("Sham");
        driver.findElement(By.id("email")).sendKeys("sham123@gmail.com");
        driver.findElement(By.id("add-customer-button")).click();

        // Validate customer added (example validation)
        Assert.assertTrue(driver.getPageSource().contains("Customer added successfully."));
    }

    @DataProvider(name = "customerData")
    public Object[][] customerData() {
        return new Object[][] {
            {"John Doe", "john.doe@example.com"},
            {"Jane Smith", "jane.smith@example.com"}
            // Add more customer data as needed
        };
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }

}
