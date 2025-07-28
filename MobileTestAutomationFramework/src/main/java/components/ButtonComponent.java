package components;

import global.PageUtils;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import utilities.LoggerUtils;

/**
 * Component class for button elements.
 * Provides methods for interacting with button elements.
 */
public class ButtonComponent extends PageUtils {
    
    /**
     * Constructor to initialize ButtonComponent.
     *
     * @param driver AppiumDriver instance
     */
    public ButtonComponent(AppiumDriver driver) {
        super(driver);
    }
    
    /**
     * Clicks on a button element.
     *
     * @param button The button element to click
     * @param buttonName The name of the button (for logging)
     * @return true if the click was successful, false otherwise
     */
    public boolean clickButton(WebElement button, String buttonName) {
        try {
            LoggerUtils.info("Clicking on button: " + buttonName);
            click(button);
            return true;
        } catch (Exception e) {
            LoggerUtils.error("Failed to click on button: " + buttonName, e);
            return false;
        }
    }
    
    /**
     * Checks if a button is enabled.
     *
     * @param button The button element to check
     * @param buttonName The name of the button (for logging)
     * @return true if the button is enabled, false otherwise
     */
    public boolean isButtonEnabled(WebElement button, String buttonName) {
        try {
            boolean isEnabled = waitForVisibility(button).isEnabled();
            LoggerUtils.info("Button " + buttonName + " is " + (isEnabled ? "enabled" : "disabled"));
            return isEnabled;
        } catch (Exception e) {
            LoggerUtils.error("Failed to check if button is enabled: " + buttonName, e);
            return false;
        }
    }
    
    /**
     * Checks if a button is displayed.
     *
     * @param button The button element to check
     * @param buttonName The name of the button (for logging)
     * @return true if the button is displayed, false otherwise
     */
    public boolean isButtonDisplayed(WebElement button, String buttonName) {
        try {
            boolean isDisplayed = isElementDisplayed(button);
            LoggerUtils.info("Button " + buttonName + " is " + (isDisplayed ? "displayed" : "not displayed"));
            return isDisplayed;
        } catch (Exception e) {
            LoggerUtils.error("Failed to check if button is displayed: " + buttonName, e);
            return false;
        }
    }
    
    /**
     * Gets the text of a button.
     *
     * @param button The button element to get text from
     * @param buttonName The name of the button (for logging)
     * @return The text of the button, or null if an error occurs
     */
    public String getButtonText(WebElement button, String buttonName) {
        try {
            String text = getText(button);
            LoggerUtils.info("Button " + buttonName + " text: " + text);
            return text;
        } catch (Exception e) {
            LoggerUtils.error("Failed to get button text: " + buttonName, e);
            return null;
        }
    }
}
