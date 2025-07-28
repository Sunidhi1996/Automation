package constants;

/**
 * Constants used throughout the application.
 * This class contains static final variables for various application constants.
 */
public class AppConstants {
    
    // Timeout constants
    public static final int DEFAULT_TIMEOUT = 10;
    public static final int EXTENDED_TIMEOUT = 30;
    public static final int SHORT_TIMEOUT = 5;
    
    // Wait constants
    public static final int LONG_WAIT = 10000; // 10 seconds
    public static final int MEDIUM_WAIT = 5000; // 5 seconds
    public static final int SHORT_WAIT = 2000; // 2 seconds
    
    // File paths
    public static final String SCREENSHOT_PATH = "screenshots/";
    public static final String REPORT_PATH = "reports/";
    
    // Test data
    public static final String TEST_DATA_FILE = "testdata/testdata.json";
    
    // Application specific constants
    public static final String LOGIN_PAGE_TITLE = "Login";
    public static final String HOME_PAGE_TITLE = "Home";
    public static final String PROFILE_PAGE_TITLE = "Profile";
    
    // Error messages
    public static final String LOGIN_ERROR = "Invalid username or password";
    public static final String NETWORK_ERROR = "Network connection error";
    
    // Private constructor to prevent instantiation
    private AppConstants() {
        throw new IllegalStateException("Constants class");
    }
}
