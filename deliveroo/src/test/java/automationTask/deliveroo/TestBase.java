package automationTask.deliveroo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    public WebDriver driver;

    private String baseUrl;

    @BeforeClass
    public void setup() {

        System.getProperty("webdriver.chrome.driver", "resources/mac64/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://deliveroo.co.uk/";
        // driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterClass
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}
