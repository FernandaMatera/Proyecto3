
import proyecto3.Dimension;
import java.util.ArrayList;
import java.util.Iterator;
import proyecto3.Caramelo;


public class Sistema
{
    static private final int ANCHO_BLOQUE = 64;
    static private final int ALTO_BLOQUE = 64;
    
    private Dimension mundo;
    private ArrayList<Caramelo> caramelos;
      
    private boolean iniciado;
    
    
    public Sistema(int width, int height)
    {
        this.mundo = new Dimension(width, height);
               
        int cantidadCaramelosHorizontales = 9;
        int cantidadCaramelosVerticales = 9;
        this.caramelos = new ArrayList<>();
        int x = (width - cantidadCaramelosHorizontales*ANCHO_BLOQUE)/2;
        int y = 2*ALTO_BLOQUE;
        
        for (int i = 0; i < cantidadCaramelosVerticales; i++)
        {
            for (int j = 0; j < cantidadCaramelosHorizontales; j++)
            {
                //porque es azul tipo azul esta aqui
                TipoCaramelos tipo = TipoCaramelo.AZUL;
                switch(i)
                {
                    //Porque el case 6 y 7 estan aqui?
                    case 0: case 6: tipo = TipoCaramelo.VERDE; break;
                    case 1: case 7: tipo = TipoCaramelo.AMARILLO; break;
                    case 2: tipo = TipoCaramelo.AZUL; break;
                    case 3: tipo = TipoCaramelo.GRIS; break;
                    case 4: tipo = TipoCaramelo.PURPURA; break;
                    case 5: tipo = TipoCaramelo.ROJO; break;
                }
                //Alto y ancho bloque estan corresponden a caramelo
                Caramelo caramelo = new Caramelo(x + j*ANCHO_BLOQUE, y + i*ALTO_BLOQUE, ANCHO_BLOQUE, ALTO_BLOQUE, tipo);
                this.caramelos.add(caramelo);
            }
        }
          
        this.iniciado = false;
    }

    public Dimension getMundo()
    {
        return this.mundo;
    }

    public boolean isIniciado()
    {
        return iniciado;
    }

    public void setIniciado(boolean iniciado)
    {
        this.iniciado = iniciado;
    }

    public Iterator<Caramelo> iterator()
    {
        return caramelos.iterator();
    }
     
    
}
