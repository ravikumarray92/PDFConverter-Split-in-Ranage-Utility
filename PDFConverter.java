package com.pdf.converter;
public class PDFConverter  {

	public static void main(String[] args)  {

		System.loadLibrary("gsdll64");
		
		ConversionUtility conv = new ConversionUtility();
		conv.convertPsToPDF();
		/*
		FileChooser fileChooser = new FileChooser();
		fileChooser.renderFileChooser();*/
		
		
				
		
		
		
		
		
		
		
	
	}
}
