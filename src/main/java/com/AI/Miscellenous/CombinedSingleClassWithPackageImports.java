//package com.AI.Miscellenous;
//
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//import io.restassured.specification.ResponseSpecification;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.net.http.HttpClient;
//import java.time.Duration;
//import java.util.AbstractCollection;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.ListIterator;
//import java.util.Map;
//import java.util.NoSuchElementException;
//import java.util.Properties;
//import java.util.Set;
//import java.util.function.Function;
//import org.apache.http.HttpEntity;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.client.methods.HttpUriRequest;
//import org.apache.http.entity.ByteArrayEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.ElementNotInteractableException;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.NoSuchWindowException;
//import org.openqa.selenium.TimeoutException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Test;
//import resources.CustomException1;
//import resources.RunnableClassForThreads;
//import resources.UITestPracticePage;
//import static io.restassured.RestAssured.given; //import this
//import utility.BaseTest;
//import utility.FrameworkConstants;
//
//public class CombinedClass {
//
//
//    // Methods from: iFrame
//
//import WebDriver;
//import ChromeDriver;
//import resources.UITestPracticePage;
//import utility.FrameworkConstants;
//
//
//public class iFrame {
//	public static void main(String[] args) {
//
//		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://uitestpractice.com/Students/");
//		System.out.println(driver.getCurrentUrl());
//
//		UITestPracticePage
//			.using(driver)
//			.getFrameElement(driver)
//			.enterIFrameText("checked iFrame");
//		driver.quit();
//
//	}
//}
//
//
//    // Methods from: UploadAFile
//
//import Test;
//import utility.BaseTest;
//
//import By;
//import WebElement;
//
//
//public class UploadAFile extends BaseTest{
//
////	@FindBy(xpath="//a[contains(text(),'File Upload')]")
////	WebElement UploadFileLink;
//
//	@Test
//	public void uploadFileTest() {
//		System.out.println("Upload file test");
//		WebElement pageLink = driver.findElement(By.xpath("//a[contains(text(),'File Upload')]"));
//		pageLink.click();
//		WebElement uploadFileLink = driver.findElement(By.cssSelector("input#file-upload"));
//		uploadFileLink.sendKeys("C:\\My docs - Official\\Resume\\New\\PowerBI\\ToUpload.txt");
//		WebElement uploadSubmit = driver.findElement(By.cssSelector("input[type='submit']"));
//		uploadSubmit.click();
//	}
//
//}
//
//
//    // Methods from: WindowActions
//
//import ArrayList;
//import List;
//import Set;
//import NoSuchWindowException;
//
//public class WindowActions extends BaseTest{
//
//	public void switchToParentWindow() {
//		Set<String> parentWindowHandle = driver.getWindowHandles();
//		List<String> windowList = new ArrayList<String>(parentWindowHandle);
//		if(windowList.size() > 0) {
//			driver.switchTo().window(windowList.get(0));
//		}else {
//			throw new NoSuchWindowException("Parent window does not exist");
//		}
//	}
//
//	public void switchToWindow(int windowindex) {
//		Set<String> windowHandle = driver.getWindowHandles();
//		List<String> windowList = new ArrayList<String>(windowHandle);
//		if(windowindex < windowHandle.size()) {
//			driver.switchTo().window(windowList.get(windowindex));
//		}else {
//			throw new NoSuchWindowException("Window does not exist with index: "+windowindex);
//		}
//	}
//
//	public void closeWindow(int windowindex) {
//		Set<String> windowHandle = driver.getWindowHandles();
//		List<String> windowList = new ArrayList<String>(windowHandle);
//		if(windowindex < windowHandle.size()) {
//			driver.switchTo().window(windowList.get(windowindex)).close();
//		}else {
//			throw new NoSuchWindowException("Window with index: "+windowindex+" does not exist ");
//		}
//	}
//
//	public void closeAllChildWindows() {
//		Set<String> windowHandle = driver.getWindowHandles();
//		List<String> windowList = new ArrayList<String>(windowHandle);
//		for(int i=1; i < windowList.size(); i++) {
//			driver.switchTo().window(windowList.get(i)).close();
//		}
//	}
//
//	public int getWindowCount() {
//		Set<String> windowHandle = driver.getWindowHandles();
//		List<String> windowList = new ArrayList<String>(windowHandle);
//		return windowList.size();
//	}
//
//}
//
//
//    // Methods from: TestingRunnableClass
//
//import resources.RunnableClassForThreads;
//
//public class TestingRunnableClass {
//
//	public static void main(String[] args) {
//
//		RunnableClassForThreads runClass = new RunnableClassForThreads();
//		Thread thread1 = new Thread(runClass);
//		thread1.start();
//		while(RunnableClassForThreads.count<=10) {
//			System.out.println("In main method : "+RunnableClassForThreads.count++);
//		}
//	}
//
//}
//
//
//    // Methods from: SecureFileDownload
//
//import File;
//import IOException;
//import HashMap;
//import org.apache.http.client.ClientProtocolException;
//import By;
//import WebDriver;
//import ChromeDriver;
//import ChromeOptions;
//import utility.FrameworkConstants;
//
//public class SecureFileDownload {
//
//	public static void main(String[] args) throws InterruptedException, ClientProtocolException, IOException {
//
//		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
//
//		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
//		chromePrefs.put("profile.default_content_settings.popups", 0);
//		chromePrefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles");
//		ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("prefs", chromePrefs);
//        WebDriver driver = new ChromeDriver(options);
//        driver.get("http://admin:admin@the-internet.herokuapp.com/download_secure");
//        Thread.sleep(2000);
//        System.out.println("Before clicking");
//        driver.findElement(By.linkText("some-file.txt")).click();
//        Thread.sleep(5000);
//		driver.quit();
//	}
//}
//
//    // Methods from: RestAPITesting_HttpURIRequest
//
//import HttpClient;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.client.methods.HttpUriRequest;
//import org.apache.http.entity.ByteArrayEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//import static io.restassured.RestAssured.given; //import this
//
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//import io.restassured.specification.ResponseSpecification;
//
//public class RestAPITesting_HttpURIRequest {
//
//	public static void main(String[] args) {
//
//		String restURL = "http://api.zippopotam.us/us/90210";
//		RestAssured.baseURI = "http://api.zippopotam.us";
//		RequestSpecification requestSpecification = given();
//		Response response = requestSpecification.get("/us/90210");
//		System.out.println(response.asString());
//
//
////		CloseableHttpClient httpclient = HttpClients.createDefault();
////		HttpPost httppost = new HttpPost("http://216.10.245.166:8080/axis2/services/EmployeeManagementService.EmployeeManagementServiceHttpSoap11Endpoint/");
////		httppost.addHeader("Content-Type", "text/xml");
////
////        HttpEntity entity = new ByteArrayEntity(readFileAsString("C:\\Saranya-Documents\\To Study\\API Testing\\SOAPUI\\Java Automation\\HttpClient\\EmployeeRequest.xml").getBytes());
////        httppost.setEntity(entity);
////
////        CloseableHttpResponse httpResponse = httpclient.execute(httppost);
////        String result = EntityUtils.toString(httpResponse.getEntity());
////		System.out.println(result);
//
//	}
//
//}
//
//
//    // Methods from: Redirection
//
//import IOException;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import By;
//import WebDriver;
//import WebElement;
//import ChromeDriver;
//import utility.FrameworkConstants;
//
//public class Redirection {
//
//	public static void main(String[] args) throws InterruptedException, ClientProtocolException, IOException {
//
//		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://the-internet.herokuapp.com/");
//		driver.findElement(By.linkText("Redirect Link")).click();
//		WebElement redirectLink = driver.findElement(By.cssSelector("a#redirect"));
//
//		CloseableHttpClient httpclient = HttpClients.createDefault();
//		HttpGet httpGet = new HttpGet(redirectLink.getAttribute("href"));
//		CloseableHttpResponse httpResponse=httpclient.execute(httpGet);
//		System.out.println(httpResponse.getStatusLine().getStatusCode());
//		redirectLink.click();
//
//
//		Thread.sleep(3000);
//		driver.quit();
//	}
//}
//
//    // Methods from: ProgressBar
//
//import Duration;
//import Function;
//
//import By;
//import JavascriptExecutor;
//import WebDriver;
//import WebElement;
//import ChromeDriver;
//import FluentWait;
//import utility.FrameworkConstants;
//
//public class ProgressBar {
//	public static void main(String[] args) throws InterruptedException {
//
//		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://uitestpractice.com/Students/");
//		System.out.println(driver.getCurrentUrl());
//
//		WebElement downloadButton= driver.findElement(By.xpath("//div[@class='container Tomato']//button"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -window.innerHeight / 4);", downloadButton);
//		downloadButton.click();
//
//	      FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
//					.withTimeout(Duration.ofSeconds(10))
//					.pollingEvery(Duration.ofMillis(500))
//					.ignoring(Exception.class);
//
//
//			Function<WebDriver, Boolean> func = new Function<WebDriver, Boolean>()
//			{
//			public Boolean apply( WebDriver driver) {
//			WebElement element = driver.findElement(By.xpath("//div[starts-with(@class,'ui-dialog')]//div[@class='progress-label']"));
//			System.out.println(element.getText());
//				if(element.getText().contains("Complete")){
//					return true;
//				}
//					return false;
//				}
//			};
//
//			fWait.until(func);
//
//			Thread.sleep(2000);
//
//			WebElement dialogClose = driver.findElement(By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']//span[@class='ui-button-text'][contains(text(),'Close')]"));
//			System.out.println(dialogClose.getText());
//			dialogClose.click();
//	}
//}
//
//    // Methods from: NotificationMessages
//
//import By;
//import WebDriver;
//import ChromeDriver;
//import utility.FrameworkConstants;
//
//public class NotificationMessages {
//
//	public static void main(String[] args) throws InterruptedException {
//
//		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://the-internet.herokuapp.com/");
//		driver.findElement(By.xpath("//a[contains(text(),'Notification Messages')]")).click();
//		System.out.println(driver.findElement(By.xpath("//div[@id='flash-messages']/div")).getText());
//
//		boolean flag = true;
//		while(flag==true) {
//			driver.findElement(By.linkText("Click here")).click();
//			System.out.println(driver.findElement(By.xpath("//div[@id='flash-messages']/div")).getText());
//			if(driver.findElement(By.xpath("//div[@id='flash-messages']/div")).getText().contains("successful")){
//				flag=false;
//			}
//		}
//
//		Thread.sleep(3000);
//		driver.quit();
//	}
//}
//
//    // Methods from: NewTab
//
//
//import Set;
//import JavascriptExecutor;
//import WebDriver;
//import ChromeDriver;
//import ExpectedCondition;
//import WebDriverWait;
//import resources.UITestPracticePage;
//import utility.FrameworkConstants;
//
//public class NewTab {
//	public static void main(String[] args) {
//
//		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://uitestpractice.com/Students/");
//		System.out.println(driver.getCurrentUrl());
//
//		String parentHandle = driver.getWindowHandle();
//		System.out.println("Parent handle id : "+parentHandle);
//		UITestPracticePage.using(driver).clickNewTabLink(driver);
//		waitForPageLoadComplete(driver);
//		Set<String> handles = driver.getWindowHandles();
//		System.out.println("no of tabs : "+handles.size());
//
//		for(String handleStr:handles) {
//			if(!handleStr.equals(parentHandle)) {
//				System.out.println(handleStr);
//				driver.switchTo().window(handleStr);
//			}
//		}
//
//		String childHandle = driver.getWindowHandle();
//		System.out.println("Child handle id : "+childHandle);
//		driver.switchTo().window(parentHandle);
//
////		WebDriverWait wait = new WebDriverWait(driver, 5);
////		wait.until(ExpectedConditions.visibilityOf(UITestPracticePage.using(driver).containerBlue));
////		UITestPracticePage.using(driver).body.sendKeys(Keys.CONTROL + "\t");
////
//		driver.quit();
//	}
//
//    public static void waitForPageLoadComplete(WebDriver driver){
//
//        ExpectedCondition<Boolean> pageLoadCondition = new
//                ExpectedCondition<Boolean>() {
//                    public Boolean apply(WebDriver driver) {
//                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
//                    }
//                };
//        try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(pageLoadCondition);
//    }
//}
//
//
//    // Methods from: MouseOverMenu
//
//import Duration;
//import List;
//import Function;
//
//import By;
//import JavascriptExecutor;
//import WebDriver;
//import WebElement;
//import ChromeDriver;
//import Actions;
//import FluentWait;
//import resources.UITestPracticePage;
//import utility.FrameworkConstants;
//
//
//public class MouseOverMenu {
//	public static void main(String[] args) {
//
//		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://uitestpractice.com/Students/");
//		System.out.println(driver.getCurrentUrl());
//		List<WebElement> menuItems = (List<WebElement>) UITestPracticePage.using(driver).mouseOverMenu;
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -window.innerHeight / 4);", menuItems.get(0));
//
//		for(WebElement menu:menuItems) {
//			if(menu.getText().equalsIgnoreCase("Salzburg")) {
//				Actions action = new Actions(driver);
//				action.moveToElement(menu);
//
//			      FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
//							.withTimeout(Duration.ofSeconds(100))
//							.pollingEvery(Duration.ofMillis(200))
//							.ignoring(Exception.class);
//
//
//					Function<WebDriver, Boolean> func = new Function<WebDriver, Boolean>()
//					{
//					public Boolean apply( WebDriver driver) {
//					WebElement element = driver.findElement(By.xpath("//ul"));
//					System.out.println(element.getCssValue("display"));
//						if(element.getCssValue("display").equalsIgnoreCase("block")){
//							return true;
//						}
//							return false;
//						}
//					};
//
//					fWait.until(func);
//					menu.click();
//
//					List<WebElement> subMenuItems = menu.findElement(By.tagName("ul")).findElements(By.tagName("li"));
//					System.out.println("Sub menu items length : "+subMenuItems.size());
//					for(WebElement subMenu:subMenuItems) {
//						if(menu.getText().equalsIgnoreCase("Delphi")) {
//							menu.click();
//						}
//					}
//			}
//
//		driver.quit();
//	}}}
//
//
//
//
//    // Methods from: ModalWindow
//
//import Test;
//import utility.BaseTest;
//import Duration;
//import Function;
//import By;
//import WebDriver;
//import WebElement;
//import FluentWait;
//
//public class ModalWindow extends BaseTest{
//
//	@Test
//	public void test() throws InterruptedException {
//		driver.findElement(By.xpath("//a[contains(text(),'Entry Ad')]")).click();
//		waitForModalWindow(driver);
//		WebElement modalBody = driver.findElement(By.cssSelector("div.modal-body p"));
//		System.out.println(modalBody.getText());
//		driver.findElement(By.cssSelector("div.modal-footer p")).click();
//		Thread.sleep(6000);
//
//	}
//
//	private void waitForModalWindow(WebDriver driver) {
//		System.out.println("Loading check");
//		FluentWait<WebDriver> fw = new FluentWait<WebDriver>(driver)
//									.withTimeout(Duration.ofSeconds(30))
//									.pollingEvery(Duration.ofMillis(500))
//									.ignoring(Exception.class);
//
//		Function<WebDriver, Boolean> func = new Function<WebDriver, Boolean>() {
//			public Boolean apply(WebDriver driver) {
//				WebElement loadingIcon = driver.findElement(By.cssSelector("div#modal"));
//				String displayValue = loadingIcon.getCssValue("display");
//				if(displayValue.equals("block")) {
//					return true;
//				}
//				return false;
//			}
//		};
//
//		fw.until(func);
//	}
//}
//
//
//    // Methods from: KeyboardActions
//
//import NoSuchElementException;
//
//import Keys;
//import WebElement;
//import Actions;
//
//public class KeyboardActions extends BaseTest{
//
//	public void sendKeyEnter() {
//		action.sendKeys(Keys.ENTER).build().perform();
//	}
//
//	public void sendKeyEscape() {
//		action.sendKeys(Keys.ESCAPE).build().perform();
//	}
//
//	public void sendKeyTab() {
//		action.sendKeys(Keys.TAB).build().perform();
//	}
//
//	public void sendKeyArrowDown() {
//		action.sendKeys(Keys.ARROW_DOWN).build().perform();
//	}
//
//	public void sendKeyArrowUp() {
//		action.sendKeys(Keys.ARROW_UP).build().perform();
//	}
//
//	public void mouseHover(WebElement webelement) {
//		try {
//			action.moveToElement(webelement).build().perform();
//		}catch (NoSuchElementException e) {
//			e.printStackTrace();
//		}
//
//	}
//}
//
//
//    // Methods from: KeyPresses
//
//import By;
//import WebDriver;
//import ChromeDriver;
//import Actions;
//import utility.FrameworkConstants;
//
//public class KeyPresses {
//
//	public static void main(String[] args) throws InterruptedException {
//
//		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://the-internet.herokuapp.com/");
//		driver.findElement(By.xpath("//a[contains(text(),'Key Presses')]")).click();
//		Actions action = new Actions(driver);
//		action.sendKeys("S").perform();;
//		System.out.println(driver.findElement(By.cssSelector("p#result")).getText());
//
//		Thread.sleep(3000);
//		driver.quit();
//	}
//}
//
//    // Methods from: JavaScriptActions
//
//import WebElement;
//
//public class JavaScriptActions extends BaseTest{
//	public static void scrollUp() {
//		js.executeScript("window.scrollBy(0,-300)");
//	}
//
//	public static void scrollDown() {
//		js.executeScript("window.scrollBy(0,300)");
//	}
//
//	public static void scrollRight() {
//		js.executeScript("window.scrollBy(300,0)");
//	}
//
//	public static void scrollLeft() {
//		js.executeScript("window.scrollBy(-300,0)");
//	}
//
//	public static void pageUp() {
//		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
//	}
//
//	public static void pageDown() {
//		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//	}
//
//	public static void scrollToElement(WebElement webElement) {
//		js.executeScript("arguments[0].scrollIntoView",webElement);
//	}
//
//	public void jsclickElement(WebElement webelement) {
//		js.executeScript("arguments[0].click()", webelement);
//	}
//
//	public void jsenterText(WebElement webelement, String value) {
//		webelement.clear();
//		js.executeScript("arguments[0].value=arguments[1]", webelement,value);
//	}
//}
//
//
//
//
//    // Methods from: InfiniteScroll
//
//import By;
//import JavascriptExecutor;
//import WebDriver;
//import ChromeDriver;
//import utility.FrameworkConstants;
//
//public class InfiniteScroll {
//
//	public static void main(String[] args) throws InterruptedException {
//
//		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://the-internet.herokuapp.com/");
//		driver.findElement(By.xpath("//a[contains(text(),'Infinite Scroll')]")).click();
//		long lenOfPage = (Long) ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);var lenOfPage=document.body.scrollHeight;return lenOfPage;");
//		boolean scrolled = true;
//		long lastCount = 0;
//		System.out.println(lenOfPage);
//
//		while(scrolled==true) {
//			Thread.sleep(1500);
//			lastCount=lenOfPage;
//			lenOfPage = (Long) ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);var lenOfPage=document.body.scrollHeight;return lenOfPage;");
//			System.out.println(lenOfPage);
//			if (lastCount==lenOfPage) {
//				scrolled=false;
//			}
//
//		}
//
//		Thread.sleep(3000);
//		driver.quit();
//	}
//}
//
//    // Methods from: Hover
//
//import List;
//import By;
//import WebDriver;
//import WebElement;
//import ChromeDriver;
//import Actions;
//import utility.FrameworkConstants;
//
//public class Hover {
//
//	public static void main(String[] args) throws InterruptedException {
//
//		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://the-internet.herokuapp.com/");
//		driver.findElement(By.xpath("//a[contains(text(),'Infinite Scroll')]")).click();
//		List<WebElement> images = driver.findElements(By.cssSelector(".figure"));
//		Actions action = new Actions(driver);
//		for(WebElement image:images) {
//			action.moveToElement(image).perform();
//			System.out.println(image.findElement(By.cssSelector(".figcaption")).isDisplayed());
//
//		}
//		Thread.sleep(3000);
//		driver.quit();
//	}
//}
//
//    // Methods from: HeadlessDriverTest
//
//
//import WebDriver;
//import ChromeDriver;
//import ChromeOptions;
//import FirefoxDriver;
//import FirefoxOptions;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//import utility.FrameworkConstants;
//
//
//public class HeadlessDriverTest {
//	public static void main(String[] args) {
////		usingHtmlUnitDriver();
////		usingChromeHeadless();
//		usingFireFoxHeadless();
//	}
//
//
//	public static void usingChromeHeadless() {
//
//		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
//		ChromeOptions options = new ChromeOptions();
//		options.setHeadless(true);
//		WebDriver driver = new ChromeDriver(options);
//		driver.get("https://www.google.co.in");
//		System.out.println(driver.getCurrentUrl());
//		driver.quit();
//	}
//
//	public static void usingFireFoxHeadless() {
//
//		System.setProperty(FrameworkConstants.FIREFOX_DRIVER_KEY,FrameworkConstants.FIREFOX_DRIVER_PATH);
//		FirefoxOptions options = new FirefoxOptions();
////		options.addArguments("--headless");
//		options.setHeadless(true);
//		WebDriver driver = new FirefoxDriver(options);
//		driver.get("https://www.google.co.in");
//		System.out.println(driver.getCurrentUrl());
//		driver.quit();
//	}
//
//}
//
//
//    // Methods from: FrameworkUtility
//
//import FileInputStream;
//import Properties;
//import Logger;
//import Alert;
//import JavascriptExecutor;
//import WebDriver;
//import Actions;
//import WebDriverWait;
//import LogManager;
//
//public class FrameworkUtility {
//
//	public static Properties properties;
//	public static String URL;
//	public static final Logger logger = LogManager.getLogger();
//	public static WebDriver driver;
//	public static JavaScriptActions jsActions;
//	public static JavascriptExecutor js;
//	public static Actions action;
//	public static WebDriverWait wait;
//	public static CustomWait Wait;
//	public static WindowActions WindowHandler;
//	public static AlertActions AlertHandler;
//	public static KeyboardActions KeyboardHandler;
//	protected Alert alert;
//
//
//	public String readConfigurationFile(String configKey) {
//		properties = new Properties();
//		try {
//			properties.load(new FileInputStream(FrameworkConstants.CONFIG_FILE_PATH));
//		} catch (Exception e) {
//			System.out.println("Error reading configuration file with exception :"+e);
//		}
//		return properties.getProperty(configKey).trim();
//	}
//}
//
//
//
//
//    // Methods from: FrameworkConstants
//
//public class FrameworkConstants extends FrameworkUtility{
//
//	public static final String CONFIG_FILE_PATH = "./Test_Configuration/Config.properties";
//	public static final String CHROME_DRIVER_KEY = "webdriver.chrome.driver";
//	public static final String CHROME_DRIVER_PATH = "./Browser_Drivers/chromedriver.exe";
//	public static final String FIREFOX_DRIVER_KEY = "webdriver.gecko.driver";
//	public static final String FIREFOX_DRIVER_PATH= "./Browser_Drivers/geckodriver.exe";
//	public static final int OBJECT_LOAD_TIME_OUT = 60;
//	public static final int PAGE_LOAD_TIME_OUT = 180;
//
//
//}
//
//
//    // Methods from: ExceptionCustomisation
//
//import resources.CustomException1;
//
//public class ExceptionCustomisation {
//
//	public static void main(String[] args) {
//
//		//			exceptionTest0();
//		exceptionTest1();
//
//	}
//
//	private static void exceptionTest1() {
//		try {
//			throw new CustomException1("My custom exception message goes here");
//		} catch (CustomException1 e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
//	//Errors - hardware failures, checked exception - which we can anticipate and handle, unchecked exception - which we cannot anticipate(array index out of bound)
//	private static void exceptionTest0() throws Exception {
//
//		NullPointerException nullException = new NullPointerException("Testing Exception");
//		Exception e = new Exception();
//		throw nullException;
//	}
//
//}
//
//
//
//
//    // Methods from: DynamicLoading
//
//import Test;
//import utility.BaseTest;
//import utility.FrameworkConstants;
//
//import List;
//import By;
//import WebDriver;
//import WebElement;
//import ChromeDriver;
//
//public class DynamicLoading extends BaseTest{
//
//	@Test
//	public void test() throws InterruptedException {
//		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
//		WebDriver driver = new ChromeDriver();
//		driver.findElement(By.xpath("//a[contains(text(),'Dynamic Content')]")).click();
//		//To get direct descendants with 'row' class of div elements
//		List<WebElement> dynamicContent = driver.findElements(By.cssSelector("div#content>div.row"));
//		//To get the text from the 2nd row of dynamic content
//		System.out.println(dynamicContent.get(1).findElement(By.cssSelector("div:nth-child(2)")).getText());
//		Thread.sleep(6000);
//		driver.quit();
//
//	}
//}
//
//
//    // Methods from: DynamicContent
//
//import Test;
//import utility.BaseTest;
//import utility.FrameworkConstants;
//
//import Duration;
//import Function;
//
//import By;
//import WebDriver;
//import WebElement;
//import ChromeDriver;
//import FluentWait;
//
//public class DynamicContent extends BaseTest{
//
//	@Test
//	public void test() throws InterruptedException {
//		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
//		WebDriver driver = new ChromeDriver();
//		driver.findElement(By.xpath("//a[contains(text(),'Dynamic Loading')]")).click();
//		hiddenElementCheck(driver);
//		renderedElementCheck(driver);
//		driver.quit();
//	}
//
//	private void hiddenElementCheck(WebDriver driver) {
//		driver.findElement(By.partialLinkText("Example 1")).click();
//		driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
//		waitForloadingToComplete(driver);
//		System.out.println(driver.findElement(By.cssSelector("div#finish>h4")).getText());
//	}
//
//	private void renderedElementCheck(WebDriver driver) {
//		driver.findElement(By.partialLinkText("Example 2")).click();
//		driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
//		waitForloadingToComplete(driver);
//		System.out.println(driver.findElement(By.cssSelector("div#finish>h4")).getText());
//	}
//
//	private void waitForloadingToComplete(WebDriver driver) {
//		System.out.println("Loading check");
//		FluentWait<WebDriver> fw = new FluentWait<WebDriver>(driver)
//									.withTimeout(Duration.ofSeconds(30))
//									.pollingEvery(Duration.ofMillis(500))
//									.ignoring(Exception.class);
//
//		Function<WebDriver, Boolean> func = new Function<WebDriver, Boolean>() {
//			public Boolean apply(WebDriver driver) {
//				WebElement loadingIcon = driver.findElement(By.cssSelector("div#loading"));
//				String displayValue = loadingIcon.getCssValue("display");
//				if(displayValue.equals("none")) {
//					return true;
//				}
//				return false;
//			}
//		};
//
//		fw.until(func);
//	}
//}
//
//
//
//    // Methods from: Dropdown
//
//import Test;
//import utility.BaseTest;
//import utility.FrameworkConstants;
//
//import By;
//import WebDriver;
//import WebElement;
//import ChromeDriver;
//import Select;
//
//public class Dropdown extends BaseTest{
//
//	@Test
//	public void test() throws InterruptedException {
//		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
//		WebDriver driver = new ChromeDriver();
//		driver.findElement(By.xpath("//a[contains(text(),'Dropdown')]")).click();
//		WebElement dropdown = driver.findElement(By.id("dropdown"));
//		Select select = new Select(dropdown);
//		select.selectByValue("2");
//		Thread.sleep(6000);
//
//	}
//}
//
//
//    // Methods from: DragAndDrop
//
//import Test;
//import utility.BaseTest;
//import utility.FrameworkConstants;
//
//import By;
//import WebDriver;
//import WebElement;
//import ChromeDriver;
//import Actions;
//
//
//public class DragAndDrop extends BaseTest{
//
//	@Test
//	public void test() throws InterruptedException {
//		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
//		WebDriver driver = new ChromeDriver();
//		driver.findElement(By.xpath("//a[contains(text(),'Drag and Drop')]")).click();
//		WebElement elementA = driver.findElement(By.cssSelector("div#column-a"));
//		System.out.println(elementA.getAttribute("id"));
//		WebElement elementB = driver.findElement(By.cssSelector("div#column-b"));
//		int x=elementB.getLocation().getX();
//		int y=elementB.getLocation().getY();
//		Actions actions = new Actions(driver);
////		elementA.click();
//		actions.dragAndDrop(elementA, elementB).build().perform();
//		Thread.sleep(6000);
//		driver.quit();
//
//	}
//}
//
//
//    // Methods from: DoubleClick
//
//import WebDriver;
//import ChromeDriver;
//import resources.UITestPracticePage;
//import utility.FrameworkConstants;
//
//
//public class DoubleClick {
//	public static void main(String[] args) {
//
//		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://uitestpractice.com/Students/");
//		System.out.println(driver.getCurrentUrl());
//		UITestPracticePage.using(driver).doDoubleClick(driver);
//		driver.quit();
//	}
//}
//
//
//    // Methods from: DialogControl
//
//import List;
//import By;
//import WebDriver;
//import WebElement;
//import ChromeDriver;
//
//import resources.UITestPracticePage;
//import utility.FrameworkConstants;
//
//
//public class DialogControl {
//	public static void main(String[] args) {
//
//		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://uitestpractice.com/Students/");
//		System.out.println(driver.getCurrentUrl());
//
//		UITestPracticePage.using(driver).dialogControl_createNewUser.click();
//		UITestPracticePage.using(driver).dialogControl_createNewUser_name.clear();
//		UITestPracticePage.using(driver).dialogControl_createNewUser_name.sendKeys("Jon Snow");
//		UITestPracticePage.using(driver).dialogControl_createNewUser_createAccount.click();
//		WebElement userTable = UITestPracticePage.using(driver).dialogControl_userTable;
//		List<WebElement> userRows = userTable.findElements(By.tagName("tr"));
//		for(WebElement userRow:userRows) {
//			List<WebElement> userData = userRow.findElements(By.tagName("td"));
//			for(WebElement user:userData) {
//				System.out.println(user.getText());
//
//			}
//			System.out.println("=============================");
//		}
//
//		driver.quit();
//	}
//}
//
//
//
//    // Methods from: CustomWait
//
//import By;
//import ElementNotInteractableException;
//import JavascriptExecutor;
//import TimeoutException;
//import WebDriver;
//import WebElement;
//import ExpectedCondition;
//import ExpectedConditions;
//import WebDriverWait;
////import com.relevantcodes.extentreports.LogStatus;
//
//public class CustomWait extends BaseTest{
//
//	public void forElementVisibility(WebElement webelement) {
//		wait = new WebDriverWait(driver, FrameworkConstants.OBJECT_LOAD_TIME_OUT);
//		wait.until(ExpectedConditions.visibilityOf(webelement));
//	}
//
//	public void forElementClickablity(WebElement webelement) {
//		System.out.println("To check element clickability");
//		wait = new WebDriverWait(driver, FrameworkConstants.OBJECT_LOAD_TIME_OUT);
//		wait.until(ExpectedConditions.elementToBeClickable(webelement));
//	}
//
//	public void forElementVisibility(WebElement webelement, int customTimeout) {
//		wait = new WebDriverWait(driver, customTimeout);
//		wait.until(ExpectedConditions.visibilityOf(webelement));
//	}
//
//	public void forElementInVisibility(By locator) throws InterruptedException {
//		wait = new WebDriverWait(driver, FrameworkConstants.OBJECT_LOAD_TIME_OUT);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
//	}
//
//	public void forElementInVisibility(By locator, int customTimeout) throws InterruptedException {
//		wait = new WebDriverWait(driver, customTimeout);
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
//	}
//
//	public void forAlertToBePresent() {
//		wait = new WebDriverWait(driver, FrameworkConstants.OBJECT_LOAD_TIME_OUT);
//		wait.until(ExpectedConditions.alertIsPresent());
//
//	}
//
//	public void forAlertToBePresent(int customTimeout) {
//		wait = new WebDriverWait(driver, customTimeout);
//		wait.until(ExpectedConditions.alertIsPresent());
//	}
//
//	public void forPageTitle(String pagetitle) {
//		wait = new WebDriverWait(driver, FrameworkConstants.OBJECT_LOAD_TIME_OUT);
//		wait.until(ExpectedConditions.titleIs(pagetitle));
//	}
//
//	public void forPageTitle(String pagetitle, int customTimeout) {
//		wait = new WebDriverWait(driver, customTimeout);
//		wait.until(ExpectedConditions.titleIs(pagetitle));
//	}
//
//	public void forPageToLoad(WebElement webelement) {
//		wait = new WebDriverWait(driver, FrameworkConstants.PAGE_LOAD_TIME_OUT);
//		wait.until(ExpectedConditions.visibilityOf(webelement));
////		test.log(LogStatus.INFO, "Webpage loaded within timeout period "+FrameworkConstants.PAGE_LOAD_TIME_OUT+" secs");
//	}
//
//	public void forPageToLoad(WebElement webelement, int customTimeout) {
//		wait = new WebDriverWait(driver, customTimeout);
//		wait.until(ExpectedConditions.visibilityOf(webelement));
//
//	}
//
//	public void forPageToLoad(String pageTitle) {
//		wait = new WebDriverWait(driver, FrameworkConstants.PAGE_LOAD_TIME_OUT);
//		wait.until(ExpectedConditions.titleIs(pageTitle));
//	}
//
//
//	public void forPageToLoad(String pageTitle, int customTimeout) {
//		forPageTitle(pageTitle,customTimeout);
//	}
//
//	public void forTextToBePresent(String text){
//		text.trim();
//		int count = 0;
//		boolean flag = false;
//		do {
//			if(driver.getPageSource().contains(text)) {
//				flag = true;
//				break;
//			} else {
//				count++;
//				forXseconds(1);
//			}
//		} while (count < FrameworkConstants.OBJECT_LOAD_TIME_OUT);
//
//		if(!flag) {
//			throw new TimeoutException("Search text not found on the webpage after timeout period of "+FrameworkConstants.OBJECT_LOAD_TIME_OUT+" secs");
//		}
//	}
//
//	public void forTextToBePresent(String text, int customTimeout){
//		text.trim();
//		int count = 0;
//		boolean flag = false;
//		do {
//			if(driver.getPageSource().contains(text)) {
//				flag = true;
////				test.log(LogStatus.INFO, "Search text found on the webpage");
//				break;
//			} else {
//				count++;
//				forXseconds(1);
//			}
//		} while (count < customTimeout);
//
//		if(!flag) {
//			throw new TimeoutException("Search text not found on the webpage after timeout period of "+customTimeout+" secs");
//		}
//	}
//
//	public void forElementToBeEnabled(WebElement webelement) {
//		int count = 0;
//		boolean flag = false;
//		do {
//			if(webelement.isEnabled()) {
//				flag = true;
//				break;
//			} else {
//				count++;
//				forXseconds(1);
//			}
//		} while (count < FrameworkConstants.OBJECT_LOAD_TIME_OUT);
//
//		if(!flag) {
//			throw new ElementNotInteractableException("Element disabled");
//		}
//	}
//
//	public void forElementToBeEnabled(WebElement webelement, int customTimeout) {
//		int count = 0;
//		boolean flag = false;
//		do {
//			if(webelement.isEnabled()) {
//				flag = true;
//				break;
//			} else {
//				count++;
//				forXseconds(1);
//			}
//		} while (count < customTimeout);
//
//		if(!flag) {
//			throw new ElementNotInteractableException("Element disabled");
//		}
//	}
//
//	public void forElementToBeVisibleAndEnabled(WebElement webelement) {
//		forElementVisibility(webelement);
//		forElementToBeEnabled(webelement);
//	}
//
//	public void forElementToBeVisibleAndEnabled(WebElement webelement, int customTimeout) {
//		forElementVisibility(webelement,customTimeout);
//		forElementToBeEnabled(webelement,customTimeout);
//	}
//
//	public void forXseconds(int seconds) {
//		seconds = seconds * 1000;
//		try {
//			Thread.sleep(seconds);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//}
//
//    // Methods from: ContextMenu
////This program works in in firefox browser so change the browser name in the configuration file before triggering this
//
//import IOException;
//import org.apache.http.client.ClientProtocolException;
//import By;
//import JavascriptExecutor;
//import WebDriver;
//import WebElement;
//import ChromeDriver;
//import Actions;
//import Test;
//import utility.BaseTest;
//import utility.FrameworkConstants;
//
//public class ContextMenu extends BaseTest{
//
//	@Test
//	public void test() throws InterruptedException, ClientProtocolException, IOException {
//		System.setProperty(FrameworkConstants.CHROME_DRIVER_KEY,FrameworkConstants.CHROME_DRIVER_PATH);
//		WebDriver driver = new ChromeDriver();
//		driver.findElement(By.xpath("//a[contains(text(),'Drag and Drop')]")).click();
//		WebElement contextBox = driver.findElement(By.cssSelector("div[contextmenu='menu']"));
//		Actions actions = new Actions(driver);
//		actions.moveToElement(contextBox);
//		actions.contextClick(contextBox).build().perform();
//		Thread.sleep(2000);
//		WebElement menuItem = driver.findElement(By.cssSelector("menuitem[label='the-internet']"));
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click()", menuItem);
//		Thread.sleep(2000);
//		driver.switchTo().alert().accept();
//		Thread.sleep(2000);
//	}
//}
//
//
//    // Methods from: CollectionsFramework
//
//import AbstractCollection;
//import ArrayList;
//import Collections;
//import HashMap;
//import Iterator;
//import List;
//import ListIterator;
//import Map;
//
//public class CollectionsFramework {
//
//	public static void main(String[] args) {
//		AbstractCollection<Object> ac = new ArrayList<Object>();
//		abstractCollection();
//		collectionsClass();
//		hashMapCheck();
//		NoOfOccuranceUsingHashMap();
//	}
//
//	private static void NoOfOccuranceUsingHashMap() {
//		System.out.println("####### duplicates in array check #########");
//		int noArray[] = {10,20,10,20,30,40,30,30,30};
//
//		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
//
//		for(int i=0;i<noArray.length;i++) {
//			Integer count=hmap.get(noArray[i]);
//			if(hmap.get(noArray[i])==null) {
//				hmap.put(noArray[i], 1);
//			}
//			else {
//				hmap.put(noArray[i], ++count);
//			}
//		}
//
//		for(Map.Entry m:hmap.entrySet()) {
//			System.out.println("Key is : "+m.getKey()+" and value is :"+m.getValue());
//		}
//
//
//
//	}
//
//	private static void hashMapCheck() {
//		System.out.println("####### hashMapCheck #########");
//		HashMap<String, String> hm = new HashMap<String, String>();
//		hm.put("1", "String 1");
//		hm.put("2", "String 2");
//		hm.put("3", "String 3");
//		hm.put("4", "String 4");
//
////		System.out.println(hm.get("3"));
//		for(String key:hm.keySet()) {
//			System.out.println(hm.get(key));
//		}
//
//
//
//
//	}
//
//	private static void abstractCollection() {
//		System.out.println("####### abstractCollection #########");
//		AbstractCollection<Object> ac = new ArrayList<Object>();
//		ac.add("string 1");
//		ac.add("string 2");
//		System.out.println(ac);
//		System.out.println(ac.contains("string 3"));
//	}
//
//	private static void collectionsClass() {
//		System.out.println("####### collectionsClass #########");
//		List<String>  list = new ArrayList<String>();
//		list.add("10");
//		list.add("40");
//		list.add("50");
//		list.add("20");
//		System.out.println(list);
//
//		Collections.reverse(list);
//		System.out.println(list);
//
//		Collections.rotate(list, 1);
//		System.out.println(list);
//
//		System.out.println(Collections.max(list));
//		System.out.println(Collections.min(list));
//
//		Collections.sort(list);
//		System.out.println(list);
//
//		Iterator itr = list.iterator();
//		ListIterator li=list.listIterator();
//		while(li.hasNext()) {
//			System.out.println(li.next());
//		}
//
//		while(itr.hasNext()) {
//				String str = (String) itr.next();
//				System.out.println(str);
//
//		}
//		System.out.println(list);
//
//	}
//
//}
//
//
//}