package test.java.stepdefinitions;

import io.cucumber.java.en.*;
import main.java.pages.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("User is on the Login page")
    public void user_is_on_the_login_page() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
    }

    @When("User enters login email {string} and password {string}")
    public void user_enters_login_email_and_password(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @When("User clicks on Sign In")
    public void user_clicks_on_sign_in() {
        loginPage.clickSignIn();
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        assert loginPage.isLoginSuccessful();
        driver.quit();
    }

    @Then("An error message should be displayed for login failure")
    public void an_error_message_should_be_displayed_for_login_failure() {
        assert loginPage.isLoginFailed();
        driver.quit();
    }
}
