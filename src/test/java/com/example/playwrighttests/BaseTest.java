package com.example.playwrighttests;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeSuite
    public void startPlaywright() {
        playwright = Playwright.create();
        System.out.println("|My Print|:Playwright initialized");
    }

    @BeforeMethod
    public void launchBrowser() {
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)); // Change to true later
        page = browser.newPage();
        page.setViewportSize(1920, 1080);
        // Set faster timeouts
//        page.setDefaultTimeout(10000);
//        page.setDefaultNavigationTimeout(10000);
        System.out.println("|My Print|:Browser launched");
    }

    @AfterMethod
    public void closeBrowser() {
        if (browser != null) {
            browser.close();
            System.out.println("|My Print|:Browser closed");
        }
    }

    @AfterSuite
    public void closePlaywright() {
        if (playwright != null) {
            playwright.close();
            System.out.println("|My Print|:Playwright closed");
        }
    }
}