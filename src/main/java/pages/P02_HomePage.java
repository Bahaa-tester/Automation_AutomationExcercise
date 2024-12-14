package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class P02_HomePage {
    SHAFT.GUI.WebDriver driver;
    public P02_HomePage (SHAFT.GUI.WebDriver driver){this.driver = driver;}

    // Locator
    By productsPage = By.xpath("//a[@href=\"/products\"]");

    public P03_ProductsPage openProductsPage () {
        driver.element().click(productsPage);
        return new P03_ProductsPage(driver);
    }

}
