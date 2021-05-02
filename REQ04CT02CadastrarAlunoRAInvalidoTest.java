package ed09;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class REQ04CT02CadastrarAlunoRAInvalidoTest {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "browserDriver/chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void rEQ04CT02CadastrarAlunoRAInvalido() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(968, 728));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		espera();
		driver.findElement(By.linkText("Alunos")).click();
		espera();
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).sendKeys("12345");
		driver.findElement(By.id("nome")).click();
		driver.findElement(By.id("nome")).sendKeys("Carlos Alberto de Moraes Junior");
		driver.findElement(By.id("email")).sendKeys("carlosjunior_sjc@hotmail.com");
		driver.findElement(By.id("cep")).sendKeys("04295-001");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		driver.findElement(By.cssSelector(".col-md-4 > .text-danger")).click();
		driver.findElement(By.cssSelector(".col-md-4")).click();
		espera();
		assertThat(driver.findElement(By.cssSelector(".col-md-4 > .text-danger")).getText(),
				is("RA deve ter 4 caracteres"));
	}

	public void espera() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}