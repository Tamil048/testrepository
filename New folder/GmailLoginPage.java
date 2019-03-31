package com.cucumber.PageObjects;

import com.cucumber.commonutils.WebUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class GmailLoginPage {
    GmailLandingHomePage gmailLandingHomePage;

    public void launchGmailURL(WebDriver driver) throws IOException {
        WebUtils.gmailURL(driver);

    }

    public boolean isGmailLoginPageDisplayed(WebDriver driver) {
        return WebUtils.isDisplayed(driver, By.xpath("//input[@type='email']"));
    }

    public GmailLandingHomePage enterGmailUsernameAndPassword(WebDriver driver, String username, String passsword) {
        WebUtils.findElementAndSendKeys(driver, By.xpath("//input[@type='email']"), username);
        WebUtils.click(driver, By.xpath("//div[@class='U26fgb O0WRkf zZhnYe e3Duub C0oVfc nDKKZc DL0QTb']/descendant::span"));
        WebUtils.findElementAndSendKeys(driver, By.xpath("//input[@type='password']"), passsword);
        WebUtils.click(driver, By.xpath("//div[@class='U26fgb O0WRkf zZhnYe e3Duub C0oVfc nDKKZc DL0QTb']/descendant::span"));
        return PageFactory.initElements(driver, GmailLandingHomePage.class);
    }
}