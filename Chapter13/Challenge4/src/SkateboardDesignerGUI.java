/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   28/12/2016.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.text.DecimalFormat;


public class SkateboardDesignerGUI extends JFrame
{
    private final DecimalFormat pounds = new DecimalFormat("£#.00");
    private final double TAX = 0.06;

    private JPanel bannerPanel;
    private JPanel inputPanel;
    private JPanel totalsPanel;

    private JLabel bannerLabel;

    private JLabel decksLabel;
    private JComboBox decksComboBox;
    private JLabel trucksLabel;
    private JComboBox trucksComboBox;
    private JLabel wheelsLabel;
    private JComboBox wheelsComboBox;

    private String[] decksAvailable = {"The Master Thrasher", "The Dictator", "The Street King"};
    private int[] deckCosts         = {                  60,             45,                50};
    private String[] trucksAvailable = {"7.75 inch axle", "8 inch axle", "8.5 inch axle"};
    private int[] truckCosts         = {             35,             40,             45};
    private String[] wheelsAvailable = {"51mm", "55mm", "58mm", "61mm"};
    private int[] wheelCosts         = {   20,     22,     24,     28};

    private JLabel miscLabel;
    private JList miscellaneousList;
    private String[] miscAvailable = {"Grip tape", "Bearings", "Riser Pads", "Nuts & Bolts kit"};
    private int[] miscCosts         = {       10,         30,            2,                  3};

    private JLabel subtotalLabel;
    private JLabel salesTaxLabel;
    private JLabel totalLabel;
    private JTextField subtotalText;
    private JTextField salesTaxText;
    private JTextField totalText;


    public SkateboardDesignerGUI()
    {
        setTitle("Skateboard Designer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        // create the interior panels
        buildBannerPanel();
        buildInputPanel();
        buildTotalsPanel();

        // Create a panel for adding padding around the interior panels
        JPanel paddingPanel = new JPanel();
        paddingPanel.setLayout(new BorderLayout());
        paddingPanel.setBorder(BorderFactory.createEmptyBorder(10,20,20,20));

        // add the interior panels to the padding panel
        paddingPanel.add(bannerPanel, BorderLayout.NORTH);
        paddingPanel.add(inputPanel, BorderLayout.CENTER);
        paddingPanel.add(totalsPanel, BorderLayout.SOUTH);

        add(paddingPanel);

        updateTotalsPanel();

        pack();
        setVisible(true);
    }

    public void buildBannerPanel()
    {
        // create the panel
        bannerPanel = new JPanel();
        bannerPanel.setLayout(new BorderLayout());
        bannerPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));

        // create the panel's components
        bannerLabel = new JLabel(" The Skate Shop Skateboard Designer ");
        bannerLabel.setFont(new Font("Sans", Font.PLAIN, 20));
        bannerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // add the label to this panel
        bannerPanel.add(bannerLabel, BorderLayout.CENTER);
    }

    public void buildInputPanel()
    {
        inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // create the inner comboBoxPanel
        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.setLayout(new GridLayout(6, 1));

        decksLabel = new JLabel(" Decks:");
        decksLabel.setHorizontalAlignment(SwingConstants.LEFT);

        trucksLabel = new JLabel(" Truck Assemblies:");
        trucksLabel.setHorizontalAlignment(SwingConstants.LEFT);

        wheelsLabel = new JLabel(" Wheels:");
        wheelsLabel.setHorizontalAlignment(SwingConstants.LEFT);

        decksComboBox = new JComboBox(decksAvailable);
        trucksComboBox = new JComboBox(trucksAvailable);
        wheelsComboBox = new JComboBox(wheelsAvailable);

        decksComboBox.addActionListener(new ItemsSelectedListener());
        trucksComboBox.addActionListener(new ItemsSelectedListener());
        wheelsComboBox.addActionListener(new ItemsSelectedListener());

        // add the components to the inner comboBoxPanel
        comboBoxPanel.add(decksLabel);
        comboBoxPanel.add(decksComboBox);
        comboBoxPanel.add(trucksLabel);
        comboBoxPanel.add(trucksComboBox);
        comboBoxPanel.add(wheelsLabel);
        comboBoxPanel.add(wheelsComboBox);

        // create the inner listPanel
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BorderLayout());
        listPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        miscLabel = new JLabel(" Miscellaneous products and services:");
        miscellaneousList = new JList(miscAvailable);

        // Allow the user to select multiple products
        miscellaneousList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // Add a line to the border of the miscellaneousList
        miscellaneousList.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        miscellaneousList.addListSelectionListener(new ListListener());

        // add the components to the inner listPanel
        listPanel.add(miscLabel, BorderLayout.NORTH);
        listPanel.add(miscellaneousList, BorderLayout.CENTER);

        // add the interior panels to the input panel
        inputPanel.add(comboBoxPanel, BorderLayout.NORTH);
        inputPanel.add(listPanel, BorderLayout.CENTER);
    }

    public void buildTotalsPanel()
    {
        totalsPanel = new JPanel();
        totalsPanel.setLayout(new GridLayout(2, 3));

        subtotalLabel = new JLabel("Subtotal:");
        subtotalLabel.setHorizontalAlignment(SwingConstants.LEFT);

        salesTaxLabel = new JLabel("Sales Tax:");
        salesTaxLabel.setHorizontalAlignment(SwingConstants.LEFT);

        totalLabel = new JLabel("Total:");
        totalLabel.setHorizontalAlignment(SwingConstants.LEFT);

        subtotalText = new JTextField(5);
        subtotalText.setEditable(false);

        salesTaxText = new JTextField(5);
        salesTaxText.setEditable(false);

        totalText = new JTextField(5);
        totalText.setEditable(false);

        totalsPanel.add(subtotalLabel);
        totalsPanel.add(salesTaxLabel);
        totalsPanel.add(totalLabel);
        totalsPanel.add(subtotalText);
        totalsPanel.add(salesTaxText);
        totalsPanel.add(totalText);

    }


    private void updateTotalsPanel()
    {
        int subtotal = 0;

        subtotal += deckCosts[decksComboBox.getSelectedIndex()];
        subtotal += truckCosts[trucksComboBox.getSelectedIndex()];
        subtotal += wheelCosts[wheelsComboBox.getSelectedIndex()];

        int[] miscIndices = miscellaneousList.getSelectedIndices();
        for(int i=0; i<miscIndices.length; i++)
            subtotal += miscCosts[miscIndices[i]];

        double salesTax = subtotal * TAX;

        double total = subtotal + salesTax;

        subtotalText.setText(pounds.format((subtotal)));
        salesTaxText.setText(pounds.format((salesTax)));
        totalText.setText(pounds.format((total)));

    }



    private class ItemsSelectedListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            updateTotalsPanel();
        }
    }

    private class ListListener implements ListSelectionListener
    {
        public void valueChanged(ListSelectionEvent e)
        {
            updateTotalsPanel();
        }
    }

}
