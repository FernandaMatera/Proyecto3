package proyecto3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis
 */
public enum TipoCaramelos {
    AMARILLOS("Candy_5.png"),ROJOS("Candy_3.png"),MORADOS("Candy_2.png"),AZULES("Candy_1.png"),NARANJOS("Candy_6.png"),VERDES("Candy_4.png");

    private final String filename;
    
    private TipoCaramelos(String filename)
    {
        this.filename = filename;
    }

    public String getFilename()
    {
        return filename;
    }
    
    
}
