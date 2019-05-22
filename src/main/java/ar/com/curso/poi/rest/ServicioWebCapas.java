package ar.com.curso.poi.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ar.com.curso.poi.modelo.Respuesta;
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
    public Respuesta obtenerPOIs(@PathParam("nombreServicio") String nombreServicio) {

        List<POI> pois = servicioPOI.obtenerPOIs(nombreServicio);
        Respuesta res = new Respuesta(pois, "OK");

        return res;
    }

    @GET
    @Path("/poiMasCercano/{nombreServicio}/{latitud}/{longitud}")
    @Produces("application/xml")
    public Respuesta obtenerPOIMasCercano(@PathParam("nombreServicio") String nombreServicio,
        @PathParam("latitud") String latitud,
        @PathParam("longitud") String longitud) {

        List<POI> pois = servicioPOI.obtenerPOIs(nombreServicio);

        CalculadorDeDistancia calculadorDeDistancia = new CalculadorDeDistancia();

        POI ubicacionActual = new POI(latitud, longitud);

        POI poiConDistanciaMinima = calculadorDeDistancia.buscarPOIMasCercano(pois, ubicacionActual);

        List<POI> poisRespuesta = new ArrayList<>();
        poisRespuesta.add(poiConDistanciaMinima);

        String mensaje = "La latitud no debe ser negativa";
        if(ubicacionActual.validarLatitudNegativa())
            mensaje = "OK";

        Respuesta respuesta = new Respuesta(poisRespuesta, mensaje);

        return respuesta;
    }

    @GET
    @Path("/poiMasCercano/{nombreServicio}/{latitud}/{longitud}/{radio}")
    @Produces("application/xml")
    public Respuesta obtenerPOIMasCercanoConRadio(@PathParam("nombreServicio") String nombreServicio,
                                                  @PathParam("latitud") String latitud,
                                                  @PathParam("longitud") String longitud,
                                                  @PathParam("radio") String radio
                                            ) {

        List<POI> pois = servicioPOI.obtenerPOIs(nombreServicio);

        CalculadorDeDistancia calculadorDeDistancia = new CalculadorDeDistancia();

        POI ubicacionActual = new POI(latitud, longitud);

        int radioDeBusqueda = Integer.parseInt(radio);

        List<POI> poiConDistanciaMinima = calculadorDeDistancia.buscarPOIDentroDeUnRadio(pois, ubicacionActual, radioDeBusqueda);

        return new Respuesta(poiConDistanciaMinima, "OK");
    }



}
