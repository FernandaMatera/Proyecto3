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

    public TipoCaramelos getCaramelo() {
        return caramelo;
    }

    public void setCaramelo(TipoCaramelos caramelo) {
        this.caramelo = caramelo;
    }
    

   }
