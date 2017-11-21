package Chrome;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Navigation {

	static WebDriver driver;

	private static final String BOTAO_PESQUISAR = ".//input[contains(@value, 'Pesquisa Google')]";

	public static WebDriver getWebDriver() {
		return driver;
	}

	public static WebElement getInputUser() {
		try {
		WebElement user = driver.findElement(By.id("email"));
		return user;
		} catch(Exception e){
			System.err.println("Campo não encontrado!");
			finalizarCenario(e);
			return null;
		}
	}
	
	public static WebElement getInputPass() {
		try {
		WebElement pass = driver.findElement(By.id("senha"));
		return pass;
		} catch(Exception e){
			System.err.println("Campo não encontrado!");
			finalizarCenario(e);
			return null;
		}
	}

	public static WebElement getBtnPesquisar() {
		try {
		WebElement botaoPesquisa = getWebDriver().findElement(By.id("formLoginButtonSubmit"));
		return botaoPesquisa;
		} catch(Exception e){
			System.err.println("Botão não encontrado");
			finalizarCenario(e);
			return null;
		}
	}

	public static void executar() {
		System.setProperty("webdriver.ie.driver",
				"Drivers//IEDriverServer.exe");
		driver = new InternetExplorerDriver();
	}

	public static void acessarPagina() {
		try {
		executar();
		getWebDriver().get("www.sp.senac.br/login");
		} catch(Exception e){
			finalizarCenario(e);
		}
	}

	public static void realizarPesquisa(String user, String pass) throws AWTException, IOException {
		try {
		Thread.sleep(4000);
		getInputUser().sendKeys(user);
		getInputPass().sendKeys(pass);
		getBtnPesquisar().click();
		Report.addStep(getInputUser(), "Efetuar Login no senac");
		finalizarCenario();
		}catch(Exception e){
			finalizarCenario(e);
			System.err.println("Não foi possivela realizar login");
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
