import org.example.CartPage;
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
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CartTest {

    public WebDriver driver;

    @BeforeMethod
    public void setupbrowser(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void checkcartList()throws IOException, ParseException{
        Loginvalid login=new Loginvalid(driver);
        login.login();
        login.gotoproducts();
        ProductsPage products=new ProductsPage(driver);
        products.verifyProductsitems();
        products.Addtocart();
        CartPage cart=new CartPage(driver);
        String actual=cart.checkcartitem();
        String expected="Sauce Labs Backpack";
        Assert.assertEquals(actual,expected);
    }

 


    @Test
    public void removecartitem()throws IOException, ParseException{
        Loginvalid login=new Loginvalid(driver);
        login.login();
        login.gotoproducts();
        ProductsPage products=new ProductsPage(driver);
        products.verifyProductsitems();
        products.Addtocart();
        CartPage cart=new CartPage(driver);
        boolean actual=cart.removefromcart();
        boolean expected=true;
        Assert.assertEquals(actual,expected);
    }
    

    @Test
    public void addmultipleitemstocart()throws IOException, ParseException{
        Loginvalid login=new Loginvalid(driver);
        login.login();
        login.gotoproducts();
        ProductsPage products=new ProductsPage(driver);
        products.verifyProductsitems();
        products.addmultipleitemstocart();
        CartPage cart=new CartPage(driver);
        int actualcartsize;
        actualcartsize=cart.addmultipleproductstocart();
        int expectedcartsize=3;
        Assert.assertEquals(actualcartsize,expectedcartsize);
    }
}
