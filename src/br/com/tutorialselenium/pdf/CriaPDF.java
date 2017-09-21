package br.com.tutorialselenium.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CriaPDF {

	public static Document CriaPDF(File dir2) throws Throwable {
		Document doc = new Document();
		OutputStream os = new FileOutputStream(dir2 + ".pdf");
		PdfWriter.getInstance(doc, os);
		doc.open();
		return doc;
	}

	public static void addCabecalhoPDF(Document doc, String nomeCT) throws DocumentException {
		Calendar date = new GregorianCalendar();

		Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

		String usuarioLogado;
		usuarioLogado = System.getProperty("user.name");

		Font alterarFonte = new com.itextpdf.text.Font(FontFamily.COURIER, 12, Font.BOLD);
		alterarFonte.setColor(BaseColor.BLUE);

		PdfPTable tableheader = new PdfPTable(new float[] { 0.15f, 0.35f, 0.13f, 0.37f });

		PdfPCell header = new PdfPCell(new Paragraph("Evidencias de Teste", alterarFonte));
		header.setUseBorderPadding(true);
		header.setBorderColor(BaseColor.BLUE);
		header.setHorizontalAlignment(Element.ALIGN_CENTER);
		header.setColspan(4);
		tableheader.setSpacingBefore(20);

		tableheader.addCell(header);

		PdfPCell lblSistema = new PdfPCell(new Paragraph("Sistema"));
		PdfPCell txtSistema = new PdfPCell(new Paragraph("Bring My Beer"));
		PdfPCell lblVersao = new PdfPCell(new Paragraph("Versão"));
		PdfPCell txtVersao = new PdfPCell(new Paragraph("V1"));
		PdfPCell lblCT = new PdfPCell(new Paragraph("Cenário de Teste"));
		PdfPCell txtCT = new PdfPCell(new Paragraph("CT.XXX.001"));
		PdfPCell lblExecutor = new PdfPCell(new Paragraph("Executor"));
		PdfPCell txtExecutor = new PdfPCell(new Paragraph(usuarioLogado));
		PdfPCell lblData = new PdfPCell(new Paragraph("Data"));
		PdfPCell txtData = new PdfPCell(new Paragraph(date.getCalendarType()));

		lblSistema.setBorderColor(BaseColor.BLUE);
		lblSistema.setHorizontalAlignment(Element.ALIGN_TOP);
		txtSistema.setBorderColor(BaseColor.BLUE);

		lblVersao.setBorderColor(BaseColor.BLUE);
		lblVersao.setHorizontalAlignment(Element.ALIGN_TOP);
		txtVersao.setBorderColor(BaseColor.BLUE);

		lblCT.setBorderColor(BaseColor.BLUE);
		lblCT.setHorizontalAlignment(Element.ALIGN_TOP);
		txtCT.setBorderColor(BaseColor.BLUE);

		lblExecutor.setBorderColor(BaseColor.BLUE);
		lblExecutor.setHorizontalAlignment(Element.ALIGN_TOP);
		txtExecutor.setBorderColor(BaseColor.BLUE);

		lblData.setBorderColor(BaseColor.BLUE);
		lblData.setHorizontalAlignment(Element.ALIGN_TOP);
		txtData.setBorderColor(BaseColor.BLUE);

		txtCT.setColspan(3);

		tableheader.addCell(lblSistema);
		tableheader.addCell(txtSistema);
		tableheader.addCell(lblVersao);
		tableheader.addCell(txtVersao);
		tableheader.addCell(lblCT);
		tableheader.addCell(txtCT);
		tableheader.addCell(lblExecutor);
		tableheader.addCell(txtExecutor);
		tableheader.addCell(lblData);
		tableheader.addCell(txtData);
		tableheader.setSpacingAfter(20);

		doc.add(tableheader);
	}

}
