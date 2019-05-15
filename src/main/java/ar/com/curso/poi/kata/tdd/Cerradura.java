package ar.com.curso.poi.kata.tdd;

public class Cerradura {

    private int clave;
    private int cantidadDeFallos;
    private boolean cerrada;
    private boolean abierta;

    public Cerradura(int clave, int cantidadDeFallos) {

        this.clave = clave;
        this.cantidadDeFallos = cantidadDeFallos;
    }

    public int getClave() {
        return clave;
    }

    public int getCantidadDeFallos() {
        return cantidadDeFallos;
    }

    public boolean abrir(int clave) {

        return this.clave == clave;
    }

    public void cerrar() {
        cerrada = true;
    }

    public boolean estaCerrada() {
        return cerrada;
    }
    
    public boolean estaAbierta() {
        return abierta;
    }

}
