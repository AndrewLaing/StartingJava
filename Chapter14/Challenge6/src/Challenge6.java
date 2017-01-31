/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   09/01/2017.
 */

import java.applet.Applet;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;


// TODO: 09/01/2017 write a procedure that iterates through squareStates and if [X][Y] is true
// TODO: 09/01/2017 then draw a circle in that square of width and height int diameter


public class Challenge6 extends Applet
{

    private int[] lineCoords = {0, 100, 200, 300, 400};
    private int lineCoordsLength = 5;
    private int diameter = 100;


    private boolean[][] squareStates = {{false, false, false, false},
                                        {false, false, false, false},
                                        {false, false, false, false},
                                        {false, false, false, false}
                                       };

    public void init()
    {
        setBackground(Color.lightGray);
        addMouseListener(new MyMouseListener());
    }

    public void paint(Graphics g)
    {
        super.paint(g);

        // draw the grid lines
        for(int i=0; i<lineCoordsLength; i++) {
            // draw the vertical lines
            g.drawLine(lineCoords[i], lineCoords[0], lineCoords[i], lineCoords[lineCoordsLength - 1]);
            // draw the horizontal lines
            g.drawLine(lineCoords[0], lineCoords[i], lineCoords[lineCoordsLength - 1], lineCoords[i]);
        }

        // draw any circles that need drawing
        for(int i=0; i < lineCoordsLength-1; i++)
        {
            for(int j=0; j < lineCoordsLength-1; j++)
            {
                if(squareStates[i][j] == true)
                {
                    int x = lineCoords[i];
                    int y = lineCoords[j];
                    g.drawOval(x,y,diameter,diameter);
                }
            }
        }
    }


    private class MyMouseListener extends MouseAdapter
    {
        public void mousePressed(MouseEvent e) {
            int X = e.getX();
            int Y = e.getY();

            // if the user has clicked out of bounds nothing to do here
            if (X < lineCoords[0] || Y < lineCoords[0] ||
                                     X > lineCoords[lineCoordsLength - 1] ||
                                     Y > lineCoords[lineCoordsLength - 1])
            {
                return;
            }

            // used to store squareStates[X][Y]
            int squareStateX=0, squareStateY=0;

            // find out which square was clicked
            for(int i=lineCoordsLength-1; i>0; i--)
            {
                if(X <= lineCoords[i])
                    squareStateX = i-1;
                if(Y <= lineCoords[i])
                    squareStateY = i-1;
            }

            // flip the squareState boolean to its opposite
            squareStates[squareStateX][squareStateY] = !(squareStates[squareStateX][squareStateY]);

            repaint();
        }
    }
}
