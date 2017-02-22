/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   19/02/2017.
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
     * The canEvaluateExpression determines whether there are enough
     * operands on the operand stack to perform an operation.
     * @return true if there are enough operands on the operand stack
     *         to perform an operation, otherwise false.
     */
    private boolean canEvaluateExpression()
    {
        boolean result = false;
        if ( (operandGenStack.size()==2) && operatorGenStack.size()>0)
            result = true;
        //else if(operatorGenStack.size() > 1 && operandGenStack.size()>1)
        //    result = true;
        return result;
    }


    /**
     * The addition method pops two values from the operand stack
     * adds them together, and pushes the result to the operand stack.
     */
    private void addition(int a, int b)
    {
        resultGenStack.push(a + b);
    }


    /**
     * The multiplication method pops two values from the operand stack
     * multiplies them together, and pushes the result to the
     * operand stack
     */
    private void multiplication(int a, int b)
    {
        resultGenStack.push(a * b);
    }


    /**
     * The evaluateSubExpression method determines which operation
     * to perform. The operation is then performed and the result
     * is pushed to the operand stack.
     */
    private void evaluateSubExpression(int a, int b)
    {
        int result;
        char operator = operatorGenStack.pop();
        switch(operator)
        {
            case '+':
                addition(a, b);
                break;
            case '*':
                multiplication(a, b);
                break;
            default:
                throw new IllegalOperatorException();
        }
    }


    private void clearStacks()
    {
        operandGenStack.clear();
        operatorGenStack.clear();
        resultGenStack.clear();
    }



    public int parseExpression(String expression)
    {
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

            if(canEvaluateExpression())
                evaluateSubExpression(operandGenStack.pop(),operandGenStack.pop());

            if(resultGenStack.size() > 1)
                evaluateSubExpression(resultGenStack.pop(),resultGenStack.pop());
        }

        // This is a case where a value was entered without an operator
        if(operandGenStack.size()==1)
            resultGenStack.push(operandGenStack.pop());

        int result;

        // Get the result
        if(resultGenStack.size()==1)
            result = resultGenStack.pop();
        else {
            clearStacks();
            throw new InvalidPrefixExpressionException();
        }

        clearStacks();
        return result;
    }
}
