package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P06_PaymentPage {

        SHAFT.GUI.WebDriver driver;
        // Constructor
        public P06_PaymentPage(SHAFT.GUI.WebDriver driver){this.driver=driver;}
        // Locators
        By nameOnCardTextField = By.xpath("//input[@name=\"name_on_card\"]");
        By cardNumberTextField = By.xpath("//input[@data-qa=\"card-number\"]");
        By cvcNumberTextField = By.xpath("//input[@data-qa=\"cvc\"]");
        By expirationMonthTextField = By.xpath("//input[@data-qa=\"expiry-month\"]");
        By expirationYearTextField = By.xpath("//input[@data-qa=\"expiry-year\"]");
        By payAndConfirmButton = By.xpath("//button[@data-qa=\"pay-button\"][contains(.,\"Pay and Confirm Order\")]");
        By confirmMessage = By.xpath("//p[contains(.,\"Congratulations! Your order has been confirmed!\")]");
        By downloadInvoiceButton = By.xpath("//a[@class='btn btn-default check_out']");
        By continueButton = By.xpath("//a[@data-qa=\"continue-button\"][contains(.,\"Continue\")]");

        @Step("Fill Payment Form And Pay")
        public pages.P06_PaymentPage fillPaymentForm (String nameOnCard, String cardNumber, String cvcNumber, String expirationMonth, String expirationYear){
            driver.element().type(nameOnCardTextField,nameOnCard)
                    .type(cardNumberTextField,cardNumber)
                    .type(cvcNumberTextField,cvcNumber)
                    .type(expirationMonthTextField,expirationMonth)
                    .type(expirationYearTextField,expirationYear)
                    .click(payAndConfirmButton)
                    .assertThat(confirmMessage).isVisible().perform();
            driver.element().click(downloadInvoiceButton);
            return this;
        }

        @Step("Navigate to the Home Page")
        public P02_HomePage navigateToHomePage(){
            driver.element().click(continueButton);
            return new P02_HomePage(driver);
        }

    }


