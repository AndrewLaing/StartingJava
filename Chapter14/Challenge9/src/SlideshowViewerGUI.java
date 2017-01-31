/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   12/01/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class SlideshowViewerGUI extends JFrame
{
    // slideshow image variables
    private int imagesAdded = 0;
    private int currentImage = 0;
    private boolean slideshowRunning = false;
    private final int MAX_IMAGES = 10;
    private ImageIcon[] imageIcons = new ImageIcon[MAX_IMAGES];
    private int TIME_DELAY = 1000;

    // Timer for changing images
    private Timer timer;

    // Menu component references
    private JMenuBar menuBar;
    private JMenu fileMenu;
        private JMenuItem addImagesItem;
        private JMenuItem removeAllImages;
        private JMenuItem exitItem;

    private JMenu settingsMenu;
        private JMenuItem setDelayItem;
        private JMenuItem startSlideShowItem;
        private JMenuItem pauseSlideShowItem;
        private JMenuItem stopSlideShowItem;

    // Image panel components
    private JPanel imagePanel;
    private JLabel imageLabel;
    ImageIcon logoImage = new ImageIcon("logo.jpg");

    /**
     * Constructor
     */
    public SlideshowViewerGUI()
    {
        setTitle("Slideshow Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buildMenuBar();
        buildImagePanel();

        timer = new Timer(TIME_DELAY, new TimerListener());

        add(imagePanel);

        pack();
        setVisible(true);

    }

    private void setTIME_DELAY(int TIME_DELAY) {
        this.TIME_DELAY = TIME_DELAY;
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
        buildSettingsMenu();

        menuBar.add(fileMenu);
        menuBar.add(settingsMenu);

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
        addImagesItem = new JMenuItem("Add images to slideshow");
        removeAllImages = new JMenuItem("Remove all added images");
        exitItem = new JMenuItem("Exit");

        // set mnemonics for the menu items
        addImagesItem.setMnemonic(KeyEvent.VK_A);
        removeAllImages.setMnemonic(KeyEvent.VK_R);
        exitItem.setMnemonic(KeyEvent.VK_X);

        // add Action Listeners to the menu items
        addImagesItem.addActionListener(new AddImagesListener());
        removeAllImages.addActionListener(new RemoveImagesListener());
        exitItem.addActionListener(new ExitListener());

        // add the menu items to the file menu
        fileMenu.add(addImagesItem);
        fileMenu.add(removeAllImages);
        fileMenu.add(exitItem);
    }



    /**
     * The method buildFileMenu creates the file menu
     */
    private void buildSettingsMenu()
    {
        settingsMenu = new JMenu("Settings");
        settingsMenu.setMnemonic(KeyEvent.VK_S);

        // create the menu items
        setDelayItem = new JMenuItem("Set delay between images");
        startSlideShowItem = new JMenuItem("Run Slideshow");
        pauseSlideShowItem = new JMenuItem("Pause Slideshow");
        stopSlideShowItem = new JMenuItem("End Slideshow");

        // set mnemonics for the menu items
        setDelayItem.setMnemonic(KeyEvent.VK_D);
        startSlideShowItem.setMnemonic(KeyEvent.VK_R);
        pauseSlideShowItem.setMnemonic(KeyEvent.VK_P);
        stopSlideShowItem.setMnemonic(KeyEvent.VK_E);

        // add Action Listeners to the menu items
        setDelayItem.addActionListener(new SetDelayListener());
        startSlideShowItem.addActionListener(new RunSlideshowListener());
        pauseSlideShowItem.addActionListener(new RunSlideshowListener());
        stopSlideShowItem.addActionListener(new RunSlideshowListener());

        // add the menu items to the file menu
        settingsMenu.add(setDelayItem);
        settingsMenu.add(startSlideShowItem);
        settingsMenu.add(pauseSlideShowItem);
        settingsMenu.add(stopSlideShowItem);
    }


    private void buildImagePanel()
    {
        imagePanel = new JPanel();
        imageLabel = new JLabel();

        imageLabel.setIcon(logoImage);

        imagePanel.add(imageLabel);
        pack();
    }


    private class SetDelayListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            int seconds;
            String inputStr = JOptionPane.showInputDialog(null, "Enter number of seconds delay between slides");
            try {
                seconds = Integer.parseInt(inputStr);
                setTIME_DELAY(seconds*1000);
                timer = new Timer(TIME_DELAY, new TimerListener());
            }
            catch(Exception exc)
            {
                JOptionPane.showMessageDialog(null, "Error - Invalid input.");
            }

        }
    }


    private class RemoveImagesListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(slideshowRunning) {
                slideshowRunning = false;
                timer.stop();
            }
            imagesAdded = 0;
            currentImage = 0;
            imageLabel.setIcon(logoImage);
        }
    }


    private class RunSlideshowListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == startSlideShowItem)
            {
                if(slideshowRunning == false) {

                    if(imagesAdded > 0) {
                        currentImage = 0;
                        slideshowRunning = true;
                        imageLabel.setIcon(imageIcons[currentImage]);
                        timer.start();
                    }
                    else
                        JOptionPane.showMessageDialog(null, "No images have been added yet.");
                }
                else {
                    if (imagesAdded > 0) {
                        slideshowRunning = true;
                        imageLabel.setIcon(imageIcons[currentImage]);
                        timer.start();
                    } else
                        JOptionPane.showMessageDialog(null, "No images have been added yet.");
                }
            }

            if(e.getSource() == pauseSlideShowItem) {
                timer.stop();
            }

            if(e.getSource() == stopSlideShowItem) {
                timer.stop();
                currentImage = 0;
                slideshowRunning = false;
                imageLabel.setIcon(logoImage);
                timer.stop();
            }

        }
    }


    private class AddImagesListener implements ActionListener
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


        private void addImage()
        {
            if(imagesAdded==MAX_IMAGES) {
                JOptionPane.showMessageDialog(null, "Error - Maximum amount of allowed images already reached!");
                return;
            }

            String filename = getOpenFilename();
            if(filename==null) {
                JOptionPane.showMessageDialog(null, "Error - invalid filename");
                return;
            }

            try {
                //ImageIcon newImage = new ImageIcon(filename);
                //imageLabel.setIcon(newImage);
                imageIcons[imagesAdded] = new ImageIcon(filename);
                imagesAdded++;
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
            addImage();
        }
    }


    private class TimerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            if(currentImage < imagesAdded-1){
                currentImage++;
                imageLabel.setIcon(imageIcons[currentImage]);
            }
            else {
                currentImage = 0;
                imageLabel.setIcon(imageIcons[currentImage]);
            }
        }
    }


    private class ExitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
