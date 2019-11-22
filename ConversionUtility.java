package com.pdf.converter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.ghost4j.converter.ConverterException;
import org.ghost4j.document.DocumentException;
import org.ghost4j.document.PSDocument;

import com.spire.pdf.PdfDocument;

public class ConversionUtility {

	void convertPsToPDF() {
		PSDocument document = new PSDocument();
		try {
			document.load(new File("C:\\Users\\RAVI\\Downloads\\sample.ps"));
		} catch (IOException ioexception) {

			ioexception.printStackTrace();
		}

		// create OutputStream
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File("C:\\Users\\RAVI\\Downloads\\rendition.pdf"));
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		}

		// create converter
		org.ghost4j.converter.PDFConverter converter = new org.ghost4j.converter.PDFConverter();

		// set options
		converter.setPDFSettings(org.ghost4j.converter.PDFConverter.OPTION_PDFSETTINGS_PREPRESS);

		// convert
		try {
			converter.convert(document, fos);
			splitPDFInRange(0, 1, "C:\\Users\\RAVI\\Downloads\\rendition.pdf");
		} catch (IOException | ConverterException | DocumentException e) {
			e.printStackTrace();

		}

	}

	public void splitPDFInRange(int start, int end, String inputFile) {
		String outputDirectory = "C:\\Users\\RAVI\\Downloads\\Output\\";

		// create a PdfDocument instance
		PdfDocument sourceDoc = new PdfDocument();

		// load a source PDF file
		sourceDoc.loadFromFile(inputFile);

		// create two extra PdfDocument objects
		PdfDocument newDoc = new PdfDocument();

		// insert the rest pages from source file to the second new PDF document
		newDoc.insertPageRange(sourceDoc, start, end);
		newDoc.saveToFile(outputDirectory + "Split.pdf");

	}

}
