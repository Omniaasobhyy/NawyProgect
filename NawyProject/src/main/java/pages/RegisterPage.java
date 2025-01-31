package pages;

import com.microsoft.playwright.Page;

public class RegisterPage {
    private Page page;

    // Locators
    private String signUpButton = "#signin2";
    private String usernameField = "#sign-username";
    private String passwordField = "#sign-password";
    private String confirmButton = "//button[text()='Sign up']";

    // Constructor
    public RegisterPage(Page page) {
        this.page = page;
    }

    // Actions
    public void registerUser(String username, String password) {
        page.click(signUpButton);
        page.fill(usernameField, username);
        page.fill(passwordField, password);
        page.click(confirmButton);
        page.waitForTimeout(2000);
    }
}