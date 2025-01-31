package pages;

import com.microsoft.playwright.Page;

public class LogoutPage {
    private Page page;
    private String logoutButton = "#logout2";

    public LogoutPage(Page page) {
        this.page = page;
    }

    public void logoutUser() {
        page.click(logoutButton);
        page.waitForTimeout(2000);
    }
}
