/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   31/12/2016.
 */

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class CellPhonePackagesGUI extends JFrame
{
    private DecimalFormat pounds = new DecimalFormat("£#0.00");
    private double totalPrice;

    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem exitItem;

    private JMenu packagesMenu;
    private JRadioButtonMenuItem firstPackageOption;
    private JRadioButtonMenuItem secondPackageOption;
    private JRadioButtonMenuItem thirdPackageOption;

    private JMenu phonesMenu;
    private JRadioButtonMenuItem firstPhoneOption;
    private JRadioButtonMenuItem secondPhoneOption;
    private JRadioButtonMenuItem thirdPhoneOption;

    private JMenu optionsMenu;
    private JCheckBoxMenuItem voiceCheckBox;
    private JCheckBoxMenuItem textCheckBox;

    private JPanel bannerPanel;
    private JLabel bannerLabel;

    private JPanel purchasePanel;
    private JLabel packageLabel;
    private JTextField packageText;
    private JLabel phoneLabel;
    private JTextField phoneText;
    private JLabel optionsLabel;
    private JList optionsList;

    private JPanel totalPanel;
    private JLabel totalLabel;
    private JTextField totalText;

    public CellPhonePackagesGUI()
    {
        totalPrice = 0.0;

        setTitle("Cell Phone Packages");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        // Create a panel for adding padding around the interior panels
        JPanel paddingPanel = new JPanel();
        paddingPanel.setLayout(new BorderLayout());
        paddingPanel.setBorder(BorderFactory.createEmptyBorder(10,20,20,20));

        // build the menu bar
        buildMenuBar();

        // build the inner panels
        buildBannerPanel();
        buildPurchasePanel();
        buildTotalPanel();

        // add the panels to the padding panel
        paddingPanel.add(bannerPanel, BorderLayout.NORTH);
        paddingPanel.add(purchasePanel, BorderLayout.CENTER);
        paddingPanel.add(totalPanel, BorderLayout.SOUTH);

        add(paddingPanel);

        pack();
        setVisible(true);
    }


    private void buildMenuBar()
    {
        menuBar = new JMenuBar();

        // create the file and text menus
        buildFileMenu();
        buildPackagesMenu();
        buildPhonesMenu();
        buildOptionsMenu();

        menuBar.add(fileMenu);
        menuBar.add(packagesMenu);
        menuBar.add(phonesMenu);
        menuBar.add(optionsMenu);

        /// set the window's menu bar
        setJMenuBar(menuBar);
    }

    private void buildFileMenu()
    {
        // create an exit menu item
        exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic(KeyEvent.VK_X);
        exitItem.addActionListener(new ExitListener());

        // Create a JMenu object for the file menu
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        fileMenu.add(exitItem);
    }

    private void buildPackagesMenu()
    {
        // Create the radio button items and add an ActionListener to each one
        firstPackageOption = new JRadioButtonMenuItem("300 minutes per month", true);
        firstPackageOption.addActionListener(new SelectedListener());
        secondPackageOption = new JRadioButtonMenuItem("800 minutes per month", true);
        secondPackageOption.addActionListener(new SelectedListener());
        thirdPackageOption = new JRadioButtonMenuItem("1500 minutes per month", true);
        thirdPackageOption.addActionListener(new SelectedListener());

        // Add the radio buttons to a group
        ButtonGroup group = new ButtonGroup();

        group.add(firstPackageOption);
        group.add(secondPackageOption);
        group.add(thirdPackageOption);

        // Create a JMenu object for the packages menu
        packagesMenu = new JMenu("Packages");
        packagesMenu.setMnemonic(KeyEvent.VK_P);

        packagesMenu.add(firstPackageOption);
        packagesMenu.add(secondPackageOption);
        packagesMenu.add(thirdPackageOption);
    }

    private void buildPhonesMenu()
    {
        // Create the radio button items and add an ActionListener to each one
        firstPhoneOption = new JRadioButtonMenuItem("Model 100", true);
        firstPhoneOption.addActionListener(new SelectedListener());
        secondPhoneOption = new JRadioButtonMenuItem("Model 110", true);
        secondPhoneOption.addActionListener(new SelectedListener());
        thirdPhoneOption = new JRadioButtonMenuItem("Model 200", true);
        thirdPhoneOption.addActionListener(new SelectedListener());

        // Add the radio buttons to a group
        ButtonGroup group = new ButtonGroup();

        group.add(firstPhoneOption);
        group.add(secondPhoneOption);
        group.add(thirdPhoneOption);

        // Create a JMenu object for the phones menu
        phonesMenu = new JMenu("Phones");
        phonesMenu.setMnemonic(KeyEvent.VK_H);

        phonesMenu.add(firstPhoneOption);
        phonesMenu.add(secondPhoneOption);
        phonesMenu.add(thirdPhoneOption);
    }

    private void buildOptionsMenu()
    {
        voiceCheckBox = new JCheckBoxMenuItem("Voice Mail");
        voiceCheckBox.addActionListener(new SelectedListener());
        textCheckBox = new JCheckBoxMenuItem("Text Messaging");
        textCheckBox.addActionListener(new SelectedListener());

        // Create a JMenu object for the options menu
        optionsMenu = new JMenu("Options");
        optionsMenu.setMnemonic(KeyEvent.VK_O);

        optionsMenu.add(voiceCheckBox);
        optionsMenu.add(textCheckBox);
    }


    private void buildBannerPanel()
    {
        // create the panel
        bannerPanel = new JPanel();
        bannerPanel.setLayout(new BorderLayout());
        bannerPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));

        // create the panel's components
        bannerLabel = new JLabel(" Cell Phone Packages ");
        bannerLabel.setFont(new Font("Sans", Font.PLAIN, 20));
        bannerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // add the label to this panel
        bannerPanel.add(bannerLabel, BorderLayout.CENTER);
    }

    private void buildPurchasePanel()
    {
        purchasePanel = new JPanel();
        purchasePanel.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(4,1));

        packageLabel = new JLabel("Selected Package: ");
        packageLabel.setHorizontalAlignment(SwingConstants.LEFT);
        packageText = new JTextField(20);
        packageText.setEditable(false);
        packageText.setBackground(Color.WHITE);
        packageText.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        phoneLabel = new JLabel("Selected Phone: ");
        phoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
        phoneText = new JTextField(20);
        phoneText.setEditable(false);
        phoneText.setBackground(Color.WHITE);
        phoneText.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());

        optionsLabel = new JLabel("Selected Options: ");
        optionsLabel.setHorizontalAlignment(SwingConstants.LEFT);
        String[] test = {" ", " "};
        optionsList = new JList(test);
        optionsList.setVisibleRowCount(4);
        optionsList.setFixedCellWidth(20);
        optionsList.setEnabled(false);
        optionsList.setBackground(Color.WHITE);
        optionsList.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        // create a padding label
        JLabel space = new JLabel(" ");

        topPanel.add(packageLabel);
        topPanel.add(packageText);
        topPanel.add(phoneLabel);
        topPanel.add(phoneText);

        bottomPanel.add(optionsLabel, BorderLayout.NORTH);
        bottomPanel.add(optionsList, BorderLayout.CENTER);
        bottomPanel.add(space, BorderLayout.SOUTH);

        purchasePanel.add(topPanel, BorderLayout.NORTH);
        purchasePanel.add(bottomPanel, BorderLayout.SOUTH);

    }

    private void buildTotalPanel()
    {
        totalPanel = new JPanel();
        totalPanel.setLayout(new GridLayout(1,3));

        // create a padding label
        JLabel space = new JLabel(" ");

        totalLabel = new JLabel("Total Price:  ");
        totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        totalText = new JTextField(5);
        totalText.setEditable(false);
        totalText.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        totalText.setHorizontalAlignment(SwingConstants.CENTER);
        updateSelectedAndTotalLabels();

        totalPanel.add(space);
        totalPanel.add(totalLabel);
        totalPanel.add(totalText);
    }


    private void updateSelectedAndTotalLabels() {
        double total = 0;

        if (firstPackageOption.isSelected()) {
            total += 45.0;
            packageText.setText("300 minutes per month");
        }
        else if(secondPackageOption.isSelected()) {
            total += 65.0;
            packageText.setText("800 minutes per month");
        }
        else if(thirdPackageOption.isSelected()) {
            total += 99.0;
            packageText.setText("1500 minutes per month");
        }

        if(firstPhoneOption.isSelected()) {
            total += 29.95;
            phoneText.setText("Model 100");
        }
        else if(secondPhoneOption.isSelected()) {
            total += 49.95;
            phoneText.setText("Model 110");
        }
        else if(thirdPhoneOption.isSelected()) {
            total += 99.95;
            phoneText.setText("Model 200");
        }


        byte flag = 0;
        String[] optionsSelected = {" ", " "};
        if(voiceCheckBox.isSelected()) {
            flag += 1;
            total += 5.0;
        }
        if(textCheckBox.isSelected()) {
            flag += 2;
            total += 10.0;
        }

        switch(flag) {
            case 0:
                break;
            case 1:
                optionsSelected = new String[]{"Voice Mail", " "};
                break;
            case 2:
                optionsSelected = new String[]{"Text Messaging", " "};
                break;
            case 3:
                optionsSelected = new String[]{"Voice Mail", "Text Messaging"};
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error - hacking detected quitting application!");
                System.exit(0);
                break;
        }

        optionsList.setListData(optionsSelected);

        totalText.setText(pounds.format(total));
    }

    private class ExitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }


    private class SelectedListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            updateSelectedAndTotalLabels();
        }
    }
}
