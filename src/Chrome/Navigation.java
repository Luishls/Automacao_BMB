package Chrome;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		//Report.addStep(getInputSearch(), "Efetuar pesquisa no Google");
	}

	public static void finalizarCenario() {
		driver.close();
		driver.quit();
		System.out.println("Cen�rio Finalizado com sucesso");
	}
}
