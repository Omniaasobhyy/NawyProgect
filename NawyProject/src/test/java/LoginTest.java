package tests;

import base.PlaywrightFactory;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {
    private Page page;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        PlaywrightFactory.initBrowser();
        loginPage = new LoginPage(page);
    }

    @Test
    public void testUserLogin() {
        loginPage.loginUser("testUser123", "TestPass@123");
    }

    @AfterClass
    public void tearDown() {
        PlaywrightFactory.closeBrowser();
    }
}
