/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   21/02/2017.
 */

import java.io.*;

public class DelimiterChecker
{
    private int curlyBraces = 0;
    private int parentheses = 0;
    private int squareBrackets = 0;


    public boolean checkDelimiters(char c)
    {
        switch (c) {
            case '{':
                curlyBraces++;
                break;
            case '}':
                curlyBraces--;
                break;
            case '[':
                squareBrackets++;
                break;
            case ']':
                squareBrackets--;
                break;
            case '(':
                parentheses++;
                break;
            case ')':
                parentheses--;
                break;
            default:
                break;
        }

        return curlyBraces>=0 && squareBrackets>=0 && parentheses>=0;
    }


    public boolean parseString(String str)
    {
        char[] chars = str.toCharArray();
        for(char c : chars) {
            if (checkDelimiters(c))
                System.out.print(c);
            else
            {
                System.out.print(c);
                System.out.println("\n// ---- Nesting errors found in file ----");
                return false;
            }
        }

        System.out.println();
        return true;
    }

    public void parseFile(String filename) throws IOException
    {
        curlyBraces = 0;
        parentheses = 0;
        squareBrackets = 0;

        BufferedReader inputFile =
                new BufferedReader(new FileReader(filename));

        String line;
        boolean tooManyClosing = false;

        line = inputFile.readLine();
        while(line != null) {
            if(parseString(line))
                line = inputFile.readLine();
            else {
                tooManyClosing = true;
                line = null;
            }
        }

        inputFile.close();

        if(tooManyClosing)
            return;

        if( curlyBraces>0 || squareBrackets>0 || parentheses>0 )
        {
            System.out.println("\n// ---- Nesting errors found in file ----");
            if(curlyBraces>0)
                System.out.println("// Missing " + curlyBraces + " x '}'");
            if(squareBrackets>0)
                System.out.println("// Missing " + squareBrackets + " x ']'");
            if(parentheses>0)
                System.out.println("// Missing " + parentheses + " x ')'");
        }
        else
            System.out.println("\n// ---- The file is properly nested ----");

    }
}
