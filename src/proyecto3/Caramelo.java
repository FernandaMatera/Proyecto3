package proyecto3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fernanda Matera
 */
public class Caramelo {
    int alto;
    int ancho;
    private TipoCaramelos caramelo;

    public Caramelo(int alto, int ancho, TipoCaramelos caramelo) {
        this.alto = alto;
        this.ancho = ancho;
        this.caramelo = caramelo;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public TipoCaramelos getCaramelo() {
        return caramelo;
    }

    public void setCaramelo(TipoCaramelos caramelo) {
        this.caramelo = caramelo;
    }

    


}
