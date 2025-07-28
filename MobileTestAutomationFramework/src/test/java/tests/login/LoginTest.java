package tests.login;

import base.BaseTest;
import constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.common.HomePage;
import pages.login.LoginPage;
import utilities.LoggerUtils;

/**
 * Test class for login functionality.
 * Contains test methods for various login scenarios.
 */
public class LoginTest extends BaseTest {
    
    private LoginPage loginPage;
    private HomePage homePage;
    
    /**
     * Setup method to initialize page objects.
     * Runs before each test method.
     */
    @BeforeMethod
    public void setupTest() {
        LoggerUtils.info("Setting up LoginTest");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }
    
    /**
     * Test successful login with valid credentials.
     */
    @Test(description = "Verify successful login with valid credentials", groups = {"smoke", "regression"})
    public void testSuccessfulLogin() {
        LoggerUtils.info("Starting test: testSuccessfulLogin");
        
        // Perform login
        loginPage.login("validuser", "validpassword");
        
        // Verify login was successful
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page should be displayed after successful login");
        Assert.assertEquals(homePage.getHomePageTitle(), AppConstants.HOME_PAGE_TITLE, "Home page title should match expected value");
        
        LoggerUtils.info("Completed test: testSuccessfulLogin");
    }
    
    /**
     * Test failed login with invalid credentials.
     */
    @Test(description = "Verify failed login with invalid credentials", groups = {"regression"})
    public void testFailedLogin() {
        LoggerUtils.info("Starting test: testFailedLogin");
        
        // Perform login with invalid credentials
        loginPage.login("invaliduser", "invalidpassword");
        
        // Verify login failed
        Assert.assertFalse(loginPage.isLoginSuccessful(), "Login should fail with invalid credentials");
        Assert.assertEquals(loginPage.getErrorMessage(), AppConstants.LOGIN_ERROR, "Error message should match expected value");
        
        LoggerUtils.info("Completed test: testFailedLogin");
    }
    
    /**
     * Test login with empty username.
     */
    @Test(description = "Verify login with empty username", groups = {"regression"})
    public void testLoginWithEmptyUsername() {
        LoggerUtils.info("Starting test: testLoginWithEmptyUsername");
        
        // Perform login with empty username
        loginPage.login("", "validpassword");
        
        // Verify login failed
        Assert.assertFalse(loginPage.isLoginSuccessful(), "Login should fail with empty username");
        Assert.assertNotNull(loginPage.getErrorMessage(), "Error message should be displayed");
        
        LoggerUtils.info("Completed test: testLoginWithEmptyUsername");
    }
    
    /**
     * Test login with empty password.
     */
    @Test(description = "Verify login with empty password", groups = {"regression"})
    public void testLoginWithEmptyPassword() {
        LoggerUtils.info("Starting test: testLoginWithEmptyPassword");
        
        // Perform login with empty password
        loginPage.login("validuser", "");
        
        // Verify login failed
        Assert.assertFalse(loginPage.isLoginSuccessful(), "Login should fail with empty password");
        Assert.assertNotNull(loginPage.getErrorMessage(), "Error message should be displayed");
        
        LoggerUtils.info("Completed test: testLoginWithEmptyPassword");
    }
}
