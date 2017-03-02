/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   02/03/2017.
 */

import java.util.Scanner;   // for parsing the expression

public class PrefixCalculator
{
    // The stacks used to hold the operators and operands
    GenLinkedStack<Character> operatorGenStack = new GenLinkedStack<Character>();
    GenLinkedStack<Integer> operandGenStack = new GenLinkedStack<Integer>();
    GenLinkedStack<Integer> resultGenStack = new GenLinkedStack<Integer>();

    public PrefixCalculator()
    {
    }


    /**
     * The parseExpression method reads a prefix expression and pushes
     * the extracted operators and operands to stacks
     * @param expression A prefix expression to parse
     * @return true if expression was parsed, otherwise false
     */
    public boolean parseExpression(String expression)
    {
        if(expression.length()==0)
            return false;

        // Create a Scanner object to parse the expression
        Scanner sc = new Scanner(expression);
        int tempInt;
        char tempChar;

        while(sc.hasNext())
        {
            if(sc.hasNextInt()) {
                tempInt = sc.nextInt();
                operandGenStack.push(tempInt);
            }
            else {
                tempChar = sc.next().charAt(0);
                operatorGenStack.push(tempChar);
            }
        }

        return !operandGenStack.empty() && (operandGenStack.size()>operatorGenStack.size());
    }


    /**
     * The calculateResult method calculates the result from the
     * prefix expression pushed into the two stacks
     * @return The result of a prefix expression
     */
    public int calculateResult()
    {
        char op;
        int a, b;

        while(!operatorGenStack.empty())
        {
            op = operatorGenStack.pop();

            if(resultGenStack.size()<2) {
                b = operandGenStack.pop();
                a = operandGenStack.pop();
            }
            else
            {
                a = resultGenStack.pop();
                b = resultGenStack.pop();
            }

            switch(op)
            {
                case '+':
                    resultGenStack.push(a+b);
                    break;
                case '*':
                    resultGenStack.push(a*b);
                    break;
                default:
                    throw new IllegalOperatorException();
            }

        }

        if(!operandGenStack.empty())
            return operandGenStack.pop();

        return resultGenStack.pop();
    }
}
