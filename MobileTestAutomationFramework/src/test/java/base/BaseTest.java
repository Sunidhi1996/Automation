package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.JavaUtils;
import utilities.LoggerUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * Base class for all test classes.
 * Provides common functionality for test setup and teardown.
 */
public class BaseTest {
    
    protected AppiumDriver driver;
    protected Properties properties;
    
    /**
     * Setup method to initialize the test environment.
     * Runs before each test class.
     *
     * @param platform The platform to run tests on (android or ios)
     * @throws Exception If an error occurs during setup
     */
    @BeforeClass
    @Parameters({"platform"})
    public void setup(@Optional("android") String platform) throws Exception {
        LoggerUtils.info("Setting up test environment for platform: " + platform);
        
        // Load properties
        try {
            properties = JavaUtils.loadProperties("properties/app.properties");
            LoggerUtils.info("Properties loaded successfully");
        } catch (IOException e) {
            LoggerUtils.error("Failed to load properties", e);
            throw e;
        }
        
        // Initialize driver based on platform
        if (platform.equalsIgnoreCase("android")) {
            initializeAndroidDriver();
        } else if (platform.equalsIgnoreCase("ios")) {
            initializeIOSDriver();
        } else {
            throw new IllegalArgumentException("Invalid platform: " + platform);
        }
    }
    
    /**
     * Initializes the Android driver.
     *
     * @throws Exception If an error occurs during initialization
     */
    private void initializeAndroidDriver() throws Exception {
        LoggerUtils.info("Initializing Android driver");
        
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", properties.getProperty("android.platformName"));
        capabilities.setCapability("deviceName", properties.getProperty("android.deviceName"));
        capabilities.setCapability("automationName", properties.getProperty("android.automationName"));
        
        // Set app path
        String appPath = properties.getProperty("android.appPath");
        File app = new File(appPath);
        if (app.exists()) {
            capabilities.setCapability("app", app.getAbsolutePath());
        } else {
            LoggerUtils.warn("App file not found at: " + appPath);
            capabilities.setCapability("appPackage", properties.getProperty("app.package"));
            capabilities.setCapability("appActivity", properties.getProperty("app.activity"));
        }
        
        // Additional capabilities
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("fullReset", false);
        
        // Initialize driver
        driver = new AndroidDriver(new URL(properties.getProperty("appium.server.url")), capabilities);
        LoggerUtils.info("Android driver initialized successfully");
    }
    
    /**
     * Initializes the iOS driver.
     *
     * @throws Exception If an error occurs during initialization
     */
    private void initializeIOSDriver() throws Exception {
        LoggerUtils.info("Initializing iOS driver");
        
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", properties.getProperty("ios.platformName"));
        capabilities.setCapability("deviceName", properties.getProperty("ios.deviceName"));
        capabilities.setCapability("automationName", properties.getProperty("ios.automationName"));
        
        // Set app path
        String appPath = properties.getProperty("ios.appPath");
        File app = new File(appPath);
        if (app.exists()) {
            capabilities.setCapability("app", app.getAbsolutePath());
        } else {
            LoggerUtils.warn("App file not found at: " + appPath);
            capabilities.setCapability("bundleId", properties.getProperty("ios.bundleId"));
        }
        
        // Additional capabilities
        capabilities.setCapability("noReset", false);
        capabilities.setCapability("fullReset", false);
        
        // Initialize driver
        driver = new IOSDriver(new URL(properties.getProperty("appium.server.url")), capabilities);
        LoggerUtils.info("iOS driver initialized successfully");
    }
    
    /**
     * Teardown method to clean up after tests.
     * Runs after each test class.
     */
    @AfterClass
    public void tearDown() {
        LoggerUtils.info("Tearing down test environment");
        if (driver != null) {
            driver.quit();
            LoggerUtils.info("Driver quit successfully");
        }
    }
    
    /**
     * Method to handle test result.
     * Runs after each test method.
     *
     * @param result The test result
     */
    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            LoggerUtils.error("Test failed: " + result.getName());
            // Capture screenshot on failure
            captureScreenshot(result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            LoggerUtils.info("Test passed: " + result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            LoggerUtils.warn("Test skipped: " + result.getName());
        }
    }
    
    /**
     * Captures a screenshot.
     *
     * @param testName The name of the test
     */
    private void captureScreenshot(String testName) {
        // Implementation for capturing screenshots
        LoggerUtils.info("Capturing screenshot for failed test: " + testName);
        // Add screenshot capture logic here
    }
}
