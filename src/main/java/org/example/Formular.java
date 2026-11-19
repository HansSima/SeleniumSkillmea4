package org.example;

import org.junit.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Formular {
  private WebDriver driver;

  @BeforeEach
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "");
    driver = new ChromeDriver();
  }

  @Test
  public void testFormular() {
    driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("Jan");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("email@email.com");
    driver.findElement(By.id("gender")).click();
    driver.findElement(By.id("mobile")).clear();
    driver.findElement(By.id("mobile")).sendKeys("1234567890");
    driver.findElement(By.id("dob")).clear();
    driver.findElement(By.id("dob")).sendKeys("2026-11-05");
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }

}
