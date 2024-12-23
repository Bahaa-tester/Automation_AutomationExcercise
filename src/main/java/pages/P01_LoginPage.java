package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P01_LoginPage {

    SHAFT.GUI.WebDriver driver;
    // Constructor
    public P01_LoginPage (SHAFT.GUI.WebDriver driver) {this.driver = driver;}

    // Locators
    By loginPage = By.xpath("//a[@href=\"/login\"]");
    By emailAddressTextField = By.xpath("//input[@data-qa=\"login-email\"]");
    By passwordTextField = By.xpath("//input[@data-qa=\"login-password\"]");
    By loginButton = By.xpath(" //button[@data-qa=\"login-button\"]");


    // Methods
    @Step("Login With A Valid Email-Address And Password")
    public P02_HomePage loginSteps (String emailAddress, String password){
                driver.element().click(loginPage)
                .type(emailAddressTextField,emailAddress)
                .typeSecure(passwordTextField,password)
                .click(loginButton);
                return new P02_HomePage(driver);
    }

}
