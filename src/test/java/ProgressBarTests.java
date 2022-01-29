import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProgressBarTests extends BaseTest{

    @Test
    public void shouldDisplayCompleteInProgressBar(){
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");
        String expectedText = "Complete!";
        // I CO TERAZ?!?!?!?!
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.textToBe(By.cssSelector(".progress-label"),expectedText));
        Assert.assertEquals(driver.findElement(By.cssSelector(".progress-label")).getText(),expectedText);
    }

    @Test
    public void shouldHaveSpecificClassWhenProgressBarIsComplete(){
        //given
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");
        String expectedText = "Complete!";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ui-progressbar-complete")));
        //when
        //puste
        //then
        Assert.assertEquals(driver.findElement(By.cssSelector(".progress-label")).getText(),expectedText);

    }


}
