package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class driver {


    public WebDriver WebDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\laris\\IdeaProjects\\curso1\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();
        return driver;
    }
}
