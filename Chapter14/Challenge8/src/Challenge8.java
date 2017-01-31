/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   12/01/2017.
 */

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class Challenge8 extends Applet
{
    private DecimalFormat secondsFormat  = new DecimalFormat("#00.00");
    private double seconds = 0;
    private boolean stopwatchRunning = false;
    private final int TIME_DELAY = 10;


    private Panel timerPanel;
    private Label timeLabel;

    private Panel buttonPanel;
    private Button startButton;
    private Button stopButton;

    private Timer timer;

    public void init()
    {
        Panel paddingPanel = new Panel();
        paddingPanel.setLayout(new BorderLayout());

        buildTimerPanel();
        buildButtonPanel();

        timer = new Timer(TIME_DELAY, new TimerListener());

        paddingPanel.add(timerPanel, BorderLayout.NORTH);
        paddingPanel.add(buttonPanel, BorderLayout.CENTER);

        add(paddingPanel);
    }

    public void buildTimerPanel()
    {
        timerPanel = new Panel();

        timeLabel = new Label(secondsFormat.format(seconds));
        timeLabel.setFont(new Font("Sans", Font.BOLD, 40));
        timeLabel.setAlignment(Label.CENTER);
        timerPanel.add(timeLabel);
    }

    public void buildButtonPanel()
    {
        buttonPanel = new Panel();
        buttonPanel.setLayout(new GridLayout(1,2));

        startButton = new Button("Start");
        startButton.setFont(new Font("Sans", Font.BOLD, 20));
        startButton.addActionListener(new ButtonListener());

        stopButton = new Button("Stop");
        stopButton.setFont(new Font("Sans", Font.BOLD, 20));
        stopButton.addActionListener(new ButtonListener());

        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
    }


    public class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == startButton) {
                if(stopwatchRunning == false)
                {
                    stopwatchRunning = true;
                    timer.start();
                }
            }
            else if(e.getSource() == stopButton) {
                if(stopwatchRunning == true)
                {
                    stopwatchRunning = false;
                    timer.stop();
                }
            }
        }
    }

    private class TimerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            // Update the timerLabel
            seconds += 0.01;
            timeLabel.setText(secondsFormat.format(seconds));
        }
    }

}
