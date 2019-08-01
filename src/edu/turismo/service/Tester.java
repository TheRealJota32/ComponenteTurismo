package edu.turismo.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.util.List;

import edu.turismo.model.LugarTuristico;

public class Tester {

	public static void main(String[] args) {

		TurismoLugares turismoLugares = new TurismoLugares();

		List<LugarTuristico> lugares = turismoLugares.getLugaresTuristicos("Pais1");
		if ((lugares != null) && !lugares.isEmpty()) {
			for (LugarTuristico l : lugares) {
				System.out.println(l.getId() + " | " + l.getNombre() + " | " + l.getCiudad().getNombre());
			}
			// uploadTest(lugares.get(0));
			// downloadTest(lugares.get(0));
		} else {
			System.out.println("Empty!");
		}

//		TurismoLugares tl = new TurismoLugares();
//		List<LugarTuristico> lugares = tl.getLugaresTuristicos("Costa Rica");
//		if ((lugares != null) && !lugares.isEmpty()) {
//			for (LugarTuristico l : lugares) {
//				System.out.println(l.getId() + " | " + l.getNombre() + " | " + l.getCiudad().getNombre());
//			}
//		} else {
//			System.out.println("Empty!");
//		}
//
//		tl.agregarlugares("Costa Rica", "Guanacaste", "Hotel Riu", "12");
//		tl.agregarLugarConPais(1, "Cartago", "Ruinas", "123");
//		tl.agregarLugarConCiudad(6, "Castillo Country Club", "1234");

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
