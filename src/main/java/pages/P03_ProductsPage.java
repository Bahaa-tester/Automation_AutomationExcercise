package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class P03_ProductsPage {
    SHAFT.GUI.WebDriver driver;
    public P03_ProductsPage (SHAFT.GUI.WebDriver driver){this.driver =driver;}


    // Locator
    By menToggleMenu = By.xpath("//a[@href=\"#Men\"]");

    By tshirtsTab = By.xpath("//a[@href=\"/category_products/3\"][contains(.,\"Tshirts\")]");
}
