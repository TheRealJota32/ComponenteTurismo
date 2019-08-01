package edu.turismo.service;

import edu.turismo.model.LugarTuristico;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.util.List;

public class Tester {

	public static void main(String[] args) {
		List<LugarTuristico> lugares = TurismoLugares.getLugaresTuristicos("Pais1");
		if ((lugares != null) && !lugares.isEmpty()) {
			for (LugarTuristico l : lugares) {
				System.out.println(l.getId() + " | " + l.getNombre() + " | " + l.getCiudad().getNombre());
			}
			//uploadTest(lugares.get(0));
			downloadTest(lugares.get(0));
		} else {
			System.out.println("Empty!");
		}
	}
	
	private static void uploadTest(LugarTuristico lugarTuristico) {
		try {
			GoogleDriveService.uploadImage(lugarTuristico, new File("/home/diego/Desktop/test2.jpeg"));
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void downloadTest(LugarTuristico lugarTuristico) {
		try {
			InputStream inputStream = GoogleDriveService.getImage(lugarTuristico);
			OutputStream outputStream = new FileOutputStream("/home/diego/Desktop/DownloadTest.jpeg");
			inputStream.transferTo(outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
	}

}
