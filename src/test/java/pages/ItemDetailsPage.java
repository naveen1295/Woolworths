package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ReusableFunctions;

public class ItemDetailsPage {

	private ReusableFunctions rfunc;

	@FindBy(id = "atcRedesignId_btn")
	private WebElement btnAddToCart;
	
	@FindBy(xpath="//*[contains(text(),'Go to cart')]")
	private WebElement btnGoToCart;


	public ItemDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		rfunc = new ReusableFunctions(driver);
	}

	public ItemDetailsPage addToCart() {
		btnAddToCart.click();
		return this;
	}
	
	public ItemDetailsPage goToCart() {
		rfunc.waitForElement(btnGoToCart).click();
		return this;
	}
}
