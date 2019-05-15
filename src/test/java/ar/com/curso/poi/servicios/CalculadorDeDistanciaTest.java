package ar.com.curso.poi.servicios;

import ar.com.curso.poi.modelo.POI;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Offset.offset;

public class CalculadorDeDistanciaTest {
	
	@Test
	public void testDistanciaNula() {
		
		CalculadorDeDistancia calculadorDeDistancia = new CalculadorDeDistancia();
		POI poi = new POI(30D, 40D, "Havanna", "Cafeteria");
		POI ubicacionActual = new POI(30D, 40D, "Mi casa", "Casa");
		
		Double distancia = calculadorDeDistancia.calcularDistancia(poi, ubicacionActual);
		assertThat(distancia).isEqualTo(0.0);

	}
	
	@Test
	public void testDistancia() {
		
		CalculadorDeDistancia calculadorDeDistancia = new CalculadorDeDistancia();
		POI poi = new POI(30D, 40D, "Havanna", "Cafeteria");
		POI ubicacionActual = new POI(10D, 10D, "Mi casa", "Casa");
		
		Double distancia = calculadorDeDistancia.calcularDistancia(poi, ubicacionActual);
		assertThat(distancia).isEqualTo(36.055, offset(0.1));

	}

	@Test
	public void testObtenerPOISDentroDeUnRadio(){

		CalculadorDeDistancia calculadorDeDistancia = new CalculadorDeDistancia();
		List<POI> pois = new ArrayList<>();

		pois.add(new POI(-14.609573,-158.396187,"Obelisco","Obelisco de Buenos Aires"));
		pois.add(new POI(-24.602305,-188.429459,"Congreso","Congreso de la nacion"));
		pois.add(new POI(-34.603983,-128.410941,"Cabildo","Cabildo"));
		pois.add(new POI(-44.609573,-158.396187,"Obelisco","Obelisco de Buenos Aires"));
		pois.add(new POI(-54.602305,-188.429459,"Congreso","Congreso de la nacion"));
		pois.add(new POI(-64.603983,-128.410941,"Cabildo","Cabildo"));
		pois.add(new POI(-74.609573,-158.396187,"Obelisco","Obelisco de Buenos Aires"));
		pois.add(new POI(-84.602305,-188.429459,"Congreso","Congreso de la nacion"));
		pois.add(new POI(-94.603983,-128.410941,"Cabildo","Cabildo"));

		List<POI> poisMasCercanosEsperados = new ArrayList<>();

		poisMasCercanosEsperados.add(new POI(-14.609573, -158.396187, "Obelisco", "Obelisco de Buenos Aires"));
		poisMasCercanosEsperados.add(new POI(-34.603983, -128.410941, "Cabildo", "Cabildo"));
		poisMasCercanosEsperados.add(new POI(-44.609573, -158.396187, "Obelisco", "Obelisco de Buenos Aires"));
		poisMasCercanosEsperados.add(new POI(-64.603983, -128.410941, "Cabildo", "Cabildo"));
		poisMasCercanosEsperados.add(new POI(-74.609573, -158.396187, "Obelisco", "Obelisco de Buenos Aires"));
		poisMasCercanosEsperados.add(new POI(-94.603983, -128.410941, "Cabildo", "Cabildo"));


		POI ubicacionActual = new POI("-20", "-36");
		int radio = 135;

		List<POI> poisMasCercanos = calculadorDeDistancia.buscarPOIDentroDeUnRadio(pois, ubicacionActual, radio);

		assertThat(poisMasCercanos).isEqualTo(poisMasCercanosEsperados);
	}

	@Test
	public void testObtenerPOIMasCercano(){

		CalculadorDeDistancia calculadorDeDistancia = new CalculadorDeDistancia();

		List<POI> pois = new ArrayList<POI>();

		pois .add(new POI(-54.609573,
				-158.396187,
				"Obelisco",
				"Obelisco de Buenos Aires"));
		pois.add(new POI(
				-74.602305,
				-88.429459,
				"Congreso",
				"Congreso de la nacion"));
		pois.add(new POI(
				-94.603983,
				-28.410941,
				"Cabildo",
				"Cabildo"));


		POI ubicacionActual = new POI("-20", "-36");
		POI poiMasCercano =  calculadorDeDistancia.buscarPOIMasCercano(pois, ubicacionActual);

		assertThat(poiMasCercano).isEqualTo(new POI(-94.603983, -28.410941, "Cabildo", "Cabildo"));
	}

}
