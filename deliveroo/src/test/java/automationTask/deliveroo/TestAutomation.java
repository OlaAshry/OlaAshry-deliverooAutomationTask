package automationTask.deliveroo;

import org.testng.annotations.Test;

import automationTask.deliveroo.AddOrderPage;
import automationTask.deliveroo.EditOrderPage;
import automationTask.deliveroo.SearchLocationPage;

public class TestAutomation extends TestBase {

    @Test(enabled = true, priority = 1)
    public void SearchLocation() throws Exception {
        SearchLocationPage searchAddress = new SearchLocationPage(driver);
        searchAddress.SearchLocationTest();

    }

    @Test(enabled = true, priority = 2, dependsOnMethods = "SearchLocation")
    public void AddOrder() throws Exception {
        AddOrderPage addOrder = new AddOrderPage(driver);
        addOrder.AddOrderTest();

    }

    @Test(enabled = true, priority = 3, dependsOnMethods = "AddOrder")
    public void EditOrder() throws Exception {
        EditOrderPage editOrder = new EditOrderPage(driver);
        editOrder.EditOrderTest();

    }

}
