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
	private String direccion; 

	// WMC: 5, CCog: 2
	public Conductor(String dni, String nombre, String apellido1,
			String apellido2, String direccion) {
		// WMC: +1, +3, CCog: +1, +1 
		if (dni == null || nombre == null || apellido1 == null || direccion == null) {
			throw new IllegalArgumentException();
		}
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.direccion = direccion;
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
	public String getApellido2() {
		return apellido2;
	}

	// WMC: 1
	public String getDireccion() {
		return direccion;
	}

	// WMC: 6, CCog: 7
	public double sueldo() {
		double sueldoTransportes = 0;
		// WMC: +1, CCog: +1 
		for (Transporte t : transportes) { 
			double sueldoExtraTransporte = 0.0;
			// CCog: +2
			switch (t.getCategoria()) { 
				case Mercancias: // WMC: +1
					sueldoExtraTransporte = t.getTon() * 2;
					break;
				case MercanciasPeligrosas: // WMC: +1
					sueldoExtraTransporte = t.getTon() * 2 + 50;
					break;
				case Personas: // WMC: +1
					// WMC: +1, CCog: +3 
					if (t.getPersonas() < 10) 
						sueldoExtraTransporte = t.getHoras() * 0.5;
					else // CCog: +1
						sueldoExtraTransporte = t.getHoras();
					break;
			}
			sueldoTransportes += t.getHoras() * 5 + sueldoExtraTransporte;
		}
		return 700 + sueldoTransportes;
	}

	// WMC: 1
	public void anhadeTransporte(Transporte t) {
		transportes.add(t);
	}
}