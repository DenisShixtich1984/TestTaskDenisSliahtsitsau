package com.pay.Tests;

import com.codeborne.selenide.Configuration;
import com.pay.pages.MainPage;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.pay.utils.Data.*;

public class MainTest {
    MainPage mainPage = new MainPage();

    @BeforeClass
    public void setUpAll() {
        ChromeOptions options = new ChromeOptions().setHeadless(true);
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.managed_default_content_settings.geolocation", 2);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-dev-shm-usage");
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
    }

    @AfterClass
    public void tearDown() {
        closeWebDriver();
    }

    @Test(priority = 1)
    public void fieldBuyFilledFieldSellEmptyTest() {
        mainPage.open();
        webdriver().shouldHave(url(START_URL));
        mainPage.getFieldBuy().scrollTo();
        mainPage.getFieldBuy().sendKeys(AMOUNT);
        mainPage.getFieldBuy().shouldHave(value(AMOUNT));
        mainPage.getFieldSell().shouldHave(value(NULL));
    }

    @Test(priority = 2)
    public void fieldSellFilledFieldBuyEmptyTest() {
        mainPage.open();
        webdriver().shouldHave(url(START_URL));
        mainPage.getFieldSell().scrollTo();
        mainPage.getFieldSell().sendKeys(AMOUNT);
        mainPage.getFieldSell().shouldHave(value(AMOUNT));
        mainPage.getFieldBuy().shouldHave(value(NULL));
    }

    @Test(priority = 3)
    public void changeCountryTest() {
        mainPage.open();
        webdriver().shouldHave(url(START_URL));
        mainPage.getFieldSell().scrollTo();
        String firstRate = mainPage.getPayseraRate().shouldBe(visible,Duration.ofSeconds(25)).getText();
        mainPage.getFooterFlagLithuania().scrollTo();
        mainPage.getFooterFlagLithuania().click();
        mainPage.getListCountries().click();
        mainPage.getIconFlagLatvia().shouldBe(visible,Duration.ofSeconds(10)).click();
        mainPage.getFooterFlagLatvia().scrollTo();
        mainPage.getFooterFlagLatvia().click();
        mainPage.getListCountries().shouldHave(text(CHECK_COUNTRY));
        refresh();
        webdriver().shouldHave(url("https://www.paysera.lv/v2/en-LV/fees/currency-conversion-calculator#/"));
        mainPage.getFieldSell().scrollTo();
        String secondRate = mainPage.getPayseraRate2().shouldBe(visible,Duration.ofSeconds(30)).getText();
        Assert.assertNotEquals(firstRate, secondRate);

    }
}