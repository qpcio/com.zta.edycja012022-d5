package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AlertsPage extends BasePage{

    
    @FindBy(id = "simple-alert")
    private WebElement simpleAlertButton;

    @FindBy(id = "simple-alert-label")
    private WebElement simpleAlertLabel;

    @FindBy(id = "delayed-alert")
    private WebElement delayedAlertButton;

    @FindBy(id = "delayed-alert-label")
    private WebElement delayedAlertLabel;

    public AlertsPage(WebDriver driver){
        super(driver);
    }

    public void processSimpleAlert(){
        simpleAlertButton.click();
        acceptAlert();
    }

    public void processDelayedAlert(){
        delayedAlertButton.click();
        acceptAlert();
    }

    private void acceptAlert(){
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public String getSimpleAlertLabel(){
        return simpleAlertLabel.getText();
    }

    public String getDelayedAlertLabel(){
        return delayedAlertLabel.getText();
    }

    public boolean isSimpleAlertLabelCorrect(){
         return simpleAlertLabel.getText().equals("OK button pressed");
    }

    public boolean isDelayedAlertLabelCorrect(){
        return delayedAlertLabel.getText().equals("OK button pressed");
    }

}
