package com.argos.pages;

import com.argos.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    public DashboardPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    Actions actions = new Actions(Driver.get());

    @FindBy(xpath = "//*[contains(text(),'Shop')]")
    public WebElement shopTab;

    @FindBy(xpath = "//*[contains(text(),'Trending')]")
    public WebElement trendingTab;

    @FindBy(xpath = "//*[contains(text(),'Garden Inspiration')]")
    public WebElement inspirationTab;

    @FindBy(xpath = "//*[contains(text(),'Account')]")
    public WebElement accountTab;

    @FindBy(xpath = "//*[contains(text(),'Wishlist')]")
    public WebElement wishListTab;

    @FindBy(id = "consent_prompt_submit")
    public WebElement acceptBanner;

    @FindBy(xpath = "//*[contains(text(),'Trolley')]")
    public WebElement TrolleyTab;

    @FindBy(xpath = "//*[@*='combobox']")
    public WebElement searchBox;

    public void bannerAccept(){
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 6);
            wait.until(ExpectedConditions.elementToBeClickable(acceptBanner));
            JavascriptExecutor executor = (JavascriptExecutor) Driver.get();
            executor.executeScript("arguments[0].scrollIntoView(true);", acceptBanner);
            executor.executeScript("arguments[0].click();",acceptBanner);
        }catch (TimeoutException e){

        }

    }

    public void navigateShopTabs(String category, String subcategory) {
        actions.moveToElement(shopTab).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.moveToElement(Driver.get().findElement(By.xpath("//*[text()='" + category + "']"))).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.moveToElement(Driver.get().findElement(By.xpath("//*[text()='" + subcategory + "']"))).click().perform();

    }

    public void navigateTo(String tab) {
        Driver.get().findElement(By.xpath("//*[text()='" + tab + "']")).click();
        Assert.assertTrue(Driver.get().getCurrentUrl().contains(tab.toLowerCase()));
    }

}
