/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   11/01/2017.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;


public class VendingMachineGUI extends JFrame
{
    private JPanel buttonPanel;

    private double credits = 0.0;
    private double change = 0.0;
    private final double priceOfDrinks = 0.75;

    private int colaRemaining = 20;
    private int spriteRemaining = 20;
    private int grapeRemaining = 20;
    private int rootRemaining = 20;
    private int waterRemaining = 20;


    DecimalFormat pounds = new DecimalFormat("#0.00");

    private JButton colaButton;
    private JButton spriteButton;
    private JButton grapeButton;
    private JButton rootButton;
    private JButton waterButton;

    private JLabel colaLabel;
    private JLabel spriteLabel;
    private JLabel grapeLabel;
    private JLabel rootLabel;
    private JLabel waterLabel;

    private JPanel leftPanel;

    private JPanel rightPanel;

    private JTextField creditsText;
    private JTextField addCreditsText;
    private JTextField changeText;
    public VendingMachineGUI()
    {
        setTitle("Vending Machine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        JPanel paddingPanel = new JPanel();
        paddingPanel.setLayout(new BorderLayout());
        paddingPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        paddingPanel.setBackground(Color.BLACK);

        setBackground(Color.BLACK);

        buildButtonPanel();
        buildLeftPanel();
        buildRightPanel();

        paddingPanel.add(buttonPanel, BorderLayout.NORTH);
        paddingPanel.add(leftPanel, BorderLayout.WEST);
        paddingPanel.add(rightPanel, BorderLayout.EAST);

        add(paddingPanel);
        pack();
        setVisible(true);
    }

    private void buildButtonPanel()
    {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,5));
        buttonPanel.setBackground(Color.BLACK);

        // create the cola button panel
        JPanel colaPanel = new JPanel();
        colaPanel.setLayout(new BorderLayout());
        colaPanel.setBackground(Color.BLACK);
        ImageIcon colaImg = new ImageIcon("src/cola.gif");
        colaButton = new JButton(colaImg);
        colaButton.setBackground(Color.BLACK);
        colaLabel = new JLabel("Coca Cola");
        colaLabel.setForeground(Color.white);
        colaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        colaPanel.add(colaButton, BorderLayout.CENTER);
        colaPanel.add(colaLabel, BorderLayout.SOUTH);

        // create the sprite button panel
        JPanel spritePanel = new JPanel();
        spritePanel.setLayout(new BorderLayout());
        spritePanel.setBackground(Color.BLACK);
        ImageIcon spriteImg = new ImageIcon("src/sprite.gif");
        spriteButton = new JButton(spriteImg);
        spriteButton.setBackground(Color.BLACK);
        spriteLabel = new JLabel("Sprite");
        spriteLabel.setForeground(Color.white);
        spriteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        spritePanel.add(spriteButton, BorderLayout.CENTER);
        spritePanel.add(spriteLabel, BorderLayout.SOUTH);

        // create the grape button panel
        JPanel grapePanel = new JPanel();
        grapePanel.setLayout(new BorderLayout());
        grapePanel.setBackground(Color.BLACK);
        ImageIcon grapeImg = new ImageIcon("src/grape.gif");
        grapeButton = new JButton(grapeImg);
        grapeButton.setBackground(Color.BLACK);
        grapeLabel = new JLabel("Grape Soda");
        grapeLabel.setForeground(Color.white);
        grapeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        grapePanel.add(grapeButton, BorderLayout.CENTER);
        grapePanel.add(grapeLabel, BorderLayout.SOUTH);

        // create the root button panel
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout());
        rootPanel.setBackground(Color.BLACK);
        ImageIcon rootImg = new ImageIcon("src/root.gif");
        rootButton = new JButton(rootImg);
        rootButton.setBackground(Color.BLACK);
        rootLabel = new JLabel("Root Beer");
        rootLabel.setForeground(Color.white);
        rootLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rootPanel.add(rootButton, BorderLayout.CENTER);
        rootPanel.add(rootLabel, BorderLayout.SOUTH);

        // create the water button panel
        JPanel waterPanel = new JPanel();
        waterPanel.setLayout(new BorderLayout());
        waterPanel.setBackground(Color.BLACK);
        ImageIcon waterImg = new ImageIcon("src/water.gif");
        waterButton = new JButton(waterImg);
        waterButton.setBackground(Color.black);
        waterLabel = new JLabel("Bottled Water");
        waterLabel.setForeground(Color.white);
        waterLabel.setHorizontalAlignment(SwingConstants.CENTER);
        waterPanel.add(waterButton, BorderLayout.CENTER);
        waterPanel.add(waterLabel, BorderLayout.SOUTH);

        colaButton.addActionListener(new DrinkButtonListener());
        spriteButton.addActionListener(new DrinkButtonListener());
        grapeButton.addActionListener(new DrinkButtonListener());
        rootButton.addActionListener(new DrinkButtonListener());
        waterButton.addActionListener(new DrinkButtonListener());

        buttonPanel.add(colaPanel);
        buttonPanel.add(spritePanel);
        buttonPanel.add(grapePanel);
        buttonPanel.add(rootPanel);
        buttonPanel.add(waterPanel);
    }

    private void buildLeftPanel()
    {
        leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setBackground(Color.BLACK);

        ImageIcon colaImg = new ImageIcon("src/cocaColaLogo.gif");
        JLabel logoLabel = new JLabel();
        logoLabel.setIcon(colaImg);

        ImageIcon pushImg = new ImageIcon("src/push.gif");
        JLabel pushLabel = new JLabel();
        pushLabel.setIcon(pushImg);

        leftPanel.add(logoLabel, BorderLayout.CENTER);
        leftPanel.add(pushLabel, BorderLayout.SOUTH);

    }

    private void buildRightPanel()
    {
        rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(7,1));
        rightPanel.setBackground(Color.BLACK);

        JLabel space = new JLabel(" ");
        JLabel space1 = new JLabel(" ");
        JLabel space2 = new JLabel(" ");

        creditsText = new JTextField(10);
        creditsText.setEditable(false);
        creditsText.setHorizontalAlignment(SwingConstants.CENTER);
        creditsText.setFont(new Font("Sans", Font.PLAIN, 50));
        creditsText.setBackground(Color.BLACK);
        creditsText.setForeground(Color.red);
        creditsText.setText(pounds.format(0.0));

        JPanel midRightPanel = new JPanel();
        midRightPanel.setLayout(new GridLayout(4,1));
        midRightPanel.setBackground(Color.BLACK);

        JLabel addCreditsLabel = new JLabel("Add credits below", SwingConstants.CENTER);
        addCreditsLabel.setForeground(Color.white);

        addCreditsText = new JTextField(10);
        addCreditsText.setHorizontalAlignment(SwingConstants.CENTER);


        JButton addCreditsButton = new JButton("ADD CREDITS");
        addCreditsButton.addActionListener(new AddButtonListener());
        JButton returnCreditsButton = new JButton("RETURN CHANGE");
        returnCreditsButton.addActionListener(new ReturnCreditsButtonListener());

        midRightPanel.add(addCreditsLabel);
        midRightPanel.add(addCreditsText);
        midRightPanel.add(addCreditsButton);
        midRightPanel.add(returnCreditsButton);

        changeText = new JTextField(10);
        changeText.setEditable(false);
        changeText.setHorizontalAlignment(SwingConstants.CENTER);
        changeText.setFont(new Font("Sans", Font.PLAIN, 50));
        changeText.setBackground(Color.BLACK);
        changeText.setForeground(Color.red);
        changeText.setText(pounds.format(0.0));

        JPanel collectPanel = new JPanel();
        collectPanel.setBackground(Color.BLACK);
        collectPanel.setLayout(new BorderLayout());

        JButton collectButton = new JButton("COLLECT CREDITS");
        collectButton.addActionListener(new CollectButtonListener());
        collectPanel.add(collectButton, BorderLayout.NORTH);

        rightPanel.add(creditsText);
        rightPanel.add(midRightPanel);
        rightPanel.add(space);
        rightPanel.add(space1);
        rightPanel.add(space2);
        rightPanel.add(changeText);
        rightPanel.add(collectPanel);
    }


    private class DrinkButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // if the user has inserted more than 75p
            if(credits >= priceOfDrinks) {
                if (e.getSource() == colaButton)
                {
                    if(colaRemaining > 0) {
                        credits -= priceOfDrinks;
                        colaRemaining--;
                        creditsText.setText(pounds.format(credits));

                        if(colaRemaining<=0)
                            colaButton.setEnabled(false);
                    }
                }
                else if (e.getSource() == spriteButton)
                {
                    if(spriteRemaining > 0) {
                        credits -= priceOfDrinks;
                        spriteRemaining--;
                        creditsText.setText(pounds.format(credits));

                        if(spriteRemaining <= 0)
                            spriteButton.setEnabled(false);
                    }
                }
                else if (e.getSource() == grapeButton)
                {
                    if(grapeRemaining > 0) {
                        credits -= priceOfDrinks;
                        grapeRemaining--;
                        creditsText.setText(pounds.format(credits));

                        if(grapeRemaining <= 0)
                            grapeButton.setEnabled(false);
                    }
                }
                else if (e.getSource() == rootButton)
                {
                    if(rootRemaining > 0) {
                        credits -= priceOfDrinks;
                        rootRemaining--;
                        creditsText.setText(pounds.format(credits));

                        if(rootRemaining <= 0)
                            rootButton.setEnabled(false);
                    }
                }
                else if (e.getSource() == waterButton)
                {
                    if(waterRemaining > 0) {
                        credits -= priceOfDrinks;
                        waterRemaining--;
                        creditsText.setText(pounds.format(credits));

                        if(waterRemaining <= 0)
                            waterButton.setEnabled(false);
                    }
                }
            }
        }
    }

    private class AddButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try {
                credits += Double.parseDouble(addCreditsText.getText());
                creditsText.setText(pounds.format(credits));
                addCreditsText.setText("");
            }
            catch(Exception expt)
            {
                addCreditsText.setText("");
            }
        }
    }

    private class ReturnCreditsButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(credits > 0)
            {
                change = credits;
                credits = 0.0;
                creditsText.setText(pounds.format(credits));
                changeText.setText(pounds.format(change));
            }

        }
    }


    private class CollectButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            change = 0.0;
            changeText.setText(pounds.format(change));

        }
    }
}
