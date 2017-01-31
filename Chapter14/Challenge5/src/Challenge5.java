/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   09/01/2017.
 */

import java.applet.Applet;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;


public class Challenge5 extends Applet
{
    // create the coordinates for the polygon
    private int MAX_POINTS = 6;
    private int[] xCoords = {0,0,0,0,0,0};
    private int[] yCoords = {0,0,0,0,0,0};
    private int coordsAdded = 0;

    public void init()
    {
        setBackground(Color.lightGray);
        addMouseListener(new MyMouseListener());
    }

    public void paint(Graphics g)
    {
        super.paint(g);

        // set the drawing colour
        g.setColor(Color.red);

        if(coordsAdded >= MAX_POINTS) {
            // draw the polygon (xCoords, yCoords,, numberOfPoints)
            g.fillPolygon(xCoords, yCoords, MAX_POINTS);
        }
        else {
            // draw the points clicked
            for(int i=0; i<coordsAdded; i++)
                g.fillOval(xCoords[i], yCoords[i], 2, 2);
        }

    }

    private class MyMouseListener extends MouseAdapter
    {
        public void mousePressed(MouseEvent e)
        {
            // reset on the click after the shape is drawn
            if(coordsAdded>=MAX_POINTS) {
                coordsAdded = 0;
            }
            xCoords[coordsAdded] = e.getX();
            yCoords[coordsAdded] = e.getY();
            coordsAdded++;

            repaint();
        }
    }

}
