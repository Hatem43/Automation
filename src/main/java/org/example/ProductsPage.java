package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProductsPage {
    WebDriver driver;
    By productsList= By.xpath("//div[@class='inventory_item']");
    By Productitem=By.xpath("(//div[@class='inventory_item'])[1]");
    By addtocart=By.id("add-to-cart-sauce-labs-backpack");
    By cart=By.xpath("//a[@class='shopping_cart_link']");
    By addbiketocart=By.id("add-to-cart-sauce-labs-bike-light");
    By addtishrttocart=By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By productssort=By.className(".inventory_item_price");
    By sort=By.className("product_sort_container");
    By menu=By.id("react-burger-menu-btn");
    By logout=By.id("logout_sidebar_link");

    public ProductsPage(WebDriver driver){
        this.driver=driver;
    }

    public boolean verifyProductsitems(){
        List<WebElement> Products=driver.findElements(productsList);
        boolean actual=Products.contains(driver.findElement(Productitem));
        return actual;
    }
    public CartPage Addtocart(){
        driver.findElement(addtocart).click();
        driver.findElement(cart).click();
        return new CartPage(driver);
    }

    public CartPage addmultipleitemstocart(){
       driver.findElement(addtocart).click();
       driver.findElement(addbiketocart).click();
       driver.findElement(addtishrttocart).click();
       driver.findElement(cart).click();
       return new CartPage(driver);
    }

    public boolean productsortsfromZtoA(){
        List<WebElement> beforesortproducts=driver.findElements(productssort);
        List<String> beforesortList=new ArrayList<>();
        Select sortAtoz=new Select(driver.findElement(sort));
        sortAtoz.selectByVisibleText("Name (Z to A)");
        List<WebElement> aftersortproducts=driver.findElements(productssort);
        List<String> aftersortList=new ArrayList<>();
        Collections.sort(beforesortList);
        boolean actual=beforesortList.equals(aftersortList);
        return actual;
    }
    public String logout(){
        driver.findElement(menu).click();
        driver.findElement(logout).click();
        String actual=driver.getCurrentUrl();
        return actual;
    }
}
