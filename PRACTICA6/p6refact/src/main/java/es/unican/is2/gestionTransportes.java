import java.util.ArrayList;
import java.util.List;

/**
 * WMC Total = 6
 * CCog Total = 4
 */
public class GestionTransportes { // Refactor: Primera letra en mayúscula

	private ArrayList<Conductor> listaConductores = new ArrayList<Conductor>(); // Refactor: cs -> listaConductores
	
	// WMC = 3 (1 base + 1 for + 1 if)
	// CCog = 3 (1 for + 2 if anidado)
	public Conductor buscaConductor(String DNI) {		
		for(Conductor c: listaConductores) 
			if (c.getDni().equals(DNI)) // Refactor: adaptado al nuevo getter
				return c;
		
		return null;
	}
	
	// WMC = 2 (1 base + 1 if)
	// CCog = 1 (1 if)
	public boolean anhadeConductor(String dni, String nombre, String apellido1, String apellido2, String direccion) {
		if (buscaConductor(dni) != null)
			return false;
		listaConductores.add(new Conductor(dni, nombre, apellido1, apellido2, direccion));
		return true;
	}

	// WMC = 1, CCog = 0
	public List<Conductor> getConductores() { // Refactor: Renombrado a getConductores
		// Refactor: Devolver copia para proteger el encapsulamiento
		return new ArrayList<>(listaConductores); 
	}
	
}