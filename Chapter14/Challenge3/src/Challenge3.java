/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   08/01/2017.
 */

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;


// TODO: 08/01/2017 Add a check so that if the mouse goes out of bounds the pupils reset to their start position

public class Challenge3 extends Applet
{
    // Constants for the starting coordinates of the pupils
    //   these are used to reset the position of the pupils when
    //   the mouse cursor goes off screen
    private final int leftStartX = 220;
    private final int pupilStartY = 280;
    private final int rightStartX = 320;
    private final int pupilDiameter = 20;

    // Constants for the coordinates of the outer eyes
    private final int leftEyeX = 190;
    private final int rightEyeX = 290;
    private final int bothEyesY = 230;
    private final int eyeWidth = 80;
    private final int eyeHeight = 120;
    private final int distanceBetweenEyes = 20;

    // Constants for the center point between the eyes
    private final int centerX = 270;
    private final int centerY = 280;

    // Variables used for the coordinates of the pupils
    private int leftPupilX = leftStartX;
    private int rightPupilX = rightStartX;
    private int leftPupilY = pupilStartY;
    private int rightPupilY = pupilStartY;


    public void init()
    {
        setBackground(Color.blue);
        addMouseMotionListener(new MyMouseMotionListener());
    }

    public void paint(Graphics g)
    {
        super.paint(g);

        // draw the left outer eye
        g.setColor(Color.white);
        g.fillOval(leftEyeX, bothEyesY, eyeWidth, eyeHeight);
        g.setColor(Color.black);
        g.drawOval(leftEyeX, bothEyesY, eyeWidth, eyeHeight);

        // draw the left pupil
        g.fillOval(leftPupilX, leftPupilY, pupilDiameter, pupilDiameter);


        // draw the right outer eye
        g.setColor(Color.white);
        g.fillOval(rightEyeX, bothEyesY, eyeWidth, eyeHeight);
        g.setColor(Color.black);
        g.drawOval(rightEyeX, bothEyesY, eyeWidth, eyeHeight);

        // draw the right pupil
        g.fillOval(rightPupilX, rightPupilY, pupilDiameter, pupilDiameter);

    }


    private class MyMouseMotionListener extends MouseMotionAdapter
    {

        // calculate the offset and set the pupil coordinates
        public void calculatePupilCoordinates(int mouseX, int mouseY){
            if(mouseX<=50 || mouseX >=530 || mouseY <=50 || mouseY >=530 )
                {
                leftPupilX = leftStartX;
                rightPupilX = rightStartX;
                leftPupilY = pupilStartY;
                rightPupilY = pupilStartY;
                return;
            }

            int offsetLeft_x = mouseX - centerX ;
            int offsetRight_x = mouseX - centerX;
            int offset_y = mouseY - centerY;

            double leftDistance  = Math.sqrt( offsetLeft_x * offsetLeft_x + offset_y * offset_y);
            double rightDistance = Math.sqrt( offsetRight_x * offsetRight_x + offset_y * offset_y);

            // If the distance from the center of the eyeball is greater than eyeWidth/2,
            // we simulate the the mouse is eyeWidth/2 pixels away from the center.
            if (leftDistance >= (eyeWidth/2)) {
                double scale_factor = (eyeWidth/2) / leftDistance;
                offsetLeft_x *= scale_factor;
            }
            if (rightDistance >= (eyeWidth/2)) {
                double scale_factor = (eyeWidth/2) / rightDistance;
                offsetRight_x *= scale_factor;
                offset_y *= scale_factor;
            }

            offsetLeft_x *= 0.60;
            offsetRight_x *= 0.60;

            // set the pupil positions
            leftPupilX =  ( centerX - ((eyeWidth+distanceBetweenEyes)/2) ) + offsetLeft_x;
            rightPupilX = ( centerX + ((eyeWidth+distanceBetweenEyes)/2) ) + offsetRight_x;
            leftPupilY =   centerY + offset_y;
            rightPupilY =  centerY + offset_y;
        }


        public void mouseMoved(MouseEvent e)
        {
            int mouseX = e.getX();
            int mouseY = e.getY();
            calculatePupilCoordinates(mouseX, mouseY);
            repaint();
        }
    }
}
