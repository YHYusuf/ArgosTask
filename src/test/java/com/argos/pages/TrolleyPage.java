package com.argos.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrolleyPage extends DashboardPage {

    @FindBy(xpath = "//*[@*='product-name']")
    public WebElement product;

    @FindBy(xpath = "//*[contains(text(),'Empty trolley!')]")
    public WebElement emptyTrolley;

    @FindBy(xpath = "(//*[contains(text(),'Remove')])[2]")
    public  static WebElement removeButton;

    public void removeItem(){
        removeButton.click();
    }


}
