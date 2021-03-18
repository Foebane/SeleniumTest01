package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	private WebDriver driver;

	@Given("I have {int}")
	public void i_have(Integer int1) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://www.marshu.com/articles/calculate-addition-calculator-add-two-numbers.php");
		WebElement num1 = driver.findElement(By.name("n01"));
		num1.sendKeys("50");

	}

	@Given("I also have {int}")
	public void i_also_have(Integer int1) {
		WebElement num1 = driver.findElement(By.name("n02"));
		num1.sendKeys("50");
	}

	@When("I press add")
	public void i_press_add() {
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/form/p[4]/input")).click();
	}

	@Then("the result should show {int}")
	public void the_result_should_show(Integer int1) throws InterruptedException {

		String result = driver.findElement(By.name("answer")).getAttribute("value");

		assertEquals("100", result);
		Thread.sleep(3000);
		driver.quit();
	}
}