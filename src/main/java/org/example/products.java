package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;
import java.util.List;

public class products {
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

        //results = items found on page
        List<WebElement> results = driver.findElements(By.xpath("//*[@class='inventory_item_name']"));
        System.out.println("Items found: " + results.size());

        String search = "Sauce";
        boolean check_result = false;
        String results_item_1 = results.get(1).getText();

        System.out.println("Name of items:");
        for (int i = 0; i < results.size(); i++) {
            System.out.println(i+1 + ": " + results.get(i).getText());
            if(results_item_1.contains(search)){
                check_result = true;
            } else {
                System.out.println("Erro!");
            }
        }

        Assert.assertTrue(check_result);

        Thread.sleep(5000);

    }


    @After
    public void closeDriver(){
        driver.close();
        driver.quit();
    }
}
