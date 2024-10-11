package org.example;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.FileReader;
import java.io.IOException;


public class Loginvalid {
    By loginbtn= By.id("login-button");
    By username=By.id("user-name");
    By userpassword=By.id("password");
    By title= By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div");
    WebDriver driver;

    public Loginvalid(WebDriver driver){
        this.driver=driver;
    }

    public Loginvalid login() throws IOException,ParseException{
        JSONParser j = new JSONParser();
        FileReader f = new FileReader("./resources/Info.json");
        Object o=j.parse(f);
        JSONObject Info=(JSONObject) o;
        String name=(String)Info.get("name");
        String password=(String)Info.get("password");;
        WebElement n=driver.findElement(username);
        WebElement m=driver.findElement(userpassword);
        n.sendKeys(name);
        m.sendKeys(password);
        return this;
    }

    public ProductsPage gotoproducts(){
        driver.findElement(loginbtn).click();
        return new ProductsPage(driver);
    }
}
