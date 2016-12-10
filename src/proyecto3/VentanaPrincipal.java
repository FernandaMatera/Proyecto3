package proyecto3;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
        
        BorderPane panelPrincipal = new BorderPane();
        root.getChildren().add(panelPrincipal);
        
        HBox topPane = new HBox();
        topPane.setBackground( new Background(new BackgroundFill(new Color(190/255.0, 0, 102/255.0, 1), CornerRadii.EMPTY, Insets.EMPTY)));
        Image image = new Image(getClass().getResourceAsStream("logo_utalca.png"));
        Label logo = new Label("", new ImageView(image));
        topPane.getChildren().add(logo);
        panelPrincipal.setTop(topPane);
        
        BorderPane panelCentral = new BorderPane();
        
        panelCentral.setPadding( new Insets(15) );
        Label label = new Label("Módulo de usuarios");
        Font antigua = label.getFont();
        Font nueva = new Font(antigua.getName(), antigua.getSize()+8);
        label.setFont(nueva);
        panelCentral.setTop(label);
        
        HBox panelBotones = new HBox(10);
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
        panelBotones.getChildren().addAll(this.jugar, this.opciones, this.ranking, this.desarrollo);
        BorderPane panelBotonesDerecha = new BorderPane();
        panelBotonesDerecha.setRight(panelBotones);
        panelCentral.setBottom(panelBotonesDerecha);
        

        
        panelPrincipal.setCenter(panelCentral);
        
        Scene scene = new Scene(root, 800, 600);
        super.setScene(scene);
    
    }

    @Override
    public void handle(Event event)
    {
        if( event.getSource() == this.jugar )
        {
            VentanaJuego stage = new VentanaJuego();
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