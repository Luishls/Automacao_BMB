package Chrome;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {

	static WebDriver driver;

	private static final String BOTAO_PESQUISAR = ".//input[contains(@name, 'btnK')]";

	public static WebDriver getWebDriver() {
		return driver;
	}

	public static WebElement getInputSearch() {
		WebElement campoPesquisa = getWebDriver().findElement(By.name("q"));
		return campoPesquisa;
	}

	public static WebElement getBtnPesquisar() {
		WebElement botaoPesquisa = getWebDriver().findElement(By.xpath(BOTAO_PESQUISAR));
		return botaoPesquisa;
	}

	public static void executarChrome() {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//Luis Henrique Lima//Documents//Arquivos//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
	}

	public static void acessarPagina() {
		executarChrome();
		getWebDriver().get("https://www.google.com.br/");
	}

	public static void realizarPesquisa(String pesquisa) throws AWTException, IOException {
		getInputSearch().sendKeys(pesquisa);
		getBtnPesquisar().click();
		Report.addStep(getInputSearch(), "Efetuar pesquisa no Google");
		finalizarCenario();
	}

	public static void finalizarCenario() {
		driver.close();
		driver.quit();
		System.out.println("Cenário Finalizado com sucesso");
	}
}
