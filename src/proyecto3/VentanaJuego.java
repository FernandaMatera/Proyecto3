/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3;

import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



class VentanaJuego extends Stage
{
    private Button atras;
    
    public VentanaJuego()
    {
               
        this.atras = new Button("ATRAS");
        this.atras.setPrefWidth(100);
        this.atras.setOnAction(this);
        
        panelPrincipal.setLeft(atras);
        
        BorderPane mainPane = new BorderPane();

        VentanaJuego paint = new VentanaJuego();
        mainPane.setCenter(paint);

        //Para que el Canvas tome el tamano del panel contenedor
        paint.widthProperty().bind(mainPane.widthProperty());
        paint.heightProperty().bind(mainPane.heightProperty());

        Scene scene = new Scene(mainPane, 800, 600);
        super.setScene(scene);
        super.setTitle("Candy Pirates");
        //super.setResizable(false);
        //super.setFullScreen(true);
    }
      public void handle(Event event)
    {
        if( event.getSource() == this.atras )
        {
            this.close();
        }
    }
}
