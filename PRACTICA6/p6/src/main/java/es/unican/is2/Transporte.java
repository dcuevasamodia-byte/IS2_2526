package es.unican.is2;

/* Clase que representa un transporte realizado por un conductor */
public class Transporte {
	
	private double horas;
	private int ton;
	private int personas;
	private CategoriaTransporte cat;
	
	// WMC: 5, CCog: 4
	public Transporte(double horas, CategoriaTransporte cat, int valor) throws IllegalArgumentException {
		// WMC: +1 + 2, CCog: +1, +1
		if (horas <= 0 || valor <= 0 || cat == null) {
			throw new IllegalArgumentException();
		}
		this.horas = horas;
		this.cat = cat;
		if (cat.equals(CategoriaTransporte.Personas)) { // WMC: +1, CCog: +1
			this.personas = valor;
		} else  { //CCog: +1 
			this.ton = valor;
		}
	}
	
	// WMC: 1 
	public double horas() {
		return horas;
	}

	// WMC: 1 
	public CategoriaTransporte categoria() {
		return cat;
	}

	// WMC: 1 
	public int ton() {
		return ton;
	}

	// WMC: 1 
	public int getPersonas() {
		return personas;
	}
	
}
