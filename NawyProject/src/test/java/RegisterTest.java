package tests;

import base.PlaywrightFactory;
import com.microsoft.playwright.*;
import org.testng.annotations.*;

public class RegisterTest {

    private PlaywrightFactory playwrightFactory;

    @BeforeClass
    public void setUp() {
        playwrightFactory = new PlaywrightFactory();
        playwrightFactory.initBrowser();
    }

    @Test
    public void testOpenPage() {
        try {
            // Use the browser and page
            Page page = playwrightFactory.getPage();
            page.navigate("https://www.demoblaze.com/");
            System.out.println("Page loaded: " + page.title());
        } catch (Exception e) {
            System.out.println("Error during test execution: " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        playwrightFactory.close();
    }
}