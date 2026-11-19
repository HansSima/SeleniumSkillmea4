package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Formular {
  private WebDriver driver;

  @BeforeEach
  public void setUp() {
    //System.setProperty("webdriver.chrome.driver", "C:\\Users\\hanss\\OneDrive\\Plocha\\StudijniMaterialy\\Studijni_material\\Studijni_material\\12_Playwright\\Kod\\SeleniumSkillmea4\\src\\main\\resources\\chromedriver.exe");
    //WebDriverManager.edgedriver().setup();
    //driver = new EdgeDriver();
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
  }

  @Test
  public void testFormular() {
    WebElement femaleRadiobutton = driver.findElement(By.xpath("/html/body/main/div/div/div[2]/form/div[3]/div/div/div[2]/input"));
    driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
    driver.manage().window().maximize();
    driver.findElement(By.id("name")).sendKeys("Petr");
    driver.findElement(By.id("email")).sendKeys("email@email.com");
    driver.findElement(By.id("gender")).click();
    femaleRadiobutton.click();
    driver.findElement(By.id("mobile")).sendKeys("8234567809");
    driver.findElement(By.id("dob")).sendKeys("20.02.1995");
    String skutecnyNadpis = driver.findElement(By.xpath("/html/body/main/div/div/div[2]/form/h1")).getText();
    assertEquals("Student Registration Form", skutecnyNadpis);
    assertTrue(femaleRadiobutton.isSelected());
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }

}
