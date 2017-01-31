/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   09/01/2017.
 */

import java.awt.*;
import javax.swing.*;
import java.text.DecimalFormat;
import javax.swing.event.*;

public class Challenge4 extends JApplet
{
    private JLabel temperatureLabel;
    private JSlider slider;

    private JPanel innerPanel;

    public void init()
    {
        makeInnerPanel();
        add(innerPanel);
    }

    private void makeInnerPanel()
    {
        // create the panel
        innerPanel = new JPanel();
        innerPanel.setLayout(new BorderLayout());
        innerPanel.setBorder(BorderFactory.createEmptyBorder(10,20,20,20));

        // create the label
        temperatureLabel = new JLabel("30 C");
        temperatureLabel.setFont(new Font("Sans", Font.PLAIN, 160));
        temperatureLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        // create the slider
        slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 30);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(2);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(new SliderListener());

        // add the components to the panel
        innerPanel.add(temperatureLabel, BorderLayout.NORTH);
        innerPanel.add(slider, BorderLayout.SOUTH);
    }


    private class SliderListener implements ChangeListener
    {
        public void stateChanged(ChangeEvent e)
        {
            double centigrade;
            DecimalFormat fmt = new DecimalFormat("#0.0");

            // get the slider value
            centigrade = slider.getValue();

            // store the centigrade value in its display field
            String temp = Double.toString(centigrade);
            temp += " C";
            temperatureLabel.setText(temp);
        }
    }


}
