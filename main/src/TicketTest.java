import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;

public class TicketTest {

    @Before
    public void setUp() throws Exception {
        DriverHelper.getCurrentDriver().get("http://dev.sencha.com/extjs/5.1.0/examples/ticket-app/index.html");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGo() throws Exception {
        Model model = new Model();
        model.LogIn("some password");
        // Code bellow should be refactored
        DriverHelper.getCurrentDriver().findElement(By.xpath("//div[@class='x-panel x-border-item x-box-item x-panel-default x-grid']//div[text()='SDK']")).click();
        DriverHelper.getCurrentDriver().findElement(By.xpath("//div[@class='x-grid-item-container']//table[tbody/tr/td/div[text()='64']]")).click();
        DriverHelper.getCurrentDriver().findElement(By.xpath("//div[@class='x-grid-item-container']//table[tbody/tr/td/div[text()='64']]//img[@role='button']")).click();
        DriverHelper.getCurrentDriver().findElement(By.xpath("//div[label/span[text()='Status:']]//input")).click();
        DriverHelper.getCurrentDriver().findElement(By.xpath("//div[@class='x-boundlist x-boundlist-floating x-layer x-boundlist-default x-border-box']//li[text()='Closed']")).click();
        Thread.sleep(1000);
        DriverHelper.getCurrentDriver().findElement(By.xpath("//span[text()='Save']")).click();
        DriverHelper.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Ticket saved successfully')]")));
        DriverHelper.getCurrentDriver().findElement(By.xpath("//span[text()='Dashboard']")).click();
        DriverHelper.getCurrentDriver().findElement(By.xpath("//*[text()='Refresh']")).click();
        Thread.sleep(1000);
        assertEquals(DriverHelper.getCurrentDriver().findElements(By.xpath("//*[title or div[@class='x-grid-cell-inner ' and text()='64']]")).size(), 1);
    }
}