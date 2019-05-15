package ar.com.curso.poi.modelo;

import ar.com.curso.poi.rest.ServicioWebCapas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Respuesta implements Serializable {

    private List<POI> pois;
    private String mensaje;

    private static final long serialVersionUID = 1L;


    public Respuesta(){

    }

    public Respuesta(List<POI> pois, String mensaje) {
        this.pois = pois;
        this.mensaje = mensaje;
    }

    @XmlElement
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @XmlElement
    public List<POI> getPois() {
        return pois;
    }

    public void setPois(List<POI> pois) {
        this.pois = pois;
    }

    @Override
    public String toString() {
        return pois.toString() + "mensaje=" + mensaje;
    }


}
