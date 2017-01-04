/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   29/12/2016.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.text.DecimalFormat;


public class ShoppingCartSystemGUI extends JFrame
{
    private static int tryOpenFile = 0;

    DecimalFormat pounds = new DecimalFormat("£#0.00");
    private final double TAX = 0.06;
    List BookTitles;    // make this local
    List BookPrices;    // used to store the book prices
    List CartContents;  // used to store the items added to the cart
    List CartPrices;    // used to store the prices of the cart items

    // bannerPanel components ////
    private JPanel bannerPanel;
    private JLabel bannerLabel;


    // centerPanel components ////
    private JPanel centerPanel;

    private JPanel titlesPanel;
    private JLabel titlesLabel;
    private JScrollPane titlesScroller;
    private JList titlesList;

    private JButton addButton;
    private JButton removeButton;
    private JButton clearButton;

    private JPanel cartPanel;
    private JLabel cartLabel;
    private JScrollPane cartScroller;
    private JList cartList;
    private JLabel subtotalLabel;
    private JTextField subtotalText;
    private JLabel salesTaxLabel;
    private JTextField salesTaxText;
    private JLabel totalLabel;
    private JTextField totalText;
    private JButton checkoutButton;


    // buttonPanel components ////
    private JPanel buttonPanel;
    private JButton exitButton;



    public ShoppingCartSystemGUI()
    {
        setTitle("Shopping Cart System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        // Create a panel for adding padding around the interior panels
        JPanel paddingPanel = new JPanel();
        paddingPanel.setLayout(new BorderLayout());
        paddingPanel.setBorder(BorderFactory.createEmptyBorder(10,20,20,20));

        // create the content panels
        buildBannerPanel();
        buildCenterPanel();
        buildButtonPanel();

        // add the panels to the padding panel
        paddingPanel.add(bannerPanel, BorderLayout.NORTH);
        paddingPanel.add(centerPanel, BorderLayout.CENTER);
        paddingPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(paddingPanel);

        pack();
        setVisible(true);
    }


    private void buildBannerPanel()
    {
        // create the panel
        bannerPanel = new JPanel();
        bannerPanel.setLayout(new BorderLayout());
        bannerPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));

        // create the panel's components
        bannerLabel = new JLabel(" Book Store Shopping Cart System ");
        bannerLabel.setFont(new Font("Sans", Font.PLAIN, 20));
        bannerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // add the label to this panel
        bannerPanel.add(bannerLabel, BorderLayout.CENTER);
    }


    private void loadTitlesList()
    {

        if(tryOpenFile==3)
        {
            JOptionPane.showMessageDialog(null, "Error - unable to find load the titles file after 3 attempts. Closing the application!");
            System.exit(0);
        }

        BookTitles = new ArrayList<String>();
        BookPrices = new ArrayList<Double>();

        String filename = "titles file.";

        try {
            filename = Utilities.getOpenFilename();
            Utilities.readFileToLists(filename, BookTitles, BookPrices);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error - unable to load " + filename + ":" + e.getMessage());
            tryOpenFile++;
            loadTitlesList();
            return;
        }

        titlesList = new JList(BookTitles.toArray());
        titlesList.setVisibleRowCount(10);
        titlesList.setFixedCellWidth(250);
        titlesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void buildTitlesPanel()
    {
        titlesPanel = new JPanel();
        titlesPanel.setLayout(new BorderLayout());

        // Create the west inner panel ///////////////////////
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BorderLayout());
        listPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));

        titlesLabel = new JLabel("Available titles: ");
        titlesLabel.setHorizontalAlignment(SwingConstants.LEFT);

        loadTitlesList();
        titlesScroller = new JScrollPane(titlesList);

        listPanel.add(titlesLabel, BorderLayout.NORTH);
        listPanel.add(titlesScroller, BorderLayout.CENTER);

        // Create the east inner panel ///////////////////////
        JPanel listButtonsPanel = new JPanel();
        listButtonsPanel.setLayout(new GridLayout(8, 1));

        // create some padding labels
        JLabel space = new JLabel(" ");
        JLabel space1 = new JLabel(" ");
        JLabel space2 = new JLabel(" ");
        JLabel space3 = new JLabel(" ");
        JLabel space4 = new JLabel(" ");

        // create the buttons
        addButton = new JButton("Add >>");
        removeButton = new JButton("<< Remove");
        clearButton = new JButton("Clear");

        // add Mnemonics to the buttons
        addButton.setMnemonic(KeyEvent.VK_A);
        removeButton.setMnemonic(KeyEvent.VK_R);
        clearButton.setMnemonic(KeyEvent.VK_C);

        // register the buttons to the action listeners
        addButton.addActionListener(new AddListener());
        removeButton.addActionListener(new RemoveListener());
        clearButton.addActionListener(new ClearListener());

        // add the components to the east inner panel
        listButtonsPanel.add(space);
        listButtonsPanel.add(addButton);
        listButtonsPanel.add(space1);
        listButtonsPanel.add(removeButton);
        listButtonsPanel.add(space2);
        listButtonsPanel.add(clearButton);
        listButtonsPanel.add(space3);
        listButtonsPanel.add(space4);

        // add the west and east inner panels to the titles panel
        titlesPanel.add(listPanel, BorderLayout.WEST);
        titlesPanel.add(listButtonsPanel, BorderLayout.EAST);
    }


    private void createCartList()
    {
        // create the ArrayLists to store the carts contents and prices in
        CartContents = new ArrayList<String>();
        CartPrices = new ArrayList<Double>();

        // create the cartList
        cartList = new JList();
        cartList.setVisibleRowCount(10);
        cartList.setFixedCellWidth(250);
        cartList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void buildCartPanel()
    {
        cartPanel = new JPanel();
        cartPanel.setLayout(new BorderLayout());

        // Create the west inner panel ///////////////////////
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BorderLayout());
        listPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 25));

        cartLabel = new JLabel("Shopping Cart: ");
        cartLabel.setHorizontalAlignment(SwingConstants.LEFT);

        createCartList();
        cartScroller = new JScrollPane(cartList);

        listPanel.add(cartLabel, BorderLayout.NORTH);
        listPanel.add(cartScroller, BorderLayout.CENTER);

        // Create the east inner panel ///////////////////////
        JPanel resultsPanel = new JPanel();
        resultsPanel.setLayout(new GridLayout(8, 1));

        subtotalLabel = new JLabel("Subtotal: ");
        subtotalLabel.setHorizontalAlignment(SwingConstants.LEFT);
        subtotalText = new JTextField(5);
        subtotalText.setEditable(false);

        salesTaxLabel = new JLabel("Sales tax: ");
        salesTaxLabel.setHorizontalAlignment(SwingConstants.LEFT);
        salesTaxText = new JTextField(5);
        salesTaxText.setEditable(false);

        totalLabel = new JLabel("Total: ");
        totalLabel.setHorizontalAlignment(SwingConstants.LEFT);
        totalText = new JTextField(5);
        totalText.setEditable(false);

        JLabel space = new JLabel(" ");
        checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(new CheckoutListener());

        // add the components to the east inner panel
        resultsPanel.add(subtotalLabel);
        resultsPanel.add(subtotalText);
        resultsPanel.add(salesTaxLabel);
        resultsPanel.add(salesTaxText);
        resultsPanel.add(totalLabel);
        resultsPanel.add(totalText);
        resultsPanel.add(space);
        resultsPanel.add(checkoutButton);

        // add the west and east inner panels to the titles panel
        cartPanel.add(listPanel, BorderLayout.WEST);
        cartPanel.add(resultsPanel, BorderLayout.EAST);
    }


    private void buildCenterPanel()
    {
        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 40, 0));

        buildTitlesPanel();
        buildCartPanel();

        centerPanel.add(titlesPanel, BorderLayout.WEST);
        centerPanel.add(cartPanel, BorderLayout.EAST);
    }


    private void buildButtonPanel()
    {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());

        exitButton = new JButton("    Exit    ");
        exitButton.setFont(new Font("Sans", Font.PLAIN, 14));

        exitButton.setMnemonic(KeyEvent.VK_X);
        exitButton.addActionListener(new ExitListener());

        buttonPanel.add(exitButton, BorderLayout.EAST);
    }


    private void updateTotals()
    {
        // calculate the subtotal
        double subtotal = 0;
        for(int i=0; i<CartPrices.size(); i++)
            subtotal += (double) CartPrices.get(i);

        // calculate the sales tax
        double salesTax = subtotal * TAX;

        // calculate the total
        double total = subtotal + salesTax;

        // update the totals text fields
        subtotalText.setText(pounds.format(subtotal));
        salesTaxText.setText(pounds.format(salesTax));
        totalText.setText(pounds.format(total));
    }


    private class AddListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // if nothing has been selected return
            if(titlesList.isSelectionEmpty()) return;

            // add the selected item to the cart content and prices lists
            CartContents.add(titlesList.getSelectedValue());
            CartPrices.add(BookPrices.get(titlesList.getSelectedIndex()));

            // update the cartList and totals
            cartList.setListData(CartContents.toArray());
            updateTotals();
            //titlesList.clearSelection();
        }
    }


    private class RemoveListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            // if nothing has been selected return
            if(cartList.isSelectionEmpty()) return;

            // remove the selected item from the cart content and prices lists
            int index = cartList.getSelectedIndex();
            CartContents.remove(index);
            CartPrices.remove(index);

            // update the cartList and totals
            cartList.setListData(CartContents.toArray());
            updateTotals();
        }
    }


    private class ClearListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            // clear the contents of the shopping cart
            CartContents.clear();
            CartPrices.clear();
            cartList.setListData(CartContents.toArray());
            updateTotals();
        }
    }


    private class CheckoutListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            // If the cart is empty show an error messsage
            if(CartContents.size()==0)
            {
                String result = "Error - no items have been added to" +
                        "\nthe shopping cart.";
                JOptionPane.showMessageDialog(null, new JTextArea(result));
                return;
            }

            // Print out a bill of sale
            String result = "Your order has been confirmed, and will be delivered" +
                            "\nto your address within 3 working days." +
                            "\n\n---- ITEMS ----\n";

            for(int i=0; i<CartContents.size(); i++)
            {
                result += CartContents.get(i) + " :- " + pounds.format(CartPrices.get(i)) + "\n";
            }

            // Calculate the total for the bill of sale
            double subtotal = 0;
            for(int i=0; i<CartPrices.size(); i++)
                subtotal += (double) CartPrices.get(i);

            double total = subtotal + (subtotal * TAX);

            result += "\nTOTAL :- " + pounds.format(total);
            JOptionPane.showMessageDialog(null, new JTextArea(result));

            // clear the contents of the shopping cart
            CartContents.clear();
            CartPrices.clear();
            cartList.setListData(CartContents.toArray());
            updateTotals();
        }
    }


    private class ExitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
