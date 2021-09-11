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

public class AddOrderPage extends AbstractPage {

    AddOrderPage(WebDriver driver) {
        super(driver);
    }

    private static Logger log = LogManager.getLogger(TestBase.class.getName());

    By mealCardLocators = By.className("HomeFeedUICard-dce4e0d3970c801d");
    By searchTextBoxLocator = By.className("Search-b9a404363546d3ba");
    By searchDropdownList = By.className("HomeSuggestionRow-ccd314d51d4b4519");
    By mealLocator = By.className("orderweb__0eecc2d3");
    By choosesCheckBoxBtnLocator = By.className("orderweb__f0c547ec");
    By selectedMealTitleLocator = By.xpath("//h1[contains(@class,'ccl-2a4b5924e2237093')]");
    By mealSectionsLocator = By.className("ccl-4be034de38ffc86c");
    By appearedIncreaseAndDecreaseButton = By.className("ccl-7dd644af63dc5b67");
    By choosesRadioBtnLocator = By.className("orderweb__cda7cb50");
    By increaseOrDecreaseOrderLocator = By.className("orderweb__66a09a43");
    By addToBasketBtnLocator = By.className("ccl-cce251427bbe4ec4");
    By mealPopupLocator = By.className("ccl-c334cd44f5e42880");
    String mealKeyWord = "Favorita Gourmet Kitchen";
    Boolean trueValue = true;
    Boolean falseValue = false;
 
    public void AddOrderTest() {
        // open a selected meal
        wait.until(ExpectedConditions.visibilityOfElementLocated(mealCardLocators));
        List<WebElement> searchTextBox = driver.findElements(searchTextBoxLocator);
        searchTextBox.get(0);
        searchTextBox.get(0).sendKeys(mealKeyWord);
        // Choose the needed meal from a drop down list
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchDropdownList));
        List<WebElement> searchResultDropDownlist = driver.findElements(searchDropdownList);
        searchResultDropDownlist.get(0).click();
        // open the selected meal
        wait.until(ExpectedConditions.visibilityOfElementLocated(mealLocator));
        List<WebElement> mealOrder = driver.findElements(mealLocator);
        mealOrder.get(0).click();
        // Choose the selected items for the meal
        wait.until(ExpectedConditions.visibilityOfElementLocated(choosesCheckBoxBtnLocator));
        List<WebElement> choosesCheckBox = driver.findElements(choosesCheckBoxBtnLocator);
        // Choose the needed chooses
        for (int i = 0; i < 3; i++) {
            choosesCheckBox.get(i).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(appearedIncreaseAndDecreaseButton));
            Boolean increaseAndDecreaseButtonAppears = driver.findElement(appearedIncreaseAndDecreaseButton).isDisplayed();
            assertEquals(increaseAndDecreaseButtonAppears, trueValue);
        }
        // chooses Radio button selection
        List<WebElement> choosesRadioButton = driver.findElements(choosesRadioBtnLocator);
        choosesRadioButton.get(0).click();
        Boolean radioButtonIsSelected = driver.findElement(choosesRadioBtnLocator).isSelected();
        assertEquals(radioButtonIsSelected, "true");
        //increase the order quantity
        List<WebElement> increaseAndDecreaseButton = driver.findElements(increaseOrDecreaseOrderLocator);
        increaseAndDecreaseButton.get(6).click();
        //Add the order to the basket
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToBasketBtnLocator));
        List<WebElement> addToBasketButton = driver.findElements(addToBasketBtnLocator);
        addToBasketButton.get(3).click();
        //Verifying that the order placed successfully
        Boolean mealPopupIsClosed = driver.findElement(mealPopupLocator).isDisplayed();
        assertEquals(mealPopupIsClosed, falseValue);
        log.info("Order Placed successfully");

    }

}
