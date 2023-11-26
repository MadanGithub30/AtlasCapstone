package Objects;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Amazon {
	
	WebDriver driver;
	
	private static final String FILE_NAME = "C:\\Users\\szmada\\eclipse-workspace\\AmazonCapstone30\\testdata\\testAmzdata.xlsx";
  
    public static HashMap<String,String> getList() throws IOException {
    	HashMap<String,String> values = new HashMap<String, String>();
    	FileInputStream excelfile = new FileInputStream(new File(FILE_NAME));
    	
		XSSFWorkbook workbook = new XSSFWorkbook(excelfile);
    	XSSFSheet sheet = workbook.getSheetAt(0);
    	int rows = sheet.getLastRowNum();
    	
    	for(int r=0;r<=rows;r++) {
    		String key = sheet.getRow(r).getCell(0).getStringCellValue();
    		String value = sheet.getRow(r).getCell(1).getStringCellValue();
    		values.put(key,value);
    	}
    	
    	return values;
    	
    }
   public Amazon(WebDriver driver) {
	   this.driver = driver;
   }
   
    By signInButton = By.xpath("//span[@id='nav-link-accountList-nav-line-1']");
    
    public WebElement signIn() {
    	return driver.findElement(signInButton);
    }
    
    By loginPage = By.xpath("//input[@type='email']");
    public WebElement loginemail() {
    	return driver.findElement(loginPage);
    }
    
    By continueloginemail = By.xpath("//input[@id='continue']");
    public WebElement continueemail() {
    	return driver.findElement(continueloginemail);
    }
    
    By passwordField = By.xpath("//input[@id='ap_password']");
    public WebElement passwordfill() {
    	return driver.findElement(passwordField);
    }
    
    By signInSubmit = By.xpath("//input[@id='signInSubmit']");
    public WebElement signInSubmitForLogin() {
    	return driver.findElement(signInSubmit);
    }
    
    By searchItem = By.xpath("//input[@id='twotabsearchtextbox']");
    public WebElement searchItemBox() {
    	return driver.findElement(searchItem);
    }
    
    public By itemElectronic = By.xpath("//*[@id='search']//img[@src='https://m.media-amazon.com/images/I/71d7rfSl0wL._AC_UY218_.jpg']");
    public WebElement itemElectronicSearchByusingImage() {
    	return driver.findElement(itemElectronic);
    }
    

    public By addToCartxpath = By.xpath("//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']");
    public WebElement addToCart() {
        return driver.findElement(addToCartxpath);
    }
    
    public By simpleClick = By.xpath("//div[@id='attach-popover-lgtbox']");
    public WebElement simpleClickObject() {
    	return driver.findElement(simpleClick);
    	
    }
    public By addToCartButtonXpath = By.xpath("//span[@id='nav-cart-count']");
    public WebElement addToButton() {
    	return driver.findElement(addToCartButtonXpath);
    }
    
    public By proceedToCheckOutXpath = By.xpath("//input[@name='proceedToRetailCheckout']");
    public WebElement proceedToCheckOut() {
    	return driver.findElement(proceedToCheckOutXpath);
    	
    }
    
  By scrollButtonforCountryXpath = By.xpath("//span[@role='button']");
  public WebElement scrollButtonforCountry() {
	  return driver.findElement(scrollButtonforCountryXpath);
	  
  }
  
  public By selectingIndiaXpath = By.xpath("//div[@class='a-popover-inner a-lgtbox-vertical-scroll']//a[@id='address-ui-widgets-countryCode-dropdown-nativeId_102']");
  public WebElement selectingIndia() {
	  return driver.findElement(selectingIndiaXpath);
  }
  
  By fullNameXpath = By.xpath("//input[@id='address-ui-widgets-enterAddressFullName']");
  public WebElement fullName() {
	  return driver.findElement(fullNameXpath);
  }
    
  public By useThisAddressXpath = By.xpath("//input[@data-testid='Address_selectShipToThisAddress']");
  public WebElement useThisAddress() {
	  return driver.findElement(useThisAddressXpath);
  }
//  By netPaymentXpathButton = By.xpath("//input[@id='pp-43rgry-102']");
//  public WebElement netPaymentButton() {
//	  return driver.findElement(netPaymentXpathButton);
//  }
//  
  By scrollDownXpathforbank = By.xpath("//span[contains(text(),'Choose an Option')]");
  public WebElement scrollDownforBank() {
	  return driver.findElement(scrollDownXpathforbank);
  }
  By selectBankXpath = By.xpath("(//a[normalize-space()='Kotak Bank'])[1]");
  public WebElement selectBank() {
	  return driver.findElement(selectBankXpath);
  }
  By useThisPaymentXpath = By.xpath("//span[@class='a-button-inner']//input[@name='ppw-widgetEvent:SetPaymentPlanSelectContinueEvent']");
  public WebElement useThisPayement() {
	  return driver.findElement(useThisPaymentXpath);
	  
  }
  By placeYourOrderandPayXpath = By.xpath("//input[@aria-labelledby='bottomSubmitOrderButtonId-announce']");
  public WebElement placeYourOrderandPay() {
	  return driver.findElement(placeYourOrderandPayXpath);
  }
  By placeTheDuplicateOrderXpath = By.xpath("//input[@name='forcePlaceOrder']");
  public WebElement placeTheDuplicateOrder() {
	  return driver.findElement(placeTheDuplicateOrderXpath);
  }
  public By returnToOrderXpath = By.xpath("//a[@id='nav-orders']");
  public WebElement returnToOrder() {
	  return driver.findElement(returnToOrderXpath);
  }
  public By invoiceForTheProductXpath = By.xpath("//a[normalize-space()='Invoice']");
  public WebElement inVoiceForTheProdut() {
	  return driver.findElement(invoiceForTheProductXpath);
  }
  By printAbleOrderSummaryXpath = By.xpath("//span[@class='a-list-item']//a[@class='a-link-normal'][normalize-space()='Printable Order Summary']");
  public WebElement printAbleOrderSummary() {
	  return driver.findElement(printAbleOrderSummaryXpath);
  }
  By printThePageXpath = By.xpath("//a[normalize-space()='Print this page for your records.']");
  public WebElement printThePage() {
	  return driver.findElement(printThePageXpath);
  }
  
}
