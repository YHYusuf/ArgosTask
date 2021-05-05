package com.argos.pages;

import com.argos.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductsPage extends DashboardPage{


    @FindBy(xpath = "//*[@*='ProductCardstyles__PriceText-gm8lcq-14 lhwdnp']")
        public List<WebElement> prices;

    @FindBy(xpath = "//*[@*='ProductCardstyles__Title-gm8lcq-12 hkIdWm']")
        public List<WebElement> products;

    @FindBy(xpath = "//*[@*='add-to-trolley-button-button']")
        public WebElement addToTrolley;

    public  String productname;

    public void selectItem() throws InterruptedException {
        WebElement product = products.get(0);
        productname = product.getText();
        product.click();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(Driver.get(),5);
        wait.until(ExpectedConditions.elementToBeClickable(accountTab));
        addToTrolley.click();
        Driver.get().navigate().refresh();

    }
}

