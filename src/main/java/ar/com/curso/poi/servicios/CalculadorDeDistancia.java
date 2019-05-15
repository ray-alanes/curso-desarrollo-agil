package ar.com.curso.poi.servicios;

import ar.com.curso.poi.modelo.POI;

import java.util.ArrayList;
import java.util.List;

public class CalculadorDeDistancia {

    public Double calcularDistancia(POI poi, POI ubicacionActual) {

        Double distancia = Math.sqrt((Math.pow((poi.getLatitud() - ubicacionActual.getLatitud()), 2)
            + Math.pow((poi.getLongitud() - ubicacionActual.getLongitud()), 2)));

        return distancia;
    }

    public POI buscarPOIMasCercano(List<POI> pois, POI ubicacionActual) {
        POI poiConDistanciaMinima = new POI();
        Double distanciaMinima = new Double(0);

        if (!pois.isEmpty()) {

            poiConDistanciaMinima = pois.get(0);
            distanciaMinima = calcularDistancia(poiConDistanciaMinima, ubicacionActual);
        }

        for (POI unPoi : pois) {

            if ( calcularDistancia(unPoi, ubicacionActual) < distanciaMinima) {

                distanciaMinima = calcularDistancia(unPoi, ubicacionActual);
                poiConDistanciaMinima = unPoi;
            }
        }
        return poiConDistanciaMinima;
    }

    public List<POI> buscarPOIDentroDeUnRadio(List<POI> pois, POI ubicacionActual, int radio){

        List<POI> poisMasCercanos = new ArrayList<>();
        Double distancia = new Double(0.0);

        if(!pois.isEmpty()){
            for(POI unPOI: pois){
                distancia = calcularDistancia(unPOI, ubicacionActual);
                if(Math.abs(distancia) <= radio){
                    poisMasCercanos.add(unPOI);
                }
            }
        }
        return poisMasCercanos;
    }

}
