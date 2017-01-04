/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   24/11/2016.
 */
public class Month {
    private int monthNumber;
    private String[] monthNames = {"January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December"};



    public Month(int monthNumber)
    {
        if(monthNumber<1 || monthNumber>12)
            this.monthNumber = 1;
        else
            this.monthNumber = monthNumber;
    }

    public Month(String monthName) {
        for (int i = 0; i < monthNames.length; i++) {
            if (monthName.equals(monthNames[i])) {
                monthNumber = i+1;
                return;
            }
        }

        // If the name has been entered incorrectly use the default value
        monthNumber = 1;
    }

    public Month() {
        monthNumber = 1;
    }

    public void setMonthNumber(int monthNumber) {
        if(monthNumber<1 || monthNumber>12)
            this.monthNumber = 1;
        else
            this.monthNumber = monthNumber;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public String getMonthName()
    {
        return monthNames[monthNumber-1];
    }

    public String toString()
    {
        return getMonthName();
    }

    public boolean equals(Month object2)
    {
        return monthNumber == object2.monthNumber;
    }

    public boolean greaterThan(Month object2)
    {
        return monthNumber > object2.monthNumber;
    }

    public boolean lessThan(Month object2)
    {
        return monthNumber < object2.monthNumber;
    }
}

