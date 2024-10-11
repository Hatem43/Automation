import org.example.Logininvalid;
import org.example.ProductsPage;
import org.example.Loginvalid;
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


public class LoginTest {

    By logo= By.xpath("//div[@class='app_logo']");
    public WebDriver driver;

    @BeforeMethod
    public void setupbrowser(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
    }
/*
    @Test
    public void regitservalid() throws IOException, ParseException {
        Loginvalid login=new Loginvalid(driver);
        login.login();
        login.gotoproducts();
        String expectedtitle="Swag Labs";
        String actualtitle=driver.findElement(logo).getText();
        Assert.assertEquals(expectedtitle,actualtitle);
    }
*/

    @Test
    public void loginwithvalidnameandinvalidpassword()throws IOException, ParseException{
        Logininvalid login=new Logininvalid(driver);
        login.login();
        String actual=login.loginwithvalidnameandinvalidpassword();
        String expected="Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void loginwithinvalidnameandvalidpassword()throws IOException,ParseException{
        Logininvalid login=new Logininvalid(driver);
        login.logininvalid();
        String actual=login.loginwithinvalidnameandvalidpassword();
        String expected="Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void loginwithinvalidnameandinvalidpassword()throws IOException,ParseException{
        Logininvalid login=new Logininvalid(driver);
        login.loginwithinvaliddata();
        String actual=login.loginwithinvalidnameandinvalidpassword();
        String expected="Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actual,expected);
    }
}
