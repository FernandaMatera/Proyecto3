
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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import proyecto3.painter.CargadorImagenes;
 


class VentanaUsuario extends Stage implements EventHandler, ChangeListener
{
    private Button atras;
    private Button jugar;
    
    private TextField usernameTextField;
    
    private Label usernameText;
    
    private VentanaPrincipal principalStage;
    
    public VentanaUsuario()
    {
        super.setTitle("Usuario");
        StackPane root = new StackPane();
        
        Label fondo = new Label ("", new ImageView(CargadorImagenes.getImage("fondo.png")));
        root.getChildren().add(fondo);
        
        BorderPane panelPrincipal = new BorderPane();
        root.getChildren().add(panelPrincipal);
        
        panelPrincipal.setLeft(insertTexts());
        panelPrincipal.setCenter(insertTextFields());
                            
        this.jugar = new Button("JUGAR");
        this.jugar.setPrefWidth(100);
        this.jugar.setOnAction(this);
        this.atras = new Button("ATRAS");
        this.atras.setPrefWidth(100);
        this.atras.setOnAction(this);
        
        panelPrincipal.setLeft(atras);
        panelPrincipal.setRight(jugar); 
        
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add("style.css");
        super.setScene(scene);
 }
    
    public VentanaUsuario (VentanaPrincipal stage){
        this.principalStage = stage;
        super.setTitle("Usuario");
        StackPane root = new StackPane();
        BorderPane panelPrincipal = new BorderPane();
        root.getChildren().add(panelPrincipal);
        
      
        panelPrincipal.setLeft(insertTexts());
        panelPrincipal.setCenter(insertTextFields());
                
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add("style.css");
        super.setScene(scene);
        
        this.atras.setOnAction(this);
        this.jugar.setOnAction(this);
    }

    private VBox insertTexts(){
        VBox textos = new VBox();
        this.usernameText = new Label("Nombre de Usuario");
              
        textos.getChildren().addAll(this.usernameText);
        textos.getStyleClass().add("textBar");
        
        return textos;
    }
       private VBox insertTextFields(){
        VBox textFields = new VBox();
        this.usernameTextField = new TextField();
               
        textFields.getChildren().addAll(this.usernameTextField);
        textFields.getStyleClass().add("textFieldsBar");
        
        return textFields;
    }
       
     public void agregarUsuario(){
        String username = this.usernameTextField.getText();
        Usuario user = new Usuario(username);
    }
     
     public void handle(Event event)
    {
        if( event.getSource() == this.atras )
        {
            this.close();
        }
        if( event.getSource() == this.jugar )
        {
            VentanaJuego stage = new VentanaJuego();
            stage.show();
            this.close();
        }
    }   

    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

