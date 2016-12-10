package proyecto3;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;


public class Main extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        VentanaPrincipal stage = new VentanaPrincipal();
        stage.show();
    }

}
