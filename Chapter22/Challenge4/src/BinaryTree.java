/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   04/03/2017.
 */

public class BinaryTree
{
    private class Node
    {
        boolean isOperator;
        char operation;         // operator to use upon numbers
        int number;
        Node left, right;   // Left and Right child
        Node previous;

        // All Nodes added will be leaf nodes
        Node(boolean isOperator, char operation, int number, Node previous)
        {
            this.isOperator = isOperator;
            this.operation = operation;
            this.number = number;
            this.left = null;
            this.right = null;
            this.previous = previous;
        }
    }

    private Node root;              // root of binary tree
    private Node lastInsertedToken; // the last node inserted into the tree

    /**
     * Constructor
     */
    public BinaryTree()
    {
        root = null;
        lastInsertedToken = null;
    }


    /**
     * The clear method clears the Binary tree by setting
     * root and lastInsertedToken to null.
     */
    public void clear()
    {
        root = null;
        lastInsertedToken = null;
    }


    /**
     * The add method adds a Node to the Binary Tree
     * @param isOperator True if the value of this node is an operator,
     *                   false otherwise.
     * @param op A character representing an operation
     * @param num A number
     * @return True if added correctly, otherwise false
     */
    public boolean add(boolean isOperator, char op, int num)
    {
        // if root is null then number is added here
        if(root==null)
        {
            root = new Node(isOperator, op, num, null);
            lastInsertedToken = root;
            return true;
        }
        if(!root.isOperator)
            return false;

        return add(isOperator, op, num, lastInsertedToken);
    }


    /**
     * The add method adds a Node to the Binary Tree
     * @param isOperator True if the value of this node is an operator,
     *                   false otherwise.
     * @param op A character representing an operation
     * @param num A number
     * @param bTree The previous Node in the Binary tree
     * @return True if added correctly, otherwise false
     */
    public boolean add(boolean isOperator, char op, int num, Node bTree)
    {
        if(bTree==null)
            return false;

        if(bTree==root && bTree.right!=null)
            if(!bTree.right.isOperator)
                return false;

        boolean added = false;
        if(bTree.left==null && bTree.isOperator )
        {
            bTree.left = new Node(isOperator, op, num, bTree);
            lastInsertedToken = bTree.left;
            added = true;
        }
        else if(bTree.previous!=null && bTree.previous.right==null)
        {
            bTree.previous.right = new Node(isOperator, op, num, bTree.previous);
            lastInsertedToken = bTree.previous.right;
            added = true;
        }
        else
        {
            added = add(isOperator, op, num, bTree.previous);
        }

        return added;
    }


    /**
     * The calculate method returns the result of
     * the prefix operation
     * @return The result of the prefix operation
     */
    public int calculate()
    {
        if(root.left==null && root.right==null)
            return root.number;

        return calculate(lastInsertedToken);
    }


    /**
     * This calculate method recursively calculates
     * the result of the prefix operation
     * @param bTree The part of the binary tree to use
     *              in the calculation - if this is root then the
     *              calculation operation is complete
     * @return The result of the prefix operation
     */
    public int calculate(Node bTree)
    {
        // base case
        if(bTree==root && !root.isOperator)
        {
            if(root.left==null && root.right==null)
                return root.number;
        }
        // if on left branch
        else if(bTree == root.left)
        {
            calculate(root.right);
        }
        // if on left branch
        else if(bTree.previous.right != bTree && bTree.previous.right!= null)
        {
            calculate(bTree.previous.right);
        }
        // calculate result and replace Node with result
        else if(!bTree.previous.left.isOperator)
        {
            int result = performOperation(bTree.previous.left.number,
                                          bTree.number,
                                          bTree.previous.operation);
            bTree.previous.isOperator = false;
            bTree.previous.number = result;
            bTree.previous.left = null;
            bTree.previous.right = null;

            calculate(bTree.previous);
        }
        // if btree right is a branch rather than a node
        else if(bTree.previous.left.right != null)
            calculate(bTree.previous.left.right);

        // Should never reach here
        return root.number;
    }

    /**
     * The performOperation method returns the result
     * of performing the operation op on a and b
     * @param a The first number in the expression
     * @param b The second number in the expression
     * @param op The operator in the expression
     * @return
     */
    private int performOperation(int a, int b, char op)
    {
        int result = 0;

        switch(op)
        {
            case '+':
                result = a+b;
                break;
            case '*':
                result = a*b;
                break;
            default:
                break;
        }

        return result;
    }

}
