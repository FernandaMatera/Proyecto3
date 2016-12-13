package proyecto3;

import java.util.ArrayList;
import java.util.Iterator;
import javafx.scene.input.MouseEvent;

public class CandyPirates
{
    static private final int ANCHO_BLOQUE = 64;
    static private final int ALTO_BLOQUE = 64;
    private boolean arrastrando = false;
    
    private Dimension mundo;
    private ArrayList<Caramelo> caramelos;
      
    private boolean iniciado;
    
    
    public CandyPirates(int width, int height)
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
    
    private boolean estaDentro(MouseEvent e,int XCaramelo, int YCaramelo, int ancho, int alto)
    {
        if ((e.getX() > XCaramelo) &&(e.getX() < (XCaramelo + ancho)) &&(e.getY() > YCaramelo) &&(e.getY() < (YCaramelo + alto)))
       {
          return true;
       }
      return false;
    }
     
    public void mover(MouseEvent e,int XCaramelo, int YCaramelo)
   {
      if (!arrastrando)
      {
        /* if (estaDentro(e))
         {
         
            int xAnteriorRaton = (int) e.getX();
            int yAnteriorRaton = (int) e.getY();
            arrastrando = true;
         }
      }
      else
      {   
         XCaramelo = (int) ((XCaramelo + e.getX()) - xAnteriorRaton);
         YCaramelo = (int)(YCaramelo+ e.getY()) - yAnteriorRaton;
         xAnteriorRaton = (int) e.getX();
         yAnteriorRaton = (int) e.getY();
   
         repintar();
      }*/

   }   

 /* public void mouseMoved(MouseEvent e)
   {
      arrastrando = false;
   }*/
   }
}
