package steps;

import org.openqa.selenium.Keys;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import po.Amazon;
import po.DashboardPage;
import utils.WebDriverUtils;

public class AmazonSteps {
	
	static WebDriverUtils wdu;
	
	@Given("I am able to navigate onto amazon home page")
	public void i_am_able_to_navigate_onto_amazon_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		wdu.initializeBrowser("gc");
		wdu.test = wdu.report.createTest("New Scenario");
		wdu.loadUrl("http://amazon.in");
	}
	@When("I search for {string}")
	public void i_search_for(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    wdu.type(Amazon.search_ip, string+Keys.ENTER);
	}
	@When("I select {string}")
	public void i_select(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    wdu.click(DashboardPage.stringLocator(string));
	    wdu.switchToCreatedWindow();
	}
	@When("I click on buy now")
	public void i_click_on_buy_now() {
	    // Write code here that turns the phrase above into concrete actions
	    wdu.click(Amazon.buynow_btn);
	}
	@When("I update username as {string}")
	public void i_update_username_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@When("I update password as {string}")
	public void i_update_password_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("I choose the delivery location")
	public void i_choose_the_delivery_location() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("I process the payment as {string}")
	public void i_process_the_payment_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("I should get a invoice summary generated")
	public void i_should_get_a_invoice_summary_generated() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("I should receive an email about the order being placed")
	public void i_should_receive_an_email_about_the_order_being_placed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("I should navigate onto the orders page")
	public void i_should_navigate_onto_the_orders_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
