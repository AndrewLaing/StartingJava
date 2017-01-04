/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   27/12/2016.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ImageViewerGUI extends JFrame
{

    // Menu component references
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem openItem;
    private JMenuItem exitItem;

    // Image panel components
    private JPanel imagePanel;
    private JLabel imageLabel;

    /**
     * Constructor
     */
    public ImageViewerGUI()
    {
        setTitle("Image Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buildMenuBar();
        buildImagePanel();

        add(imagePanel);

        pack();
        setVisible(true);

    }


    /**
     * The method buildMenuBar creates the menu bar and adds it
     * to the frame
     */
    private void buildMenuBar()
    {
        menuBar = new JMenuBar();

        // create the file and text menus
        buildFileMenu();

        menuBar.add(fileMenu);

        /// set the window's menu bar
        setJMenuBar(menuBar);
    }


    /**
     * The method buildFileMenu creates the file menu
     */
    private void buildFileMenu()
    {
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        // create the menu items
        openItem = new JMenuItem("Open");
        exitItem = new JMenuItem("Exit");

        // set mnemonics for the menu items
        openItem.setMnemonic(KeyEvent.VK_O);
        exitItem.setMnemonic(KeyEvent.VK_X);

        // add Action Listeners to the menu items
        openItem.addActionListener(new OpenListener());
        exitItem.addActionListener(new ExitListener());

        // add the menu items to the file menu
        fileMenu.add(openItem);
        fileMenu.add(exitItem);

    }


    private void buildImagePanel()
    {
        imagePanel = new JPanel();
        imageLabel = new JLabel();
        ImageIcon myImage = new ImageIcon("logo.jpg");
        imageLabel.setIcon(myImage);

        imagePanel.add(imageLabel);
        pack();
    }


    private class OpenListener implements ActionListener
    {
        private String getOpenFilename()
        {
            String filename = "";

            // Get the name of the file to open
            JFileChooser getName1 = new JFileChooser();
            int status = getName1.showOpenDialog(null);

            if(status == JFileChooser.APPROVE_OPTION)
            {
                File selectedFile = getName1.getSelectedFile();
                filename = selectedFile.getPath();
            }
            else
                return null;

            return filename;
        }


        private void openImage()
        {
            String filename = getOpenFilename();
            if(filename==null) {
                JOptionPane.showMessageDialog(null, "Error - invalid filename");
                return;
            }

            try {
                ImageIcon newImage = new ImageIcon(filename);
                imageLabel.setIcon(newImage);
                pack();
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Error - invalid image file");
                return;
            }
        }


        public void actionPerformed(ActionEvent e)
        {
            openImage();
        }
    }


    private class ExitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

}
