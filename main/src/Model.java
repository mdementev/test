import org.openqa.selenium.By;

/**
 * Created by mikhail.dementev on 11/25/2015.
 */
public class Model {

    By password = By.xpath("//input[@type='password']");
    By logInButton = By.xpath("//span[text()='Login']");

    public Model LogIn(String pass) {
        DriverHelper.getCurrentDriver().findElement(password).sendKeys(pass);
        DriverHelper.getCurrentDriver().findElement(logInButton).click();
        return this;
    }
}
