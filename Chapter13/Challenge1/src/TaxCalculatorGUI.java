import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   27/12/2016.
 */


public class TaxCalculatorGUI extends JFrame
{
    private DecimalFormat pounds = new DecimalFormat("£#0.00");

    private JPanel bannerPanel;
    private JPanel inputPanel;
    private JPanel bottomPanel;

    private JLabel bannerLabel;

    private JLabel purchaseLabel;
    private JLabel taxRateLabel;
    private JTextField purchaseText;
    private JSlider slider;

    private JLabel salesTaxLabel;
    private JTextField salesTaxText;

    private JButton calculateButton;
    private JButton exitButton;


    /**
     * Constructor
     */
    public TaxCalculatorGUI()
    {
        setTitle("Tax Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        // Create a panel for adding padding around the interior panels
        JPanel paddingPanel = new JPanel();
        paddingPanel.setLayout(new BorderLayout());
        paddingPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        // Create the interior panels
        buildBannerPanel();
        buildInputPanel();
        buildBottomPanel();

        // add the interior panels to the padding panel
        paddingPanel.add(bannerPanel, BorderLayout.NORTH);
        paddingPanel.add(inputPanel,BorderLayout.CENTER);
        paddingPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(paddingPanel);
        pack();
        setVisible(true);
    }


    /**
     * The method buildBannerPanel creates the banner panel
     */
    private void buildBannerPanel()
    {
        bannerPanel = new JPanel();
        bannerPanel.setLayout(new BorderLayout());
        bannerPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 20, 0));

        // create the panel's components
        bannerLabel = new JLabel("   Tax Calculator   ");
        bannerLabel.setFont(new Font("Sans", Font.PLAIN, 20));
        bannerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // add the label to this panel
        bannerPanel.add(bannerLabel, BorderLayout.CENTER);
    }


    /**
     * The method buildInputPanel creates the input panel
     */
    private void buildInputPanel()
    {
        inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 50, 0));

        // create a panel to hold the text input components
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(1, 2));

        // create the textPanel components
        purchaseLabel = new JLabel("Purchase Cost: ");
        purchaseText = new JTextField(10);
        purchaseText.setHorizontalAlignment(SwingConstants.CENTER);

        // add the components to the text panel
        textPanel.add(purchaseLabel);
        textPanel.add(purchaseText);

        // create a panel to hold the slider components
        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridLayout(2, 1));

        // create the slider panel components
        taxRateLabel = new JLabel("Tax Rate", SwingConstants.LEFT);
        slider = new JSlider(0, 10, 5);
        slider.setMajorTickSpacing(5);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        // add the components to the slider panel
        sliderPanel.add(taxRateLabel);
        sliderPanel.add(slider);

        // add the two inner panels to the inputt panel
        inputPanel.add(textPanel, BorderLayout.CENTER);
        inputPanel.add(sliderPanel, BorderLayout.SOUTH);

    }


    /**
     * The method buildBottomPanel creates the bottom panel
     */
    private void buildBottomPanel()
    {
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(3,3));

        // these blank labels are used to layout the panel neatly
        JLabel space = new JLabel();
        JLabel space1 = new JLabel();
        JLabel space2 = new JLabel();
        JLabel space3 = new JLabel();
        JLabel space4 = new JLabel();

        // create the panel's working components
        salesTaxLabel = new JLabel("Sales tax: ");
        salesTaxText = new JTextField(10);
        salesTaxText.setEditable(false);            // set text field as read-only
        calculateButton = new JButton("Calculate");
        exitButton = new JButton("Exit");

        // add ActionListeners to the buttons
        calculateButton.addActionListener(new CalculateListener());
        exitButton.addActionListener(new ExitListener());

        // add mnemonics to the buttons
        calculateButton.setMnemonic(KeyEvent.VK_C);
        exitButton.setMnemonic(KeyEvent.VK_X);

        // add the components to the panel
        bottomPanel.add(space);
        bottomPanel.add(salesTaxLabel);
        bottomPanel.add(salesTaxText);
        bottomPanel.add(space1);
        bottomPanel.add(space2);
        bottomPanel.add(space3);
        bottomPanel.add(space4);
        bottomPanel.add(calculateButton);
        bottomPanel.add(exitButton);
    }


    /**
     * Private inner class that handles the Action Event generated by
     * clicking on the calculate button.
     */
    private class CalculateListener implements ActionListener
    {
        /**
         * The method calculateSalesTax calculates the amount of sales tax due
         * given the purchase cost entered and tax rate selected on the slider
         * and displays it in the sales tax text field.
         */
        private void calculateSalesTax()
        {
            try {
                double cost = Double.parseDouble(purchaseText.getText());
                double salesTax = cost * (slider.getValue()/100.0);
                salesTaxText.setText(pounds.format(salesTax));
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Error - invalid input");
            }
        }

        public void actionPerformed(ActionEvent e) {
            calculateSalesTax();
        }
    }


    /**
     * Private inner class that handles the Action Event generated by
     * clicking on the exit button.
     */
    private class ExitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
}
