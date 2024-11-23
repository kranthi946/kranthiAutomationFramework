

package com.AI.pages;

import com.AI.enums.WaitStrategy;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorldsearchEU extends Basepage{



//	 Constructor to receive WebDriver instance
	public WorldsearchEU() {

	}
	By 	searchboxkeyword = By.xpath("//input[@id='occupations-search-input']");

	By search = By.xpath("//button[@id='shared-search-bar-search-btn']");
	By cookie = By.xpath("//a[contains(text(),'Accept all cookies')]");
	By xbutton = By.xpath("//body/div[@id='cookie-consent-banner']/div[1]/div[1]/div[2]/button[1]/span[1]");

	// not working By vancanciestxt = By.xpath("//section[@class=\"ecl-col-m-9 ng-star-inserted\"]/self::*/child::h2[1]");


	By clickingonTestresults = By.xpath("//div[@class='ecl-u-border-top ecl-u-border-color-grey-15']/self::div/child::jv-result-summary/descendant::div//a[contains(text(),'Test')]");

	By selectCountry = By.xpath("//ul[@id='jobs-by-location-list']/self::ul/descendant::a");

	//By employer = By.xpath("//ecl-inpage-navigation-item[@id='inline-nav-employer']");


	By searchresultslist  = By.xpath("//div[@class=\"ecl-u-border-top ecl-u-border-color-grey-15\"]/self::div/descendant::a");
	public WorldsearchEU acceptcookies() {
		click(cookie, WaitStrategy.CLICKABLE);
		return this;

	}

	public WorldsearchEU closebutton() {
		click(xbutton, WaitStrategy.CLICKABLE);
		return this;

	}

	public WorldsearchEU selectcountryandsearchresult() throws Throwable {
		Thread.sleep(5000);

		By selectCountry = By.xpath("//ul[@id='jobs-by-location-list']/self::ul/descendant::a");
		List<WebElement> listofcountries = getLinksText(selectCountry);

		List<String>  cl = new ArrayList<>();
		for(WebElement c : listofcountries) {

			cl.add(c.getText());

		}

		for (int i = 0; i < listofcountries.size(); i++) {
			WebElement currentCountry = listofcountries.get(i);
			String countryName = currentCountry.getText();

			System.out.println("Selected the country position " + i + ": " + countryName);


			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofMillis(500L));
			wait.until(ExpectedConditions.presenceOfElementLocated(selectCountry));

			WebDriverWait wait1 = new WebDriverWait(DriverManager.getDriver(), Duration.ofMillis(500L));
			wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner-wrapper")));

			currentCountry.click();

			Thread.sleep(2000);
			DriverManager.getDriver().navigate().refresh();


			enterkeywords();
			Thread.sleep(4000);
			pressEnterInSearchBox();


			List<WebElement> foundlistjobpostings  = 	getLinksText(searchresultslist);

			List<String> jt = new ArrayList<>();

			for (WebElement e : foundlistjobpostings) {

				jt.add(e.getText());
				//	System.out.println(jt.size());

			}



			Thread.sleep(8000);

			boolean containsKeywords = foundlistjobpostings.stream()
					.anyMatch(jp -> {
						String jobTitle = jp.getText().toUpperCase();

						return jobTitle.contains("ICT TEST ANALYST") ||
								jobTitle.contains("Test Analyst")||
								jobTitle.contains("TEST MANAGER") ||
								jobTitle.contains("SOFTWARE TESTER") ||
								jobTitle.contains("AUTOMATION") ||
								jobTitle.contains("TEST ENGINEER");
					});

			if(containsKeywords) {




				clickontestresultandextractingemails();
				Thread.sleep(2000);
				DriverManager.getDriver().navigate().back();
				Thread.sleep(2000);
				listofcountries = getLinksText(selectCountry);
				
			}

			else {



				DriverManager.getDriver().navigate().back();
				DriverManager.getDriver().navigate().refresh();

			}
			Thread.sleep(5000);

			// Re-fetch the list of countries after refreshing the page
			listofcountries = getLinksText(selectCountry);
		}

		return this;
	}


	public  WorldsearchEU  enterkeywords() throws InterruptedException{
		Thread.sleep(5000);
		sendkeys(searchboxkeyword, "ICT Test Analyst", WaitStrategy.VISIBLE);
		return  this;
	}


	public WorldsearchEU pressEnterInSearchBox() throws Throwable {
		WebElement searchBox = DriverManager.getDriver().findElement(searchboxkeyword);
		searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		return this;
	}




	public Jobpositionportalemailextract clickontestresultandextractingemails() throws Throwable {
	    List<WebElement> jobpositionsinthepagefound = getLinksText(clickingonTestresults);

	    int totaljobsavailableinthepage = jobpositionsinthepagefound.size();
	    System.out.println("Total job listings in this page: " + totaljobsavailableinthepage);

	    for (int i = 0; i < totaljobsavailableinthepage; i++) {
	        // Open link in a new tab using JavaScript
	    	
	    	String currenturl = DriverManager.getDriver().getCurrentUrl();
	        System.out.println("Opening job position in a new tab");
	        
	        System.out.println("current url : "+ currenturl);
	        
	        openLinkInNewTab(jobpositionsinthepagefound.get(i));

	        // Switch to the new tab
	        switchToNewTab(jobpositionsinthepagefound);

	       
	        System.out.println("Closed tab");

	        // Switch back to the main tab
	        switchToMainTab();

	        
	        jobpositionsinthepagefound = getLinksText(clickingonTestresults);
	    }

	    return new Jobpositionportalemailextract();
	}

	private void openLinkInNewTab(WebElement linkElement) throws Throwable {
	    JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
	    executor.executeScript("window.open(arguments[0], '_blank');", linkElement.getAttribute("href"));
	    System.out.println("Extracting email");
        landonpageextractemail();
	}

	private void switchToMainTab() {
	    List<String> handles = new ArrayList<>(DriverManager.getDriver().getWindowHandles());
	    DriverManager.getDriver().switchTo().window(handles.get(0));
	}

	
	
	private void landonpageextractemail() throws InterruptedException {

		WebDriverWait waitSpinner = new WebDriverWait(DriverManager.getDriver(), Duration.ofMillis(500L));

	    waitSpinner.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.spinner-wrapper")));

	    // Wait for the email element to be present
	    try {
	        WebDriverWait wait =  new WebDriverWait(DriverManager.getDriver(), Duration.ofMillis(500L));

			WebElement howToApplyElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='jv-details-how-to-apply']")));

	        Thread.sleep(3000);
	        // Extract emails from the "How to apply" element text
	        List<String> extractedEmails = extractEmails(howToApplyElement.getText());

	        // Print the extracted emails
	        System.out.println("Extracted Emails: " + extractedEmails);
	    } catch (org.openqa.selenium.TimeoutException e) {
	        // Handle the TimeoutException, for example, log a message
	        System.out.println("TimeoutException: Email element not found within the specified time.");
	        
	        // Close the tab and move to the next job posting
	        closeTab();
	        return;
	    }

	    
	}

	

private void closeTab() {
    switchToMainTab(); // Switch back to the main tab before closing
   
}
	
	private void switchToNewTab(List<WebElement> jobpositionsinthepagefound) throws Throwable {
		List<String> handles = new ArrayList<>(DriverManager.getDriver().getWindowHandles());
		DriverManager.getDriver().switchTo().window(handles.get(handles.size() - 1));
		Thread.sleep(2000);
		DriverManager.getDriver().navigate().refresh();
		Thread.sleep(2000);
		clickUsingJavaScript( jobpositionsinthepagefound);
		
		
		Thread.sleep(2000);
		DriverManager.getDriver().close();
		
	}
	private List<String> extractEmails(String text) {
		// Create a pattern for extracting emails within the specific structure
		String emailPattern = "Email:\\s*([A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,})";
		Pattern pattern = Pattern.compile(emailPattern);
		Matcher matcher = pattern.matcher(text);

		// Find all matches
		List<String> emails = new ArrayList<>();
		while (matcher.find()) {
			emails.add(matcher.group(1));  // Use group(1) to capture the email address part
		}

		return emails;
	}

	private void clickUsingJavaScript(List<WebElement> jobpositionsinthepagefound) throws Throwable {
		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
		executor.executeScript("arguments[0].click();", jobpositionsinthepagefound);
		Thread.sleep(2000);
		landonpageextractemail();


	}

	


	

}