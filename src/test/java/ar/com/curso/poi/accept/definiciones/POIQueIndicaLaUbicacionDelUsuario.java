package ar.com.curso.poi.accept.definiciones;

import ar.com.curso.poi.modelo.POI;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

public class POIQueIndicaLaUbicacionDelUsuario {

    POI poi;

    private String url;
    private String urlBase;
    private String port;
    private String respuestaJson;

    public POIQueIndicaLaUbicacionDelUsuario(){
        port = System.getProperty("servlet.port", "8080");
        urlBase = "http://localhost:" + port + "/pois-app";
    }

    @Dado("estoy en la ubicacion (.*) y (.*)")
    public void estoy_en_una_latitud_y_longitud(String latitud, String longitud){

        poi = new POI(latitud, longitud);

    }

    @Cuando("pido el POI mas cercano a la ubicacion del servicio (.*)")
    public void pido_los_puntos_mas_cercanos(String servicio) throws Exception {
        url = urlBase +"/poiMasCercano/" + servicio + "/" + poi.getLatitud() + "/" + poi.getLongitud();
        respuestaJson = this.obtenerContenidoRespuesta(url);
    }

    private String obtenerContenidoRespuesta(String url) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.connect();
        return new BufferedReader( new InputStreamReader( connection.getInputStream() ) ).readLine();
    }

    @Entonces("^el servicio me devuelve el mensaje \"([^\"]*)\"$")
    public void elServicioDevuelveElMensaje(String mensaje) throws Throwable {

        assertThat(mensaje).contains("la latitud debe ser negativa");
    }
}
