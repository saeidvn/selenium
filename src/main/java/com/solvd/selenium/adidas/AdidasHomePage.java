package com.solvd.selenium.adidas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdidasHomePage {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdidasHomePage.class);

    private WebDriver driver;

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

    @FindBy(css = ".header-cross-link___iEGVx")
    private WebElement reebokButton;

    public AdidasHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.driver.get("https://www.adidas.com/us");
    }

    public void typeInSearchInput(String productName){
        searchInput.sendKeys(productName);
    }

    public void submitSearchButton(){
        searchButton.submit();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickLoginBox() {
        loginBox.click();
    }

    public void typeLoginEmail(String email) {
        loginEmail.sendKeys(email);
    }

    public void submitContinueButton() {
        continueButton.submit();
    }

    public void typeLoginPassword(String password) {
        loginPassword.sendKeys(password);
    }

    public void submitLoginAccountButton() {
        loginAccountButton.submit();
    }

    public void submitReebokButton() {
        reebokButton.click();
    }

    public WebElement getSearchInput() {
        return searchInput;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getLoginEmail() {
        return loginEmail;
    }

    public WebElement getLoginPassword() {
        return loginPassword;
    }

    public WebElement getLoginAccountButton() {
        return loginAccountButton;
    }
}
