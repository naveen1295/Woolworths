package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

	private WebDriver driver;

	@FindBy(id = "gh-ac")
	private WebElement txtSearchBox;

	@FindBy(id = "gh-btn")
	private WebElement btnSearch;
	
	@FindBys(value = { @FindBy(xpath="//a[@class='s-item__link']//h3")})
	private List<WebElement> lnkSearchResults;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage verifyTitle(String tileName) {
		if (driver.getTitle().equals(tileName))
			System.out.println("HomePage launched successfully");
		else
			System.out.println("HomePage not launched");
		return this;
	}

	public HomePage enterSearchText(String searchtext) {
		txtSearchBox.clear();
		txtSearchBox.sendKeys(searchtext);
		return this;
	}

	public HomePage clickSearchButton() {
		btnSearch.click();
		return this;
	}
	
	public HomePage clickOnSearchResultWithIndex(int index) {
		lnkSearchResults.get(index).click();
		return this;
	}
	
	public String storeItemName(int itemIndex) {
		try {
			System.out.println(lnkSearchResults.get(itemIndex).getText());
			return lnkSearchResults.get(itemIndex).getText();
		}catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

}
