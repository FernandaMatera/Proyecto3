/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3.painter;

import proyecto3.Sistema;
import java.util.Iterator;
import javafx.scene.canvas.GraphicsContext;
import proyecto3.Caramelo;
import proyecto3.Dimension;

public class Pintor 
{
    static public void pintar( Sistema juego, GraphicsContext context, Dimension mundo, Dimension ventana, Caramelo caramelo )
    {
        int x = Pintor.convertirXACoordenadasMundo(caramelo.getX(), mundo, ventana);
        int y = Pintor.convertirYACoordenadasMundo (caramelo.getY(), mundo, ventana);
        int ancho = Pintor.convertirXACoordenadasVentana(caramelo.getAncho(), mundo, ventana);
        int alto = Pintor.convertirYACoordenadasVentana(caramelo.getAlto(), mundo, ventana);
        Iterator<Caramelo> caramelos = juego.iterator();
        while( caramelos.hasNext() )
        {
            Caramelo caramelo = caramelos.next();
            Pintor.dibujar(caramelo, context, mundo, ventana);
            if((x<=ancho)&(y<=alto))
            {
                
            }
            
        }
        
       
        
    }
    
     static private void dibujar(Caramelo caramelo, GraphicsContext context, Dimension mundo, Dimension ventana)
    {
        int x = Pintor.convertirXACoordenadasVentana(caramelo.getX(), mundo, ventana);
        int y = Pintor.convertirYACoordenadasVentana(caramelo.getY(), mundo, ventana);
        int ancho = Pintor.convertirXACoordenadasVentana(caramelo.getAncho(), mundo, ventana);
        int alto = Pintor.convertirYACoordenadasVentana(caramelo.getAlto(), mundo, ventana);
        context.drawImage(CargadorImagenes.getImage(caramelo.getCaramelo().getFilename()), x, y, ancho, alto);
        
    }
    
    static private int convertirXACoordenadasMundo(int XCaramelo, Dimension mundo, Dimension ventana)
    {
        return XCaramelo*mundo.getWidth()/ventana.getWidth();
    }
    
    static private int convertirYACoordenadasMundo(int YCaramelo, Dimension mundo, Dimension ventana)
    {
        return YCaramelo*mundo.getHeight()/ventana.getHeight();
    }
    
    static private int convertirXACoordenadasVentana(int x, Dimension mundo, Dimension ventana)
    {
        return x*ventana.getWidth()/mundo.getWidth();
    }
    
    static private int convertirYACoordenadasVentana(int y, Dimension mundo, Dimension ventana)
    {
        return y*ventana.getHeight()/mundo.getHeight();
    }
    
    static private int convertirMagnitudACoordenadasVentana(int magnitud, Dimension mundo, Dimension ventana)
    {
        double diagonalMundo = Math.sqrt( mundo.getWidth()*mundo.getWidth() + mundo.getHeight()*mundo.getHeight() );
        double diagonalVentana = Math.sqrt( ventana.getWidth()*ventana.getWidth() + ventana.getHeight()*ventana.getHeight() );
        return (int)(magnitud*diagonalVentana/diagonalMundo);
    }
    
}

