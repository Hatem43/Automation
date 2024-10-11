package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class checkoutPage {

    WebDriver driver;
    By fname=By.id("first-name");
    By lname=By.id("last-name");
    By zip=By.id("postal-code");
    By purchase=By.id("continue");
    By finish=By.id("finish");
    By ordermessage=By.xpath("//h2[@class='complete-header']");

    public checkoutPage(WebDriver driver){
        this.driver=driver;
    }

    public checkoutPage checkout() throws IOException,ParseException{
      JSONParser j=new JSONParser();
      FileReader f=new FileReader("./resources/checkinfo.json");
      Object o=j.parse(f);
      JSONObject checkout=(JSONObject) o;
      String firstname=(String)checkout.get("Firstname");
      String lastname=(String)checkout.get("Lastname");
      String postal=(String)checkout.get("Postalcode");
      WebElement n=driver.findElement(fname);
      WebElement m=driver.findElement(lname);
      WebElement z=driver.findElement(zip);
      n.sendKeys(firstname);
      m.sendKeys(lastname);
      z.sendKeys(postal);
      return this;
    }

    public String gotopurchasepage(){
    driver.findElement(purchase).click();
    String actuallink=driver.getCurrentUrl();
    return actuallink;
    }

    public String finishpurchase(){
        driver.findElement(finish).click();
        String actual=driver.findElement(ordermessage).getText();
        return actual;
    }

}
