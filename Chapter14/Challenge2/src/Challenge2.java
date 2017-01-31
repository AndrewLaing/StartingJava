/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   06/01/2017.
 */

import java.applet.Applet;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;



public class Challenge2 extends Applet
{
    private boolean openLeftWindow = true;
    private boolean openRightWindow = true;
    private boolean openDoor = true;


    public void init()
    {
        setBackground(Color.white);
        addMouseListener(new MyMouseListener());
    }

    public void paint(Graphics g)
    {
        super.paint(g);

        // create the coordinates for the polygon
        int[] xCoords = {0,200,400};
        int[] yCoords = {120,0,120};

        // set the drawing colour
        g.setColor(Color.BLACK);

        // draw the roof as a polygon (xCoords, yCoords,, numberOfPoints)
        g.drawPolygon(xCoords, yCoords, 3);
        // draw the walls as a rectangle
        g.drawRect(20,120,360,140);

        // if the left window is open draw open left window
        if(openLeftWindow)
            g.fillRect(55, 155, 70, 70);
        // if the left window is closed draw closed left window
        else {
            g.drawRect(55, 155, 70, 70);
            g.drawLine(90,155,90,225);
            g.drawLine(55,190,125,190);
        }

        // if the right window is open draw open right window
        if(openRightWindow)
            g.fillRect(275, 155, 70, 70);
        // if the right window is closed draw closed right window
        else {
            g.drawRect(275, 155, 70, 70);
            g.drawLine(310,155,310,225);
            g.drawLine(275,190,345,190);
        }

        // if the door is open draw open door
        if(openDoor)
            g.fillRect(165, 155, 70, 105);
        // if the door is closed draw closed door
        else {

            g.drawRect(165, 155, 70, 105);
            g.fillOval(220, 210, 10, 10);
        }
    }

    private class MyMouseListener extends MouseAdapter
    {
        public void mousePressed(MouseEvent e) {
            int X = e.getX();
            int Y = e.getY();


            if(Y>155 && Y<225)
            {
                // the windows and door are in this range of Y-coordinates
                if(Y>225) {
                }
                    if (X > 55 && X < 125) {
                        if (openLeftWindow)
                            openLeftWindow = false;
                        else
                            openLeftWindow = true;
                        repaint();
                        return;
                    }

                    if (X > 275 && X < 345) {
                        if (openRightWindow)
                            openRightWindow = false;
                        else
                            openRightWindow = true;
                        repaint();
                        return;
                    }

                if(X>165 && X<235){
                    if(openDoor)
                        openDoor = false;
                    else
                        openDoor=true;
                    repaint();
                    return;
                }

            }
            // in this range the only possibility is the door
            else if(Y>225 && Y<260)
            {
                if(X>165 && X<235){
                    if(openDoor)
                        openDoor = false;
                    else
                        openDoor=true;
                    repaint();
                    return;
                }

            }
            else
                return;
        }
    }
}
