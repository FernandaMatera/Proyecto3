/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import proyecto3.painter.CargadorImagenes;


class VentanaOpciones extends Stage implements EventHandler, ChangeListener
{
    private Button atras;
      
    public VentanaOpciones()
    {
        super.setTitle("Opciones");
        StackPane root = new StackPane();
        
        Label fondo = new Label ("", new ImageView(CargadorImagenes.getImage("opciones.png")));
        root.getChildren().add(fondo);
        
        BorderPane panelPrincipal = new BorderPane();
        root.getChildren().add(panelPrincipal);
    
        this.atras = new Button("ATRAS");
        this.atras.setPrefWidth(100);
        this.atras.setOnAction(this);
        
        panelPrincipal.setLeft(atras);
        
        
        Scene scene = new Scene(root, 800, 600);
        super.setScene(scene);
    
    }

    @Override
    public void handle(Event event)
    {
        if( event.getSource() == this.atras )
        {
            this.close();
        }
    }

    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
