import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P02_HomePage;
import pages.P03_ProductsPage;
import pages.P04_ViewCartPage;

public class AddProductsTest {
    SHAFT.GUI.WebDriver driver;
 // SHAFT.TestData.JSON testDataLogin;
    SHAFT.TestData.EXCEL testDataExcel ;
    SHAFT.TestData.JSON testDataPayment;

    @BeforeClass
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://www.automationexercise.com/");
     // testDataLogin = new SHAFT.TestData.JSON(SHAFT.Properties.paths.testData()+"testDataLogin.json");
        testDataExcel = new SHAFT.TestData.EXCEL(SHAFT.Properties.paths.testData()+"testDataExcel.xlsx");
        testDataPayment = new SHAFT.TestData.JSON(SHAFT.Properties.paths.testData()+"testDataPayment.json");
    }

    @Test
    public void addProductsToCart() throws InterruptedException {
       // new P01_LoginPage(driver).loginSteps(testDataLogin.getTestData("emailAddress"),testDataLogin.getTestData("password"));
          new P01_LoginPage(driver).loginSteps(testDataExcel.getCellData("emailAddress"),testDataExcel.getCellData("password"));
          new P02_HomePage(driver).openProductsPage()
                  .navigateToTshirtProductsSection();
          Thread.sleep(5000);
           new P03_ProductsPage(driver).addProducts();
          Thread.sleep(5000);
          new P03_ProductsPage(driver).openViewCartPage()
                  .viewAddedItems()
                  .proceedToCheckOut()
                  .makeActionsWithCheckoutPage()
                  .navigateToPaymentPage()
                  .fillPaymentForm(testDataPayment.getTestData("nameOnCard")
                          ,testDataPayment.getTestData("cardNumber")
                          ,testDataPayment.getTestData("cvcNumber"),
                          testDataPayment.getTestData("expirationMonth")
                          ,testDataPayment.getTestData("expirationYear"))
                  .navigateToHomePage()
                  .openTheViewCartPage()
                  .verifyThatTheCartIsEmpty();

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
