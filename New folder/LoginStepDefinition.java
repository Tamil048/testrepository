package com.cucumber.stepdefinition;

import com.cucumber.PageObjects.GmailLandingHomePage;
import com.cucumber.PageObjects.GmailLoginPage;
import com.cucumber.commonutils.StepContext;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;

public class LoginStepDefinition {
    StepContext stepContext;
    WebDriver driver;
    GmailLoginPage gmailLoginPage = new GmailLoginPage();
    GmailLandingHomePage gmailLandingHomePage;

    public LoginStepDefinition(StepContext stepContext) {
        this.stepContext = stepContext;
    }

    @Given("^launch the Gmail URl$")
    public void launchGmail() throws IOException {
        driver = stepContext.getCurrentDriver();
        gmailLoginPage.launchGmailURL(driver);
    }

    @Given("^User is on gmail LogIn Page$")
    public void GmailLoginPage() throws Throwable {
        driver = stepContext.getCurrentDriver();
        Assert.assertTrue("Gmail login page should be displayed", gmailLoginPage.isGmailLoginPageDisplayed(driver));
    }

    @Given("^User enters gmail UserName /*(.*)/* and Password /*(.*)/*$")
    public void enterGamilUserNameAndPassword(String username, String password) throws Throwable {
        gmailLandingHomePage = gmailLoginPage.enterGmailUsernameAndPassword(driver, username, password);
    }

    @Given("^User enters gmail UserName and Password$")
    public void enterUserNamePasswordDatatable(DataTable dataTable) throws Throwable {
        //initialize data table
        List<List<String>> data = dataTable.raw();
        String username = data.get(1).get(0);
        String password = data.get(1).get(1);
        gmailLandingHomePage = gmailLoginPage.enterGmailUsernameAndPassword(driver, username, password);
    }

    @Given("^Gmail user logged in successfully$")
    public void userLoggedInSuccessFully() throws Throwable {

        Assert.assertTrue("gmail search box should be displayed", gmailLandingHomePage.isSearchBoxDisplayed(driver));
    }
}
