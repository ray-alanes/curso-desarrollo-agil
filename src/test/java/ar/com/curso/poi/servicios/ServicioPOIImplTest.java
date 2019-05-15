package ar.com.curso.poi.servicios;

import ar.com.curso.poi.modelo.POI;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class ServicioPOIImplTest {


    @Test
    public void deberiaDevolverLosPOISDeRealidadAumentada(){

        List<POI> pois = RepositorioCapas.getInstance().getPOIs("realidadAumentada");
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


        assertThat(pois).isEqualTo(poisRealidadAumentadaEsperados);

    }
}
