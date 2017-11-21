package Chrome;

import java.awt.AWTException;
import java.io.IOException;
import br.com.tutorialselenium.pdf.Login;

public class ExecuteAutomation {

	Login log = new Login();
	public static void main(String[] args) throws AWTException, IOException {
		Navigation.acessarPagina();
		Navigation.realizarPesquisa(Login.user, Login.pass);
	}
}
