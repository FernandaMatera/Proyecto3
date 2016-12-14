package proyecto3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis
 */
public class CargadorPuntajes {



    public static Sistema cargarArchivo(){
        try
        {
            int cantidad;
            Sistema sistema = new Sistema();
            try (Scanner scanner = new Scanner(new File("\\temp\\save.proyecto"))) {
                cantidad = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < cantidad; i++){
                    String nick = scanner.nextLine();
                    int puntaje = Integer.parseInt(scanner.nextLine());
                }
            }
            return sistema;
        }
        catch(FileNotFoundException e)
        {
            System.out.println("No se ha podido leer el archivo, prueba revisando si existe el archivo");
            return new Sistema();
        }
    }

}


