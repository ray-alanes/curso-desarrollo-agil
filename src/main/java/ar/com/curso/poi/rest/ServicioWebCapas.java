package ar.com.curso.poi.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ar.com.curso.poi.servicios.CalculadorDeDistancia;
import ar.com.curso.poi.modelo.POI;
import ar.com.curso.poi.servicios.ServicioPOI;
import ar.com.curso.poi.servicios.ServicioPOIImpl;

@Path("/")
public class ServicioWebCapas {

    private ServicioPOI servicioPOI = new ServicioPOIImpl();

    @GET
    @Path("/test")
    public String hola() {

        return "Test";
    }

    @GET
    @Path("/pois/{nombreServicio}")
    @Produces("application/xml")
    public List<POI> obtenerPOIs(@PathParam("nombreServicio") String nombreServicio) {

        return servicioPOI.obtenerPOIs(nombreServicio);
    }

    @GET
    @Path("/poiMasCercano/{nombreServicio}/{latitud}/{longitud}")
    @Produces("application/xml")
    public POI obtenerPOIMasCercano(@PathParam("nombreServicio") String nombreServicio,
        @PathParam("latitud") String latitud,
        @PathParam("longitud") String longitud) {

        List<POI> pois = servicioPOI.obtenerPOIs(nombreServicio);

        CalculadorDeDistancia calculadorDeDistancia = new CalculadorDeDistancia();

        POI ubicacionActual = new POI(latitud, longitud);

        POI poiConDistanciaMinima = calculadorDeDistancia.buscarPOIMasCercano(pois, ubicacionActual);

        return poiConDistanciaMinima;
    }

}
