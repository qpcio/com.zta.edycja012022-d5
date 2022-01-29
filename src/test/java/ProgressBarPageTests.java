import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PrograssBarPage;

public class ProgressBarPageTests extends BaseTest {

    @Test
    public void shouldLetProgressBarComplete() {
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");
        PrograssBarPage prograssBarPage = new PrograssBarPage(driver);
        Assert.assertEquals(prograssBarPage.getLabel(), "Complete!");
    }
}
