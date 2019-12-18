package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableFunctions {
	
	private Wait<WebDriver>  wait;
	
	public ReusableFunctions(WebDriver driver) {
		wait = new WebDriverWait(driver, 15).withMessage("Element was not found");;
	}

	public WebElement waitForElement(WebElement element) {
		WebElement welement;
		welement= wait.until(ExpectedConditions.visibilityOf(element));
		return welement;
	}
	
}
