package com.example.playwrighttests;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import org.testng.Assert;  // Add this import
public class GoogleTest extends BaseTest {

    @Test
    public void testGoogleHomepage() {
        // Navigate to Google
//        page.navigate("https://www.google.com");
        page.navigate("https://www.google.com", new Page.NavigateOptions()
                .setTimeout(5000)); // Max 5 seconds wait

        // Verify title contains Google
        String title = page.title();
        assertTrue(title.contains("Google"), "Title should contain Google. Actual: " + title);

        System.out.println("✓ Google homepage test passed!");
    }

    @Test
    public void testGoogleSearch() {
        page.navigate("https://www.google.com");


        Locator searchBox = page.locator("textarea[name='q']");
        boolean searchBoxExists = searchBox.isVisible();
        System.out.println("|My Print|:Search box visible: " + searchBoxExists);

        if (searchBoxExists) {
            System.out.println("|My Print|:Search box was found!");
            String seatchText = "gegrergerg";
            searchBox.fill(seatchText);
            String actualText = searchBox.inputValue();
            assertEquals(actualText, seatchText,
                    "Search box text should match expected value");
            System.out.println("|My Print|:Actual text in search box: '" + actualText + "'");
            searchBox.press("Enter");

            page.waitForURL(url -> url.contains("search") && url.contains("q="),
                    new Page.WaitForURLOptions().setTimeout(10000));

            String newUrl = page.url();
            System.out.println("|My Print|:New URL after search: " + newUrl);
            page.waitForSelector("#search");


        }else{
            Assert.fail("Search box not found - cannot perform search");

        }
//        // Perform search
//         page.locator("textarea[name='q']").fill("Playwright Java");
//         page.locator("textarea[name='q']").press("Enter");
////
////        // Wait for results
//        page.waitForSelector("#search");
////
////        // Verify results are displayed
////        assertTrue(page.locator("#search").isVisible(), "Search results should be visible");

        System.out.println("✓ Google search test passed!");
    }
}