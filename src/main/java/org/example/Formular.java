package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Formular {
  private WebDriver driver;

  @BeforeEach
  public void setUp() {
    //System.setProperty("webdriver.chrome.driver", "C:\\Users\\hanss\\OneDrive\\Plocha\\StudijniMaterialy\\Studijni_material\\Studijni_material\\12_Playwright\\Kod\\SeleniumSkillmea4\\src\\main\\resources\\chromedriver.exe");
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
  }

  @Test
  public void testFormular() {
    driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("Petr");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("email@email.com");
    driver.findElement(By.id("gender")).click();
    driver.findElement(By.id("mobile")).clear();
    driver.findElement(By.id("mobile")).sendKeys("8234567809");
    driver.findElement(By.id("dob")).clear();
    driver.findElement(By.id("dob")).sendKeys("20.02.1995");
    assertEquals("Student registration Form", driver.findElement(By.xpath("/html/body/main/div/div/div[2]/form/h1")).getText());
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }

}
