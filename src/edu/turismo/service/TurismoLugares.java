package edu.turismo.service;

import java.util.HashSet;

import edu.turismo.model.Ciudad;
import edu.turismo.model.LugarTuristico;
import edu.turismo.model.Pais;

public class TurismoLugares {
	private static Conector ch = new Conector();

	public static void agregarlugares(String nombrePais, String nombreCiudad, String nombreTuris, String cordenadas) {

		try {
			ch.startEntityManagerFactory();
			Pais pais = new Pais();
			pais.setNombre(nombrePais);
			pais.setCiudades(new HashSet<Ciudad>());

			Ciudad ciudad = new Ciudad();
			ciudad.setNombre(nombreCiudad);
			ciudad.setPais(pais);
			ciudad.setLugares(new HashSet<LugarTuristico>());

			LugarTuristico lugarTuristico = new LugarTuristico();
			lugarTuristico.setCiudad(ciudad);
			lugarTuristico.setNombre(nombreTuris);
			lugarTuristico.setGeoCorde(cordenadas);

			pais.getCiudades().add(ciudad);

			ciudad.getLugares().add(lugarTuristico);

			ch.getEm().getTransaction().begin();
			ch.getEm().persist(pais);
			ch.getEm().persist(ciudad);
			ch.getEm().flush();
			ch.getEm().getTransaction().commit();
			ch.stopEntityManagerFactory();
			System.out.println("Finalizo");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void borrarLugarTuristico(int id) {
		LugarTuristico lt = null;
		try {
			ch.startEntityManagerFactory();
			ch.getEm().getTransaction().begin();
			lt = ch.getEm().find(LugarTuristico.class, id);

			ch.getEm().remove(lt);
			ch.getEm().flush();
			ch.getEm().getTransaction().commit();
			ch.stopEntityManagerFactory();
			System.out.println("Finalizo");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void modificarLugarTuristico(int id, String nombre) {
		LugarTuristico lt = null;
		try {
			ch.startEntityManagerFactory();
			ch.getEm().getTransaction().begin();
			lt = ch.getEm().find(LugarTuristico.class, id);
			lt.setNombre(nombre);

			ch.getEm().persist(lt);
			ch.getEm().flush();
			ch.getEm().getTransaction().commit();

			ch.stopEntityManagerFactory();
			System.out.println("Finalizo");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
