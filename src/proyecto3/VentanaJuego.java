/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


class VentanaJuego extends Stage
{
    
    public VentanaJuego()
    {
        BorderPane mainPane = new BorderPane();

        FXproyecto3Canvas paint = new FXproyecto3Canvas();
        mainPane.setCenter(paint);

        //Para que el Canvas tome el tamano del panel contenedor
        paint.widthProperty().bind(mainPane.widthProperty());
        paint.heightProperty().bind(mainPane.heightProperty());

        Scene scene = new Scene(mainPane, 800, 600);
        super.setScene(scene);
        super.setTitle("CandyPirates");
        //super.setResizable(false);
        //super.setFullScreen(true);


    }
}

