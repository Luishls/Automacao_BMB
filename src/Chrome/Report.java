package Chrome;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.xml.crypto.Data;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class Report {
	
	public static Navigation navigation = new Navigation();
	
	public static void gerarEvidencia() throws AWTException, IOException{
		String format = "jpg";
		Robot robot = new Robot();
		Date data = new Date();	
		
		File raiz = new File("C://Users//caue.ghetti//Desktop//Evidencias De Teste");
		raiz.mkdir();
		File dir2 = new File(raiz + "//Execucao" + data.getTime());
		dir2.mkdir();
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
		ImageIO.write(screenFullImage, format, new File(dir2 + "\\Evidencia_" + data.getTime() + ".jpg"));
	}
	
	public static void highlightElement(WebElement element){
	        JavascriptExecutor jse = (JavascriptExecutor) navigation.driver;
	        jse.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public static void addStep(WebElement element) throws AWTException, IOException{
		highlightElement(element);
		gerarEvidencia();
	}
	
	public static void addStep(WebElement element, String description) throws AWTException, IOException{
		highlightElement(element);
		gerarEvidencia();
		System.out.println("Cenário: " + description);
	}
}
