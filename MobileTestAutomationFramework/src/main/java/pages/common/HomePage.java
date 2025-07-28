package pages.common;

import components.ButtonComponent;
import global.PageUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import utilities.LoggerUtils;

/**
 * Page object for the home page.
 * Contains elements and methods related to the home page functionality.
 */
public class HomePage extends PageUtils {
    
    // Page elements
    @AndroidFindBy(id = "home_title")
    @iOSXCUITFindBy(accessibility = "home_title")
    private WebElement homeTitle;
    
    @AndroidFindBy(id = "profile_button")
    @iOSXCUITFindBy(accessibility = "profile_button")
    private WebElement profileButton;
    
    @AndroidFindBy(id = "settings_button")
    @iOSXCUITFindBy(accessibility = "settings_button")
    private WebElement settingsButton;
    
    @AndroidFindBy(id = "notifications_button")
    @iOSXCUITFindBy(accessibility = "notifications_button")
    private WebElement notificationsButton;
    
    @AndroidFindBy(id = "search_button")
    @iOSXCUITFindBy(accessibility = "search_button")
    private WebElement searchButton;
    
    private ButtonComponent buttonComponent;
    
    /**
     * Constructor to initialize the home page.
     *
     * @param driver AppiumDriver instance
     */
    public HomePage(AppiumDriver driver) {
        super(driver);
        buttonComponent = new ButtonComponent(driver);
    }
    
    /**
     * Checks if the home page is displayed.
     *
     * @return true if the home page is displayed, false otherwise
     */
    public boolean isHomePageDisplayed() {
        boolean isDisplayed = isElementDisplayed(homeTitle);
        LoggerUtils.info("Home page is " + (isDisplayed ? "displayed" : "not displayed"));
        return isDisplayed;
    }
    
    /**
     * Gets the home page title text.
     *
     * @return The home page title text
     */
    public String getHomePageTitle() {
        String title = getText(homeTitle);
        LoggerUtils.info("Home page title: " + title);
        return title;
    }
    
    /**
     * Navigates to the profile page.
     */
    public void navigateToProfile() {
        LoggerUtils.info("Navigating to profile page");
        buttonComponent.clickButton(profileButton, "Profile");
    }
    
    /**
     * Navigates to the settings page.
     */
    public void navigateToSettings() {
        LoggerUtils.info("Navigating to settings page");
        buttonComponent.clickButton(settingsButton, "Settings");
    }
    
    /**
     * Navigates to the notifications page.
     */
    public void navigateToNotifications() {
        LoggerUtils.info("Navigating to notifications page");
        buttonComponent.clickButton(notificationsButton, "Notifications");
    }
    
    /**
     * Opens the search functionality.
     */
    public void openSearch() {
        LoggerUtils.info("Opening search");
        buttonComponent.clickButton(searchButton, "Search");
    }
    
    /**
     * Waits for the home page to load.
     *
     * @return The HomePage instance for method chaining
     */
    public HomePage waitForHomePageToLoad() {
        LoggerUtils.info("Waiting for home page to load");
        waitForVisibility(homeTitle);
        return this;
    }
}
