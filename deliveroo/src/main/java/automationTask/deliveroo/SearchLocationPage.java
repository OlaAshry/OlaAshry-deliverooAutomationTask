package automationTask.deliveroo;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import automationTask.deliveroo.TestBase;

public class SearchLocationPage extends AbstractPage {

    public SearchLocationPage(WebDriver driver) {
        super(driver);
    }
    
    By locationTextBox = By.id("location-search");
    String searchKeyword = "Bedford";
    By searcResultDropDownList = By.className("ccl-224a39591f0cfb3e");
    By promptionPopup = By.className("ccl-42bb256c439a40df");
    By promptionPopupButtons = By.className("ccl-cce251427bbe4ec4"); 
    By locationPageTitleLocator = By.cssSelector(".ccl-19882374e640f487.ccl-1daa0367dee37c3b.ccl-dd90031787517421");


    private static Logger log = LogManager.getLogger(TestBase.class.getName());

    
    public void SearchLocationTest() {
        //Search for a country      
        wait.until(ExpectedConditions.visibilityOfElementLocated(locationTextBox));
        WebElement locationSearch = driver.findElement(locationTextBox);
        locationSearch.sendKeys(searchKeyword); 
        wait.until(ExpectedConditions.visibilityOfElementLocated(searcResultDropDownList));
        List<WebElement> searcResult = driver.findElements(searcResultDropDownList);
        searcResult.get(0).click();      
        try {
            //Close the promotional Popup
            wait.until(ExpectedConditions.visibilityOfElementLocated(promptionPopup));
            List<WebElement> promptionPopupBtns = driver.findElements(promptionPopupButtons);
            promptionPopupBtns.get(1).click();
        }
        catch (Exception e) {
            log.info("No promational popup");
        }
        //Close the cookiesPopup
        WebElement cookiesPopup = driver.findElement(By.cssSelector(".optanon-allow-all.accept-cookies-button"));
        cookiesPopup.click();
        //Restaurants page opened based on the selected location
        wait.until(ExpectedConditions.visibilityOfElementLocated(locationPageTitleLocator));     
        List<WebElement> Locationtitles = driver.findElements(locationPageTitleLocator);
        String Locationtitle = Locationtitles.get(0).getText();
        assertEquals(searchKeyword, Locationtitle);
        log.info("Go to the right location");
                
    }

}
