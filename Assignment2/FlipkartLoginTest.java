package Assignment2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlipkartLoginTest {
    WebDriver driver;
    String flipkartUrl = "http://www.flipkart.com";

    @BeforeTest
    public void setUp() {
        // Set the path for ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize ChromeDriver and open the Flipkart website
        driver = new ChromeDriver();
        driver.get(flipkartUrl);
    }

    @Test(priority = 1)
    public void testLogin() {
        // Enter Email Id or Phone Number
        driver.findElement(By.xpath("//input[@type='text']"))
              .sendKeys("your_email_or_phone_number");

        // Enter Password
        driver.findElement(By.xpath("//input[@type='password']"))
              .sendKeys("your_password");

        // Click the login button
        driver.findElement(By.xpath("//button[@type='submit']"))
              .click();

        // Verify that the user is logged in successfully
        // You can use a suitable XPath to identify an element that is displayed after successful login
        boolean isLoggedIn = driver.findElement(By.xpath("your_xpath_for_successful_login_element"))
                                 .isDisplayed();
        Assert.assertTrue(isLoggedIn, "Login was not successful");
    }

    @AfterTest
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
