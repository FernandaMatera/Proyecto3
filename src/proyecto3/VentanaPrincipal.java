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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


class VentanaPrincipal extends Stage implements EventHandler, ChangeListener
{
    private Button jugar;
    private Button opciones;
    private Button ranking;
    private Button desarrollo;
    
    public VentanaPrincipal()
    {
        super.setTitle("CandyPirates");
        StackPane root = new StackPane();
        Label fondo = new Label ("", new ImageView(new Image(getClass().getResourceAsStream("fondo.png"))));
        root.getChildren().add(fondo);
        
        BorderPane panelPrincipal = new BorderPane();
        root.getChildren().add(panelPrincipal);
                    
        this.jugar = new Button("JUGAR");
        this.jugar.setPrefWidth(100);
        this.jugar.setOnAction(this);
        this.opciones = new Button("OPCIONES");
        this.opciones.setPrefWidth(100);
        this.opciones.setOnAction(this);
        this.ranking = new Button("RANKING");
        this.ranking.setPrefWidth(100);
        this.ranking.setOnAction(this);
        this.desarrollo = new Button("DESARROLLO");
        this.desarrollo.setPrefWidth(100);
        this.desarrollo.setOnAction(this);
        
        VBox panelBotones = new VBox();
        panelBotones.getChildren().addAll(this.opciones, this.desarrollo);
        panelPrincipal.setRight(panelBotones);
        panelPrincipal.setCenter(this.jugar);
        BorderPane rankingDerecha = new BorderPane();
        rankingDerecha.setRight(this.ranking);
        panelPrincipal.setTop(rankingDerecha);
   
        Scene scene = new Scene(root, 800, 600);
        super.setScene(scene);
    
    }

    @Override
    public void handle(Event event)
    {
        if( event.getSource() == this.jugar )
        {
            VentanaUsuario stage = new VentanaUsuario();
            stage.show();
        }
        if( event.getSource() == this.opciones)
        {
            VentanaOpciones stage = new VentanaOpciones();
            stage.show();
        }
        if( event.getSource() == this.ranking )
        {
            VentanaRanking stage = new VentanaRanking();
            stage.show();
         
        }
         if( event.getSource() == this.desarrollo )
        {
            VentanaDesarrolladores stage = new VentanaDesarrolladores();
            stage.show();
        }
    }

    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}