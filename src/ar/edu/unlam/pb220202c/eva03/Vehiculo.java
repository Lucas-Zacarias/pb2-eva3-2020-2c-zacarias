package ar.edu.unlam.pb220202c.eva03;

public abstract class Vehiculo implements Imultable{

	//Se debe crear contructeres getters y Setters y loos que crean convenientes
	private String patente;
	private Integer velocidadActual;
	private Integer limiteVelocidad;

	
	public void incrementarVelocidad(Integer Velocidad) {
		
	}


	public Vehiculo(String patente, Integer velocidadActual, Integer limiteVelocidad) {
		this.patente = patente;
		this.velocidadActual = velocidadActual;
		this.limiteVelocidad = limiteVelocidad;
	}


	public String getPatente() {
		return patente;
	}


	public void setPatente(String patente) {
		this.patente = patente;
	}


	public Integer getVelocidadActual() {
		return velocidadActual;
	}


	public void setVelocidadActual(Integer velocidadActual) {
		this.velocidadActual = velocidadActual;
	}


	public Integer getLimiteVelocidad() {
		return limiteVelocidad;
	}


	public void setLimiteVelocidad(Integer limiteVelocidad) {
		this.limiteVelocidad = limiteVelocidad;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((patente == null) ? 0 : patente.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Vehiculo))
			return false;
		Vehiculo other = (Vehiculo) obj;
		if (patente == null) {
			if (other.patente != null)
				return false;
		} else if (!patente.equals(other.patente))
			return false;
		return true;
	}


	@Override
	public abstract Boolean enInfraccion();



}
