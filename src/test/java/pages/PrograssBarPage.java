package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PrograssBarPage extends BasePage{
    //wypelnic klase polami i metodami, stworzyc test przy ich pomocy

    @FindBy(css = ".ui-progressbar-value")
    private WebElement progressLabelValue;

    @FindBy(css = ".progress-label")
    private WebElement progressLabel;

    @FindBy(css = ".ui-progressbar-complete")
    private WebElement completedProgressBar;

    public PrograssBarPage(WebDriver driver) {
        super(driver);
    }

    public String waitForCompletedProgressBarAndReturnText(){
        System.out.println(completedProgressBar.getAttribute("class"));
        return progressLabel.getText();
    }

    private void waitForCompletion() {

        wait.until(ExpectedConditions.attributeContains(progressLabelValue,"class","ui-progressbar-complete"));
        wait.until(ExpectedConditions.textToBePresentInElement(progressLabel,"Complete!"));
    }
    public String getLabel(){
        waitForCompletion();
        return progressLabel.getText();
    }
}
