/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   31/01/2017.
 */

import java.util.*;

public class EmployeeMap
{
    private Map<Integer, Employee> employees;

    public EmployeeMap()
    {
        employees = new HashMap<Integer, Employee>();
    }

    public void add(Integer key, Employee value)
    {
        employees.put(key, value);
    }

    public Employee search(Integer key)
    {
        return employees.get(key);
    }

}
