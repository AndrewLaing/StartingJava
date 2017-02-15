/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   01/02/2017.
 */

/**
 * The StringList interface specifies the operations
 * that should be supported by a list of strings
 */
public interface StringList
{
    /**
     * The add method adds a string to the list
     * @param str The string to add
     */
    public void add(String str);

    /**
     * The add method adds a string at a specific index
     * @param index The added string's position
     * @param str The string to add
     * @exception IndexOutOfBoundsException When index is out of bounds
     */
    public void add(int index, String str);

    /**
     * The clear method clears the list
     */
    public void clear();

    /**
     * The contains method searches the list for a spoecified string
     * @param str The string to search for
     * @return True if the list contains the string false otherwise
     */
    public boolean contains(String str);

    /**
     * The get method gets an element at a specific position
     * @param index The specified index
     * @return The element at index
     * @exception IndexOutOfBoundsException When index is out of bounds
     */
    public String get(int index);

    /**
     * The indexOf method gets the index of the first occurrence of
     * the specified string
     * @param str The string to search for
     * @return The index of the first occurrence of str if it exists
     *         -1 if str is not in the list
     */
    public int indexOf(String str);

    /**
     * The isEmpty method determines whether the list is empty
     * @return True if the list is empty; false otherwise
     */
    public boolean isEmpty();

    /**
     * The remove method removes a specific string fr5om the list
     * @param str The string to remove
     * @return true if the string was found false otherwise
     */
    public boolean remove(String str);

    /**
     * The remove method removes a string at a specific index
     * @param index The index of the string to remove
     * @return The string that was removed
     * @exception IndexOutOfBoundsException When index is out of bounds
     */
    public String remove(int index);

    /**
     * The set method replaces a string at a specified index with another string
     * @param index The index of the string to replace
     * @param str The string to replace it with
     * @return The string previously stored at the index
     * @exception IndexOutOfBoundsException When index is out of bounds
     */
    public String set(int index, String str);

    /**
     * The size method returns the number of elements in the list
     * @return The number of elements in the list
     */
    public int size();
}
