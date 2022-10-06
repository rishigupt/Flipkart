package org.rishi.automation.pages;

import org.rishi.automation.base.BasePage;
import org.rishi.automation.objects.LoginData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {


    private By loginIdFld = By.xpath("//div[@class='IiD88i _351hSN']/input[@type='text']");
    private By loginPwFld = By.xpath("//input[@type='password']");
    private By loginBtn = By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']");
    private By myAccount = By.xpath("//div[text()='My Account']");
    private By myProfile = By.xpath("//div[text()='My Profile']");
    private By closeLoginPopup = By.xpath("//button[@class='_2KpZ6l _2doB4z']");
    private By searchForProducts = By.xpath("//input[@type='text']");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By sortByLowestPrice = By.xpath("//div[text()='Price -- Low to High']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage load(){
        load("/");
        return this;
    }



    public HomePage enterUserName(String loginID) {
        driver.findElement(loginIdFld).sendKeys(loginID);
        return this;
    }

    public HomePage enterPassword(String loginPW) {
        driver.findElement(loginPwFld).sendKeys("loginPW");
        return this;
    }

    public HomePage clickLoginBtn() {
        driver.findElement(loginBtn).click();
        return this;
    }

    public HomePage setLoginDetails(LoginData loginData) {
        return enterUserName(loginData.getUsername()).enterPassword(loginData.getPassword());
    }

    public HomePage mouseHoverMyAccount (){
        actions.moveToElement(waitForElementToBeVisible(myAccount)).build().perform();
        return this;
    }

    public AccountPage clickMyProfile (){
        driver.findElement(myProfile).click();
        return new AccountPage(driver);
    }

    @Step
    public HomePage closeLoginPopup() {
        driver.findElement(closeLoginPopup).click();
        return this;
    }

    @Step
    public HomePage searchProduct(String productName) {
        driver.findElement(searchForProducts).sendKeys(productName);
        return this;
    }

    @Step
    public HomePage clickSearchButton() {
        driver.findElement(searchButton).click();
        return this;
    }

    @Step
    public HomePage sortByLowest() {
        wait.until(ExpectedConditions.elementToBeClickable(sortByLowestPrice)).click();
        return this;
    }
}
