import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;

public class AlertsPageTests extends BaseTest{
    @Test
    public void shouldDisplayCorrectMessageAfterClickingSimpleAlertButton(){
        //given
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        AlertsPage alertsPage = new AlertsPage(driver);
        //when
        alertsPage.processSimpleAlert();
        //then
        Assert.assertEquals(alertsPage.getSimpleAlertLabel(),"OK button pressed");
    }

    @Test
    public void shouldDisplayCorrectMessageAfterClickingSimpleAlertButton2(){
        //given
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        AlertsPage alertsPage = new AlertsPage(driver);
        //when
        alertsPage.processSimpleAlert();
        //then
        Assert.assertTrue(alertsPage.isSimpleAlertLabelCorrect());
    }


}
