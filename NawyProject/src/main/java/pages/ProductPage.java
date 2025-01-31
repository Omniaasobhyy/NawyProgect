package pages;

import com.microsoft.playwright.Page;

public class ProductPage {
    private Page page;

    private String appleMonitor = "//a[text()='Apple monitor 24']";
    private String addToCartButton = "//a[text()='Add to cart']";

    public ProductPage(Page page) {
        this.page = page;
    }

    public void addProductToCart() {
        page.click(appleMonitor);
        page.waitForTimeout(2000);
        page.click(addToCartButton);
        page.waitForTimeout(2000);
    }
}
