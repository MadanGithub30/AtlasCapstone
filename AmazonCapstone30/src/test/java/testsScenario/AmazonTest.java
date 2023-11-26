package testsScenario;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Objects.Amazon;
import io.github.bonigarcia.wdm.WebDriverManager;


public class AmazonTest {
    WebDriver driver;
    private Amazon amz;
    private HashMap<String, String> values;
    
    public  void takeScreenShot(WebDriver webdriver,String fileWithPath) {
    	//Convert web driver object to TakeScreenshot
    	TakesScreenshot scrShot = ((TakesScreenshot)webdriver);
    	//Call getScreenshotAs method to create image file
    	File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
    	//Move image file to new destination
    	File DestFile = new File(fileWithPath);
    	//Copy file at destination
    	try {
            FileUtils.copyFile(SrcFile, DestFile);
        }catch (IOException e) {

            System.err.println("An IOException was caught :"+e.getMessage());
        }
    }
    
    @BeforeTest
    public void setUp() throws IOException  {
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
    	driver.get("https://www.amazon.in");
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	this.takeScreenShot(driver,"C:\\Users\\szmada\\eclipse-workspace\\AmazonCapstone30\\screenshots\\screen1.png");
    	amz = new Amazon(driver);// Initializing Amazon object with the shared WebDriver instance
    	values = Amazon.getList();
    }
    
    @Test(priority=0)
    //For an synchronization using priority, Because tests passed based on method starting letter.
    public void verifySignup() {
    	amz.signIn().click();
    	this.takeScreenShot(driver,"C:\\Users\\szmada\\eclipse-workspace\\AmazonCapstone30\\screenshots\\screen2.png");
    }
    
    @Test(priority=1)
    public void verifyemail() {
    	WebDriverWait wait = new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.visibilityOf(amz.loginemail()));
    	String emailValue = values.get("email");
    	
    	amz.loginemail().sendKeys(emailValue);
    	this.takeScreenShot(driver,"C:\\Users\\szmada\\eclipse-workspace\\AmazonCapstone30\\screenshots\\screen3.png");
    	
    }
    
    @Test(priority=2)
    public void verifycontinue() {
    	
    	System.out.println("Continue button is visible: " + amz.continueemail().isDisplayed());
        System.out.println("Continue button is enabled: " + amz.continueemail().isEnabled());
       // Click the "Continue" button    
    	amz.continueemail().click();
    	this.takeScreenShot(driver,"C:\\Users\\szmada\\eclipse-workspace\\AmazonCapstone30\\screenshots\\screen4.png");

    }
   
    @Test(priority=3)
    public void passwordFillField(){
    	String passWordValue = values.get("password");
    	amz.passwordfill().sendKeys(passWordValue);
    	this.takeScreenShot(driver,"C:\\Users\\szmada\\eclipse-workspace\\AmazonCapstone30\\screenshots\\screen5.png");
    }
    @Test(priority=4)
    public void signInClick() {
    	amz.signInSubmitForLogin().click();
    	this.takeScreenShot(driver,"C:\\Users\\szmada\\eclipse-workspace\\AmazonCapstone30\\screenshots\\screen6.png");
    }
    @Test(priority=5)
    public void searchproduct() {
    	
    	String searchpro = values.get("Product");
    	amz.searchItemBox().clear();
    	amz.searchItemBox().sendKeys(searchpro + Keys.ENTER);
        this.takeScreenShot(driver,"C:\\Users\\szmada\\eclipse-workspace\\AmazonCapstone30\\screenshots\\screen7.png");
    }
    
    @Test(priority=6)
    public void item() {
    	
    	WebDriverWait wait = new WebDriverWait(driver,5);
    	String originalWindowHandle = driver.getWindowHandle();// Capture the current window handle
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(amz.itemElectronic));
    	amz.itemElectronicSearchByusingImage().click();
    	 // Switch to the new window
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);// This line switches the focus of the WebDriver to the window with the given handle (winHandle)
        }
     // If i need Optionally, switch back to the original window if needed
        //driver.switchTo().window(originalWindowHandle);

    	this.takeScreenShot(driver,"C:\\Users\\szmada\\eclipse-workspace\\AmazonCapstone30\\screenshots\\screen8.png");
    }
    @Test(priority=7)
    public void addToCartTest() {
    	WebDriverWait wait = new WebDriverWait(driver,10);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(amz.addToCartxpath));
    	amz.addToCart().click();
    	this.takeScreenShot(driver,"C:\\Users\\szmada\\eclipse-workspace\\AmazonCapstone30\\screenshots\\screen9.png");

    	try {
            Thread.sleep(2000); // Adjust this delay if needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Test(priority=8)
    public void simpleClickTest() {
    	WebDriverWait wait = new WebDriverWait(driver,10);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(amz.simpleClick));
    	this.takeScreenShot(driver,"C:\\Users\\szmada\\eclipse-workspace\\AmazonCapstone30\\screenshots\\screen10.png");

    	amz.simpleClickObject().click();
    	 try {
    	        Thread.sleep(10000); // Adjust this delay if needed
    	    } catch (InterruptedException e) {
    	        e.printStackTrace();
    	    }

    	    // Check the cart icon agai
    	
    }
    
    @Test(priority=9)
    	public void addToCartButtonTest() throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver,10);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(amz.addToCartButtonXpath));
    		amz.addToButton().click();
        	this.takeScreenShot(driver,"C:\\Users\\szmada\\eclipse-workspace\\AmazonCapstone30\\screenshots\\screen11.png");

    		Thread.sleep(10000); // Adjust this delay if needed

    	    // Check the cart icon again
    	    
    }
    
    @Test(priority=10)
    
    public void proceedToCheckOutTest() throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver,10);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(amz.proceedToCheckOutXpath));
    	
    	amz.proceedToCheckOut().click();
    	this.takeScreenShot(driver,"C:\\Users\\szmada\\eclipse-workspace\\AmazonCapstone30\\screenshots\\screen12.png");

    	Thread.sleep(5000);
    	
//    	amz.scrollButtonforCountry().click();
//    	
//    	Thread.sleep(5000);
//    	
//    	amz.selectingIndia().click();
    }
    
    @Test(priority=11)
    public void useThisAddressTest() throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver,10);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(amz.useThisAddressXpath));
    	amz.useThisAddress().click();
    	this.takeScreenShot(driver,"C:\\Users\\szmada\\eclipse-workspace\\AmazonCapstone30\\screenshots\\screen13.png");

    	Thread.sleep(5000);
    	//amz.netPaymentButton().click();
    	//Thread.sleep(10000);
    	amz.scrollDownforBank().click();
    	this.takeScreenShot(driver,"C:\\Users\\szmada\\eclipse-workspace\\AmazonCapstone30\\screenshots\\screen14.png");

    	Thread.sleep(10000);

    	amz.selectBank().click();
    	this.takeScreenShot(driver,"C:\\Users\\szmada\\eclipse-workspace\\AmazonCapstone30\\screenshots\\screen15.png");

    	Thread.sleep(10000);

    	amz.useThisPayement().click();
    	this.takeScreenShot(driver,"C:\\Users\\szmada\\eclipse-workspace\\AmazonCapstone30\\screenshots\\screen16.png");

    	Thread.sleep(20000);

        amz.placeYourOrderandPay().click();
    	this.takeScreenShot(driver,"C:\\Users\\szmada\\eclipse-workspace\\AmazonCapstone30\\screenshots\\screen17.png");

        Thread.sleep(20000);
        try {
        amz.placeTheDuplicateOrder().click();
        Thread.sleep(20000);
        driver.navigate().back();
        driver.navigate().back();
        Thread.sleep(20000);
        } catch(Exception e) {
        	System.err.println("Exception occurred: " + e.getMessage());
            
            // If an exception occurs, navigate back
            driver.navigate().back();
        	this.takeScreenShot(driver,"C:\\Users\\szmada\\eclipse-workspace\\AmazonCapstone30\\screenshots\\screen18.png");

            driver.navigate().back();
            Thread.sleep(10000);
        }
        
        
        
    }
    
    @Test(priority=12)
    
    public void returnToOrderTest() throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver,10);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(amz.returnToOrderXpath));
    	amz.returnToOrder().click();
    	this.takeScreenShot(driver,"C:\\Users\\szmada\\eclipse-workspace\\AmazonCapstone30\\screenshots\\screen19.png");

    	Thread.sleep(10000);
    	
    }
    
    @Test(priority=13)
    public void invoiceForTheProductTest() throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver,10);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(amz.invoiceForTheProductXpath));
    	amz.inVoiceForTheProdut().click();
    	this.takeScreenShot(driver,"C:\\Users\\szmada\\eclipse-workspace\\AmazonCapstone30\\screenshots\\screen20.png");

    	Thread.sleep(5000);
    	amz.printAbleOrderSummary().click();
    	this.takeScreenShot(driver,"C:\\Users\\szmada\\eclipse-workspace\\AmazonCapstone30\\screenshots\\screen21.png");

    	Thread.sleep(5000);
    	this.takeScreenShot(driver,"C:\\Users\\szmada\\eclipse-workspace\\AmazonCapstone30\\screenshots\\screen22.png");

    	amz.printThePage();
    	Thread.sleep(5000);
    	
    }
    
    

   
    
    
    

    
    
//    @AfterTest
//    public void aftertest() {
//    	driver.quit();
//    }
}
