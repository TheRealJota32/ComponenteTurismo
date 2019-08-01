package edu.turismo.service;

import edu.turismo.model.LugarTuristico;

import java.util.List;

public class Tester {

	public static void main(String[] args) {
		List<LugarTuristico> lugares = TurismoLugares.getLugaresTuristicos("Pais1");
		if ((lugares != null) && !lugares.isEmpty()) {
			for (LugarTuristico l : lugares) {
				System.out.println(l.getId() + " | " + l.getNombre() + " | " + l.getCiudad().getNombre());
			}
		} else {
			System.out.println("Empty!");
		}
	}

}
