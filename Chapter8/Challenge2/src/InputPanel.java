/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   09/11/2016.
 */

import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel
{
    private JLabel employeeIDLabel;
    private JLabel employeeIDContentsLabel;
    private JLabel hoursLabel;
    private JTextField hoursTextField;
    private JLabel payRateLabel;
    private JTextField payRateTextField;

    /**
     * Constructor
     */
    public InputPanel(int firstIDNumber)
    {
        employeeIDLabel = new JLabel("Employee ID: ");
        employeeIDContentsLabel = new JLabel("");
        hoursLabel = new JLabel("Hours worked: ");
        hoursTextField = new JTextField(10);
        payRateLabel = new JLabel("Hourly Pay Rate: ");
        payRateTextField = new JTextField(10);

        // use a gridLayout manager for the panel
        setLayout(new GridLayout(3, 2));

        // add the components
        add(employeeIDLabel);
        add(employeeIDContentsLabel);
        add(hoursLabel);
        add(hoursTextField);
        add(payRateLabel);
        add(payRateTextField);

        // create a border around the panel
        setBorder(BorderFactory.createTitledBorder("Enter details for employee."));

        // Set the label for the first employee
        setEmployeeIDContentsLabelText(firstIDNumber);
    }


    // ============= Sets and gets =======================================

    public void setEmployeeIDContentsLabelText(int IDNumber) {
        employeeIDContentsLabel.setText(Integer.toString(IDNumber));
    }

    public String getHoursTextFieldText() {
        return hoursTextField.getText();
    }

    public void resetHoursTextFieldText() {
        hoursTextField.setText("");
    }

    public String getPayRateTextFieldText() {
        return payRateTextField.getText();
    }

    public void resetPayRateTextFieldText() {
        payRateTextField.setText("");
    }

    public void resetTextFieldTexts() {
        hoursTextField.setText("");
        payRateTextField.setText("");
    }

}
