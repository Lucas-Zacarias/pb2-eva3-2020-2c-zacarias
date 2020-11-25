package ar.edu.unlam.pb220202c.eva03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.TreeSet;

import org.junit.Test;

public class TestAutoPista {
	
	@Test
	public void queSePuedaRegistrarTelepase () {
		Vehiculo auto = new Automovil("123abc", 100, 130);
		Integer nroTelepase = 1;
		Autopista autopista = new Autopista();
		
		Boolean resultado = autopista.registrarTelepase(nroTelepase, auto);
		
		assertTrue(resultado);
	
	}
	@Test(expected = VehiculoNotFounException.class)
	public void queAlSalirDelAutopistaNoestaEncirculacionLanceUnaExcepcion() throws VehiculoNotFounException {
		Vehiculo auto = new Automovil("123abc", 100, 130);
		Integer nroTelepase = 1;
		Autopista autopista = new Autopista();
		
		autopista.registrarTelepase(nroTelepase, auto);
		
		autopista.salirAutopista(auto);
	}
	 @Test
	public void queVerifiqueQueSeObtengaUnaListaDeAutosInsfractoresOrdenadaPorPatente(){
		Vehiculo auto1 = new Automovil("456abc", 150, 130);
		Vehiculo auto2 = new Automovil("123abc", 140, 130);
		Vehiculo auto3 = new Automovil("012cdf", 140, 130); 
		
		Autopista autopista = new Autopista();
		
		autopista.registrarTelepase(1, auto1);
		autopista.registrarTelepase(2, auto2);
		autopista.registrarTelepase(3, auto3);
		
		TreeSet<Vehiculo> autosInfractoresOrdenados = autopista.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente();
		
		Vehiculo autoEsperadoPrimero = autosInfractoresOrdenados.first();
		assertEquals(autoEsperadoPrimero, auto2);
		Vehiculo autoEsperadoUltimo = autosInfractoresOrdenados.last();
		assertEquals(autoEsperadoUltimo, auto3);
	}
@Test
	public void queLaCantidadDeVehiculosEnCirculacionSeaLaEsperada() {
		Vehiculo auto1 = new Automovil("456abc", 150, 130);
		Vehiculo auto2 = new Automovil("123abc", 140, 130);
		Vehiculo auto3 = new Automovil("012cdf", 140, 130); 
		
		Autopista autopista = new Autopista();
		
		autopista.registrarTelepase(1, auto1);
		autopista.registrarTelepase(2, auto2);
		autopista.registrarTelepase(3, auto3);
		
		Integer cantidadEsperada = 3;
		Integer cantidadObtenida = autopista.cantidadDeVehiculosENCirculacion();
		
		assertEquals(cantidadEsperada, cantidadObtenida);
	}
	@Test
	public void queUnVehiculoTengaInfraccionPorIrPorSobreLaVelocidadMaxima() {
		Vehiculo auto1 = new Automovil("456abc", 150, 130);
		
		Boolean resultado = auto1.enInfraccion();
				
		assertTrue(resultado);		
		
	}
	
}
