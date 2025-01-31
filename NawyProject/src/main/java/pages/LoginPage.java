package pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;

    // Locators
    private String loginButton = "#login2";
    private String usernameField = "#loginusername";
    private String passwordField = "#loginpassword";
    private String confirmButton = "//button[text()='Log in']";

    // Constructor
    public LoginPage(Page page) {
        this.page = page;
    }

    // Actions
    public void loginUser(String username, String password) {
        page.click(loginButton);
        page.fill(usernameField, username);
        page.fill(passwordField, password);
        page.click(confirmButton);
        page.waitForTimeout(2000);
    }
}
