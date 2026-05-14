package es.unican.is2;

import java.util.ArrayList;
import java.util.List;

/**
 * WMC Total = 6
 * CCog Total = 6
 */
public class GestionTransportes { 

	private ArrayList<Conductor> listaConductores = new ArrayList<Conductor>(); 
	
	// WMC: 3, CCog: 3
	public Conductor buscaConductor(String DNI) {		
		for(Conductor c: listaConductores) // WMC: +1, CCog: +1
			if (c.getDni().equals(DNI)) // WMC: +1, CCog: +2 
				return c;
		
		return null;
	}
	
	// WMC: 2, CCog: 1
	public boolean anhadeConductor(String dni, String nombre, String apellido1, String apellido2, String direccion) {
		if (buscaConductor(dni) != null) // WMC: +1, CCog: +1
			return false;
		listaConductores.add(new Conductor(dni, nombre, apellido1, apellido2, direccion));
		return true;
	}

	// WMC: 1
	public List<Conductor> getConductores() { 
		
		return new ArrayList<>(listaConductores); 
	}
	
}