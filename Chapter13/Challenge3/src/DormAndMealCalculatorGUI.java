/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   27/12/2016.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;


public class DormAndMealCalculatorGUI extends JFrame
{
    private final DecimalFormat pounds = new DecimalFormat("£#.00");

    // The contents of the combo boxes and their costs
    private final String[] dorms = {"Allen Hall", "Pike Hall", "Farthing Hall", "University Suites"};
    private final int[] dormCosts = {      1500,        1600,            1200,                 1800};
    private final String[] meals = {"7 meals per week", "14 meals per week", "Unlimited meals"};
    private final int[] mealCosts = {             560,                1095,              1500};

    private JPanel bannerPanel;
    private JLabel bannerLabel;

    private JPanel comboBoxPanel;
    private JLabel dormLabel;
    private JComboBox dormComboBox;
    private JLabel mealLabel;
    private JComboBox mealComboBox;

    private JPanel chargesPanel;
    private JLabel chargesLabel;
    private JTextField chargesText;


    public DormAndMealCalculatorGUI()
    {
        setTitle("Combo Box Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        buildBannerPanel();
        buildComboBoxPanel();
        buildChargesPanel();

        // Create a panel for adding padding around the interior panels
        JPanel paddingPanel = new JPanel();
        paddingPanel.setLayout(new BorderLayout());
        paddingPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

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
        bannerLabel = new JLabel(" Dorm and Meal Plan Calculator ");
        bannerLabel.setFont(new Font("Sans", Font.PLAIN, 20));
        bannerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // add the label to this panel
        bannerPanel.add(bannerLabel, BorderLayout.CENTER);
    }

    private void buildComboBoxPanel()
    {
        comboBoxPanel = new JPanel();
        comboBoxPanel.setLayout(new GridLayout(2, 2));

        dormLabel = new JLabel("Dormitory:     ");
        dormLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        mealLabel = new JLabel("Meal:     ");
        mealLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        dormComboBox = new JComboBox(dorms);
        mealComboBox = new JComboBox(meals);

        dormComboBox.addActionListener(new ComboBoxSelectListener());
        mealComboBox.addActionListener(new ComboBoxSelectListener());

        comboBoxPanel.add(dormLabel);
        comboBoxPanel.add(dormComboBox);
        comboBoxPanel.add(mealLabel);
        comboBoxPanel.add(mealComboBox);
    }

    private void buildChargesPanel()
    {
        chargesPanel = new JPanel();
        chargesPanel.setLayout(new BorderLayout());
        chargesPanel.setBorder(BorderFactory.createEmptyBorder(30,0,10,0));

        chargesLabel = new JLabel("Total charges for semester:     ");
        chargesLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        chargesText = new JTextField();
        chargesText.setHorizontalAlignment(SwingConstants.CENTER);
        chargesText.setEditable(false);
        chargesText.setText(pounds.format(dormCosts[0] + mealCosts[0]));

        chargesPanel.add(chargesLabel,BorderLayout.WEST);
        chargesPanel.add(chargesText, BorderLayout.CENTER);

    }


    private class ComboBoxSelectListener implements ActionListener
    {

        private void updateChargesText()
        {
            int dormCost = dormCosts[dormComboBox.getSelectedIndex()];
            int mealCost = mealCosts[mealComboBox.getSelectedIndex()];

            chargesText.setText(pounds.format((dormCost + mealCost)));
        }


        public void actionPerformed(ActionEvent e) {
            updateChargesText();

        }
    }


}
