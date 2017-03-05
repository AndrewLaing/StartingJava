/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   27/02/2017.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class GenealogyTree
{
    private class Node
    {
        String name;
        Node leftChild, rightChild;
        Node ancestor;

        public Node(String name)
        {
            // Call the other (sister) constructor.
            this(name, null, null, null);
        }

        public Node(String name, Node leftChild, Node rightChild, Node ancestor)
        {
            this.name = name;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.ancestor = ancestor;
        }
    }

    private Node root = null;


    /**
     * The GTreeDisplayClass is used to create a graphical view
     * of a GenealogyTree
     */
    private class GTreeDisplay extends JPanel
    {
        /**
         * Constructor
         * @param tree The root of the genealogy tree to display
         */
        GTreeDisplay(Node tree)
        {
            setBorder(BorderFactory.createEtchedBorder());
            setLayout(new BorderLayout());
            if(tree!=null)
            {
                String value = String.valueOf(tree.name);
                int pos = SwingConstants.CENTER;
                JLabel rootLabel = new JLabel(value, pos);
                add(rootLabel, BorderLayout.NORTH);
                JPanel panel = new JPanel(new GridLayout(1, 2));
                panel.add(new GTreeDisplay(tree.leftChild));
                panel.add(new GTreeDisplay(tree.rightChild));
                add(panel);
            }
        }
    }


    /**
     * The getView method creates and returns a
     * graphical view of a genealogy tree
     * @return A panel that displays a view of the tree
     */
    public JPanel getView()
    {
        return new GTreeDisplay(root);
    }


    /**
     * The method addRoot creates a new root node.
     * @param name The name to add to the root node
     */
    public boolean addRoot(String name)
    {
        if(root!=null)
            return false;

        root = new Node(name);
        return true;
    }


    /**
     * This addChild method calls the recursive version of addChild
     * passing it the values and a reference to root
     * @param leftChild Is the new node a left child
     * @param parent The name of the parent
     * @param child The name of the child
     * @return true if child added, otherwise false
     */
    public boolean addChild(boolean leftChild, String parent, String child)
    {
        return addChild(leftChild, parent, child, root);
    }


    /**
     * The addChild method recursively adds a left or right child
     * with the name child to the node with the name parent
     * @param leftChild Is the new node a left child
     * @param parent The name of the parent
     * @param child The name of the child
     * @param bTree The node to examine.
     * @return true if child added, otherwise false
     */
    public boolean addChild(boolean leftChild, String parent, String child, Node bTree)
    {
        boolean added = false;
        // either a leaf has been reached or the tree is empty
        if(bTree==null)
            return false;
        // this is the correct node
        if(bTree.name.equals(parent))
        {
            if(leftChild && bTree.leftChild==null)
            {
                bTree.leftChild = new Node(child, null, null, bTree);
                added = true;
            }
            else if((!leftChild) && bTree.rightChild==null)
            {
                bTree.rightChild = new Node(child, null, null, bTree);
                added = true;
            }
            else
                added = false;
        }

        if(added) return true;

        // recursively check the right and left children for the parent
        added = addChild(leftChild, parent, child, bTree.leftChild);
        if(added) return true;

        added = addChild(leftChild, parent, child, bTree.rightChild);
        if(added) return true;
        return false;
    }


    /**
     * The getPerson method searches for and returns the Node
     * with the name attribute person
     * @param person The name attribute of the Node to return
     * @return The Node found with the name attribute person,
     *         otherwise null
     */
    public Node getPerson(String person)
    {
        return getPerson(person, root);
    }


    /**
     * The getPerson method recursively searches for and
     * returns the Node with the name attribute person
     * @param person The name attribute of the Node to return
     * @param bTree The node to check
     * @return The Node found with the name attribute person,
     *         otherwise null
     */
    public Node getPerson(String person, Node bTree)
    {
        Node found = null;
        if(bTree==null)
            return null;

        if(bTree.name.equals(person))
            return bTree;

        // Recursively search left and right subtrees for person
        found = getPerson(person, bTree.leftChild);
        if(found!=null) return found;

        found = getPerson(person, bTree.rightChild);

        return found;
    }


    /**
     * This descendants method first checks whether a person
     * exists within the tree, then calls the recursive descendants
     * method to create a list of that persons descendants.
     * @param person A person to create a list of descendants for.
     * @return A list of a person's descendants
     */
    public String descendants(String person)
    {
        Node found = getPerson(person);
        String descendantsFound = "";
        if(found==null)
            return "Person not found!";

        if(found.leftChild!=null)
            descendantsFound = descendants(descendantsFound, found.leftChild);
        if(found.rightChild!=null)
            descendantsFound = descendants(descendantsFound, found.rightChild);

        if(descendantsFound.length()==0)
            descendantsFound = "No descendants have been found for this person!";

        return descendantsFound;
    }


    /**
     * The descendants method recursively creates a list of
     * a person's descendants
     * @param descendantsFound A string containing the names of
     *                         a person's descendants
     * @param person A node to check for descendants
     * @return A list of a person's descendants
     */
    private String descendants(String descendantsFound, Node person)
    {
        if(person==null)
            return descendantsFound;
        descendantsFound += person.name + " ";

        // recursively add names to the descendants list
        descendantsFound = descendants(descendantsFound, person.leftChild);
        descendantsFound = descendants(descendantsFound, person.rightChild);

        return descendantsFound;
    }


    /**
     * This ancestors method first checks whether a person
     * exists within the tree, then calls the recursive ancestors
     * method to create a list of that person's ancestors.
     * @param person A person to create a list of ancestors for.
     * @return A list of a person's ancestors
     */
    public String ancestors(String person)
    {
        Node found = getPerson(person);
        String ancestorsFound = "";
        if(found==null)
            return "Person not found!";

        if(found.ancestor!=null)
            ancestorsFound = ancestors(ancestorsFound, found.ancestor);


        if(ancestorsFound.length()==0)
            ancestorsFound = "No ancestors have been found for this person!";

        return ancestorsFound;
    }


    /**
     * The ancestors method recursively creates a list of
     * a person's ancestors
     * @param ancestorsFound A string containing the names of
     *                         a person's ancestors
     * @param person A node to check for ancestors
     * @return A list of a person's ancestors
     */
    private String ancestors(String ancestorsFound, Node person)
    {
        if(person==null)
            return ancestorsFound;
        ancestorsFound += person.name + " ";

        if(person.ancestor!=null)
            ancestorsFound = ancestors(ancestorsFound, person.ancestor);

        return ancestorsFound;
    }
}
