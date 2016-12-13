

package proyecto3;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import proyecto3.painter.CargadorImagenes;
import proyecto3.painter.Pintor;


/**
 *
 * @author Pablo Rojas
 */
public class FXproyecto3Canvas extends Canvas implements EventHandler, ChangeListener
{
    private Sistema sistema;
    private final GraphicsContext context;
    
    public FXproyecto3Canvas()
    {
        this.sistema = new Sistema(1366, 768);
        this.context = super.getGraphicsContext2D();
        
        //agrego eventos del mouse
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, this);
        this.addEventHandler(MouseEvent.MOUSE_DRAGGED, this);
        this.addEventHandler(MouseEvent.MOUSE_MOVED, this);
        
        //agrego eventos de cambios del tamano 
        this.widthProperty().addListener(this);
        this.heightProperty().addListener(this);
                
        Timeline timer = new Timeline( new KeyFrame(Duration.millis(5), this));
        timer.setCycleCount(Animation.INDEFINITE);
        timer.play();
             
    }
     
//Pintador tiene que ser llamado de otra forma, porque esta en otra carpeta, no me acuero de donde esta
    
    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue)
    {
       this.repintar();
    }

    private void repintar()
    {
        this.context.clearRect(0, 0, (int)this.getWidth(), (int)this.getHeight());
    
        this.context.drawImage(CargadorImagenes.getImage("wallpaper.png"), 0, 0, this.getWidth(), this.getHeight());
                
        if(this.sistema != null)
        {
            Pintor.pintar(this.sistema, this.context, sistema.getMundo(),new Dimension((int)this.getWidth(),(int)this.getHeight(), Caramelo caramelo));
        }
    }
    
    private void mover()
    {
        this.sistema.mover();
        
    }

    @Override
    public void handle(Event event) {
        if (event.getEventType()== MouseEvent.MOUSE_PRESSED){
            MouseEvent elGranEvento = (MouseEvent)event;
            int xCaramelo = (int) elGranEvento.getX();
            int yCaramelo = (int) elGranEvento.getY();
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
}