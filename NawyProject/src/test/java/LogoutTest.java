package tests;

import base.PlaywrightFactory;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import pages.LoginPage;
import pages.LogoutPage;

public class LogoutTest {
    private Page page;
    private LoginPage loginPage;
    private LogoutPage logoutPage;

    @BeforeClass
    public void setUp() {
        page = PlaywrightFactory.initBrowser();
        loginPage = new LoginPage(page);
        logoutPage = new LogoutPage(page);
    }

    @Test
    public void testUserLogout() {
        loginPage.loginUser("testUser123", "TestPass@123"); // Login before logging out
        logoutPage.logoutUser(); // Perform logout

        // Assert that the login button is visible again after logout
        assertTrue(page.isVisible("#loginbtn"), "Login button should be visible after logout.");
    }

    @AfterClass
    public void tearDown() {
        PlaywrightFactory.closeBrowser();
    }
}
