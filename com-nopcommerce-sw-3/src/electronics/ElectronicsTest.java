package electronics;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElectronicsTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    String email = "khushbu28698@gmail.com";
    public void login() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement loginLink = driver.findElement(By.xpath("//a[contains(text(),'Log in')]"));
        loginLink.click();
        WebElement emailLoginField = driver.findElement(By.id("Email"));
        emailLoginField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("Khushbu@2802#");
        WebElement login = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
        login.click();
        Thread.sleep(1000);
        WebElement shoppingCart = driver.findElement( By.xpath("//span[contains(text(),'Shopping cart')]"));
        WebElement goToCart = driver.findElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        actions.moveToElement(shoppingCart).moveToElement(goToCart).click().build().perform();
    }
    @Test
    public void textVerified() throws InterruptedException {
//        1.1 Mouse Hover on “Electronics” Tab
        Actions actions = new Actions(driver);
        WebElement electronics = driver.findElement(By.xpath("//div[@class='header-menu']/ul[1]/li[2]"));
        actions.moveToElement(electronics).build().perform();
//        1.2 Mouse Hover on “Cell phones” and click
        WebElement cellphones = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]/a"));
        actions.moveToElement(cellphones).click().build().perform();
//        1.3 Verify the text “Cell phones”
        String actualResult = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
        System.out.println(actualResult);
        String expectedResult = "Cell phones";
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
 //       2.1 Mouse Hover on “Electronics” Tab
        Actions actions = new Actions(driver);
        WebElement electronics = driver.findElement(By.xpath("//div[@class='header-menu']/ul[1]/li[2]"));
        actions.moveToElement(electronics).build().perform();
//        2.2 Mouse Hover on “Cell phones” and click
        WebElement cellphones = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]/a"));
        actions.moveToElement(cellphones).click().build().perform();
//        2.3 Verify the text “Cell phones”
        String actualResult = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
        System.out.println(actualResult);
//        2.4 Click on List View Tab
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[contains(text(),'List')]")).click();
//        2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(5000);
        WebElement product = driver.findElement(By.xpath("//div[@class='item-grid']/div[3]/div/div[2]/h2/a"));
        product.click();
//        2.6 Verify the text “Nokia Lumia 1020”
        String actualResult1 = driver.findElement(By.tagName("h1")).getText();
        System.out.println(actualResult1);
        String expectedResult1 = "Nokia Lumia 1020";
        Assert.assertEquals(actualResult1,expectedResult1);
//        2.7 Verify the price “$349.00”
        String actualResult2 = driver.findElement(By.xpath("//div[@class='product-price']/span")).getText();
        System.out.println(actualResult2);
        String expectedResult2 = "$349.00";
        Assert.assertEquals(actualResult2,expectedResult2);
//        2.8 Change quantity to 2
        WebElement quantity = driver.findElement(By.xpath("//div[@class='add-to-cart-panel']/input"));
        quantity.clear();
        quantity.sendKeys("2");
//        2.9 Click on “ADD TO CART” tab
        WebElement addToCart = driver.findElement(By.xpath("//div[@class='add-to-cart-panel']/button"));
        addToCart.click();
//        2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Thread.sleep(1000);
        String actualResult3 = driver.findElement(By.xpath("//div[@class='bar-notification-container']/div/p")).getText();
        System.out.println(actualResult3);
        String expectedResult3 = "The product has been added to your shopping cart";
        Assert.assertEquals(actualResult3,expectedResult3);
//        After that close the bar clicking on the cross button.
        WebElement closeTab = driver.findElement(By.xpath("//div[@id='bar-notification']/div/span"));
        closeTab.click();
//        2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Actions actions1 = new Actions(driver);
        WebElement shoppingCart = driver.findElement(By.id("topcartlink"));
        actions1.moveToElement(shoppingCart).build().perform();
        WebElement goToCart = driver.findElement(By.xpath("//div[@class='mini-shopping-cart']/div[4]/button"));
        goToCart.click();
//        2.12 Verify the message "Shopping cart"
        String actualResult4 = driver.findElement(By.tagName("h1")).getText();
        System.out.println(actualResult4);
        String expectedResult4 = "Shopping cart";
        Assert.assertEquals(actualResult4,expectedResult4);
//        2.13 Verify the quantity is 2
        String actualResult5 = driver.findElement(By.xpath("//div[@class='order-summary-content']/form/div[1]/table/tbody/tr/td[5]/input")).getText();
        System.out.println(actualResult5);
//        String expectedResult5 = "2";
//        Assert.assertEquals(actualResult5,expectedResult5);
//        2.14 Verify the Total $698.00
        String actualResult6 = driver.findElement(By.xpath("//div[@class='order-summary-content']/form/div[1]/table/tbody/tr/td[6]/span")).getText();
        System.out.println(actualResult6);
        String expectedResult6 = "$698.00";
        Assert.assertEquals(actualResult6,expectedResult6);
//        2.15 click on checkbox “I agree with the terms of service”
        WebElement agreeTerms = driver.findElement(By.id("termsofservice"));
        agreeTerms.click();
//        2.16 Click on checkout
        WebElement clickCheckout = driver.findElement(By.id("checkout"));
        clickCheckout.click();
//        2.17 Verify the Text “Welcome, Please Sign In!”
        String actualResult7 = driver.findElement(By.tagName("h1")).getText();
        System.out.println(actualResult7);
        String expectedResult7 = "Welcome, Please Sign In!";
        Assert.assertEquals(actualResult7,expectedResult7);
//        2.18 Click on “REGISTER” tab
        WebElement register = driver.findElement(By.xpath("//div[@class='page-body']/div[1]/div[1]/div[3]/button[2]"));
        register.click();
//        2.19 Verify the text “Register”
        String actualResult8 = driver.findElement(By.tagName("h1")).getText();
        System.out.println(actualResult8);
        String expectedResult8 = "Register";
        Assert.assertEquals(actualResult8,expectedResult8);
//        2.20 Fill the mandatory fields
        WebElement firstNameField = driver.findElement(By.id("FirstName"));
        firstNameField.sendKeys("Khushbu");
        WebElement lastNameField = driver.findElement(By.id("LastName"));
        lastNameField.sendKeys("Patel");
        WebElement emailLoginField = driver.findElement(By.id("Email"));
        emailLoginField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("Khushbu@2802#");
        WebElement confirmPasswordField = driver.findElement(By.id("ConfirmPassword"));
        confirmPasswordField.sendKeys("Khushbu@2802#");
//        2.21 Click on “REGISTER” Button
        WebElement register1 = driver.findElement(By.xpath("//button[@class='button-1 register-next-step-button']"));
        register1.click();
//        2.22 Verify the message “Your registration completed”
        String actualResult9 = driver.findElement(By.className("result")).getText();
        System.out.println(actualResult9);
        String expectedResult9 = "Your registration completed";
        Assert.assertEquals(actualResult9,expectedResult9);
//        2.23 Click on “CONTINUE” tab
        WebElement continueTab = driver.findElement(By.xpath("//div[@class='page registration-result-page']/div[2]/div[2]/a"));
        continueTab.click();
//        2.24 Verify the text “Shopping cart”
        Thread.sleep(1000);
        String actualResult10 = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
        System.out.println(actualResult10);
        String expectedResult10 = "Shopping cart";
        Assert.assertEquals(actualResult10,expectedResult10);
        //call login method
        login();
//        2.25 click on checkbox “I agree with the terms of service”
        Thread.sleep(2000);
        WebElement agreeTerms1 = driver.findElement(By.xpath("//input[@id='termsofservice']"));
        agreeTerms1.click();
//        2.26 Click on “CHECKOUT”
        WebElement clickCheckout1 = driver.findElement(By.id("checkout"));
        clickCheckout1.click();
//        2.27 Fill the Mandatory fields
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
//        2.28 Click on “CONTINUE”
        WebElement continueButton = driver.findElement(By.xpath("//div[@id='billing-buttons-container']/button[4]"));
        continueButton.click();
//        2.29 Click on Radio Button “2nd Day Air ($0.00)”
        WebElement secondDayAir = driver.findElement(By.xpath("//input[@id='shippingoption_2']"));
        secondDayAir.click();
//        2.30 Click on “CONTINUE”
        WebElement continueButton1 = driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']/button"));
        continueButton1.click();
//        2.31 Select Radio Button “Credit Card”
        WebElement creditCard = driver.findElement(By.xpath("//div[@class='section payment-method']/ul/li[2]/div/div[2]/input"));
        creditCard.click();
        Thread.sleep(1000);
        WebElement continueButton2 = driver.findElement(By.xpath("//div[@id='payment-method-buttons-container']/button"));
        continueButton2.click();
//        2.32 Select “Visa” From Select credit card dropdown
        WebElement masterCard = driver.findElement(By.id("CreditCardType"));
        Select select4 = new Select(masterCard);
        select4.selectByIndex(0); // select by index
//        2.33 Fill all the details
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
//        2.34 Click on “CONTINUE CHECKOUT”
        WebElement continueButton3 = driver.findElement(By.xpath("//div[@id='payment-info-buttons-container']/button"));
        continueButton3.click();
//        2.35 Verify “Payment Method” is “Credit Card”
        String actualResult11 = driver.findElement(By.xpath("//div[@class='payment-method-info']/ul/li/span[2]")).getText();
        System.out.println(actualResult11);
        String expectedResult11 = "Credit Card";
        Assert.assertEquals(actualResult11,expectedResult11);
//        2.36 Verify “Shipping Method” is “2nd Day Air”
        String actualResult12 = driver.findElement(By.xpath("//div[@class='shipping-info-wrap']/div[2]/ul/li/span[2]")).getText();
        System.out.println(actualResult12);
//        String expectedResult12 = "2nd Day Air";
//        Assert.assertEquals(actualResult12,expectedResult12);
//        2.37 Verify Total is “$698.00”
        String actualResult13 = driver.findElement(By.xpath("//td[@class='subtotal']/span")).getText();
        System.out.println(actualResult13);
//        String expectedResult13 = "$2,950.00";
//        Assert.assertEquals(actualResult13,expectedResult13);
//        2.38 Click on “CONFIRM”
        WebElement confirm = driver.findElement(By.xpath("//div[@id='confirm-order-buttons-container']/button"));
        confirm.click();
//        2.39 Verify the Text “Thank You”
        Thread.sleep(1000);
        String actualResult14 = driver.findElement(By.xpath("//div[@class='center-1']/div/div[1]/h1")).getText();
        System.out.println(actualResult14);
        String expectedResult14 = "Thank you";
        Assert.assertEquals(actualResult14,expectedResult14);
//        2.40 Verify the message “Your order has been successfully processed!”
        String actualResult15 = driver.findElement(By.xpath("//div[@class='section order-completed']/div/strong")).getText();
        System.out.println(actualResult15);
        String expectedResult15 = "Your order has been successfully processed!";
        Assert.assertEquals(actualResult15,expectedResult15);
//        2.41 Click on “CONTINUE”
        WebElement continueButton4 = driver.findElement(By.xpath("//div[@class='page-body checkout-data']/div/div[3]/button"));
        continueButton4.click();
//        2.42 Verify the text “Welcome to our store”
        String actualResult16 = driver.findElement(By.xpath("//div[@class='topic-block-title']/h2")).getText();
        System.out.println(actualResult16);
        String expectedResult16 = "Welcome to our store";
        Assert.assertEquals(actualResult16,expectedResult16);
//        2.43 Click on “Logout” link
        WebElement logOut = driver.findElement(By.className("ico-logout"));
        logOut.click();
//        2.44 Verify the URL is “https://demo.nopcommerce.com/”
    }
    @After
    public void endTest(){
        closeBrowser();
    }
}
