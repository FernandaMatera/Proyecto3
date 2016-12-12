/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3.painter;

import java.util.HashMap;
import javafx.scene.image.Image;

/**
 *
 * @author Luis
 */
public class CargadorImagenes 
{
    static private final HashMap<String, Image> IMAGENES = new HashMap<>();
    
    static public Image getImage(String filename)
    {
        Image image = CargadorImagenes.IMAGENES.get(filename);
        if( image != null )
        {
            return image;
        }
        
        image = new Image(Pintor.class.getResourceAsStream("/proyecto3/Imagenes/" + filename));
        CargadorImagenes.IMAGENES.put(filename, image);
        return image;
    }
}
