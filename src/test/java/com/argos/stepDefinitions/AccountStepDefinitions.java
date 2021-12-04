package com.argos.stepDefinitions;

import com.argos.pages.AccountPage;
import com.argos.utilities.ConfigurationReader;
import com.argos.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountStepDefinitions {

    AccountPage accountPage = new AccountPage();

    @Given("the user is on login page")
    public void the_user_is_on_login_page() throws InterruptedException {
        Driver.get().get(ConfigurationReader.get("homepage"));
        accountPage.bannerAccept();


    }
    @When("the user navigates to {string} page")
    public void the_user_navigates_to_page(String string) {
        accountPage.navigateTo(string);
    }

    @When("fills fields with valid credentials")
    public void fills_fields_with_valid_credentials() {
        accountPage.emailInput.sendKeys(ConfigurationReader.get("email"));
        accountPage.passwordInput.sendKeys(ConfigurationReader.get("password"));

    }




    @Then("the user should land on homepage")
    public void the_user_should_land_on_homepage() {
        Driver.get().get(ConfigurationReader.get("homepage"));
        Assert.assertTrue(Driver.get().getTitle().contains("Order online"));
    }
    @When("enters {string} and {string}")
    public void enters_and(String email, String password) {
        accountPage.emailInput.sendKeys(email);
        accountPage.passwordInput.sendKeys(password);
    }

    @Then("title should still be {string}")
    public void title_should_still_be(String title) {
        Assert.assertEquals(title,Driver.get().getTitle());
    }

}
//getTitlesdafaskj
//sdfkl
//        asfd
//asfddfd
//                saf
//as
//                        @FindBy(as)
//                            public WebElement f;
//sdfdfsaklaskjflaskjflkdasjflkjaslkfjlkasjfklfjdslkjfklasj