package ar.com.curso.poi.servicios;

import ar.com.curso.poi.modelo.Capa;
import ar.com.curso.poi.modelo.POI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioCapas {

    private Map<String, Capa> capas = new HashMap<String, Capa>();

    private static RepositorioCapas instance = new RepositorioCapas();

    private RepositorioCapas() {

        Capa pizzerias = new Capa("pizzerias");
        pizzerias.setPOIs(crearCapaPizzerias());

        Capa cafeterias = new Capa("cafeterias");
        cafeterias.setPOIs(crearCapaCafeterias());

        Capa realidadAumentada = new Capa("realidadAumentada");
        realidadAumentada.setPOIs(crearRealidadAumentada());

        capas.put(pizzerias.getNombre(), pizzerias);
        capas.put(cafeterias.getNombre(), cafeterias);
        capas.put(realidadAumentada.getNombre(), realidadAumentada);
    }

    public static RepositorioCapas getInstance() {

        return instance;
    }

    public List<POI> getPOIs(String nombre) {

        return capas.get(nombre).getPOIs();
    }

    public Capa getCapa(String nombre) {

        return capas.get(nombre);
    }

    private List<POI> crearCapaPizzerias() {

        List<POI> pois = new ArrayList<POI>();
        pois.add(new POI(
            -34.603705,
            -58.379058,
            "Las cuartetas",
            "La mejor pizza a la piedra"));
        pois.add(new POI(
            -34.59762,
            -58.385527,
            "El cuartito",
            "Pizza con Faina increible"));
        pois.add(new POI(
            -34.60393,
            -58.38605,
            "Guerrin",
            "Pizeria al paso"));
        return pois;
    }

    public List<POI> crearCapaCafeterias() {

        List<POI> pois = new ArrayList<POI>();
        pois.add(new POI(
            -34.609573,
            -58.396187,
            "Los Angelitos",
            "Cafeteria con historia"));
        pois.add(new POI(
            -34.602305,
            -58.429459,
            "Havanna",
            "Cafeteria moderna en Av Corrientes"));
        pois.add(new POI(
            -34.603983,
            -58.410941,
            "Starbucks",
            "Cafeteria internacional en Abasto Shopping"));
        return pois;
    }

    public List<POI> crearRealidadAumentada() {

        List<POI> pois = new ArrayList<POI>();
        pois.add(new POI(
                -54.609573,
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
        return pois;
    }

}
