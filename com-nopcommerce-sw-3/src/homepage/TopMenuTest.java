package homepage;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    public void selectMenu(String menu){
        WebElement elements = driver.findElement(By.xpath(menu));
        elements.click();
    }
    @Test
    public void verifyPageNavigation(){
        selectMenu("//ul[@class='top-menu notmobile']/li[1]/a");
        String actualResult = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
        System.out.println(actualResult);
        String expectedResult = "Computers";
        Assert.assertEquals(actualResult,expectedResult);
    }
    @After
    public void endTest(){
        //closeBrowser();
    }
}
