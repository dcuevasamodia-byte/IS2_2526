import java.util.ArrayList;

/**
 * Clase que representa a un conductor, con sus datos personales
 * y los transportes que ha realizado. 
 * 
 * WMC Total = 14 (1 por cada método simple + complejidad de los ifs/bucles)
 * CCog Total = 7 (Por los anidamientos en el constructor y en el método sueldo)
 */
public class Conductor {

	private ArrayList<Transporte> transportes = new ArrayList<Transporte>();
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String direccion; // Refactor: dire -> direccion

	// WMC = 2 (1 base + 1 por la condición compuesta)
	// CCog = 1 (1 por el if)
	public Conductor(String dni, String nombre, String apellido1,
			String apellido2, String direccion) {
		if (dni == null || nombre == null || apellido1 == null || direccion == null) {
			throw new IllegalArgumentException();
		}
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.direccion = direccion;
	}

	// WMC = 1, CCog = 0
	public String getDni() {
		return dni;
	}

	// WMC = 1, CCog = 0
	public String getNombre() {
		return nombre;
	}

	// WMC = 1, CCog = 0
	public String getApellido1() {
		return apellido1;
	}

	// Refactor: añadido 'get' al nombre del método
	// WMC = 1, CCog = 0
	public String getApellido2() {
		return apellido2;
	}

	// WMC = 1, CCog = 0
	public String getDireccion() {
		return direccion;
	}

	// WMC = 6 (1 base + 1 for + 3 cases + 1 if)
	// CCog = 6 (1 for + 2 switch anidado + 3 if anidado)
	public double sueldo() {
		double sueldoTransportes = 0;
		for (Transporte t : transportes) { // +1 CCog
			double sueldoExtraTransporte = 0.0;
			switch (t.getCategoria()) { // +2 CCog (Switch anidado nivel 1)
				case Mercancias:
					sueldoExtraTransporte = t.getTon() * 2;
					break;
				case MercanciasPeligrosas:
					sueldoExtraTransporte = t.getTon() * 2 + 50;
					break;
				case Personas:
					if (t.getPersonas() < 10) // +3 CCog (If anidado nivel 2)
						sueldoExtraTransporte = t.getHoras() * 0.5;
					else
						sueldoExtraTransporte = t.getHoras();
					break;
			}
			sueldoTransportes += t.getHoras() * 5 + sueldoExtraTransporte;
		}
		return 700 + sueldoTransportes;
	}

	// WMC = 1, CCog = 0
	public void anhadeTransporte(Transporte t) {
		transportes.add(t);
	}
}