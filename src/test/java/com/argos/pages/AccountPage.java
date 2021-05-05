package com.argos.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends DashboardPage{
    @FindBy(id = "consent_prompt_submit")
    public WebElement acceptBanner;

    @FindBy(id = "email-address")
    public WebElement emailInput;

    @FindBy(id = "current-password")
    public WebElement passwordInput;

    @FindBy(id = "yourEmailSubmitButton")
    public WebElement signInButton;




}