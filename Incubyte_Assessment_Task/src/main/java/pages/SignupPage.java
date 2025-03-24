package main.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage {

    // Constructor
    public SignupPage(WebDriver driver) {
        super(driver);
    }

    // Web Elements using @FindBy annotation
    @FindBy(id = "firstname")
    private WebElement firstNameInput;

    @FindBy(id = "lastname")
    private WebElement lastNameInput;

    @FindBy(id = "email_address")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "password-confirmation")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//button[@title='Create an Account']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//div[contains(@class, 'message-success')]")
    private WebElement successMessage;

    @FindBy(xpath = "//div[contains(@class, 'message-error')]")
    private WebElement errorMessage;

    // Page Actions
    public void openSignupPage() {
        openUrl("https://magento.softwaretestingboard.com/customer/account/create/");
    }

    public void enterFirstName(String firstName) {
        enterText(firstNameInput, firstName);
    }

    public void enterLastName(String lastName) {
        enterText(lastNameInput, lastName);
    }

    public void enterEmail(String email) {
        enterText(emailInput, email);
    }

    public void enterPassword(String password) {
        enterText(passwordInput, password);
    }

    public void confirmPassword(String password) {
        enterText(confirmPasswordInput, password);
    }

    public void clickCreateAccount() {
        click(createAccountButton);
    }

    public boolean isSignupSuccessful() {
        return isElementDisplayed(successMessage);
    }

    public boolean isSignupFailed() {
        return isElementDisplayed(errorMessage);
    }
}
