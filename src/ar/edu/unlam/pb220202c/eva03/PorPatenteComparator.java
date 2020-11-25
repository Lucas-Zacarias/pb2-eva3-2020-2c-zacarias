package ar.edu.unlam.pb220202c.eva03;

import java.util.Comparator;

public class PorPatenteComparator implements Comparator<Vehiculo>{

	@Override
	public int compare(Vehiculo o1, Vehiculo o2) {
		// TODO Auto-generated method stub
		return o1.getPatente().compareTo(o2.getPatente());
	}

}
