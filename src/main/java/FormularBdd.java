import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormularBdd {
    private WebDriver driver;
    WebElement femaleRadiobutton = driver.findElement(By.xpath("/html/body/main/div/div/div[2]/form/div[3]/div/div/div[2]/input"));
    WebElement maleRadiobutton = driver.findElement(By.id("gender"));

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @Given("Uzivatel je na strance s formularem")
    public void uzivatelJeNaStranceSFormularem() {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        driver.manage().window().maximize();
    }

    @When("Uzivatel klikne na radiobutton male")
    public void uzivatelKlikneNaRadiobuttonMale() {
        maleRadiobutton.click();
    }

    @And("Uzivatel klikne na radiobutton female")
    public void uzivatelKlikneNaRadiobuttonFemale() {
        femaleRadiobutton.click();
    }

    @Then("Uzivatel vidi zaskrtnuto female")
    public void uzivatelVidiZaskrtnutoFemale() {
        assertTrue(femaleRadiobutton.isSelected());
    }

    @And("Uzivatel vidi odskrtnuto male")
    public void uzivatelVidiOdskrtnutoMale() {
        assertFalse(maleRadiobutton.isSelected(), "Radiobutton Male je zaskrtnuto");
    }
}
