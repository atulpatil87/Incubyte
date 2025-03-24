package main.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Web Elements using @FindBy annotation
    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "pass")
    private WebElement passwordInput;

    @FindBy(id = "send2")
    private WebElement signInButton;

    @FindBy(xpath = "//div[contains(@class, 'message-error')]")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[contains(@class, 'message-success')]")
    private WebElement successMessage;

    // Page Actions
    public void openLoginPage() {
        openUrl("https://magento.softwaretestingboard.com/customer/account/login/");
    }

    public void enterEmail(String email) {
        enterText(emailInput, email);
    }

    public void enterPassword(String password) {
        enterText(passwordInput, password);
    }

    public void clickSignIn() {
        click(signInButton);
    }

    public boolean isLoginSuccessful() {
        return isElementDisplayed(successMessage);
    }

    public boolean isLoginFailed() {
        return isElementDisplayed(errorMessage);
    }
}
