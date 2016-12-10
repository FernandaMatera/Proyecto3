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
    AMARILLOS(".png"),ROJOS(".png"),MORADOS(".png"),AZULES(".png"),NARANJOS(".png"),VERDES(".png");

    private final String filename;
    
    private Tipo(String filename)
    {
        this.filename = filename;
    }

    public String getFilename()
    {
        return filename;
    }
    
    
}
