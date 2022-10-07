package org.rishi.automation.tests;
import org.rishi.automation.objects.ProductData;
import org.rishi.automation.pages.AccountPage;
import org.rishi.automation.objects.LoginData;
import org.rishi.automation.pages.HomePage;
import org.rishi.automation.utils.JacksonUtils;
import org.rishi.automation.base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.io.IOException;

@Epic("Flipkart Epic")
@Feature("New Feature")
public class FirstTest extends BaseTest {

    public FirstTest() {
    }

    @Test
    public void loginAndLogout() throws IOException {

        LoginData loginData = JacksonUtils.deserializeJson("loginDetails.json", LoginData.class);
        HomePage homePage = new HomePage(getDriver()).load();
        AccountPage accountPage = homePage.setLoginDetails(loginData)
                .clickLoginBtn()
                .mouseHoverMyAccount()
                .clickMyProfile();
        accountPage
                .isLoaded()
                .clickLogoutBtn();
    }

    @Story("Search a product")
    @Description("Search and sort")
    @Link("https://example.org")
    @Issue("123")
    @TmsLink("test-1")
    @Test(description = "should be able to search product")
    public void searchProduct() throws IOException {

        ProductData productData = new ProductData(1215);
        HomePage homePage = new HomePage(getDriver()).load();
        homePage.closeLoginPopup()
                .searchProduct(productData.getName())
                .clickSearchButton()
                .sortByLowest();
    }
}