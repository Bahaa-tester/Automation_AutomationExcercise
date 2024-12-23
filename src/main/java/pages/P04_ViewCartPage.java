package pages;

import com.jcraft.jsch.jce.SHA1;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class P04_ViewCartPage {
    SHAFT.GUI.WebDriver driver;
    public P04_ViewCartPage(SHAFT.GUI.WebDriver driver) {this.driver=driver;}

    // Locators
    By productNumberOne = By.xpath("//tr[@id=\"product-2\"]");
    By productNo_1Name = By.xpath("//a[@href=\"/product_details/2\"]");
    By productNumberTwo = By.xpath("//tr[@id=\"product-31\"]");
    By productNo_2Name = By.xpath("//a[@href=\"/product_details/31\"]");
    By proceedToCheckoutButton = By.xpath("//a[@class=\"btn btn-default check_out\"][contains(.,\"Proceed To Checkout\")]");
    By emptyCartVerificationText = By.xpath("//span[@id=\"empty_cart\"]/p[@class=\"text-center\"]/b[contains(.,\"Cart is empty!\")]");

    // Methods
    @Step("View Cart Page to Verify Added Items")
    public P04_ViewCartPage viewAddedItems (){
        driver.assertThat().element(productNumberOne).exists().perform();
        driver.assertThat().element(productNumberTwo).exists().perform();
        System.out.println("The first Item is: "+driver.element().getText(productNo_1Name));
        System.out.println("The second Item is: "+driver.element().getText(productNo_2Name));
        return this;
    }
    @Step("Open CheckOut Page")
    public P05_CheckoutPage proceedToCheckOut(){
        driver.element().click(proceedToCheckoutButton);
        return new P05_CheckoutPage(driver);
    }

    @Step("Verify that the Cart is Empty After CheckOut")
    public P04_ViewCartPage verifyThatTheCartIsEmpty(){
        String emptyCartVerificationExpected = "Cart is empty!";
        String emptyCartVerificationActual = driver.element().getText(emptyCartVerificationText);
        Assert.assertEquals(emptyCartVerificationActual,emptyCartVerificationExpected," Cart is empty!");

      return this;
    }
}
