package global;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

/**
 * Base class for all page objects.
 * Provides common functionality for page objects.
 */
public abstract class BasePage {
    
    protected AppiumDriver driver;
    
    /**
     * Constructor to initialize the page objects.
     * 
     * @param driver AppiumDriver instance
     */
    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
