package com.example.playwrighttests;

import org.testng.annotations.Test;

public class QuickTest extends BaseTest {

    @Test
    public void quickDemo() {
        System.out.println("=== QUICK TEST STARTED ===");
        page.navigate("https://example.com");

        System.out.println("|My Print|:Page title: " + page.title());
        System.out.println("|My Print|:=== QUICK TEST FINISHED ===");
    }
}