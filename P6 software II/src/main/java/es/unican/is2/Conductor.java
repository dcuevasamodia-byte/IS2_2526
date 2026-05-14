package es.unican.is2;

import java.util.ArrayList;

/**
 * Clase que representa a un conductor, con sus datos personales
 * y los transportes que ha realizado. 
 */
public class Conductor {

	private ArrayList<Transporte> transportes = new ArrayList<Transporte>();
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String dire;

	// WMC: 2, CCog: 1
	public Conductor(String dni, String nombre, String apellido1,
			String apellido2, String direccion) {
		// WMC: +1, CCog: +1
		if (dni == null || nombre == null || apellido1 == null || direccion == null) {
			throw new IllegalArgumentException();
		}
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dire = direccion;
	}

	// WMC: 1 
	public String dni() {
		return dni;
	}

	// WMC: 1 
	public String getDni() {
		return dni;
	}

	// WMC: 1 
	public String getNombre() {
		return nombre;
	}

	// WMC: 1 
	public String getApellido1() {
		return apellido1;
	}

	// WMC: 1
	public String apellido2() {
		return apellido2;
	}

	// WMC: 1
	public String getDire() {
		return dire;
	}

	// WMC: 6, CCog: 12
	public double sueldo() {
		double sueldoTransportes = 0;
		for (Transporte t : transportes) { // WMC: +1, CCog: +1
			double sueldoExtraTransporte = 0.0;
			switch (t.categoria()) { //CCog: +1
				case Mercancias: // WMC: +1, CCog: +1 
					sueldoExtraTransporte = t.ton() * 2;
					break;
				case MercanciasPeligrosas: // WMC: +1, CCog: +1
					sueldoExtraTransporte = t.ton() * 2 + 50;
					break;
				case Personas: // WMC: +1, CCog: +1 
					if (t.getPersonas() < 10) // WMC: +1, CCog: +2 
						sueldoExtraTransporte = t.horas() * 0.5;
					else //CCog: +1 
						sueldoExtraTransporte = t.horas();
					break;
			}
			sueldoTransportes += t.horas() * 5 + sueldoExtraTransporte;
		}
		return 700 + sueldoTransportes;
	}

	// WMC: 1
	public void anhadeTransporte(Transporte t) {
		transportes.add(t);
	}

}