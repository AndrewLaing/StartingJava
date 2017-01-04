/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   01/01/2017.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class ShadeDesignerGUI extends JFrame
{
    DecimalFormat pounds = new DecimalFormat("£#0.00");

    private JPanel bannerPanel;
    private JLabel bannerLabel;

    private JPanel comboBoxPanel;
    private JLabel stylesLabel;
    private JComboBox stylesComboBox;
    private JLabel sizesLabel;
    private JComboBox sizesComboBox;
    private JLabel coloursLabel;
    private JComboBox coloursComboBox;
    private JLabel numbersLabel;
    private JComboBox numbersComboBox;

    // The contents of the combo boxes and their costs
    private final String[] styles = {"Regular shades", "Folding shades", "Roman shades"};
    private final int[] stylesCosts = {             0,               10,             15};
    private final String[] sizes = {"25 inches wide", "27 inches wide", "32 inches wide", "40 inches wide"};
    private final int[] sizesCosts = {             0,                2,                4,                6};
    private final String[] colours = {"Natural", "Blue", "Teal", "Red", "Green"};
    private final int[] coloursCosts = {     5,      0,      0,     0,       0};
    private final String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};


    private JPanel chargesPanel;
    private JLabel chargesLabel;
    private JTextField chargesText;


    /**
     * Constructor
     */
    public ShadeDesignerGUI()
    {
        setTitle("Shade Designer");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a panel for adding padding around the interior panels
        JPanel paddingPanel = new JPanel();
        paddingPanel.setLayout(new BorderLayout());
        paddingPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        buildBannerPanel();
        buildComboBoxPanel();
        buildChargesPanel();

        paddingPanel.add(bannerPanel, BorderLayout.NORTH);
        paddingPanel.add(comboBoxPanel, BorderLayout.CENTER);
        paddingPanel.add(chargesPanel, BorderLayout.SOUTH);

        add(paddingPanel);

        pack();
        setVisible(true);
    }

    private void buildBannerPanel()
    {
        // create the panel
        bannerPanel = new JPanel();
        bannerPanel.setLayout(new BorderLayout());
        bannerPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 30, 0));

        // create the panel's components
        bannerLabel = new JLabel(" Shade Order Calculator ");
        bannerLabel.setFont(new Font("Sans", Font.PLAIN, 20));
        bannerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // add the label to this panel
        bannerPanel.add(bannerLabel, BorderLayout.CENTER);
    }

    private void buildComboBoxPanel()
    {
        comboBoxPanel = new JPanel();
        comboBoxPanel.setLayout(new GridLayout(4, 2));

        stylesLabel = new JLabel("Style:         ");
        stylesLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        sizesLabel = new JLabel("Size:         ");
        sizesLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        coloursLabel = new JLabel("Colour:         ");
        coloursLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        numbersLabel = new JLabel("Number of items:         ");
        numbersLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        stylesComboBox = new JComboBox(styles);
        sizesComboBox = new JComboBox(sizes);
        coloursComboBox = new JComboBox(colours);
        numbersComboBox = new JComboBox(numbers);

        stylesComboBox.addActionListener(new ComboListener());
        sizesComboBox.addActionListener(new ComboListener());
        coloursComboBox.addActionListener(new ComboListener());
        numbersComboBox.addActionListener(new ComboListener());

        comboBoxPanel.add(stylesLabel);
        comboBoxPanel.add(stylesComboBox);
        comboBoxPanel.add(sizesLabel);
        comboBoxPanel.add(sizesComboBox);
        comboBoxPanel.add(coloursLabel);
        comboBoxPanel.add(coloursComboBox);
        comboBoxPanel.add(numbersLabel);
        comboBoxPanel.add(numbersComboBox);
    }

    private void buildChargesPanel()
    {
        chargesPanel = new JPanel();
        chargesPanel.setLayout(new BorderLayout());
        chargesPanel.setBorder(BorderFactory.createEmptyBorder(30,0,10,0));

        chargesLabel = new JLabel("Total charges:     ");
        chargesLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        chargesText = new JTextField();
        chargesText.setHorizontalAlignment(SwingConstants.CENTER);
        chargesText.setEditable(false);
        updateTotalCharges();

        chargesPanel.add(chargesLabel,BorderLayout.WEST);
        chargesPanel.add(chargesText, BorderLayout.CENTER);
    }


    /**
     * The method updateTotalCharges finds out which combo box items
     * are selected, calculates the total charges, and updates the
     * Total Charges text field
     */
    private void updateTotalCharges()
    {
        double total = 50.0;

        total += stylesCosts[stylesComboBox.getSelectedIndex()];
        total += sizesCosts[sizesComboBox.getSelectedIndex()];
        total += coloursCosts[coloursComboBox.getSelectedIndex()];
        total *= (numbersComboBox.getSelectedIndex() + 1);

        chargesText.setText(pounds.format(total));
    }


    /**
     * Private inner class that responds to items being selected
     * in the combo boxes.
     */
    private class ComboListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            updateTotalCharges();
        }
    }
}
