package ar.com.curso.poi.kata.tdd;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CerraduraTest {

    @Test
    public void crearCerraduraConClaveYCantidadDeFallos() {

        Cerradura c = new Cerradura(1234, 3);
        assertThat(c).isNotNull();
        assertThat(c.getClave()).isEqualTo(1234);
        assertThat(c.getCantidadDeFallos()).isEqualTo(3);
    }

    @Test
    public void crearOtraCerraduraConClaveYCantidadDeFallos() {

        Cerradura c = new Cerradura(12345, 5);
        assertThat(c).isNotNull();
        assertThat(c.getClave()).isEqualTo(12345);
        assertThat(c.getCantidadDeFallos()).isEqualTo(5);
    }

    @Test
    public void abrirConLaClaverCorrectaAbre() {

        Cerradura c = new Cerradura(12345, 5);
        assertThat(c.abrir(12345)).isTrue();
    }

    @Test
    public void abrirConLaClaverIncorrectaNoAbre() {

        Cerradura c = new Cerradura(12345, 5);
        assertThat(c.abrir(1234)).isFalse();
    }

    @Test
    public void cerrarCierra() {

        Cerradura c = new Cerradura(12345, 5);
        c.cerrar();
        assertThat(c.estaCerrada()).isTrue();
    }

    @Test
    public void noCerrarNoCierra() {

        Cerradura c = new Cerradura(12345, 5);
        c.abrir(12345);
        assertThat(c.estaCerrada()).isFalse();
    }

}
