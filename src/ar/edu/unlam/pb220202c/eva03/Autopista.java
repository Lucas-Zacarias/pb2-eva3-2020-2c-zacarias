package ar.edu.unlam.pb220202c.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Autopista{
	//Si es necesario Utilice herencia o implemente de Interfaces
	//Se debe crear contructeres getters y Setters y los atributos o metodos que crean convenientes
	private HashMap <Integer,Vehiculo> telepase;
	private HashSet <Vehiculo> vehiculosEnCirculacion;
	
	public Autopista() {
		this.telepase = new HashMap<Integer, Vehiculo>();
		this.vehiculosEnCirculacion = new HashSet<Vehiculo>();
	}
	
	public Boolean registrarTelepase (Integer numeroTelpase, Vehiculo vehiculo) {
		Boolean registroExitoso = false;
		if(vehiculo != null) {
			this.telepase.put(numeroTelpase, vehiculo);
			this.vehiculosEnCirculacion.add(vehiculo);
			registroExitoso = true;
		}
		return registroExitoso;
	}
	public Boolean ingresarAutopista (Integer numeroTelepase) throws VehiculoNotFounException {
		//si el telepase no esta registrado lanza una Exceptios del tipo VehiculoNotFounException
	   // y no permite ingresar al autopista
		
		Boolean ingresoExitoso = true;
		if(this.telepase.containsKey(numeroTelepase) == false ) {
			ingresoExitoso = false;
			throw new VehiculoNotFounException();
		}
		
		return ingresoExitoso;
	}
	
	public void salirAutopista (Vehiculo vehiculo) throws VehiculoNotFounException {
		//lanza Una exception VehiculoNotFounException si no esta en circulacion
		
		if(this.vehiculosEnCirculacion.contains(vehiculo) == false) {
			throw new VehiculoNotFounException();
		}
		this.vehiculosEnCirculacion.remove(vehiculo);
	}
	
	public TreeSet<Vehiculo> obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente(){
		TreeSet<Vehiculo> vehiculosConExcesoDeVelocidadOrdenadosPorPatente = new TreeSet<Vehiculo>(new PorPatenteComparator());
		for (Vehiculo vehiculo : this.vehiculosEnCirculacion) {
			if(vehiculo.enInfraccion()) {
				vehiculosConExcesoDeVelocidadOrdenadosPorPatente.add(vehiculo);
			}
		}
	return vehiculosConExcesoDeVelocidadOrdenadosPorPatente;
    }

	public Integer cantidadDeVehiculosENCirculacion() {
	
		return this.vehiculosEnCirculacion.size();
}

	public HashMap<Integer, Vehiculo> getTelepase() {
		return telepase;
	}

	public void setTelepase(HashMap<Integer, Vehiculo> telepase) {
		this.telepase = telepase;
	}

	public HashSet<Vehiculo> getVehiculosEnCirculacion() {
		return vehiculosEnCirculacion;
	}

	public void setVehiculosEnCirculacion(HashSet<Vehiculo> vehiculosEnCirculacion) {
		this.vehiculosEnCirculacion = vehiculosEnCirculacion;
	}

	
	}
