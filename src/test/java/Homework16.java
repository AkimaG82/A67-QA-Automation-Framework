import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Homework16 {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");


        driver = new ChromeDriver();


        driver.manage().window().maximize();
    }

    @Test
    public void registrationNavigation() {
        // Navigate to the website
        driver.get("https://qa.koel.app/");


        WebElement registrationLink = driver.findElement(By.id("hel"));
        registrationLink.click();


        String expectedUrl = "https://qa.koel.app/register";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL did not match the expected Registration page URL");


        WebElement registrationHeader = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(registrationHeader.getText(), "Registration", "Registration header text mismatch");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}