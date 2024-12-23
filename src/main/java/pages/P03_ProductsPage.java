package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_ProductsPage {
    SHAFT.GUI.WebDriver driver;
    public P03_ProductsPage (SHAFT.GUI.WebDriver driver){this.driver =driver;}


    // Locator
    By menToggleMenu = By.xpath("//a[@data-toggle=\"collapse\"][@href=\"#Men\"]");

    By tshirtsTab = By.xpath("//ul//li//a[@href=\"/category_products/3\"][contains(.,\"Tshirts\")]");
    //By allShownProducts = By.xpath("//div[@class=\"col-sm-9 padding-right\"]//div[@class=\"features_items\"]");
    By continueShoppingButton = By.xpath("//button[@class=\"btn btn-success close-modal btn-block\"][contains(.,\"Continue Shopping\")]");

    //By subScription = By.xpath("//div[@class=\"single-widget\"][contains(.,\"Subscription\")]");
    By viewCartPage = By.xpath("//li/a[@href=\"/view_cart\"][contains(.,\"Cart\")]");

    // Methods

    public P03_ProductsPage navigateToTshirtProductsSection (){
        driver.element().click(menToggleMenu)
                .click(tshirtsTab);
        return this;
    }
    @Step("Add products with price less than 1000 Rs.")
    public void addProducts() {
        int i = 0;

        while (true) {
            try {
                // Re-fetch all products to account for DOM changes
                List<WebElement> productPrices = driver.getDriver().findElements(By.xpath("//div[@class=\"productinfo text-center\"]/h2"));

                // Break the loop if all products have been processed
                if (i >= productPrices.size()) {
                    break;
                }

                // Extract the price of the current product
                String priceText = productPrices.get(i).getText().replaceAll("[^0-9]", "");
                int price = Integer.parseInt(priceText);

                System.out.println("Price of Product " + (i + 1) + " is: " + price);

                if (price < 1000) {
                    // Click the "Add to Cart" button for the current product
                    driver.element()
                            .click(By.xpath("(//div[@class=\"productinfo text-center\"]/a)[" + (i + 1) + "]"));

                    // Click "Continue Shopping" to allow the loop to continue
                    driver.element().click(continueShoppingButton);

                    System.out.println("Added product with price " + price + " to the cart");
                }

                // Move to the next product
                i++;
            } catch (NumberFormatException e) {
                System.err.println("Error parsing price for Product " + (i + 1));
                throw new RuntimeException(e);
            }
        }
    }


    @Step("Open the View Cart Page")
    public P04_ViewCartPage openViewCartPage() {
        driver.element().scrollToElement(viewCartPage).click(viewCartPage);
        return new P04_ViewCartPage(driver);
    }
}