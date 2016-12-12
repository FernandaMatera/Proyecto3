/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3;

/**
 * @author Fernanda Matera
 */

public class Juego{
    private final int TableroWidth = 9;
    private final int TableroHeight = 9;
    private boolean finCaida = false;
    private boolean iniciado = false;
    private int numLinesRemoved = 0;
    private int curX = 0;
    private int curY = 0;
    private Caramelo curPiece;
    private TipoCaramelos tipo;
    private final Caramelo[][] tablero;
    
 
    public Juego()
    {
        this.tablero = new Caramelo[9][9];
    }

    public void start()
    {
        iniciado = true;
        finCaida = false;
        numLinesRemoved = 0;
        limpiarTablero();
        nuevaPieza();
    }

    private void caerPieza()
    {
        int newY = curY;
        while (newY > 0) 
        {
            if (!verificarMovimiento(curPiece, curX, newY - 1))
                break;
                newY--;
        }
        caerPieza();
    }

    private void bajarLinea()
    {
        if (!verificarMovimiento(curPiece, curX, curY - 1))
            caerPieza
        ();
    }

    private void limpiarTablero()
    {
        for (int i = 0; i < TableroHeight; i++){
            for(int j = 0; j < TableroWidth; j++){
                tablero[i][j] = null;
            }
        }
    }

    private void pieceDropped()
    {
       for (int i = 0; i < 8; ++i) 
       {
            int x = curX + curPiece.x(i);
            int y = curY - curPiece.y(i);
            tablero[(y * TableroWidth) + x] = curPiece.getCaramelo();
        }
        eliminarLinea();
        if (!finCaida)
            nuevaPieza();
    }

    private void nuevaPieza()
    {
        curPiece.setRandomCaramelo();
        curX = TableroWidth / 2 + 1;
        curY = TableroHeight - 1 + curPiece.minY();

        if (!verificarMovimiento(curPiece, curX, curY)) 
        {
            curPiece.setCaramelo(tipo.nStripes);
            timer.stop();
            iniciado = false;
            statusbar.setText("game over");
        }
    }

    private boolean verificarMovimiento(Caramelo newPiece, int newX, int newY)
    {
        for (int i = 0; i < 9; ++i) 
        {
            int x = newX + nuevaPieza.x(i);
            int y = newY - nuevaPieza.y(i);
            if (x < 0 || x >= TableroWidth || y < 0 || y >= TableroHeight)
                return false;
            if (shapeAt(x, y) != tipo.nStripes)
                return false;
        }
        
        curPiece = newPiece;
        curX = newX;
        curY = newY;
        repaint();
        return true;
    }

    private void eliminarLinea()
    {
        int numFullLines = 0;
        for (int i = TableroHeight - 1; i >= 0; --i) 
        {
            boolean lineIsFull = true;
            for (int j = 0; j < TableroWidth; ++j)
            {
                if (shapeAt(j, i) == tipo.nStripes)
                {
                    lineIsFull = false;
                    break;
                }
            }
            
            if (lineIsFull)
            {
                ++numFullLines;
                for (int k = i; k < TableroHeight - 1; ++k) 
                {
                    for (int j = 0; j < TableroWidth; ++j)
                        tablero[(k * TableroWidth) + j] = shapeAt(j, k + 1);
                }
            }
        }
        if (numFullLines > 0)
        {
            numLinesRemoved += numFullLines;
            statusbar.setText(String.valueOf(numLinesRemoved));
            finCaida = true;
            curPiece.setShape(tipo.nStripes);
            repaint();
        }
    }

   