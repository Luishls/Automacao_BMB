package Chrome;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {

	static WebDriver driver;

	private static final String BOTAO_PESQUISAR = ".//input[contains(@value, 'Pesquisa Google')]";

	public static WebDriver getWebDriver() {
		return driver;
	}

	public static WebElement getInputSearch() {
		try {
		WebElement campoPesquisa = getWebDriver().findElement(By.name("q"));
		return campoPesquisa;
		} catch(Exception e){
			System.err.println("Campo não encontrado!");
			finalizarCenario(e);
			return null;
		}
	}

	public static WebElement getBtnPesquisar() {
		try {
		WebElement botaoPesquisa = getWebDriver().findElement(By.xpath(BOTAO_PESQUISAR));
		return botaoPesquisa;
		} catch(Exception e){
			System.err.println("Botão não encontrado");
			finalizarCenario(e);
			return null;
		}
	}

	public static void executarChrome() {
		System.setProperty("webdriver.chrome.driver",
				"Drivers//chromedriver.exe");
		driver = new ChromeDriver();
	}

	public static void acessarPagina() {
		try {
		executarChrome();
		getWebDriver().get("https://www.google.com.br/");
		} catch(Exception e){
			finalizarCenario(e);
		}
	}

	public static void realizarPesquisa(String pesquisa) throws AWTException, IOException {
		try {
		getInputSearch().sendKeys(pesquisa);
		getBtnPesquisar().click();
		Report.addStep(getInputSearch(), "Efetuar pesquisa no Google");
		finalizarCenario();
		}catch(Exception e){
			finalizarCenario(e);
			System.err.println("Não foi possivela realizar a pesquisa");
		}
	}

	public static void finalizarCenario() {
		driver.close();
		driver.quit();
		System.out.print("finalizado com sucesso");
	}
	
	public static void finalizarCenario(Exception e) {
		driver.close();
		driver.quit();
		System.err.print("finalizado com erro: " + e);
	}
}
