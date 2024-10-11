package org.example;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.util.*;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
public class CartPage {

    WebDriver driver;
    By cartitems=By.xpath("//div[@class='inventory_item_name']");
    By removeitem=By.xpath("//button[@class='btn btn_secondary btn_small cart_button']");
    By checkout= By.xpath("//button[@class='btn btn_action btn_medium checkout_button ']");


    public CartPage(WebDriver driver){
        this.driver=driver;
    }
    public String checkcartitem(){
        List<WebElement>cartitemList=driver.findElements(cartitems);
        String actual=cartitemList.getFirst().getText();
        return  actual;
    }

    public boolean removefromcart(){
        driver.findElement(removeitem).click();
        List<WebElement>cartitemsList=driver.findElements(cartitems);
        boolean actual=cartitemsList.isEmpty();
        return actual;
    }
    public int addmultipleproductstocart() {
        List<WebElement> cartitemsList=driver.findElements(cartitems);
        return cartitemsList.size();
        }

        public checkoutPage buyproduct(){
           driver.findElement(checkout).click();
           return new checkoutPage(driver);
        }

    }
