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
public class Caramelo extends PosicionImagen{

    private TipoCaramelos caramelo;

    public Caramelo( int x, int y, int alto, int ancho, TipoCaramelos caramelo) 
    {
        super (x,y,alto,ancho);
        this.caramelo = caramelo;
    }

    Caramelo(int i, int i0, int ANCHO_BLOQUE, int ALTO_BLOQUE, proyecto3.TipoCaramelos tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public TipoCaramelos getCaramelo() {
        return caramelo;
    }

    public void setCaramelo(TipoCaramelos caramelo) {
        this.caramelo = caramelo;
    }

    static class TipoCaramelos {

        public TipoCaramelos() {
        }
    }
}
