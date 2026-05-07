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
	
	// WMC = 2 (1 base + 1 if)
	// CCog = 2 (1 por el primer if + 1 por el if del enum)
	public Transporte(double horas, CategoriaTransporte cat, int valor) throws IllegalArgumentException {
		if (horas <= 0 || valor <= 0 || cat == null) {
			throw new IllegalArgumentException();
		}
		this.horas = horas;
		this.cat = cat;
		
		// Refactor: Uso de '==' en vez de .equals para Enums
		if (cat == CategoriaTransporte.Personas) {
			this.personas = valor;
		} else  {
			this.ton = valor;
		}
	}
	
	// Refactor: Nombres estandarizados a getters
	// WMC = 1, CCog = 0
	public double getHoras() {
		return horas;
	}

	// WMC = 1, CCog = 0
	public CategoriaTransporte getCategoria() {
		return cat;
	}

	// WMC = 1, CCog = 0
	public int getTon() {
		return ton;
	}

	// WMC = 1, CCog = 0
	public int getPersonas() {
		return personas;
	}
}