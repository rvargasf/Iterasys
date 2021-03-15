package common;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public static final String URL = "https://www.petz.com.br/";
	private static WebDriver driver;

	public void iniciarWebDriver() {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("incognito");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver.manage().window().maximize();
		}
	}

	public void goToUrl() {
		driver.get(URL);
	}

	public void escrever(By by, String value) {
		try {
			aguardarVisibilidadeElemento(by);
			driver.findElement(by).clear();
			driver.findElement(by).sendKeys(value);
		} catch (WebDriverException e) {
			Assert.fail("Elemento não localizado.");
		}
	}

	public void aguardarVisibilidadeElemento(By by) {
		@SuppressWarnings("unused")
		WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void validarTitulo(String esperado) {
		String title = driver.getTitle();
		Assert.assertEquals(esperado, title);
	}

	public String obterTexto(By by) {
		aguardarVisibilidadeElemento(by);
		if (!elementoVisivel(by)) {
			Assert.fail("Texto não localizado.");
		}
		return driver.findElement(by).getText();
	}

	public void click(By by) {
		try {
			driver.findElement(by).click();
		} catch (Exception e) {
			Assert.fail("Elemento não localizado.");
		}
	}

	public boolean elementoVisivel(By by) {
		try {
			return driver.findElement(by).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void selecionarCombo(String id, String valor) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}

	public void encerrarWebDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	public void aguardarCarregamentoPagina() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			// Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout durante o carregamento da página.");
		}
	}

	public void submeterEnter(By by) {
		driver.findElement(by).sendKeys(Keys.RETURN);
	}
}
