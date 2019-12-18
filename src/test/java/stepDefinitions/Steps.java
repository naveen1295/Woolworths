package stepDefinitions;

import pages.CartPage;
import pages.HomePage;
import pages.ItemDetailsPage;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class Steps {
	
	private World world;
	private static WebDriver driver;
	public HomePage homePage;
	public ItemDetailsPage itemDetailsPage;
	public CartPage cartPage;
	private static String itemName;

	public Steps(World world) {
		this.world = world;
        driver = (WebDriver) this.world.context.get("driver");
		homePage = new HomePage(driver);
		itemDetailsPage = new ItemDetailsPage(driver);
		cartPage = new CartPage(driver);
	}

	@Given("user is on ebay home page")
	public void user_is_on_ebay_home_page() {
		//driver.get((String) world.context.get("URL"));
	}

	@When("he searchs for {string}")
	public void he_searchs_for(String string) {
		homePage.enterSearchText(string);
		homePage.clickSearchButton();
	}

	@When("clicks on the first item on the search result")
	public void clicks_on_the_first_item_on_the_search_result() {
		itemName = homePage.storeItemName(0);
		homePage.clickOnSearchResultWithIndex(0);
	}

	@When("adds the item to the cart")
	public void adds_the_item_to_the_cart() {
		itemDetailsPage.addToCart();
	}

	@When("he navigates to the cart")
	public void he_navigates_to_the_cart() {
		itemDetailsPage.goToCart();
	}
	
	@Then("the item is deleted from the cart")
	public void the_item_is_deleted_from_the_cart() {
		assertTrue(cartPage.itemDeletedSuccessfully());
		
	}
	
	@When("delete the item in the cart")
	public void delete_the_item_in_the_cart() {
		cartPage.deleteItemWithIndex(0);
	}

	@Then("the item added is in the cart")
	public void the_item_added_is_in_the_cart() {
		assertTrue(cartPage.cartItemExists(itemName));
	}

}
