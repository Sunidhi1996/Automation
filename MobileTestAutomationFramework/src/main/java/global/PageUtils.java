package global;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

/**
 * Utility class for page interactions.
 * Contains common methods used across page objects.
 */
public class PageUtils extends BasePage {

    protected static final int DEFAULT_WAIT = 10;
    protected WebDriverWait wait;
    protected Properties properties;

    /**
     * Constructor to initialize PageUtils.
     *
     * @param driver AppiumDriver instance
     */
    public PageUtils(AppiumDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT));
    }

    /**
     * Waits for an element to be visible.
     *
     * @param element WebElement to wait for
     * @return WebElement that is now visible
     */
    public WebElement waitForVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for an element to be clickable.
     *
     * @param element WebElement to wait for
     * @return WebElement that is now clickable
     */
    public WebElement waitForClickability(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Clicks on an element after waiting for it to be clickable.
     *
     * @param element WebElement to click
     */
    public void click(WebElement element) {
        waitForClickability(element).click();
    }

    /**
     * Enters text in an input field after waiting for it to be visible.
     *
     * @param element WebElement to enter text into
     * @param text Text to enter
     */
    public void sendKeys(WebElement element, String text) {
        waitForVisibility(element).sendKeys(text);
    }

    /**
     * Gets text from an element after waiting for it to be visible.
     *
     * @param element WebElement to get text from
     * @return Text of the element
     */
    public String getText(WebElement element) {
        return waitForVisibility(element).getText();
    }

    /**
     * Checks if an element is displayed.
     *
     * @param element WebElement to check
     * @return true if element is displayed, false otherwise
     */
    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
