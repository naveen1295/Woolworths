package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import utils.ReusableFunctions;

public class CartPage {
	
	public ReusableFunctions rfunc;

	@FindBys(value = { @FindBy(xpath = "//a[@data-test-id='cart-item-link']//span[@class='BOLD']") })
	private List<WebElement> lstCartItemNames;
	
	@FindBys(value = { @FindBy(xpath = "//button[contains(.,'Remove')]") })
	private List<WebElement> lnkRemove; 
	
	@FindBy(xpath="//span[contains(text(),'was removed from your cart.')]")
	private WebElement removeSuccessMessage;

	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		rfunc = new ReusableFunctions(driver);
	}

	public Boolean cartItemsExists() {
		if (lstCartItemNames.size() > 0) {
			return true;
		} else
			return false;
	}

	public Boolean cartItemExists(String itemtext) {
		if (cartItemsExists()) {
			for (WebElement element : lstCartItemNames) {
				if (element.getText().equals(itemtext)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public CartPage deleteItemWithIndex(int index) {
		
		if (cartItemsExists()) {
			rfunc.waitForElement(lnkRemove.get(index));
			lnkRemove.get(index).click();
		}
		return this;
	}
	
	public Boolean itemDeletedSuccessfully() {
		if(rfunc.waitForElement(removeSuccessMessage) != null) {
			return true;
		} else
			return false;
	}

}
