import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
   This class implements AVLTrees.
*/

public class AVLTree
{
    /**
       AVLNode Represents a node in an AVL tree.
    */
    
    private class AVLNode 
    {      
        int value;           // Value stored in this node.
        AVLNode left, right; // Left and right subtree.
        int height;          // Height of node.

        public AVLNode(int value)
        { 
            // Call the other (sister) constructor.
            this(value, null, null);
        }
        public AVLNode(int val, AVLNode left1, AVLNode right1)
        {
            value = val;
            left = left1;
            right = right1;
            height = 0;
        }
        
        /**
           The resetHeight methods recomputes height 
           if the left or right subtrees have changed.
        */
        
        void resetHeight()
        {
          int leftHeight = AVLTree.getHeight(left);
          int rightHeight = AVLTree.getHeight(right);      
          height = 1 + Math.max(leftHeight, rightHeight);
        }    
    } 
    
    /** 
      The BTreeDisplay class can graphically 
       display a binary tree.
    */
    
    private class BTreeDisplay extends JPanel
    {
        /**
           Constructor.
           @param tree The root of the binary
			  tree to display.
         */
        
        BTreeDisplay(AVLNode tree)
        {           
           setBorder(BorderFactory.createEtchedBorder());
           setLayout(new BorderLayout());
           if (tree != null) 
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
       The getHeight method computes the 
       height of an AVL tree.
       @param tree An AVL tree.
		 @return The height of the AVL tree.
    */

    static int getHeight(AVLNode tree)
    {
      if (tree == null) return -1; 
      else return tree.height;       
    }


    /**
     * The level method returns the level of a number in the tree
     * @param x A number in the tree to return the level for
     * @return The level of the number in the tree, else -1
     *         if the number was not found in the tree.
     */
    public int level(int x)
    {
        if(root==null)
            return -1;
        else if(root.value == x)
            return 0;
        return level(x, 0, root);
    }


    /**
     * The level method returns the level of a number in the tree
     * @param x A number in the tree to return the level for
     * @param currentLevel The number of the current level being searched
     * @param bTree The AVLNode currently being searched
     * @return The level of the number in the tree, else -1
     *         if the number was not found in the tree.
     */
    public int level(int x, int currentLevel, AVLNode bTree)
    {
        if(bTree==null)
            return -1;

        if(bTree.value==x)
            return currentLevel;
        if(x < bTree.value)
        {
            // recursively look in left subtree
            currentLevel = level(x, currentLevel+1, bTree.left);
        }
        if(x > bTree.value)
        {
            // recursively look in right subtree
            currentLevel = level(x, currentLevel+1, bTree.right);
        }

        return currentLevel;
    }

     
    /**
      The add method adds a value to this AVL tree.
      @param x The value to add.
      @return true. 
    */
    
    public boolean add(int x)
    {
       root = add(root, x);   
       return true;
    }
    
    /**
       The getView method creates and returns a 
       a graphical view of the binary tree.
       @return A panel that displays a view of the tree.
    */
    
    public JPanel getView()
    {
        return new BTreeDisplay(root);
    }
    
    /**
       The isEmpty method checks if this AVL tree is empty.
       @return true if the tree is empty, false otherwise.
    */
    
    public boolean isEmpty() 
    {
        return root == null;
    }
    
    private AVLNode root = null;   // Root of this AVL tree  


    public void clear()
    {
        root=null;
    }



    /**
       The add method adds a value to an AVL tree.
       @return The root of the  augmented AVL tree.
    */
    
    private AVLNode add(AVLNode bTree, int x)
    {        
        if (bTree == null)
            return new AVLNode(x);        
        if (x < bTree.value)       
            bTree.left = add(bTree.left, x);       
        else       
            bTree.right = add(bTree.right, x);
        
        // Compute heights of the left and right subtrees
		  // and rebalance the tree if needed
        int leftHeight = getHeight(bTree.left);
        int rightHeight = getHeight(bTree.right);       
        if (Math.abs(leftHeight - rightHeight) == 2)
           return balance(bTree);
        else
        {
           bTree.resetHeight();
           return bTree;
        }                
    }
    
    /**
       The balance method rebalances an AVL tree. 
       @param bTree The AVL tree needing to be balanced.
       @return The balanced AVL tree.      
    */
    
    private AVLNode balance(AVLNode bTree)
    {
        int rHeight = getHeight(bTree.right);
        int lHeight = getHeight(bTree.left);
        
        if (rHeight > lHeight)
        {
            AVLNode rightChild = bTree.right;
            int rrHeight = getHeight(rightChild.right);
            int rlHeight = getHeight(rightChild.left);           
            if (rrHeight > rlHeight)           
                return rrBalance(bTree);            
            else            
                return rlBalance(bTree);            
        }
        else
        {
            AVLNode leftChild = bTree.left;
            int llHeight = getHeight(leftChild.left);
            int lrHeight = getHeight(leftChild.right);           
            if (llHeight > lrHeight)
                return llBalance(bTree);
            else
                return lrBalance(bTree);            
        }        
    }
    
    /** 
       The rrBlance method corrects an RR imbalance.
       @param bTree The AVL tree wih an RR imbalance.
       @return The balanced AVL tree.       
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
       The rlBalance method corrects an RL imbalance.
       @parame bTree The AVL tree with an RL imbalance.
       @return The balanced AVL tree.
    */
    
    private AVLNode rlBalance(AVLNode bTree)
    {
        AVLNode root = bTree;
        AVLNode rNode = root.right;
        AVLNode rlNode = rNode.left;
        AVLNode rlrTree = rlNode.right;
        AVLNode rllTree = rlNode.left;
        
        // Build the restructured tree
        rNode.left = rlrTree;
        root.right = rllTree;
        rlNode.left = root;
        rlNode.right = rNode;
        
        // Adjust heights
        rNode.resetHeight();
        root.resetHeight();
        rlNode.resetHeight();
        
        return rlNode;        
    }
    
    /**
       The llBalance method corrects an LL imbalance.
       @param bTree The AVL tree with an LL imbalance.
       @return The balanced AVL tree.
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
       The lrBalance method corrects an LR imbalance.
       @param bTree The AVL tree with an LR imbalance.
       @return The balanced AVL tree.
    */

    private AVLNode lrBalance(AVLNode bTree)
    {
        AVLNode root = bTree;
        AVLNode lNode = root.left;
        AVLNode lrNode = lNode.right;
        AVLNode lrlTree = lrNode.left;
        AVLNode lrrTree = lrNode.right;
        
        // Build the restructured tree
        lNode.right = lrlTree;
        root.left = lrrTree;
        lrNode.left = lNode;
        lrNode.right = root;
        
        // Adjust heights
        lNode.resetHeight();
        root.resetHeight();
        lrNode.resetHeight();
		  
        return lrNode;        
    }    
}