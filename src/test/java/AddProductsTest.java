import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P02_HomePage;

public class AddProductsTest {
    SHAFT.GUI.WebDriver driver;
    // SHAFT.TestData.JSON testData;
    SHAFT.TestData.EXCEL testDataExcel ;

    @BeforeClass
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().maximizeWindow();
        driver.browser().navigateToURL("https://www.automationexercise.com/");
       // testData = new SHAFT.TestData.JSON(SHAFT.Properties.paths.testData()+"testData.json");
        testDataExcel = new SHAFT.TestData.EXCEL(SHAFT.Properties.paths.testData()+"testDataExcel.xlsx");
    }

    @Test
    public void addProductsToCart(){
       // new P01_LoginPage(driver).login(testData.getTestData("emailAddress"),testData.getTestData("password"));
          new P01_LoginPage(driver).login(testDataExcel.getCellData("emailAddress"),testDataExcel.getCellData("password"));
          new P02_HomePage(driver).openProductsPage();

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
