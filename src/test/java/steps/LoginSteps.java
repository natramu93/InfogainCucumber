package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import po.DashboardPage;
import po.LoginPage;
import utils.WebDriverUtils;

public class LoginSteps {
	static WebDriverUtils wdu;
	@Given("I am able to navigate onto openEMR Login page")
	public void i_am_able_to_navigate_onto_open_emr_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		wdu.initializeBrowser("gc");
		wdu.test = wdu.report.createTest("New Scenario");
		wdu.loadUrl("https://demo.openemr.io/a/openemr");
	}
	
	@Before
	public void before_all() {
		wdu= new WebDriverUtils();
		CreatePatient.wdu = wdu;
		AmazonSteps.wdu = wdu;
		System.out.println("Before");
	}
	
//	@Before("@invalid")
//	public void before_invalid() {
//		
//	}
//	
	@When("I update the username as {string}")
	public void i_update_the_username_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
		wdu.type(LoginPage.username_ip, string);
	}
	@When("I update the password as {string}")
	public void i_update_the_password_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    wdu.type(LoginPage.pwd_ip, string);
	}
	@When("I click on the login button")
	public void i_click_on_the_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		wdu.click(LoginPage.login_btn);
	}
	@Then("I should see the user as {string}")
	public void i_should_see_the_user_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
		wdu.mouseOver(DashboardPage.usericon);
		wdu.validateText(DashboardPage.username_label, string);
		wdu.quit();
	}
	@Then("I should get the error message as {string}")
	public void i_should_get_the_error_message_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    wdu.validateText(LoginPage.error_msg, string);
	    wdu.quit();
	}

}
