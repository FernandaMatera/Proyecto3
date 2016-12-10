
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis Aburto
 */
public class Lector {
     private final Scanner scanner;
    
    public Lector()
    {
        this.scanner = new Scanner(System.in);
    }
    /**
     * 
     * @param nick Es del tipo String, corresponde al texto para interactuar con el usuario
     * @return Se devuelve un String que fue ingresado por el usuario
     */
    public String leerNombre(String nick)
    {
        System.out.print(nick + ": ");
        return this.scanner.nextLine();
    }


 

}

