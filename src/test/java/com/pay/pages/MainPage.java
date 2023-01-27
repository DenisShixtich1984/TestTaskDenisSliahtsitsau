package com.pay.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.pay.utils.PropertyReader;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    final static String START_URL = PropertyReader.getProperty("urlPay");
    private final SelenideElement fieldSell = $(byXpath("//label[text()='Sell']//following-sibling::input"));
    private final SelenideElement fieldBuy = $(byXpath("//label[text()='Buy']//following-sibling::input"));
    private final SelenideElement footerFlagLithuania = $(byXpath("//span[@class='flag-icon-small flag-icon-lt']"));
    private final SelenideElement listCountries = $(byXpath("//button[@class='btn btn-default btn-sm btn-block dropdown-toggle']"));
    private final SelenideElement iconFlagLatvia = $(byXpath("//span[@class='flag-icon-small flag-icon-lv']/ancestor::a"));
    private final SelenideElement footerFlagLatvia = $(byXpath("//span[@class='flag-icon-small flag-icon-lv']"));
    private final SelenideElement payseraRate = $(byXpath("//tbody/tr[1]/td[3]"));
    private final SelenideElement payseraRate2 = $(byXpath("//table/tbody/tr[1]/td[3]"));


    public SelenideElement getPayseraRate2() {
        return payseraRate2;
    }

    public SelenideElement getPayseraRate() {
        return payseraRate;
    }

    public SelenideElement getFooterFlagLatvia() {
        return footerFlagLatvia;
    }

    public SelenideElement getIconFlagLatvia() {
        return iconFlagLatvia;
    }

    public SelenideElement getListCountries() {
        return listCountries;
    }

    public SelenideElement getFooterFlagLithuania() {
        return footerFlagLithuania;

    } public SelenideElement getFieldSell() {
        return fieldSell;

    }
    public SelenideElement getFieldBuy() {
        return fieldBuy;
    }

    public MainPage open() {
        Selenide.open(START_URL);
        return this;
    }
}
