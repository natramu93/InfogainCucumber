package utils;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtils {
	WebDriver driver;
	WebDriverWait wait;
	Actions act;
	public ExtentTest test;
	public ExtentReports report;

	public void initializeBrowser(String browser) {
		ExtentSparkReporter sreport = new ExtentSparkReporter(System.getProperty("user.dir")+"/ExtentReportResults.html");
		report = new ExtentReports();
		report.attachReporter(sreport);
		switch(browser) {
		case "gc": case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "headless":
			WebDriverManager.chromedriver().setup();
			ChromeOptions opt = new ChromeOptions();
			opt.setHeadless(true);
			driver = new ChromeDriver(opt);
			break;
		case "ff":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		act = new Actions(driver);
	}
	
	public void loadUrl(String url) {
		test.log(Status.INFO, "Loading URL: "+ url+"\nCurrent URL: "+driver.getCurrentUrl());
		driver.get(url);
		test.log(Status.PASS, "Loaded URL: "+driver.getCurrentUrl());
		test.log(Status.PASS, "screenshot "+test.addScreenCaptureFromPath(driver.findElement(By.tagName("html")).getScreenshotAs(OutputType.FILE).getAbsolutePath()));
	}
	
	public void navigateBack() {
		test.log(Status.INFO, "Navigating Back");
		driver.navigate().back();
	}
	
	public void navigateForward() {
		test.log(Status.INFO, "Navigating Forward");
		driver.navigate().forward();
	}
	
	public void refresh() {
		test.log(Status.INFO, "Navigating Refresh");
		driver.navigate().refresh();
	}
	int cnt = 0;
	public WebElement findElement(By loc) {
		WebElement e = null;
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(loc));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
			e = driver.findElement(loc);
			cnt = 0;
		}
		catch(NoSuchElementException ex) {
			refresh();
			if(cnt<2)
			{
				cnt++;
				findElement(loc);
			}
			cnt = 0;
			test.fail("Failed to locate "+loc.toString()+" after 2 attempts of refresh");
			test.fail("Screenshot Below:"+test.addScreenCaptureFromBase64String(driver.findElement(By.tagName("html")).getScreenshotAs(OutputType.BASE64)));
		}
		return e;
	}
	
	public void click(By loc) {
		WebElement e = findElement(loc);
		
		try {
			wait.until(ExpectedConditions.elementToBeClickable(e));
			e.click();
		}
		catch(StaleElementReferenceException ex) {
			e = findElement(loc);
			e.click();
		}
		test.pass("Click on "+loc.toString());
	}
	
	public void type(By loc, String data) {
		WebElement e = findElement(loc);
		try {
			e.clear();
			e.sendKeys(data);
		}
		catch(IllegalArgumentException ex)
		{
			e.clear();
			e.sendKeys("");
		}
		test.pass("Type "+data+" into "+loc.toString());
	}	
	
	public void validateText(By loc, String text) {
		String actual = driver.findElement(loc).getText();
		Assert.assertEquals(text, actual );
		test.pass("Validation of Text at "+loc.toString());
	}
	
	public void mouseOver(By loc) {
		act.moveToElement(driver.findElement(loc)).perform();
	}
	
	public void quit() {
		driver.quit();
	}
	
	public void switchFrame(WebElement e) {
		driver.switchTo().frame(e);
	}
	
	public void switchFrameContaining(By loc) {
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		if(frames.size()==0) {
			frames = driver.findElements(By.tagName("frame"));
		}
		for (WebElement frame:frames) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.switchTo().frame(frame);
			if(driver.findElements(loc).size()>0)
			{
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				break;
			}
			driver.switchTo().defaultContent();
		}
	}
	
	public void selectByVisibleText(By loc, String text) {
		Select obj = new Select(findElement(loc));
		obj.selectByVisibleText(text);
	}
	
	public void switchDefault() {
		driver.switchTo().defaultContent();
	}
	
	public void switchToCreatedWindow() {
		Set<String> winids = driver.getWindowHandles();
		driver.switchTo().window(winids.toArray()[winids.size()-1].toString());
	}
	
}
