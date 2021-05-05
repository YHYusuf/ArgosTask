package com.argos.stepDefinitions;

import com.argos.pages.DashboardPage;
import com.argos.pages.ProductsPage;
import com.argos.pages.TrolleyPage;
import com.argos.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdersStepDefinitions extends DashboardPage {
    ProductsPage productsPage = new ProductsPage();
    TrolleyPage trolleyPage = new TrolleyPage();


    @When("the user navigates to {string} and {string}")
    public void the_user_navigates_to_and(String category, String subcategory) {
        new DashboardPage().navigateShopTabs(category, subcategory);
        Assert.assertTrue(Driver.get().getTitle().contains(subcategory));

    }

    @When("the user sorts product by {string}")
    public void the_user_sorts_product_by(String criteria) {
        WebElement selectDropDown = Driver.get().findElement(By.id("sort-select"));
        Select select = new Select(selectDropDown);
        select.selectByVisibleText(criteria);



    }

    @Then("the products should be listed accordingly")
    public void theProductsShouldBeListedAccordingly() {

        List<Double> priceList= new ArrayList<>();
        for (WebElement price : productsPage.prices) {
            priceList.add(Double.parseDouble(price.getText().replaceAll("[^\\d.]", "")));
        }
        System.out.println(priceList);
        List<Double> dummyList= new ArrayList<>(priceList);
        Collections.sort(dummyList);
        Assert.assertEquals(dummyList,priceList);
    }
    @When("the user chooses the first product on the page")
    public void the_user_chooses_the_first_product_on_the_page() throws InterruptedException {

        productsPage.selectItem();

    }

    @Then("the product should be seen on trolley page")
    public void the_product_should_be_seen_on_trolley_page() {
        Driver.get().navigate().refresh();
        productsPage.navigateTo("Trolley");
        Assert.assertEquals(trolleyPage.product.getAttribute("text"),productsPage.productname);



    }

    @And("removes the product")
    public void removesTheProduct() {
        trolleyPage.removeItem();

    }

    @Then("trolley should be empty")
    public void trolleyShouldBeEmpty() {
        Assert.assertTrue(trolleyPage.emptyTrolley.isDisplayed());
    }

    @When("the user searches for {string}")
    public void the_user_searches_for(String productToSearch) {
        searchBox.sendKeys(productToSearch, Keys.ENTER);
    }

    @When("the user chooses first product on the list")
    public void the_user_chooses_first_product_on_the_list() {
        productsPage.products.get(0).click();
    }

    @Then("{string} button shouldn't appear on the page")
    public void button_shouldn_t_appear_on_the_page(String buton) {
        try {
            productsPage.addToTrolley.click();
        }
        catch (NoSuchElementException e){
            System.out.println(buton+" is not attached to the page");
        }

    }
}