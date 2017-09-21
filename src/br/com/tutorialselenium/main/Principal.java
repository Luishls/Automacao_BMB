package br.com.tutorialselenium.main;

import java.io.File;

import com.itextpdf.text.Document;

import br.com.tutorialselenium.pdf.CriaPDF;

public class Principal {
	public static void main(String[] args) throws Throwable{
		File dir2 = new File("C://Users//Luis Henrique Lima//Desktop//Evidencias De Teste");
		dir2.mkdir();
		
		Document doc = CriaPDF.CriaPDF(dir2);
		CriaPDF.addCabecalhoPDF(doc, "");
		doc.close();
		System.exit(0);
	}
}
