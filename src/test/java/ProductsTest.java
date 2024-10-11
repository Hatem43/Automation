import org.example.ProductsPage;
import org.example.Loginvalid;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductsTest {


    public WebDriver driver;

    @BeforeMethod
    public void setupbrowser(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void verifyProductsitems()throws IOException, ParseException {
        Loginvalid login=new Loginvalid(driver);
        login.login();
        login.gotoproducts();
        ProductsPage products=new ProductsPage(driver);
        boolean actual=products.verifyProductsitems();
        boolean expected=true;
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void verifysortproducts()throws IOException, ParseException{
        Loginvalid login=new Loginvalid(driver);
        login.login();
        login.gotoproducts();
        ProductsPage products=new ProductsPage(driver);
        boolean actual=products.productsortsfromZtoA();
        boolean expected=true;
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void checklogout()throws IOException, ParseException{
        Loginvalid login=new Loginvalid(driver);
        login.login();
        login.gotoproducts();
        ProductsPage products=new ProductsPage(driver);
        String actual=products.logout();
        String expected="https://www.saucedemo.com/";
        Assert.assertEquals(actual,expected);
    }
}
