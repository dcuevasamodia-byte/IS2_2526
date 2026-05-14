package es.unican.is2;

/**
 * Clase que representa un transporte realizado por un conductor 
 * 
 * WMC Total = 6 (2 del constructor + 4 getters simples)
 * CCog Total = 2 (2 ifs en el constructor)
 */
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
		
		// WMC: +1, CCog: +1
		if (cat == CategoriaTransporte.Personas) {
			this.personas = valor;
		} else  { //CCog: +1
			this.ton = valor;
		}
	}
	
	// WMC = 1
	public double getHoras() {
		return horas;
	}

	// WMC = 1
	public CategoriaTransporte getCategoria() {
		return cat;
	}

	// WMC = 1
	public int getTon() {
		return ton;
	}

	// WMC = 1
	public int getPersonas() {
		return personas;
	}
}