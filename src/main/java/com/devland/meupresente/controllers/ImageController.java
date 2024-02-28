package com.devland.meupresente.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class ImageController {

	
	public byte[] saveImage(String arquivo) {
		File fileImg = new File(arquivo);
		byte[] byteImage = new byte[(int) fileImg.length()];
		try {
			FileInputStream fileInputStream = new FileInputStream(fileImg);
			fileInputStream.read(byteImage);
			fileInputStream.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return byteImage;
	}
	/*
	public void testSaveBook() {
		
		//File file = new File("images\\extjsfirstlook.jpg"); //windows
		File file = new File("images/extjsfirstlook.jpg");
        byte[] bFile = new byte[(int) file.length()];
        
        try {
	        FileInputStream fileInputStream = new FileInputStream(file);
	        fileInputStream.read(bFile);
	        fileInputStream.close();
        } catch (Exception e) {
	        e.printStackTrace();
        }
        
        Book book = new Book();
        book.setName("Ext JS 4 First Look");
        book.setImage(bFile);
        
        bookDAO.saveBook(book);
        
        assertNotNull(book.getId());
	}
	*/
	
}
