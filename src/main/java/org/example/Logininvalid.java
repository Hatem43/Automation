package org.example;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Logininvalid {

    By loginbtn= By.id("login-button");
    By username=By.id("user-name");
    By userpassword=By.id("password");
    WebDriver driver;
    By errormessage=By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");

    public Logininvalid(WebDriver driver){
        this.driver=driver;
    }
    public Logininvalid login() throws IOException,ParseException {
        JSONParser j=new JSONParser();
        FileReader f=new FileReader("./resources/logininvalid.json");
        Object o=j.parse(f);
        JSONObject Info=(JSONObject) o;
        String validname=(String)Info.get("validname");
        String invalidpassword=(String)Info.get("invalidpassword");
        WebElement n=driver.findElement(username);
        WebElement m=driver.findElement(userpassword);
        n.sendKeys(validname);
        m.sendKeys(invalidpassword);
        return this;
    }
    public String loginwithvalidnameandinvalidpassword(){
        driver.findElement(loginbtn).click();
        String actual=driver.findElement(errormessage).getText();
        return actual;
    }

    public Logininvalid logininvalid() throws IOException,ParseException{
        JSONParser j=new JSONParser();
        FileReader f=new FileReader("./resources/logininvalid.json");
        Object o=j.parse(f);
        JSONObject Info=(JSONObject) o;
        String invalidname=(String)Info.get("invalidname");
        String validpassword=(String)Info.get("validpassword");
        WebElement n=driver.findElement(username);
        WebElement m=driver.findElement(userpassword);
        n.sendKeys(invalidname);
        m.sendKeys(validpassword);
        return this;
    }
    public String loginwithinvalidnameandvalidpassword(){
        driver.findElement(loginbtn).click();
        String actual=driver.findElement(errormessage).getText();
        return actual;
    }

    public Logininvalid loginwithinvaliddata() throws IOException,ParseException{
        JSONParser j=new JSONParser();
        FileReader f=new FileReader("./resources/logininvalid.json");
        Object o=j.parse(f);
        JSONObject Info= (JSONObject) o;
        String invalidname=(String) Info.get("invalidname");
        String invalidpassword=(String) Info.get("invalidpassword");
        WebElement n=driver.findElement(username);
        WebElement m=driver.findElement(userpassword);
        n.sendKeys(invalidname);
        m.sendKeys(invalidpassword);
        return this;
    }
    public String loginwithinvalidnameandinvalidpassword(){
        driver.findElement(loginbtn).click();
        String actual=driver.findElement(errormessage).getText();
        return actual;
    }

}
