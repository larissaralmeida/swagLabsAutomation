package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class buyProduct {

    private WebDriver driver;

    @Before
    public void createDriver(){
        driver wDriver = new driver();
        driver = wDriver.WebDriver();

    }

    @Test
    public void login() throws InterruptedException {
        //To check successful Login. Correct login and username
        WebElement username = driver.findElement(By.xpath("//input[@name='user-name']"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.xpath("//input[@name='login-button']"));
        loginButton.click();


        List<WebElement> results = driver.findElements(By.xpath("//*[@class='inventory_item_name']"));
        System.out.println("Items found: " + results.size());

        WebElement first_list_result = results.get(0);
        first_list_result.click();

        WebElement inventory_button = driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']"));
        inventory_button.click();
        WebElement inventory_button_remove = driver.findElement(By.xpath("//*[@id='remove-sauce-labs-backpack']"));
        System.out.println(inventory_button_remove.getText());
        WebElement details_price = driver.findElement(By.xpath("//*[@id='inventory_item_container']/div/div/div[2]/div[3]"));
        System.out.println(details_price.getText());
        WebElement cart_link = driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a"));
        cart_link.click();

        WebElement cart_list = driver.findElement(By.xpath("//*[@id='cart_contents_container']/div/div[1]"));
        System.out.println(cart_list.getText());

        WebElement checkout_button = driver.findElement(By.xpath("//*[@id='checkout']"));
        checkout_button.click();

        WebElement your_information = driver.findElement(By.xpath("//*[@id='header_container']/div[2]"));
        System.out.println(your_information.getText().toLowerCase());

        WebElement first_name = driver.findElement(By.xpath("//*[@id='first-name']"));
        first_name.sendKeys("Robot");
        WebElement last_name = driver.findElement(By.xpath("//*[@id='last-name']"));
        last_name.sendKeys("JK");
        WebElement zip_code = driver.findElement(By.xpath("//*[@id='postal-code']"));
        zip_code.sendKeys("9999999");
        WebElement continue_button = driver.findElement(By.xpath("//*[@id='continue']"));
        continue_button.click();

        WebElement finish_button = driver.findElement(By.xpath("//*[@id='finish']"));
        finish_button.click();

        WebElement order = driver.findElement(By.xpath("//*[@id='checkout_complete_container']/h2"));
        String order_text = order.getText().toLowerCase();
        boolean check_result = false;

        if(order_text.contains("thank you for your order")){
            check_result = true;
        } else {
            System.out.println("Error!");
        }

        Assert.assertTrue(check_result);

        /*for (int i = 0; i < results.size(); i++) {
            System.out.println(i+1 + ": " + results.get(i).getText());
        }*/


        Thread.sleep(4000);





    }




    @After
    public void closeDriver(){
        driver.close();
        driver.quit();
    }

}
