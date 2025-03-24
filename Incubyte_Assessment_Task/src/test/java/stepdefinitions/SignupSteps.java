package test.java.stepdefinitions;

import io.cucumber.java.en.*;
import main.java.pages.SignupPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SignupSteps {
    WebDriver driver;
    SignupPage signupPage;

    @Given("User is on the Signup page")
    public void user_is_on_the_signup_page() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        signupPage = new SignupPage(driver);
        signupPage.openSignupPage();
    }

    @When("User enters first name {string} and last name {string}")
    public void user_enters_first_and_last_name(String firstName, String lastName) {
        signupPage.enterFirstName(firstName);
        signupPage.enterLastName(lastName);
    }

    @When("User enters email {string}")
    public void user_enters_email(String email) {
        signupPage.enterEmail(email);
    }

    @When("User enters password {string} and confirms password {string}")
    public void user_enters_password_and_confirms_password(String password, String confirmPassword) {
        signupPage.enterPassword(password);
        signupPage.confirmPassword(confirmPassword);
    }

    @When("User clicks on Create an Account")
    public void user_clicks_on_create_an_account() {
        signupPage.clickCreateAccount();
    }

    @Then("Account should be created successfully")
    public void account_should_be_created_successfully() {
        assert signupPage.isSignupSuccessful();
        driver.quit();
    }

    @Then("An error message should be displayed for signup failure")
    public void an_error_message_should_be_displayed_for_signup_failure() {
        assert signupPage.isSignupFailed();
        driver.quit();
    }
}
