package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import po.CreatePatientFrame;
import po.DashboardPage;
import utils.WebDriverUtils;

public class CreatePatient {
	static WebDriverUtils wdu;
	
	@Given("I am able to navigate onto OpenEMR Home Page")
	public void i_am_able_to_navigate_onto_open_emr_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		wdu.initializeBrowser("gc");
		wdu.test = wdu.report.createTest("New Scenario");
		wdu.loadUrl("https://demo.openemr.io/a/openemr");
	}
	
	@When("I choose the menu option {string}")
	public void i_choose_the_menu_option(String string) {
	    wdu.mouseOver(DashboardPage.stringLocator(string));
	    
	}
	@When("I click on {string}")
	public void i_click_on(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    wdu.click(DashboardPage.stringLocator(string));
	    wdu.switchFrameContaining(CreatePatientFrame.title_select);
	}
	@When("I select the title as {string}")
	public void i_select_the_title_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    wdu.selectByVisibleText(CreatePatientFrame.title_select, string);
	}
	
	@When("I update the firstname as {string}")
	public void i_update_the_firstname_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    wdu.type(CreatePatientFrame.fname_ip, string);
	}
	
	@When("I update the lastname as {string}")
	public void i_update_the_lastname_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
		wdu.type(CreatePatientFrame.lname_ip, string);
	}
	@When("I update the DOB as today")
	public void i_update_the_dob_as_today() {
	    // Write code here that turns the phrase above into concrete actions
	    wdu.click(CreatePatientFrame.dob_ip);
	    wdu.click(CreatePatientFrame.today_date);
	}
	@When("I select the gender as {string}")
	public void i_select_the_gender_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    wdu.selectByVisibleText(CreatePatientFrame.gender_dropdown, string);
	}
	@When("I click on Create Button")
	public void i_click_on_create_button() {
	    // Write code here that turns the phrase above into concrete actions
	    wdu.click(CreatePatientFrame.create_btn);
	    wdu.switchDefault();
	}
	@When("I click on confirm create Button")
	public void i_click_on_confirm_create_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("I should see an alert message")
	public void i_should_see_an_alert_message() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("I should see a happy birthday message")
	public void i_should_see_a_happy_birthday_message() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
}
