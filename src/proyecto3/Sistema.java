package proyecto3;


import java.util.ArrayList;
import java.util.Iterator;

public class Sistema
{
    static private final int ANCHO_BLOQUE = 64;
    static private final int ALTO_BLOQUE = 64;
    
    private Dimension mundo;
    private ArrayList<Caramelo> caramelos;
      
    private boolean iniciado;
    
    
    public Sistema(int width, int height)
    {
        /*creo que mundo no es necesario*/
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
                TipoCaramelos tipo = TipoCaramelos.AZULES;
                switch(i)
                {
                    case 0: tipo = TipoCaramelos.VERDES; break;
                    case 1: tipo = TipoCaramelos.AMARILLOS; break;
                    case 2: tipo = TipoCaramelos.AZULES; break;
                    case 3: tipo = TipoCaramelos.NARANJOS; break;
                    case 4: tipo = TipoCaramelos.MORADOS; break;
                    case 5: tipo = TipoCaramelos.ROJOS; break;
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

    void mover() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
    
}
