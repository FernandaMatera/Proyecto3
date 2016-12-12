/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto3;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Fernanda Matera
 */
public class Juego extends JPanel implements ActionListener{
    final int TableroWidth = 9;
    final int TableroHeight = 9;
    Timer timer;
    boolean isFallingFinished = false;
    boolean isStarted = false;
    int numLinesRemoved = 0;
    int curX = 0;
    int curY = 0;
    JLabel statusbar;
    Caramelo curPiece;
    private TipoCaramelo tipo;
    
 
    public Juego(CandyCrush parent)
    {
        setFocusable(true);
        curPiece = new Caramelo();
        timer = new Timer(90, this);
        timer.start();
        statusbar =  parent.getStatusBar();
        tablero = new tipo[TableroWidth * TableroHeight];
        limpiarTablero(); 
    }

    public void eventoRealizado(ActionEvent e)
    {
        if (isFallingFinished) {
            isFallingFinished = false;
            nuevaPieza();
        } else {
            oneLineDown();
        }
    }

    int squareWidth() { return (int) getSize().getWidth() / TableroWidth; }
    int squareHeight() { return (int) getSize().getHeight() / TableroHeight; }
    tipo shapeAt(int x, int y) { return tablero[(y * TableroWidth) + x]; }

    public void start()
    {
        isStarted = true;
        isFallingFinished = false;
        numLinesRemoved = 0;
        limpiarTablero();
        nuevaPieza();
        timer.start();
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        java.awt.Dimension size = getSize();
        int boardTop = (int) size.getHeight() - TableroHeight * squareHeight();
        
        for (int i = 0; i < TableroHeight; ++i)
        {
            for (int j = 0; j < TableroWidth; ++j) 
            {
               tipo shape = shapeAt(j, TableroHeight - i - 1);
               
               if (shape != tipo.nStripes)
                drawSquare(g, 0 + j * squareWidth(),
                boardTop + i * squareHeight(), shape);
            }
        }
        
        if (curPiece.getShape() != tipo.nStripes) 
        {
            for (int i = 0; i < 4; ++i)
            {
                int x = curX + curPiece.x(i);
                int y = curY - curPiece.y(i);
                drawSquare(g, 0 + x * squareWidth(),
                boardTop + (TableroHeight - y - 1) * squareHeight(),
                curPiece.getShape());
            }
        }
    }

    private void caerPieza()
    {
        int newY = curY;
        while (newY > 0) 
        {
            if (!verificarMovimiento(curPiece, curX, newY - 1))
                break;
                --newY;
        }
        pieceDropped();
    }

    private void oneLineDown()
    {
        if (!verificarMovimiento(curPiece, curX, curY - 1))
            pieceDropped();
    }

    private void limpiarTablero()
    {
        for (int i = 0; i < TableroHeight * TableroWidth; ++i)
            tablero[i] = tipo.nStripes;
    }

    private void pieceDropped()
    {
       for (int i = 0; i < 4; ++i) 
       {
            int x = curX + curPiece.x(i);
            int y = curY - curPiece.y(i);
            tablero[(y * TableroWidth) + x] = curPiece.getCaramelo();
        }
        eliminarLinea();
        if (!isFallingFinished)
            nuevaPieza();
    }

    private void nuevaPieza()
    {
        curPiece.setRandomCaramelo();
        curX = TableroWidth / 2 + 1;
        curY = TableroHeight - 1 + curPiece.minY();

        if (!verificarMovimiento(curPiece, curX, curY)) 
        {
            curPiece.setShape(tipo.nStripes);
            timer.stop();
            isStarted = false;
            statusbar.setText("game over");
        }
    }

    private boolean verificarMovimiento(Caramelo newPiece, int newX, int newY)
    {
        for (int i = 0; i < 4; ++i) 
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
            isFallingFinished = true;
            curPiece.setShape(tipo.nStripes);
            repaint();
        }
    }

   }