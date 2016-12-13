/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class GuardarRecord {

    
    public static void crearArchivo(String save){
        try{
            File guardar = new File("\\temp\\save.proyecto");
            guardar.getParentFile().mkdirs();
            FileWriter escritor = new FileWriter(guardar);
            escritor.write(save);
            escritor.close();
        }
        
        catch(Exception e){
            System.out.println("Error al guardar nuevo Jugador");
            e.printStackTrace();
        }
    }
    static public boolean CrearArchivo(){
        try {
            
            Scanner scanner = new Scanner(new File("\\temp\\save.proyecto"));
            int numeroUsuarios;
            numeroUsuarios = Integer.parseInt(scanner.nextLine());
            ArrayList<Usuario> usuarios = new ArrayList<>();
            for (int i = 0; i < numeroUsuarios; i++){
                String nickname = scanner.nextLine();
                int puntaje = Integer.parseInt(scanner.nextLine());
                Usuario usuario = new Usuario(nickname, puntaje);
            }
            return true;
                
                
        } catch (FileNotFoundException ex) {
            return false;
        }
    }
}
