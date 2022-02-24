package com.solvd.selenium.adidasUs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import static java.time.Duration.*;

public class AdidasHomePage {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdidasHomePage.class);

    private WebDriver driver;

    private static final String ADIDAS = "https://www.adidas.com/us";

    @FindBy(xpath = "//input[@class='searchinput___zXLAR']")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@action='/us/search']")
    private WebElement searchButton;

    @FindBy(xpath = "//button[@data-auto-id='profile-icon-header']")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@id='login-register-auto-flow-input']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@data-auto-id='login-auto-flow-form-button']")
    private WebElement continueButton;

    @FindBy(xpath = "//*[@id='registration-firstname-field']")
    private WebElement firstName;

    @FindBy(xpath = "//*[@id='registration-lastname-field']")
    private WebElement lastName;

    @FindBy(xpath = "//*[contains(@class, 'gl-radio-input__input') and contains(@value, 'Male')]")
    private WebElement gender;

    @FindBy(xpath = "//*[@id='registration-password-field']")
    private WebElement createPassword;

    @FindBy(xpath = "//*[@id='autoFlowRegistration-registration-ageconfirmation-field']")
    private WebElement flowRegistration;

    @FindBy(xpath = "//*[@id='registration-terms-field autoFlowRegistration']")
    private WebElement submitTerms;

    @FindBy(xpath = "//*[@data-auto-id='registration-submit-button']")
    private WebElement register;

    @FindBy(xpath = "//*[@class='gl-modal__main-content']")
    private WebElement welcomeText;

    @FindBy(xpath = "//input[@id='login-register-auto-flow-input']")
    private WebElement loginBox;

    @FindBy(xpath = "//input[@id='login-register-auto-flow-input']")
    private WebElement loginEmail;

    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement passwordBox;

    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement loginPassword;

    @FindBy(xpath = "//*[@data-auto-id='login-form-login']")
    private WebElement loginAccountButton;

    //    @FindBy(xpath = "//*[contains(@class, 'col-l-2')]")
    @FindBy(css = ".gl-heading--m")
    private WebElement myAccount;

    @FindBy(css = "a[href*='/us/men].label'")
    private WebElement menFilter;

    @FindBy(xpath = "//*[contains(@class, 'gl-cta gl-cta--tertiary') and contains(@title, 'TOPS')]")
    private WebElement topsFilter;

    @FindBy(css = ".filter-panel-cta-btn___PnD1m")
    private WebElement filterButton;

    @FindBy(xpath = "//*[contains(@class,'inner___1T3DW')]//*[contains(@manual_cm_sp,'Help')]")
    public WebElement helpButton;

    @FindBy(xpath = "//div[@class='gl-wishlist-icon wishlist_button___3ppwb outlined-icon-color___2xwB3']")
    public WebElement wishList;

    public AdidasHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.driver.get(ADIDAS);
    }

    public boolean isPageOpened() {
        return driver.getCurrentUrl().equals(ADIDAS);
    }

    public void typeInSearchInput(String productName) {
        new WebDriverWait(driver, ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(searchInput)).sendKeys(productName);
    }

    public SearchResultPage clickSearchButton() {
         new WebDriverWait(driver, ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(searchButton));
         searchButton.click();
        return new SearchResultPage(driver);
    }

    public boolean isLoginBoxIsVisible() {
        return loginBox.isDisplayed();
    }

    public void enterTextToLoginBox(String email) {
        loginBox.click();
        loginBox.sendKeys(email);
    }

    public String getTextFromLoginBox() {
        return loginBox.getAttribute("value");
    }

    public String getTextFromPasswordBox() {
        return passwordBox.getAttribute("value");
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void submitContinueButton() {
        continueButton.submit();
    }

    public void enterPasswordToPasswordBox(String password) {
        WebElement passwordField = new WebDriverWait(driver, ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(passwordBox));
        passwordField.click();
        passwordBox.sendKeys(password);
    }

    public Boolean isPasswordBoxIsVisible() {
        new WebDriverWait(driver, ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(passwordBox));
        return passwordBox.isDisplayed();
    }

    public void submitLoginAccountButton() {
        loginAccountButton.submit();
    }

    public void clickHelpButton() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        helpButton.click();
    }

    public void clickWishListButton() {
        wishList.click();
    }

}
