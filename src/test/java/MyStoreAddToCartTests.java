import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class MyStoreAddToCartTests extends BaseTest{

    @Test
    public void shouldAddProductToTheShoppingCart(){
        String expextedText = "There are no more items in your cart";
        driver.get("http://146.59.32.4/index.php?id_product=6&rewrite=mug-the-best-is-yet-to-come&controller=product");
        driver.findElement(By.cssSelector(".add>button")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));    // ten wait czeka na konkretny stan lub warunek

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));   // czekanie na istnienie kazdego elementu od tego miejsca (Default: 0s dla Selenium)
        //WebElement tenGuzik = driver.findElement(By.cssSelector(".cart-content-btn>.btn-primary"));
        
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cart-content-btn>.btn-primary")));
        driver.findElement(By.cssSelector(".cart-content-btn>.btn-primary")).click();
        //tu moglbym czekac na pojawienie sie kosza
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(),"SHOPPING CART");
        driver.findElement(By.cssSelector(".remove-from-cart")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".remove-from-cart")));
        String textFromPage = driver.findElement(By.cssSelector(".no-items")).getText();
        Assert.assertEquals(textFromPage,expextedText);
    }

    @Test
    public void shouldContainNProductsInTheCart(){
        String expextedText = "There are no more items in your cart";
        driver.get("http://146.59.32.4/index.php?id_product=6&rewrite=mug-the-best-is-yet-to-come&controller=product");
        int nMugs = 4;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));    // ten wait czeka na konkretny stan lub warunek
        //dodaj N-razy kubek  do koszyka

        for(int i=0;i<nMugs-1;i++){
            driver.findElement(By.cssSelector(".add>button")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cart-content-btn>.btn-secondary")));
            driver.findElement(By.cssSelector(".cart-content-btn>.btn-secondary")).click();
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".add>button"))));
        }
        driver.findElement(By.cssSelector(".add>button")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cart-content-btn>.btn-primary")));

        driver.findElement(By.cssSelector(".cart-content-btn>.btn-primary")).click();
        //tu moglbym czekac na pojawienie sie kosza
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(),"SHOPPING CART");
        String amount = driver.findElement(By.cssSelector(".js-cart-line-product-quantity")).getAttribute("value");
        Assert.assertEquals(amount,String.valueOf(nMugs));
        driver.findElement(By.cssSelector(".remove-from-cart")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".remove-from-cart")));
        String textFromPage = driver.findElement(By.cssSelector(".no-items")).getText();
        Assert.assertEquals(textFromPage,expextedText);
    }


}
