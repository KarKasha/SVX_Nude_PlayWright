package com.example.playwrighttests;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static utils.com.example.TimeNumberGenerator.generateTimeBasedLetters;

import java.nio.file.Path;
import java.nio.file.Paths;

public class SVXNudeTest {

    @Test
    //ТК-1
    public void checkPressedLikeInFriendlyList() {
        try (Playwright playwright = Playwright.create()) {
            Path currentDir = Paths.get(System.getProperty("user.dir"));
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page mailPage = context.newPage();
            mailPage.setDefaultNavigationTimeout(90000);
            mailPage.setDefaultTimeout(90000);
            mailPage.navigate("https://internxt.com/ru/temporary-email");
            mailPage.locator("button", new Page.LocatorOptions().setHasText("@")).first().waitFor();

            Locator emailButton = mailPage.locator("button", new Page.LocatorOptions().setHasText("@")).first();

            String email = emailButton.locator("p").first().textContent();
            System.out.println("Email: " + email);

            Page womanPage = context.newPage();
            womanPage.navigate("https://dev.app.nude.web.ghfls.ru/dating");

            womanPage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Регистрация")).click();
            womanPage.getByPlaceholder("Введите email").click();
            womanPage.getByPlaceholder("Введите email").fill(email);
            womanPage.getByPlaceholder("Введите пароль").click();
            womanPage.getByPlaceholder("Введите пароль").fill("Qwe35ewq!");
            womanPage.getByLabel("Переключить видимость пароля").click();

            womanPage.locator("label").filter(new Locator.FilterOptions().setHasText("Я подтверждаю, что мне есть")).locator("svg").click();
            womanPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Далее")).click();
            womanPage.waitForTimeout(6000);


            mailPage.locator("#inbox").getByRole(AriaRole.BUTTON).first().click();
            mailPage.waitForTimeout(6000);
            String otpText = mailPage.locator("text=Your OTP-code is").first().textContent();
            System.out.println("Raw OTP text: " + otpText);
            java.util.regex.Matcher matcher = java.util.regex.Pattern
                    .compile("Your OTP-code is:\\s*(\\d{6})")
                    .matcher(otpText);

            String otpCode = "";
            if (matcher.find()) {
                otpCode = matcher.group(1); // group(1) = only the digits
            }else{
                Assert.fail("otpCode wasn't set");
            }
            System.out.println("Extracted OTP code: |" + otpCode + "|");




            womanPage.getByPlaceholder("-000").fill(otpCode);
            womanPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Далее")).click();

            womanPage.waitForTimeout(5000);
            String womanName =  generateTimeBasedLetters()+"Карина";
            womanPage.getByPlaceholder("Ваше имя").fill(womanName);
            womanPage.getByPlaceholder("dd.MM.yyyy").click();
            womanPage.getByPlaceholder("dd.MM.yyyy").fill("20.10.1994");
            womanPage.locator("label").filter(new Locator.FilterOptions().setHasText("Женщина")).click();


            womanPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Далее")).click();
            womanPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Далее")).click();
            Path girlImagePath = currentDir.resolve("Photos/Girl.jpg");

            womanPage.getByLabel("Выбрать главное фото профиля")
                    .setInputFiles(girlImagePath);


            womanPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Далее")).click();
            womanPage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Aватар Профиль")).click();

            BrowserContext nextContext = browser.newContext();
            Page manPage = nextContext.newPage();
            manPage.navigate("https://dev.app.nude.web.ghfls.ru/dating");
            mailPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Изменить email")).click();
            mailPage.waitForTimeout(6000);


            String nextEmail = emailButton.locator("p").first().textContent();
            System.out.println("nextEmail: " + nextEmail);


            manPage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Регистрация")).click();
            manPage.getByPlaceholder("Введите email").click();
            manPage.getByPlaceholder("Введите email").fill(nextEmail);
            manPage.getByPlaceholder("Введите пароль").click();
            manPage.getByPlaceholder("Введите пароль").fill("Qwe35ewq!");
            manPage.getByLabel("Переключить видимость пароля").click();
            manPage.locator("label").filter(new Locator.FilterOptions().setHasText("Я подтверждаю, что мне есть")).locator("svg").click();
            manPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Далее")).click();
            manPage.waitForTimeout(6000);


            mailPage.locator("#inbox").getByRole(AriaRole.BUTTON).first().click();
            mailPage.waitForTimeout(6000);
            String nextOtpText = mailPage.locator("text=Your OTP-code is").first().textContent();
            System.out.println("Raw nextOtpTextOTP text: " + nextOtpText);
            java.util.regex.Matcher nextMatcher = java.util.regex.Pattern
                    .compile("Your OTP-code is:\\s*(\\d{6})")
                    .matcher(nextOtpText);

            String nextOtpCode = "";
            if (nextMatcher.find()) {
                nextOtpCode = nextMatcher.group(1); // group(1) = only the digits
            }else{
                Assert.fail("nextotpCode wasn't set");
            }
            System.out.println("Extracted nextOTP code: |" + nextOtpCode + "|");



            manPage.getByPlaceholder("-000").fill(nextOtpCode);
            manPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Далее")).click();


            String manName = generateTimeBasedLetters()+"Владимир";
            manPage.getByPlaceholder("Ваше имя").fill(manName);
            manPage.getByPlaceholder("dd.MM.yyyy").click();
            manPage.getByPlaceholder("dd.MM.yyyy").fill("21.09.1994");
            manPage.locator("label").filter(new Locator.FilterOptions().setHasText("Мужчина")).click();
            manPage.waitForTimeout(3000);

            manPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Далее")).click();
            manPage.waitForTimeout(3000);
            manPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Далее")).click();

            manPage.waitForTimeout(3000);
            Path menImagePath = currentDir.resolve("Photos/Man.png");
            manPage.getByLabel("Выбрать главное фото профиля")
                    .setInputFiles(menImagePath);


            manPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Далее")).click();
            manPage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Aватар Профиль")).click();
            manPage.waitForTimeout(5000);


            womanPage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Знакомства")).click();
            manPage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Знакомства")).click();

            womanPage.navigate("https://dev.app.nude.web.ghfls.ru/dating");
            womanPage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Знакомства")).click();
            womanPage.waitForTimeout(3000);
            womanPage.getByLabel("Суперлайк").first().click();
            womanPage.waitForTimeout(3000);

            womanPage.navigate("https://dev.app.nude.web.ghfls.ru/chats/likes");
            womanPage.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Понравившиеся")).click();
            womanPage.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName(manName)).click();
            womanPage.waitForTimeout(3000);
            womanPage.getByLabel("Закрыть").click();



            manPage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Aватар Профиль")).click();
            manPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Настройки")).click();
            manPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Аккаунт")).click();
            manPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Удалить аккаунт")).click();
            manPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Подтвердить")).click();


            womanPage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Aватар Профиль")).click();
            womanPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Настройки")).click();
            womanPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Аккаунт")).click();
            womanPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Удалить аккаунт")).click();
            womanPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Подтвердить")).click();

            womanPage.waitForTimeout(3000);

        }

    }


    @Test
    // ТК-2
    public void checkGottenLike() {
        try (Playwright playwright = Playwright.create()) {
            Path currentDir = Paths.get(System.getProperty("user.dir"));

            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page mailPage = context.newPage();
            mailPage.setDefaultNavigationTimeout(90000);
            mailPage.setDefaultTimeout(90000);
            mailPage.navigate("https://internxt.com/ru/temporary-email");
            mailPage.locator("button", new Page.LocatorOptions().setHasText("@")).first().waitFor();

            Locator emailButton = mailPage.locator("button", new Page.LocatorOptions().setHasText("@")).first();

            String email = emailButton.locator("p").first().textContent();
            System.out.println("Email: " + email);

            Page sitePage = context.newPage();
            sitePage.navigate("https://dev.app.nude.web.ghfls.ru/dating");

            sitePage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Регистрация")).click();
            sitePage.getByPlaceholder("Введите email").click();
            sitePage.getByPlaceholder("Введите email").fill(email);
            sitePage.getByPlaceholder("Введите пароль").click();
            sitePage.getByPlaceholder("Введите пароль").fill("Qwe35ewq!");
            sitePage.getByLabel("Переключить видимость пароля").click();
            sitePage.waitForTimeout(3000);
            sitePage.locator("label").filter(new Locator.FilterOptions().setHasText("Я подтверждаю, что мне есть")).locator("svg").click();
            sitePage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Далее")).click();
            sitePage.waitForTimeout(6000);


            mailPage.locator("#inbox").getByRole(AriaRole.BUTTON).first().click();
            mailPage.waitForTimeout(6000);
            String otpText = mailPage.locator("text=Your OTP-code is").first().textContent();
            System.out.println("Raw OTP text: " + otpText);
            java.util.regex.Matcher matcher = java.util.regex.Pattern
                    .compile("Your OTP-code is:\\s*(\\d{6})")
                    .matcher(otpText);

            String otpCode = "";
            if (matcher.find()) {
                otpCode = matcher.group(1); // group(1) = only the digits
            }else{
                Assert.fail("otpCode wasn't set");
            }
            System.out.println("Extracted OTP code: |" + otpCode + "|");

            mailPage.waitForTimeout(3000);


            sitePage.getByPlaceholder("-000").fill(otpCode);
            sitePage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Далее")).click();

            sitePage.waitForTimeout(5000);
            String womanName =  generateTimeBasedLetters()+"Карина";
            sitePage.getByPlaceholder("Ваше имя").fill(womanName);
            sitePage.getByPlaceholder("dd.MM.yyyy").click();
            sitePage.getByPlaceholder("dd.MM.yyyy").fill("20.10.1994");
            sitePage.locator("label").filter(new Locator.FilterOptions().setHasText("Женщина")).click();

            sitePage.waitForTimeout(3000);

            sitePage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Далее")).click();
            sitePage.waitForTimeout(3000);
            sitePage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Далее")).click();

            sitePage.waitForTimeout(3000);

            Path girlImagePath = currentDir.resolve("Photos/Girl.jpg");
            sitePage.getByLabel("Выбрать главное фото профиля")
                    .setInputFiles(girlImagePath);

            sitePage.waitForTimeout(3000);
            sitePage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Далее")).click();
            sitePage.waitForTimeout(3000);
            sitePage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Aватар Профиль")).click();
            sitePage.waitForTimeout(3000);


            BrowserContext nextContext = browser.newContext();
            Page userAPage = nextContext.newPage();
            userAPage.navigate("https://dev.app.nude.web.ghfls.ru/dating");
            mailPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Изменить email")).click();
            mailPage.waitForTimeout(6000);


            String nextEmail = emailButton.locator("p").first().textContent();
            System.out.println("nextEmail: " + nextEmail);


            userAPage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Регистрация")).click();
            userAPage.getByPlaceholder("Введите email").click();
            userAPage.getByPlaceholder("Введите email").fill(nextEmail);
            userAPage.getByPlaceholder("Введите пароль").click();
            userAPage.getByPlaceholder("Введите пароль").fill("Qwe35ewq!");
            userAPage.getByLabel("Переключить видимость пароля").click();
            userAPage.waitForTimeout(3000);
            userAPage.locator("label").filter(new Locator.FilterOptions().setHasText("Я подтверждаю, что мне есть")).locator("svg").click();
            userAPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Далее")).click();
            userAPage.waitForTimeout(3000);


            mailPage.locator("#inbox").getByRole(AriaRole.BUTTON).first().click();
            mailPage.waitForTimeout(3000);
            String nextOtpText = mailPage.locator("text=Your OTP-code is").first().textContent();
            System.out.println("Raw nextOtpTextOTP text: " + nextOtpText);
            java.util.regex.Matcher nextMatcher = java.util.regex.Pattern
                    .compile("Your OTP-code is:\\s*(\\d{6})")
                    .matcher(nextOtpText);

            String nextOtpCode = "";
            if (nextMatcher.find()) {
                nextOtpCode = nextMatcher.group(1); // group(1) = only the digits
            }else{
                Assert.fail("nextotpCode wasn't set");
            }
            System.out.println("Extracted nextOTP code: |" + nextOtpCode + "|");

            mailPage.waitForTimeout(3000);


            userAPage.getByPlaceholder("-000").fill(nextOtpCode);
            userAPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Далее")).click();

            userAPage.waitForTimeout(5000);

            String manName = generateTimeBasedLetters()+"Владимир";
            userAPage.getByPlaceholder("Ваше имя").fill(manName);
            userAPage.getByPlaceholder("dd.MM.yyyy").click();
            userAPage.getByPlaceholder("dd.MM.yyyy").fill("21.09.1994");

            userAPage.locator("label").filter(new Locator.FilterOptions().setHasText("Мужчина")).click();
            userAPage.waitForTimeout(3000);

            userAPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Далее")).click();
            userAPage.waitForTimeout(3000);
            userAPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Далее")).click();

            userAPage.waitForTimeout(3000);
            Path menImagePath = currentDir.resolve("Photos/Man.png");
            userAPage.getByLabel("Выбрать главное фото профиля")
                    .setInputFiles(menImagePath);

            userAPage.waitForTimeout(3000);
            userAPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Далее")).click();
            userAPage.waitForTimeout(3000);
            userAPage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Aватар Профиль")).click();
            userAPage.waitForTimeout(5000);


            sitePage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Знакомства")).click();
            userAPage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Знакомства")).click();

            sitePage.navigate("https://dev.app.nude.web.ghfls.ru/dating");
            sitePage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Знакомства")).click();
            userAPage.waitForTimeout(3000);
            sitePage.getByLabel("Суперлайк").first().click();
            sitePage.waitForTimeout(3000);

            userAPage.navigate("https://dev.app.nude.web.ghfls.ru/dating");
            userAPage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Чаты")).click();
            userAPage.navigate("https://dev.app.nude.web.ghfls.ru/chats");

            userAPage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Чаты")).click();
            userAPage.waitForTimeout(3000);
            userAPage.navigate("https://dev.app.nude.web.ghfls.ru/chats/likes");
            userAPage.waitForTimeout(3000);
            userAPage.getByRole(AriaRole.RADIO, new Page.GetByRoleOptions().setName("Меня лайкнули")).click();
            userAPage.waitForTimeout(3000);
            userAPage.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName(womanName)).click();
            userAPage.waitForTimeout(3000);
            userAPage.getByLabel("Закрыть").click();
            userAPage.waitForTimeout(3000);

            userAPage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Aватар Профиль")).click();
            userAPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Настройки")).click();
            userAPage.waitForTimeout(3000);
            userAPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Аккаунт")).click();
            userAPage.waitForTimeout(3000);
            userAPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Удалить аккаунт")).click();
            userAPage.waitForTimeout(3000);
            userAPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Подтвердить")).click();
            userAPage.waitForTimeout(3000);

            sitePage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Aватар Профиль")).click();
            sitePage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Настройки")).click();
            sitePage.waitForTimeout(3000);
            sitePage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Аккаунт")).click();
            sitePage.waitForTimeout(3000);
            sitePage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Удалить аккаунт")).click();
            sitePage.waitForTimeout(3000);
            sitePage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Подтвердить")).click();
            sitePage.waitForTimeout(3000);

        }
    }


    @Test
    // ТК-3
    public void checkEditProfile() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://dev.app.nude.web.ghfls.ru/dating");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Войти")).click();
            page.getByPlaceholder("Введите email").click();
            page.getByPlaceholder("Введите email").fill("316th@2200freefonts.com");
            page.getByPlaceholder("Введите пароль").click();
            page.getByLabel("Переключить видимость пароля").click();
            page.getByPlaceholder("Введите пароль").click();
            page.getByPlaceholder("Введите пароль").fill("Qwe35ewQ@");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Войти")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Aватар Профиль")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Aватар Профиль")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Редактировать профиль")).click();
            page.getByLabel("О себе").click();
            page.waitForTimeout(10000);
            page.getByLabel("О себе").fill("Люблю поэзию и собак");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Сохранить")).click();
        }

    }

}
