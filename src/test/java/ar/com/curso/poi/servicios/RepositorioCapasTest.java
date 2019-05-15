package ar.com.curso.poi.servicios;

import ar.com.curso.poi.modelo.Capa;
import ar.com.curso.poi.modelo.POI;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class RepositorioCapasTest {

    @Test
    public void obtenerLosPoisDeRealidadAumentada() {


        List<POI> poisRealidadAumentada = RepositorioCapas.getInstance().getPOIs("realidadAumentada");

        List<POI> poisRealidadAumentadaEsperados = new ArrayList<POI>();

        poisRealidadAumentadaEsperados .add(new POI(
                -54.609573,
                -158.396187,
                "Obelisco",
                "Obelisco de Buenos Aires"));
        poisRealidadAumentadaEsperados.add(new POI(
                -74.602305,
                -88.429459,
                "Congreso",
                "Congreso de la nacion"));
        poisRealidadAumentadaEsperados.add(new POI(
                -94.603983,
                -28.410941,
                "Cabildo",
                "Cabildo"));
        poisRealidadAumentadaEsperados.add(new POI(
                -34.6010406,
                -58.3852726,
                "Teatro Colon",
                "Teatro Colon"));
        poisRealidadAumentadaEsperados.add(new POI(
                -34.6010406,
                -58.3852726,
                "Planetario",
                "Planetario"));
        poisRealidadAumentadaEsperados.add(new POI(
                -34.5784263,
                -58.4227352,
                "La rural",
                "La Rural"));

        assertThat(poisRealidadAumentada).isEqualTo(poisRealidadAumentadaEsperados);

    }

}
