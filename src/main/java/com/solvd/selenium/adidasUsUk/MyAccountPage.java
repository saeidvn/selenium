package com.solvd.selenium.adidasUsUk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    private WebDriver driver;

//    @FindBy(css = ".gl-heading.gl-heading--m.gl-heading--no-margin")
    @FindBy(css = ".gl-flex-display.col-l-24")
    private WebElement myAccount;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.driver.get("https://www.adidas.com/us/my-account");
    }

    public Boolean pageContainName() {
        return myAccount.isDisplayed();
    }

    public void closePopUp() {
        driver.switchTo().activeElement().findElement(By.xpath("//button[@class='gl-modal__close']")).click();
    }
}
