package proyecto3;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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


class MiStage extends Stage implements EventHandler, ChangeListener
{
    private Button eliminar;
    private Button editar;
    private Button agregar;
    final TableView<Usuario> table; 
    ObservableList<Usuario> data;
    
    public MiStage()
    {
        super.setTitle("Sistema de usuarios");
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
        this.eliminar = new Button("Eliminar");
        this.eliminar.setPrefWidth(100);
        this.eliminar.setOnAction(this);
        this.eliminar.setDisable(true);
        this.editar = new Button("Editar");
        this.editar.setPrefWidth(100);
        this.editar.setDisable(true);
        this.editar.setOnAction(this);
        this.agregar = new Button("Agregar");
        this.agregar.setPrefWidth(100);
        this.agregar.setOnAction(this);
        panelBotones.getChildren().addAll(this.eliminar, this.editar, this.agregar);
        BorderPane panelBotonesDerecha = new BorderPane();
        panelBotonesDerecha.setRight(panelBotones);
        panelCentral.setBottom(panelBotonesDerecha);
        
        
        data = FXCollections.observableArrayList(
            new Usuario("Jacob", "Smith", "jacob.smith@example.com"),
            new Usuario("Isabella", "Johnson", "isabella.johnson@example.com"),
            new Usuario("Ethan", "Williams", "ethan.williams@example.com"),
            new Usuario("Emma", "Jones", "emma.jones@example.com"),
            new Usuario("Michael", "Brown", "michael.brown@example.com")
        );
        table = new TableView<>();
        table.setItems(data);
        TableColumn firstNameCol = new TableColumn("Nombre de Usuario");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("Nombre Real"));
        TableColumn emailCol = new TableColumn("Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(new PropertyValueFactory<>("Email"));
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
        
        BorderPane panelTabla = new BorderPane();
        panelTabla.setCenter(table);
        panelTabla.setPadding(new Insets(0, 0, 10, 0));
        panelCentral.setCenter(panelTabla);
        
        panelPrincipal.setCenter(panelCentral);
        
        Scene scene = new Scene(root, 800, 600);
        super.setScene(scene);
        
        
        this.agregar.setOnAction(this);
        
        table.getSelectionModel().selectedItemProperty().addListener(this);
        
               
        
    }

    @Override
    public void handle(Event event)
    {
        if( event.getSource() == this.agregar )
        {
            NewStage stage = new NewStage();
            stage.show();
        }
        if( event.getSource() == this.editar )
        {
            NewStage2 stage = new NewStage2();
            stage.show();
        }
        if( event.getSource() == this.eliminar )
        {
            Object ob = table.getSelectionModel().getSelectedItem();
            this.data.remove(ob);
         
        }
    }

    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) 
    {
        if( newValue != null )
        {
            this.eliminar.setDisable(false);
            this.editar.setDisable(false);        }
        else
        {
            this.eliminar.setDisable(true);
            this.editar.setDisable(true);
        }
    }

}