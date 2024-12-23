package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P02_HomePage {
    SHAFT.GUI.WebDriver driver;
    public P02_HomePage (SHAFT.GUI.WebDriver driver){this.driver = driver;}

    // Locators
    By productsPage = By.xpath("//a[@href=\"/products\"]");
    By viewCartPage = By.xpath("//li/a[@href=\"/view_cart\"][contains(.,\"Cart\")]");
    By logoutPageButton = By.xpath("//li[4]//a[@href=\"/logout\"]//i[@class=\"fa fa-lock\"]");

    // Methods
    @Step("Navigate To The Products Page")
    public P03_ProductsPage openProductsPage () {
        driver.element().click(productsPage);
        return new P03_ProductsPage(driver);
    }

    @Step("Navigate To The Cart Page")
    public P04_ViewCartPage openTheViewCartPage(){
        driver.element().click(viewCartPage);
        return new P04_ViewCartPage(driver);
    }

    @Step("Logging Out From My Account")
    public P01_LoginPage logOut(){
        driver.element().click(logoutPageButton);
        return new P01_LoginPage(driver);
    }

}
