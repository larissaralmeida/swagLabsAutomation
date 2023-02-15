package org.example;

import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class loginTest {
        private WebDriver driver;

        @Before
        public void createDriver(){
            driver wDriver = new driver();
            driver = wDriver.WebDriver();
        }


        @Test
                public void access(){
            //To check if the website is opening
            System.out.println("Website open successfully.");
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
            WebElement homePage = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span"));
            String result_login = homePage.getText().toLowerCase();

            boolean check_result = false;

            if(result_login.contains("products")){
                System.out.println("Login successfully");
                System.out.println(result_login);
                check_result = true;
            } else {
                System.out.println("Check and try again!");
            }

            Assert.assertTrue(check_result);


            Thread.sleep(1000);
        }

        @Test
        public void wrongUsername() throws InterruptedException {
            //To check failed login. Correct password, wrong username
            WebElement username = driver.findElement(By.xpath("//input[@name='user-name']"));
            username.sendKeys("standard");
            WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
            password.sendKeys("secret_sauce");
            WebElement loginButton = driver.findElement(By.xpath("//input[@name='login-button']"));
            loginButton.click();
            WebElement error_message = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]"));
            String message = error_message.getText().toLowerCase();

            boolean check_result = false;

            if (message.contains("username and password do not match any user in this service")){
                System.out.println("Invalid Username");
                System.out.println("Message result: " + message);
                System.out.println("Expected result: Epic sadface: Username and password do not match any user in this service");
                check_result = true;
            } else {
                System.out.println("The message must contains 'Username and password do not match any user in this service'");
                System.out.println("Message result: " + message);
            }

            Assert.assertTrue(check_result);


            Thread.sleep(1000);

        }

        @Test
        public void wrongPassword() throws InterruptedException {
            //To check failed login. Correct username, wrong password.
            WebElement username = driver.findElement(By.xpath("//input[@name='user-name']"));
            username.sendKeys("standard_user");
            WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
            password.sendKeys("secret_");
            WebElement loginButton = driver.findElement(By.xpath("//input[@name='login-button']"));
            loginButton.click();
            WebElement error_message = driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]"));
            String message = error_message.getText().toLowerCase();

            boolean check_result = false;

            if (message.contains("username and password do not match any user in this service")){
                System.out.println("Invalid password");
                System.out.println("Message result: " + message);
                System.out.println("Expected result: Epic sadface: Username and password do not match any user in this service");
                check_result = true;
            } else {
                System.out.println("The message must contains 'Username and password do not match any user in this service'");
                System.out.println("Message result: " + message);
            }

            Assert.assertTrue(check_result);


            Thread.sleep(1000);
        }



        @After
        public void closeDriver(){
            driver.close();
            driver.quit();
        }
    }
