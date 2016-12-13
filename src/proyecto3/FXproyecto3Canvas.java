

package proyecto3;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import proyecto3.painter.CargadorImagenes;
import proyecto3.painter.Pintor;


public class FXproyecto3Canvas extends Canvas implements EventHandler, ChangeListener
{
    private CandyPirates sistema;
    private final GraphicsContext context;
    private boolean arrastrando = false;
    private int xAnteriorRaton;
    private int yAnteriorRaton;
    public FXproyecto3Canvas()
    {
        this.sistema = new CandyPirates(1366, 768);
        this.context = super.getGraphicsContext2D();
        
        //agrego eventos del mouse
        this.addEventHandler(MouseEvent.MOUSE_PRESSED, this);
        this.addEventHandler(MouseEvent.MOUSE_DRAGGED, this);
        this.addEventHandler(MouseEvent.MOUSE_MOVED, this);
        
        //agrego eventos de cambios del tamano 
        this.widthProperty().addListener(this);
        this.heightProperty().addListener(this);
                
                  
    }
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
            Pintor.pintar(this.sistema, this.context, sistema.getMundo(),new Dimension((int)this.getWidth(),(int)this.getHeight()));
        }
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