package computer;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestSuite extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void name(){
//        1.1 Click on Computer Menu.
        WebElement computerMenu = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]/a"));
        computerMenu.click();
//        1.2 Click on Desktop
        WebElement desktop = driver.findElement(By.xpath("//div[@class='item-grid']/div[1]/div/div/a"));
        desktop.click();
//        1.3 Select Sort By position "Name: Z to A"
        WebElement sort = driver.findElement(By.xpath("//div[@class='product-sorting']/select"));
        Select select = new Select(sort);
        select.selectByIndex(2); // select by index
//        1.4 Verify the Product will arrange in Descending order.
        WebElement product = driver.findElement(By.xpath("//div[@class='product-sorting']/select"));
        product.isDisplayed();
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
//        2.1 Click on Computer Menu.
        WebElement computerMenu = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]/a"));
        computerMenu.click();
//        2.2 Click on Desktop
        WebElement desktop = driver.findElement(By.xpath("//div[@class='item-grid']/div[1]/div/div/a"));
        desktop.click();
//        2.3 Select Sort By position "Name: A to Z"
        WebElement sort = driver.findElement(By.xpath("//div[@class='product-sorting']/select"));
        Select select = new Select(sort);
        select.selectByIndex(1); // select by index
//        2.4 Click on "Add To Cart"
        Thread.sleep(1000);
        WebElement cart = driver.findElement(By.xpath("//div[@class='item-grid']/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        cart.click();
//        2.5 Verify the Text "Build your own computer"
        Thread.sleep(1000);
        String actualResult = driver.findElement(By.xpath("//div[@class='product-name']/h1")).getText();
        System.out.println(actualResult);
        String expectedResult = "Build your own computer";
        Assert.assertEquals(actualResult,expectedResult);
//        2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        WebElement processor = driver.findElement(By.id("product_attribute_1"));
        Select select1 = new Select(processor);
        select1.selectByIndex(1); // select by index
//        2.7.Select "8GB [+$60.00]" using Select class.
        WebElement ram = driver.findElement(By.id("product_attribute_2"));
        Select select2 = new Select(ram);
        select2.selectByIndex(3); // select by index
//        2.8 Select HDD radio "400 GB [+$100.00]"
        WebElement hdd = driver.findElement(By.id("product_attribute_3_7"));
        hdd.click();
//        2.9 Select OS radio "Vista Premium [+$60.00]"
        WebElement os = driver.findElement(By.id("product_attribute_4_9"));
        os.click();
//        2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        Thread.sleep(5000);
        WebElement microsoftOffice = driver.findElement(By.xpath("//input[@id='product_attribute_5_10']"));
        microsoftOffice.isEnabled();
        WebElement totalCommander = driver.findElement(By.id("product_attribute_5_12"));
        totalCommander.click();
//        2.11 Verify the price "$1,475.00"
        Thread.sleep(2000);
        String actualResult1 = driver.findElement(By.id("price-value-1")).getText();
        System.out.println(actualResult1);
        String expectedResult1 = "$1,475.00";
        Assert.assertEquals(actualResult1,expectedResult1);
//        2.12 Click on "ADD TO CARD" Button.
        WebElement addToCart = driver.findElement(By.id("add-to-cart-button-1"));
        addToCart.click();
//        2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String actualResult2 = driver.findElement(By.xpath("//div[@id='bar-notification']/div/p")).getText();
        System.out.println(actualResult2);
        String expectedResult2 = "The product has been added to your shopping cart";
        Assert.assertEquals(actualResult2,expectedResult2);
//        After that close the bar clicking on the cross button.
        WebElement closeTab = driver.findElement(By.xpath("//div[@id='bar-notification']/div/span"));
        closeTab.click();
//        2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Actions actions = new Actions(driver);
        WebElement shoppingCart = driver.findElement(By.id("topcartlink"));
        actions.moveToElement(shoppingCart).build().perform();
        WebElement goToCart = driver.findElement(By.xpath("//div[@class='mini-shopping-cart']/div[4]/button"));
        goToCart.click();
//        2.15 Verify the message "Shopping cart"
        String actualResult3 = driver.findElement(By.tagName("h1")).getText();
        System.out.println(actualResult3);
        String expectedResult3 = "Shopping cart";
        Assert.assertEquals(actualResult3,expectedResult3);
//        2.16 Change the Qty to "2" and Click on "Update shopping cart"
        WebElement quantity = driver.findElement(By.xpath("//table[@class='cart']/tbody/tr/td[5]/input"));
        quantity.clear();
        quantity.sendKeys("2");
        WebElement updateCart = driver.findElement(By.xpath("//div[@class='common-buttons']/button[1]"));
        updateCart.click();
//        2.17 Verify the Total"$2,950.00"
        String actualResult4 = driver.findElement(By.xpath("//table[@class='cart']/tbody/tr/td[6]/span")).getText();
        System.out.println(actualResult4);
        String expectedResult4 = "$2,950.00";
        Assert.assertEquals(actualResult4,expectedResult4);
//        2.18 click on checkbox “I agree with the terms of service”
        WebElement agreeTerms = driver.findElement(By.id("termsofservice"));
        agreeTerms.click();
//        2.19 Click on “CHECKOUT”
        WebElement clickCheckout = driver.findElement(By.id("checkout"));
        clickCheckout.click();
//        2.20 Verify the Text “Welcome, Please Sign In!”
        String actualResult5 = driver.findElement(By.tagName("h1")).getText();
        System.out.println(actualResult5);
        String expectedResult5 = "Welcome, Please Sign In!";
        Assert.assertEquals(actualResult5,expectedResult5);
//        2.21 Click on “CHECKOUT AS GUEST” Tab
        WebElement guestCheckout = driver.findElement(By.xpath("//div[@class='page-body']/div[1]/div[1]/div[3]/button[1]"));
        guestCheckout.click();
//        2.22 Fill the all mandatory field
        WebElement firstName = driver.findElement(By.xpath("//div[@class='edit-address']/div[1]/input"));
        firstName.sendKeys("Khushbu");
        WebElement lastName = driver.findElement(By.xpath("//div[@class='edit-address']/div[2]/input"));
        lastName.sendKeys("Patel");
        WebElement email = driver.findElement(By.xpath("//div[@class='edit-address']/div[3]/input"));
        email.sendKeys("khushbu2827@gmail.com");
        WebElement country = driver.findElement(By.xpath("//div[@class='edit-address']/div[5]/select"));
        Select select3 = new Select(country);
        select3.selectByVisibleText("United Kingdom");
        WebElement city = driver.findElement(By.xpath("//div[@class='edit-address']/div[7]/input"));
        city.sendKeys("Dagenham");
        WebElement address1 = driver.findElement(By.xpath("//div[@class='edit-address']/div[8]/input"));
        address1.sendKeys("20 High Street");
        WebElement postCode = driver.findElement(By.xpath("//div[@class='edit-address']/div[10]/input"));
        postCode.sendKeys("RM12 2HJ");
        WebElement telephone = driver.findElement(By.xpath("//div[@class='edit-address']/div[11]/input"));
        telephone.sendKeys("9879731846");
//        2.23 Click on “CONTINUE”
        WebElement continueButton = driver.findElement(By.xpath("//div[@id='billing-buttons-container']/button[4]"));
        continueButton.click();
//        2.24 Click on Radio Button “Next Day Air($0.00)”
        WebElement nextDayAir = driver.findElement(By.xpath("//input[@id='shippingoption_1']"));
        nextDayAir.click();
//        2.25 Click on “CONTINUE”
        WebElement continueButton1 = driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']/button"));
        continueButton1.click();
//        2.26 Select Radio Button “Credit Card”
        WebElement creditCard = driver.findElement(By.xpath("//div[@class='section payment-method']/ul/li[2]/div/div[2]/input"));
        creditCard.click();
        Thread.sleep(1000);
        WebElement continueButton2 = driver.findElement(By.xpath("//div[@id='payment-method-buttons-container']/button"));
        continueButton2.click();
//        2.27 Select “Master card” From Select credit card dropdown
        WebElement masterCard = driver.findElement(By.id("CreditCardType"));
        Select select4 = new Select(masterCard);
        select4.selectByIndex(1); // select by index
//        2.28 Fill all the details
        WebElement cardHolderName = driver.findElement(By.id("CardholderName"));
        cardHolderName.sendKeys("Khushbu");
        WebElement cardNumber = driver.findElement(By.id("CardNumber"));
        cardNumber.sendKeys("2222420000001113");
        WebElement expiryMonth = driver.findElement(By.id("ExpireMonth"));
        Select select5 = new Select(expiryMonth);
        select5.selectByVisibleText("08"); // select by index
        WebElement expiryYear = driver.findElement(By.id("ExpireYear"));
        Select select6 = new Select(expiryYear);
        select6.selectByVisibleText("2026"); // select by index
        WebElement cardCode = driver.findElement(By.id("CardCode"));
        cardCode.sendKeys("143");
//        2.29 Click on “CONTINUE”
        WebElement continueButton3 = driver.findElement(By.xpath("//div[@id='payment-info-buttons-container']/button"));
        continueButton3.click();
//        2.30 Verify “Payment Method” is “Credit Card”
        String actualResult6 = driver.findElement(By.xpath("//div[@class='payment-method-info']/ul/li/span[2]")).getText();
        System.out.println(actualResult6);
        String expectedResult6 = "Credit Card";
        Assert.assertEquals(actualResult6,expectedResult6);
//        2.32 Verify “Shipping Method” is “Next Day Air”
        String actualResult7 = driver.findElement(By.xpath("//div[@class='shipping-info-wrap']/div[2]/ul/li/span[2]")).getText();
        System.out.println(actualResult7);
        String expectedResult7 = "Next Day Air";
        Assert.assertEquals(actualResult7,expectedResult7);
//        2.33 Verify Total is “$2,950.00”
        String actualResult8 = driver.findElement(By.xpath("//td[@class='subtotal']/span")).getText();
        System.out.println(actualResult8);
        String expectedResult8 = "$2,950.00";
        Assert.assertEquals(actualResult8,expectedResult8);
//        2.34 Click on “CONFIRM”
        WebElement confirm = driver.findElement(By.xpath("//div[@id='confirm-order-buttons-container']/button"));
        confirm.click();
//        2.35 Verify the Text “Thank You”
        Thread.sleep(1000);
        String actualResult9 = driver.findElement(By.xpath("//div[@class='center-1']/div/div[1]/h1")).getText();
        System.out.println(actualResult9);
        String expectedResult9 = "Thank you";
        Assert.assertEquals(actualResult9,expectedResult9);
//        2.36 Verify the message “Your order has been successfully processed!”
        String actualResult10 = driver.findElement(By.xpath("//div[@class='section order-completed']/div/strong")).getText();
        System.out.println(actualResult10);
        String expectedResult10 = "Your order has been successfully processed!";
        Assert.assertEquals(actualResult10,expectedResult10);
//        2.37 Click on “CONTINUE”
        WebElement continueButton4 = driver.findElement(By.xpath("//div[@class='page-body checkout-data']/div/div[3]/button"));
        continueButton4.click();
//        2.37 Verify the text “Welcome to our store”
        String actualResult11 = driver.findElement(By.xpath("//div[@class='topic-block-title']/h2")).getText();
        System.out.println(actualResult11);
        String expectedResult11 = "Welcome to our store";
        Assert.assertEquals(actualResult11,expectedResult11);
    }

    @After
    public void endTest(){
        closeBrowser();
    }
}
