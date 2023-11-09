package com.springboot.pdf.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.springboot.pdf.domain.Product;

@RestController
public class ProductRestController {

	//@Autowired
	//private ProductRepository repository;

	@GetMapping("/report/product/")
	public ResponseEntity<Resource> generateExcelReport() throws IOException, DocumentException {
		//List<Product> products = repository.findAll();

		Document document = new Document(PageSize.A4.rotate() );
		
		List<Product> products = new ArrayList<>();
		products.add(new Product(339, "harish",3.66,5.1,22,"dpd","1"));
		products.add(new Product(338, "subbu",3.66,5.1,22,"kkt","2"));
		products.add(new Product(340, "mohan",3.66,5.1,22,"ylm","3"));
		products.add(new Product(334, "rama",3.66,5.1,22,"kgm","4"));
		products.add(new Product(335, "chiru",3.66,5.1,22,"kmv","5"));

		
		ByteArrayOutputStream os = new ByteArrayOutputStream();

		PdfWriter.getInstance(document, os);

		document.open();

		
		
		 Font largeBold = new Font(Font.FontFamily.COURIER, 32,
                 Font.BOLD);
         Font smallBold = new Font(Font.FontFamily.HELVETICA, 10,
                 Font.BOLD);
         Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
                 Font.ITALIC | Font.UNDERLINE, BaseColor.RED);

         // Creates chunk, phrase and paragraph with font
         // information.
         Chunk chunk = new Chunk("smart Pharma", largeBold);
         Phrase phrase =
                 new Phrase("Building The Future Pharma ", smallBold);
         Paragraph paragraph =
                 new Paragraph("", redFont);

         document.add(chunk);
         document.add(phrase);
         document.add(paragraph);
		

//		Product product1 = new Product();
//		
//		Paragraph p1;
//        p1 = new Paragraph(Element.ALIGN_LEFT , "ALARIC ENTERPRISES" + 
//        		"H.NO 16-11-20/7/A/2, TO 5/101,1ST FLOOR" + 
//        		"CHINNA BALAPPA COMPLEX,SALEEM NAGARCOLONY, MALAKPET" + 
//        		"HYDERABAD - 500036" + 
//        		"(L): 9989011088 - (@): raj@alaric.in,hyderabad@alaric.in,adil@alaric.in" + 
//        		"D.L.No. TS/HYD/2020-68381, TS/HYD/2020-68381" + 
//        		"GSTIN: 36AAVFA6895N1ZA",  FontFactory.getFont(FontFactory.HELVETICA, 6, Font.BOLD, new BaseColor(20, 255, 255)));
//        
//        p1 = new Paragraph(Element.ALIGN_LEFT , "To: UNIMED HEALTH CARE PRIVATE LTD" + 
//        		"8-2-596/5,BANJARAHILLS,HYDERABAD" + 
//        		" " + 
//        		"HYDERABAD (P): 040-44777777" + 
//        		"D.L.Nos: 261/HD/AP/2008/W, 261/HD/AP/2008/W" + 
//        		"GSTIN: 36AAACU8638B1ZD " + " " + "Kondapur", FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new BaseColor(150, 255, 255)));

        
//        document.add(p1);
//        p1 = new Paragraph(String.valueOf(product1.getName()));
//        p1.setAlignment(Element.ALIGN_RIGHT);
//        document.add(p1);
        
        PdfPTable headerTable = new PdfPTable(3);
		headerTable.setSpacingBefore(30);
		headerTable.setSpacingAfter(30);
		
		headerTable.setTotalWidth(2500);

		
PdfPCell a1 = new PdfPCell(new Phrase("ALARIC ENTERPRISES\n" + 
		"H.NO 16-11-20/7/A/2, TO 5/101,1ST FLOOR,\n" + 
		"CHINNA BALAPPA COMPLEX,SALEEM NAGARCOLONY,MALAKPET\n" + 
		"HYDERABAD - 500036\n" + 
		"(L): 9989011088 - (@): raj@alaric.in,hyderabad@alaric.in,adil@alaric.in\n" + 
		"D.L.No. TS/HYD/2020-68381, TS/HYD/2020-68381\n" + 
		"GSTIN: 36AAVFA6895N1ZA", smallBold));	
headerTable.addCell(a1);
headerTable.getSpacingAfter();

PdfPCell a2 = new PdfPCell(new Phrase (" "));
headerTable.setSplitRows(true);
headerTable.addCell(a2);
headerTable.getSpacingAfter();

PdfPCell a3 = new PdfPCell(new Phrase("To: UNIMED HEALTH CARE PRIVATE LTD\\n\" + \n" + 
		"		\"8-2-596/5,BANJARAHILLS,HYDERABAD\\n\" + \n" + 
		"		\".\\n\" + \n" + 
		"		\"HYDERABAD (P): 040-44777777\\n\" + \n" + 
		"		\"D.L.Nos: 261/HD/AP/2008/W, 261/HD/AP/2008/W\\n\" + \n" + 
		"		\"GSTIN: 36AAACU8638B1ZD\"", smallBold));
headerTable.addCell(a3);
headerTable.getSpacingAfter();

        
		Paragraph title = new Paragraph("Sales Information for Products",
				FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new BaseColor(54, 54, 54)));

		document.add(title);
		document.add(headerTable);
     
//		Font fontH1 = new Font(Currier, 12, Font.NORMAL);
//
//		PdfPTable table = new PdfPTable(1);
//
//		table.addCell(new PdfPCell(new Phrase(yourDatabaseValue,fontH1)));
		
		
		BaseFont bf = BaseFont.createFont(
                BaseFont.HELVETICA_BOLD,
                BaseFont.CP1252,
                BaseFont.EMBEDDED);
        Font font = new Font(bf, 9);
        
        
        BaseFont b2 = BaseFont.createFont(
                BaseFont.HELVETICA,
                BaseFont.CP1252,
                BaseFont.EMBEDDED);
        Font font2 = new Font(b2, 8);
        
		
		PdfPTable table = new PdfPTable(14);
		table.setSpacingBefore(25);
		table.setSpacingAfter(25);
		
	
		
		PdfPCell c1 = new PdfPCell(new Phrase("HNS CODE", font));
		table.addCell(c1);

		PdfPCell c2 = new PdfPCell(new Phrase("MFG", font));
		table.addCell(c2);

		PdfPCell c3 = new PdfPCell(new Phrase("PRODUCT NAME",font));
		table.addCell(c3);

		PdfPCell c4 = new PdfPCell(new Phrase("PACK ", font));
		table.addCell(c4);

		PdfPCell c5 = new PdfPCell(new Phrase("BATCH NO ", font));
		table.addCell(c5);

		PdfPCell c6 = new PdfPCell(new Phrase("EXPIRY", font));
		table.addCell(c6);
		
		
		PdfPCell c7 = new PdfPCell(new Phrase("QTY", font));
		table.addCell(c7);

		PdfPCell c8 = new PdfPCell(new Phrase("RATE", font));
		table.addCell(c8);

		PdfPCell c9 = new PdfPCell(new Phrase("AMOUNT", font));
		table.addCell(c9);

		PdfPCell c10 = new PdfPCell(new Phrase("MRP", font));
		table.addCell(c10);

		PdfPCell c11 = new PdfPCell(new Phrase("DISC %", font));
		table.addCell(c11);

		PdfPCell c12 = new PdfPCell(new Phrase("GST %", font) );
		table.addCell(c12);


		for (Product product : products) {
			
			table.addCell(new PdfPCell(new Phrase(product.getId() )));
			table.addCell(new PdfPCell(new Phrase(product.getName(),font2)));
			table.addCell(new PdfPCell(new Phrase(product.getSalesCount())));
			table.addCell(new PdfPCell(new Phrase(product.getSaleDate(),font2)));
			table.addCell(String.valueOf(product.getPrice()));
			table.addCell(String.valueOf(product.getSalePrice()));		}

		
		

		PdfPTable footertable = new PdfPTable(9);
		footertable.setSpacingBefore(25);
		footertable.setSpacingAfter(25);
		
		
		
		PdfPCell d1 = new PdfPCell(new Phrase("HNS CODE", font));
		footertable.addCell(d1);

		PdfPCell d2 = new PdfPCell(new Phrase("MFG", font));
		footertable.addCell(d2);

		PdfPCell d3 = new PdfPCell(new Phrase("PRODUCT NAME", font));
		footertable.addCell(d3);

		PdfPCell d4 = new PdfPCell(new Phrase("PACK ", font));
		footertable.addCell(d4);

		PdfPCell d5 = new PdfPCell(new Phrase("BATCH NO ", font));
		footertable.addCell(d5);

		PdfPCell d6 = new PdfPCell(new Phrase("EXPIRY", font));
		footertable.addCell(d6);
		
		
		PdfPCell d7 = new PdfPCell(new Phrase("QTY", font));
		footertable.addCell(d7);

		PdfPCell d8 = new PdfPCell(new Phrase("RATE", font));
		footertable.addCell(d8);

		PdfPCell d9 = new PdfPCell(new Phrase("AMOUNT", font));
		footertable.addCell(d9);
		
		
		
		document.add(table);
		
		
		document.add(footertable);
		
		document.close();

		ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=ProductPdfReport.pdf");

		ResponseEntity<Resource> response = new ResponseEntity<Resource>(new InputStreamResource(is), headers,
				HttpStatus.OK);

		return response;
	}
	
	
	
	

}