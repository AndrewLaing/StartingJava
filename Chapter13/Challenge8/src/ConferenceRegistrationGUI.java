/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   01/01/2017.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class ConferenceRegistrationGUI extends JFrame
{
    private final DecimalFormat pounds = new DecimalFormat("£#0.00");

    private JPanel bannerPanel;
    private JLabel bannerLabel;

    private JPanel inputPanel;
        // inner titled panels
        private JPanel registrationPanel;
        private JRadioButton generalRadioBtn;
        private JRadioButton studentRadioBtn;

        private JPanel openingNightPanel;
        private JCheckBox dinnerCheckBox;

        private JPanel workshopsPanel;
        private JCheckBox introCheckBox;
        private JCheckBox webCheckBox;
        private JCheckBox javaCheckBox;
        private JCheckBox securityCheckBox;


    private JPanel totalPanel;
    private JLabel totalLabel;
    private JTextField totalText;


    public ConferenceRegistrationGUI()
    {
        setTitle("Conference Registration");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        buildBannerPanel();
        buildInputPanel();
        buildTotalPanel();

        // Create a panel for adding padding around the interior panels
        JPanel paddingPanel = new JPanel();
        paddingPanel.setLayout(new BorderLayout());
        paddingPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        paddingPanel.add(bannerPanel, BorderLayout.NORTH);
        paddingPanel.add(inputPanel, BorderLayout.CENTER);
        paddingPanel.add(totalPanel, BorderLayout.SOUTH);

        updateTotal();

        add(paddingPanel);

        pack();
        setVisible(true);
    }

    private void buildBannerPanel()
    {
        // create the panel
        bannerPanel = new JPanel();
        bannerPanel.setLayout(new BorderLayout());
        bannerPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 20, 0));

        // create the panel's components
        bannerLabel = new JLabel(" Conference Registration System ");
        bannerLabel.setFont(new Font("Sans", Font.PLAIN, 20));
        bannerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // add the label to this panel
        bannerPanel.add(bannerLabel, BorderLayout.CENTER);
    }


    private void buildInnerRegistrationPanel()
    {
        // Create the panel
        registrationPanel = new JPanel();
        registrationPanel.setLayout(new GridLayout(2, 1));
        registrationPanel.setBorder(BorderFactory.createTitledBorder("REGISTRATION"));

        // Create the radio buttons
        generalRadioBtn = new JRadioButton("General registration", true);
        studentRadioBtn = new JRadioButton("Student registration");

        // Group the radio buttons together
        ButtonGroup group = new ButtonGroup();
        group.add(generalRadioBtn);
        group.add(studentRadioBtn);

        // add the listener to the radio buttons
        generalRadioBtn.addActionListener(new SelectedListener());
        studentRadioBtn.addActionListener(new SelectedListener());

        // Add the buttons to the panel
        registrationPanel.add(generalRadioBtn);
        registrationPanel.add(studentRadioBtn);
    }

    private void buildInnerOpeningNightPanel()
    {
        // Create the panel
        openingNightPanel = new JPanel();
        openingNightPanel.setLayout(new GridLayout(1, 1));
        openingNightPanel.setBorder(BorderFactory.createTitledBorder("OPENING NIGHT"));

        // create the check box and add the listener
        dinnerCheckBox = new JCheckBox("Dinner with keynote speech");
        dinnerCheckBox.addActionListener(new SelectedListener());

        // add the check box to the panel
        openingNightPanel.add(dinnerCheckBox);
    }

    private void buildInnerWorkshopsPanel()
    {
        // Create the panel
        workshopsPanel = new JPanel();
        workshopsPanel.setLayout(new GridLayout(4, 1));
        workshopsPanel.setBorder(BorderFactory.createTitledBorder("OPTIONAL PRECONFERENCE WORKSHOPS"));

        // Add the checkboxes
        introCheckBox = new JCheckBox("Introduction to E-commerce");
        webCheckBox = new JCheckBox("The Future of the Web");
        javaCheckBox = new JCheckBox("Advanced Java Programming");
        securityCheckBox = new JCheckBox("Network Security");

        // add the listener to the check boxes
        introCheckBox.addActionListener(new SelectedListener());
        webCheckBox.addActionListener(new SelectedListener());
        javaCheckBox.addActionListener(new SelectedListener());
        securityCheckBox.addActionListener(new SelectedListener());

        // add the check boxes to the panel
        workshopsPanel.add(introCheckBox);
        workshopsPanel.add(webCheckBox);
        workshopsPanel.add(javaCheckBox);
        workshopsPanel.add(securityCheckBox);
    }

    private void buildInputPanel()
    {
        inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        buildInnerRegistrationPanel();
        buildInnerOpeningNightPanel();
        buildInnerWorkshopsPanel();

        inputPanel.add(registrationPanel, BorderLayout.NORTH);
        inputPanel.add(openingNightPanel, BorderLayout.CENTER);
        inputPanel.add(workshopsPanel, BorderLayout.SOUTH);

    }

    private void buildTotalPanel()
    {
        totalPanel = new JPanel();
        totalPanel.setLayout(new BorderLayout());
        totalPanel.setBorder(BorderFactory.createEmptyBorder(30,0,10,0));

        totalLabel = new JLabel("Total cost:     ");
        totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        totalText = new JTextField(7);
        totalText.setHorizontalAlignment(SwingConstants.CENTER);
        totalText.setEditable(false);
        totalText.setBackground(Color.white);

        totalPanel.add(totalLabel,BorderLayout.CENTER);
        totalPanel.add(totalText, BorderLayout.EAST);
    }


    /**
     * The method updateTotal checks which items are selected, calculates
     * the total cost, and updates the total cost text field.
     */
    private void updateTotal()
    {
        double total = 0.0;

        if(generalRadioBtn.isSelected())
            total += 895.0;
        else if(studentRadioBtn.isSelected())
            total += 495.0;

        if(dinnerCheckBox.isSelected())
            total += 30.0;

        if(introCheckBox.isSelected())
            total += 295.0;
        if(webCheckBox.isSelected())
            total += 295.0;
        if(javaCheckBox.isSelected())
            total += 395.0;
        if(securityCheckBox.isSelected())
            total += 395.0;

        totalText.setText(pounds.format(total));
    }


    /**
     * Private class that deals with the radio buttons and check boxes
     * being selected
     */
    private class SelectedListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            updateTotal();
        }
    }
}
