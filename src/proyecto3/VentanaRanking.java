/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3;

/**
 *
 * @author Fernanda Matera
 */


import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

class VentanaRanking extends Stage implements EventHandler, ChangeListener
{
    private Button atras;
    final TableView<Usuario> table; 
    ObservableList<Usuario> data;
    
    public VentanaRanking()
    {
        super.setTitle("Ranking");
       
        StackPane root = new StackPane();
        Label fondo = new Label ("", new ImageView(new Image(getClass().getResourceAsStream("fondo.png"))));
        root.getChildren().add(fondo);
        
        BorderPane panelPrincipal = new BorderPane();
        root.getChildren().add(panelPrincipal);
        
        BorderPane panelCentral = new BorderPane();
        
        panelCentral.setPadding( new Insets(15) );
        Label label = new Label("Posiciones Generales");
        Font antigua = label.getFont();
        Font nueva = new Font(antigua.getName(), antigua.getSize()+8);
        label.setFont(nueva);
        panelCentral.setTop(label);
        
        HBox panelBotones = new HBox(10);
        this.atras = new Button("Atras");
        this.atras.setPrefWidth(100);
        this.atras.setOnAction(this);
        panelBotones.getChildren().addAll(this.atras);
        BorderPane panelBotonesDerecha = new BorderPane();
        panelBotonesDerecha.setRight(panelBotones);
        panelCentral.setBottom(panelBotonesDerecha);
        
        
        data = FXCollections.observableArrayList(
          
        );
        table = new TableView<>();
        table.setItems(data);
        TableColumn firstNameCol = new TableColumn("Nombre");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("Puntaje"));
         
        BorderPane panelTabla = new BorderPane();
        panelTabla.setCenter(table);
        panelTabla.setPadding(new Insets(0, 0, 10, 0));
        panelCentral.setCenter(panelTabla);
        
        panelPrincipal.setCenter(panelCentral);
        
        
        table.setItems(data);
        firstNameCol = new TableColumn("Nombre");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("Puntaje"));
         
        panelTabla = new BorderPane();
        panelTabla.setCenter(table);
        panelTabla.setPadding(new Insets(0, 0, 10, 0));
        panelCentral.setCenter(panelTabla);
        
        panelPrincipal.setCenter(panelCentral);
        
        Scene scene = new Scene(root, 800, 600);
        super.setScene(scene);
        
        
 
    }

    @Override
    public void handle(Event event)
    {
        if( event.getSource() == this.atras )
        {
            VentanaPrincipal stage = new VentanaPrincipal();
            stage.show();
        }
    }

 }
    
