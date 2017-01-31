/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   05/01/2017.
 */

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;


public class Challenge1 extends Applet
{
    private Font myFont;
    private String myString;
    private int currentX = 200;
    private int currentY = 200;

    public void init()
    {
        myFont = new Font("SansSerif", Font.BOLD, 35);
        myString = "Hello";
        addMouseMotionListener(new MyMouseMotionListener());
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.red);
        g.setFont(myFont);
        g.drawString(myString, currentX, currentY);
    }


    private class MyMouseMotionListener extends MouseMotionAdapter
    {
        public void mouseMoved(MouseEvent e) {
            currentX = e.getX();
            currentY = e.getY();
            repaint();
        }
    }
}