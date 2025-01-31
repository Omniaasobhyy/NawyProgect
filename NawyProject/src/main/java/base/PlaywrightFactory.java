package base;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class PlaywrightFactory {
    private static Playwright playwright;
    private static Browser browser;


    private static final String BROWSER_PATH = "C:\\JavaCourse\\NawyProject\\src\\main\\resources\\chrome.exe";
    private static final String DRIVER_PATH = "C:\\JavaCourse\\NawyProject\\src\\main\\resources\\chromedriver.exe";

    public static Page initBrowser() {
        try {
            if (playwright == null) {
                playwright = Playwright.create(); // Properly initializing Playwright instance
            }
            if (browser == null) {
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setExecutablePath(Paths.get(BROWSER_PATH)));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error initializing Playwright: " + e.getMessage());
        }
        return browser != null ? browser.newPage() : null;
    }

    public static void closeBrowser() {
        if (browser != null) {
            browser.close();
        }
    }

    public Playwright getPlaywright() {
        return playwright;
    }

    public Browser getBrowser() {
        return browser;
    }

    public Page getPage() {
        return browser != null ? browser.newPage() : null;
    }

    public void close() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}
