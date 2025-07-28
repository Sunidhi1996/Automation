package pages.login;

import components.ButtonComponent;
import global.PageUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import utilities.LoggerUtils;

/**
 * Page object for the login page.
 * Contains elements and methods related to the login functionality.
 */
public class LoginPage extends PageUtils {
    
    // Page elements
    @AndroidFindBy(id = "username_input")
    @iOSXCUITFindBy(accessibility = "username_input")
    private WebElement usernameInput;
    
    @AndroidFindBy(id = "password_input")
    @iOSXCUITFindBy(accessibility = "password_input")
    private WebElement passwordInput;
    
    @AndroidFindBy(id = "login_button")
    @iOSXCUITFindBy(accessibility = "login_button")
    private WebElement loginButton;
    
    @AndroidFindBy(id = "error_message")
    @iOSXCUITFindBy(accessibility = "error_message")
    private WebElement errorMessage;
    
    private ButtonComponent buttonComponent;
    
    /**
     * Constructor to initialize the login page.
     *
     * @param driver AppiumDriver instance
     */
    public LoginPage(AppiumDriver driver) {
        super(driver);
        buttonComponent = new ButtonComponent(driver);
    }
    
    /**
     * Enters the username.
     *
     * @param username The username to enter
     * @return The LoginPage instance for method chaining
     */
    public LoginPage enterUsername(String username) {
        LoggerUtils.info("Entering username: " + username);
        sendKeys(usernameInput, username);
        return this;
    }
    
    /**
     * Enters the password.
     *
     * @param password The password to enter
     * @return The LoginPage instance for method chaining
     */
    public LoginPage enterPassword(String password) {
        LoggerUtils.info("Entering password");
        sendKeys(passwordInput, password);
        return this;
    }
    
    /**
     * Clicks the login button.
     *
     * @return The LoginPage instance for method chaining
     */
    public LoginPage clickLoginButton() {
        LoggerUtils.info("Clicking login button");
        buttonComponent.clickButton(loginButton, "Login");
        return this;
    }
    
    /**
     * Performs the login operation with the provided credentials.
     *
     * @param username The username to enter
     * @param password The password to enter
     * @return The LoginPage instance for method chaining
     */
    public LoginPage login(String username, String password) {
        LoggerUtils.info("Performing login with username: " + username);
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        return this;
    }
    
    /**
     * Gets the error message text if present.
     *
     * @return The error message text, or null if not present
     */
    public String getErrorMessage() {
        if (isElementDisplayed(errorMessage)) {
            String message = getText(errorMessage);
            LoggerUtils.info("Error message displayed: " + message);
            return message;
        }
        return null;
    }
    
    /**
     * Checks if the login was successful.
     *
     * @return true if login was successful, false otherwise
     */
    public boolean isLoginSuccessful() {
        // Check if error message is not displayed
        boolean noErrorMessage = !isElementDisplayed(errorMessage);
        LoggerUtils.info("Login " + (noErrorMessage ? "successful" : "failed"));
        return noErrorMessage;
    }
}
