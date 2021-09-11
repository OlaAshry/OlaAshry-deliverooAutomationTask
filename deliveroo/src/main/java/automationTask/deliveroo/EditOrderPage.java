package automationTask.deliveroo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditOrderPage extends AbstractPage {

    EditOrderPage(WebDriver driver) {
        super(driver);
    }

    By editOrderQuantityLocator = By.cssSelector(".ccl-c0ea52ac936ae58f.ccl-80b8020826128361");

    By goToCheckOutBtnLocator = By.xpath("//div[@class='Basket-bf28b64c20927ec7']//button[contains(@class,'ccl-d0484b0360a2b432')]");

    public void EditOrderTest() {
        // Edit the order quantity of the order
        wait.until(ExpectedConditions.visibilityOfElementLocated(editOrderQuantityLocator));
        WebElement editOrderQuantity = driver.findElement(editOrderQuantityLocator);
        editOrderQuantity.click();
        // Click on the checkout button
        By goToCheckOutBtnLocator = By.xpath("//div[@class='Basket-bf28b64c20927ec7']//button[contains(@class,'ccl-d0484b0360a2b432')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(goToCheckOutBtnLocator));
        WebElement goToCheckOutBtn = driver.findElement(goToCheckOutBtnLocator);
        goToCheckOutBtn.click();
        // Check that the order added to the basket
        By basketSectionSummaryLocator = By.className("ccl-9aab795066526b4d ccl-24c197eb36c1c3d3");
        wait.until(ExpectedConditions.visibilityOfElementLocated(basketSectionSummaryLocator));

    }

}
