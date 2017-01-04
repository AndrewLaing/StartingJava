/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   05/12/2016.
 */

/**
 * The Class StringOps contains static methods that are used to perform
 * operations upon Strings, and operations that return references to Strings
 */
public class StringOps
{
    /**
     * The method wordCount returns the number of words that appear
     * in the string passed.
     * @param testStr
     * @return The number of words that appear in the string passed
     *         to the method
     */
    public static int WordCount(String testStr) {
        int count = 0;

        // first replace all other word delimiters that appear in
        // the string with spaces and then split it into words
        testStr = testStr.replaceAll("[!?,]", " "); // first replace all other word delimiters
        String[] tokens = testStr.trim().split(" ");

        for(String token : tokens) {
            if(token.length()>0)
                count++;
        }

        return count;
    }


    // StringBuffer is used because otherwise each string created when a character
    //  is appended to a result string must be sent to the garbage collector when
    //  it is dereferenced by creating a new string with the next appended character
    public static String arrayToString(char[] toConvert)
    {
        StringBuffer sb = new StringBuffer("");

        for(char c : toConvert)
            sb.append(c);

        return sb.toString();
    }


    /**
     * The method mostFrequent returns the character that appears
     * most frequently within the string passed to it
     * @param testStr The string to work upon
     * @return The most frequent character in the string passed to the method
     */
    public static char mostFrequent(String testStr)
    {
        char[] array = testStr.toCharArray();
        char mostFreq = array[0];
        int max = 0;
        int count = 0;

        for(int i=0; i<array.length; i++)
        {
            count = 1;
            for(int j=0; j<array.length; j++)
            {
                if(i!=j) {
                    if(array[i]==array[j])
                        count++;
                }

                if(count>max) {
                    max = count;
                    mostFreq = array[i];
                }
            }
        }

        return mostFreq;
    }


    /**
     * The method replaceSubstring replaces occurrences of string2 in string1
     * with string3
     * @param string1 The string to work on
     * @param string2 The substring to replace
     * @param string3 The substring to replace with
     * @return
     */
    public static String replaceSubstring(String string1, String string2, String string3)
    {
        StringBuffer sb = new StringBuffer(string1);

        int str2_len = string2.length(),
                str3_len = string3.length();;

        // look for the first instance of string2 in string1
        int indexOf3 = string1.indexOf(string2);
        int i=0;

        while(indexOf3>-1 && i<sb.length())
        {
            // replace string2 with string3
            sb.replace(indexOf3, indexOf3+str2_len, string3);

            // look for another occurrence of string2 after the added substring
            i+= str3_len;
            if(i<sb.length())
                indexOf3 = sb.indexOf(string2, i);
        }

        return sb.toString();
    }
}
