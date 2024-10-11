import org.example.*;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class checkoutTest {
    public WebDriver driver;

    @BeforeMethod
    public void setupbrowser(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void checkout() throws IOException, ParseException {

        Loginvalid login=new Loginvalid(driver);
        login.login();
        login.gotoproducts();
        ProductsPage products=new ProductsPage(driver);
        products.Addtocart();
        CartPage cart=new CartPage(driver);
        cart.buyproduct();
        checkoutPage check=new checkoutPage(driver);
        check.checkout();
        String actuallink=check.gotopurchasepage();
        String expectedlink="https://www.saucedemo.com/checkout-step-two.html";
        Assert.assertEquals(actuallink,expectedlink);
        String actualmessage=check.finishpurchase();
        String expectedmessage="Thank you for your order!";
        Assert.assertEquals(actualmessage,expectedmessage);
    }

}
