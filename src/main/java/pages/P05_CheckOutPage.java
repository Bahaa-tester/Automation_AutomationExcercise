package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class P05_CheckOutPage {

        SHAFT.GUI.WebDriver driver;
        public P05_CheckOutPage(SHAFT.GUI.WebDriver driver){this.driver=driver;}

        // Locators
        By addressDetails = By.xpath("//ul[@id=\"address_delivery\"]");
        By productNo_1_Checkout = By.xpath("//tr[@id=\"product-2\"]");
        By priceProductNo_1 = By.xpath("//tr[@id=\"product-2\"]//p[@class=\"cart_total_price\"]");
        By productNo_2_Checkout = By.xpath("//tr[@id=\"product-31\"]");
        By priceProductNo_2 = By.xpath("//tr[@id=\"product-31\"]//p[@class=\"cart_total_price\"]");
        By totalPrice = By.xpath("//tr[3]//p[@class=\"cart_total_price\"]");

        By addCommentTextField = By.xpath("//textarea[@name=\"message\"]");
        By placeOrderButton = By.xpath("//a[@href=\"/payment\"][@class=\"btn btn-default check_out\"][contains(.,\"Place Order\")]");

        // Methods
        @Step("Check Some Assertions And Do Some Actions On The CheckOut Page")
        public P05_CheckOutPage makeActionsWithCheckoutPage(){
            driver.assertThat().element(addressDetails).exists().perform();
            System.out.println("The Address Details are: "+driver.element().getText(addressDetails));
            driver.assertThat().element(productNo_1_Checkout).exists().perform();
            System.out.println("The price of product no.1 is: "+driver.element().getText(priceProductNo_1));
            driver.assertThat().element(productNo_2_Checkout).exists().perform();
            System.out.println("The price of product no.2 is: "+driver.element().getText(priceProductNo_2));
            System.out.println("The total price is: "+driver.element().getText(totalPrice));
            driver.element().type(addCommentTextField,"If the quality of the two products is high,I'll buy from you everytime!").getText(addCommentTextField);
            return this;
        }
        @Step("Navigate To The Payment Page")
        public P06_PaymentPage navigateToPaymentPage(){
            driver.element().click(placeOrderButton);
            return new P06_PaymentPage(driver);
        }
    }


