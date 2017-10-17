package Chrome;

import java.awt.AWTException;
import java.io.IOException;

public class ExecuteChrome {

	public static void main(String[] args) throws AWTException, IOException {
		Navigation.acessarPagina();
		Navigation.realizarPesquisa("Automação de Testes Selenium");
	}
}
