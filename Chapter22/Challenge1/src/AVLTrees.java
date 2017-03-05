/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   23/02/2017.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AVLTrees
{
    private class AVLNode
    {
        int value;              // value stored in this node
        AVLNode left, right;    // left and right subtrees
        int height;             // height of node

        public AVLNode(int value)
        {
            // call the other (sister) constructor
            this(value, null, null);
        }


        public AVLNode(int value, AVLNode left, AVLNode right)
        {
            this.value = value;
            this.left = left;
            this.right = right;
            height = 0;
        }



        void resetHeight()
        {
            int leftHeight = AVLTrees.getHeight(left);
            int rightHeight = AVLTrees.getHeight(right);
            height = 1 + Math.max(leftHeight, rightHeight);
        }
    }


    /**
     * The BTreeDisplay class graphically displays
     * trees in JPanel. The JPanel is recursively
     * partitioned into a top part displaying the root,
     * and two lower parts displaying the left and
     * tight subtrees
     */
    private class BTreeDisplay extends JPanel
    {
        /**
         * Constructor
         * @param tree The root of the binary tree to display
         */
        BTreeDisplay(AVLNode tree)
        {
            setBorder(BorderFactory.createEtchedBorder());
            setLayout(new BorderLayout());
            if(tree!=null)
            {
                String value = String.valueOf(tree.value);
                int pos = SwingConstants.CENTER;
                JLabel rootLabel = new JLabel(value, pos);
                add(rootLabel, BorderLayout.NORTH);
                JPanel panel = new JPanel(new GridLayout(1, 2));
                panel.add(new BTreeDisplay(tree.left));
                panel.add(new BTreeDisplay(tree.right));
                add(panel);
            }
        }
    }


    /**
     * The get height method computes
     * the height of an AVLTree.
     * @param tree An AVL tree.
     * @return The height of the AVLTree.
     */
    static int getHeight(AVLNode tree)
    {
        if(tree==null)
            return -1;
        else
            return tree.height;
    }


    /**
     * The getView method creates and returns a
     * graphical view of a binary tree
     * @return A panel that displays a view of the tree
     */
    public JPanel getView()
    {
        return new BTreeDisplay(root);
    }


    /**
     * The isEmpty method checks if this AVL tree is empty
     * @return true if the tree is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return root==null;
    }

    private AVLNode root = null;  // root of this AVL tree


    ////////////////////////////////////////////////////////////
    // REMOVE METHODS AND REMOVAL RESULT CLASS /////////////////
    ////////////////////////////////////////////////////////////

    /**
     * This class represents the result of
     * removing a node from a binary tree.
     */
    private class RemovalResult
    {
        AVLNode node;
        AVLNode tree;
        RemovalResult(AVLNode node, AVLNode tree)
        {
            this.node = node;
            this.tree = tree;
        }
    }


    /**
     * used by the remove methods
     * @param toBalance
     * @return
     */
    private AVLNode balanceNode(AVLNode toBalance)
    {
        // Compute heights of the left and right subtrees
        // and rebalance the tree if needed
        int leftHeight = AVLTrees.getHeight(toBalance.left);
        int rightHeight = AVLTrees.getHeight(toBalance.right);
        if(Math.abs(leftHeight - rightHeight) >= 2)
        {
            toBalance = balance(toBalance);
        }
        else
        {
            toBalance.resetHeight();
        }
        return toBalance;
    }


    /**
     * The remove method removes a value
     * from the AVL tree.
     * @param x The value to remove.
     * @return true if x was removed, false otherwise.
     */
    public boolean remove(int x)
    {
        RemovalResult result = remove(root, x);
        if(result==null)
            return false;
        else
        {
            root = result.tree;
            if(root==null)
                return true;

            root = balanceNode(root);

            return true;
        }
    }


    /**
     * This remove method removes a value from the
     * AVL tree and returns the removed
     * node and the remaining tree wrapped in a
     * RemovalResult object.
     * @param bTree AVL tree.
     * @param x The value to remove.
     * @return A RemovalResult object
     *         else null if x not found in bTree
     */
    private RemovalResult remove(AVLNode bTree, int x)
    {
        if(bTree==null)
            return null;
        if(x < bTree.value)
        {
            // remove x from the left subtree
            RemovalResult result = remove(bTree.left, x);
            if(result==null)
                return null;

            bTree.left = balanceNode(bTree.left);

            bTree.left = result.tree;
            result.tree = bTree;

            return result;
        }
        if(x > bTree.value)
        {
            // remove x from the right subtree
            RemovalResult result = remove(bTree.right, x);
            if(result==null)
                return null;

            bTree.right = balanceNode(bTree.right);

            bTree.right = result.tree;
            result.tree = bTree;

            return result;

        }
        // x is in this root node
        // is it a leaf?
        if(bTree.right==null && bTree.left==null)
            return new RemovalResult(bTree, null);

        // does the node have two children
        if(bTree.right!=null && bTree.left!=null)
        {
            // remove largest node in left subtree and
            // make it the root of the remaining tree
            RemovalResult remResult =
                    removeLargest(bTree.left);
            AVLNode newRoot = remResult.node;

            newRoot.left = balanceNode(newRoot.left);
            newRoot.right = balanceNode(newRoot.right);

            newRoot.left = remResult.tree;
            newRoot.right = bTree.right;
            // prepare the result to be returned
            bTree.left = null;
            bTree.right = null;

            return new RemovalResult(bTree, newRoot);
        }

        // the node has one child
        AVLNode node = bTree;
        AVLNode tree;
        if(bTree.left!=null)
            tree = bTree.left;
        else
            tree = bTree.right;

        tree = balanceNode(tree);

        node.left = null;
        node.right = null;
        return new RemovalResult(node, tree);
    }


    /**
     * The removeLargest method removes the largest node
     * from a binary search tree
     * @param bTree The binary search tree
     * @return The result of removing the largest node
     */
    private RemovalResult removeLargest(AVLNode bTree)
    {
        if(bTree==null)
            return null;
        if(bTree.right==null)
        {
            // root is the largest node
            AVLNode tree = bTree.left;
            bTree.left = null;
            return new RemovalResult(bTree, tree);
        }
        else
        {
            // remove the largest node from the right subtree
            RemovalResult remResult =
                    removeLargest(bTree.right);
            bTree.right = remResult.tree;
            remResult.tree = bTree;
            return remResult;
        }
    }

    ////////////////////////////////////////////////////////////
    // CONTAINS METHODS ////////////////////////////////////////
    ////////////////////////////////////////////////////////////

    /**
     * The contains method checks to see if
     * a value is in the AVL tree.
     * @param x The value to check for.
     * @return true if x is in the tree
     */
    public boolean contains(int x)
    {
        // Call the private recursive method
        return contains(x, root);
    }


    /**
     * The method contains checks whether an item
     * is in an AVL tree.
     * @param x The item to check for.
     * @param bstree The binary tree to look in.
     * @return true if found, false otherwise
     */
    private boolean contains(int x, AVLNode bstree)
    {
        if(bstree == null)
            return false;
        if(x==bstree.value)
            return true;
        if(x < bstree.value)
        {
            // recursively look in left subtree
            return contains(x, bstree.left);
        }
        else
        {
            // recursively look in right subtree
            return contains(x, bstree.right);
        }
    }


    ////////////////////////////////////////////////////////////
    // ADD METHODS /////////////////////////////////////////////
    ////////////////////////////////////////////////////////////

    /**
     * The add method adds a value to this AVLTree.
     * @param x The value to add.
     * @return true.
     */
    public boolean add(int x)
    {
        root = add(root, x);
        return true;
    }


    private AVLNode add(AVLNode bTree, int x)
    {
        if(bTree==null)
            return new AVLNode(x);
        if(x < bTree.value)
            bTree.left = add(bTree.left, x);
        else
            bTree.right = add(bTree.right, x);


        // Compute heights of the left and right subtrees
        // and rebalance the tree if needed
        int leftHeight = AVLTrees.getHeight(bTree.left);
        int rightHeight = AVLTrees.getHeight(bTree.right);
        if(Math.abs(leftHeight - rightHeight) == 2)
            return balance(bTree);
        else
        {
            bTree.resetHeight();
            return bTree;
        }
    }


    ////////////////////////////////////////////////////////////
    // BALANCE METHODS /////////////////////////////////////////
    ////////////////////////////////////////////////////////////
    /**
     * The balance method rebalances an AVL tree
     * @param bTree The AVL tree needing to be balanced
     * @return The balanced AVL tree
     */
    private AVLNode balance(AVLNode bTree)
    {
        int rHeight = getHeight(bTree.right);
        int lHeight = getHeight(bTree.left);

        if(rHeight > lHeight)
        {
            AVLNode rightChild = bTree.right;
            int rrHeight = getHeight(rightChild.right);
            int rlHeight = getHeight(rightChild.left);
            if(rrHeight > rlHeight)
                return rrBalance(bTree);
            else
                return rlBalance(bTree);
        }
       else
        {
            AVLNode leftChild = bTree.left;
            int llHeight = getHeight(leftChild.left);
            int lrHeight = getHeight(leftChild.right);
            if(llHeight > lrHeight)
                return llBalance(bTree);
            else
                return lrBalance(bTree);
        }
    }


    /**
     * The rrBalance method corrects an RR imbalance.
     * @param bTree The tree with the RR imbalance
     * @return The balanced AVL tree
     */
    private AVLNode rrBalance(AVLNode bTree)
    {
        AVLNode rightChild = bTree.right;
        AVLNode rightLeftChild = rightChild.left;
        rightChild.left = bTree;
        bTree.right = rightLeftChild;
        bTree.resetHeight();
        rightChild.resetHeight();
        return rightChild;
    }


    /**
     * The rlBalance method corrects an RL imbalance.
     * @param bTree The tree with the RL imbalance
     * @return The balanced AVL tree
     */
    private AVLNode rlBalance(AVLNode bTree)
    {
        AVLNode root = bTree;
        AVLNode rNode = root.right;
        AVLNode rlNode = rNode.left;
        AVLNode rlrTree = rlNode.right;
        AVLNode rllTree = rlNode.left;

        // build the restructured tree
        rNode.left = rlrTree;
        root.right = rllTree;
        rlNode.left = root;
        rlNode.right = rNode;

        // adjust heights
        rNode.resetHeight();
        root.resetHeight();
        rlNode.resetHeight();

        return rlNode;
    }


    /**
     * The llBalance method corrects an LL imbalance.
     * @param bTree The tree with the LL imbalance
     * @return The balanced AVL tree
     */
    private AVLNode llBalance(AVLNode bTree)
    {
        AVLNode leftChild = bTree.left;
        AVLNode lrTree = leftChild.right;
        leftChild.right = bTree;
        bTree.left = lrTree;
        bTree.resetHeight();
        leftChild.resetHeight();
        return leftChild;
    }


    /**
     * The lrBalance method corrects an LR imbalance.
     * @param bTree The tree with the LR imbalance
     * @return The balanced AVL tree
     */
    private AVLNode lrBalance(AVLNode bTree)
    {
        AVLNode root = bTree;
        AVLNode lNode = root.left;
        AVLNode lrNode = lNode.right;
        AVLNode lrlTree = lrNode.left;
        AVLNode lrrTree = lrNode.right;

        // build the restructured tree
        lNode.right = lrlTree;
        root.left = lrrTree;
        lrNode.left = lNode;
        lrNode.right = root;

        // adjust heights
        lNode.resetHeight();
        root.resetHeight();
        lrNode.resetHeight();

        return lrNode;
    }



}
