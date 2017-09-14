package Chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {
	
	static WebDriver driver;

	private static final String BOTAO_PESQUISAR = ".//input[contains(@name, 'btnK')]";
	
	public static WebElement getBtnPesquisar(){
		WebElement botaoPesquisa = driver.findElement(By.xpath(BOTAO_PESQUISAR));
		return botaoPesquisa;
	}
	
	
	public static void executarChrome(){
		System.setProperty("webdriver.chrome.driver", "C://Users//Luis Henrique Lima//Documents//Arquivos//chromedriver_win32//chromedriver.exe");	
		driver = new ChromeDriver();
	}
	
	public static void acessarPagina(){
		executarChrome();
		driver.get("https://www.google.com.br/");
	}
	
	public static void realizarPesquisa(String pesquisa){
		driver.findElement(By.name("q")).sendKeys(pesquisa);
		getBtnPesquisar().click();
	}
}
