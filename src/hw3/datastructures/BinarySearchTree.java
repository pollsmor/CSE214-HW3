package hw3.datastructures;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Ritwik Banerjee
 */
public class BinarySearchTree<T extends Comparable<T>> implements BinaryTree<T> {
    
    private BinaryTreeNode<T> root;
    private int               size;
    
    /**
     * !!DO NOT MODIFY THIS CODE!!
     * Consrtucts a binary search tree consisting of items from the given collection. Duplicates in the collection are
     * ignored, i.e., every item will be considered only once for the tree being constructed.
     *
     * @param collection the given collection
     */
    public BinarySearchTree(Collection<T> collection) {
        this();
        for (T t : collection)
            add(t);
    }
    
    /**
     * !!DO NOT MODIFY THIS CODE!!
     * Constructs an empty binary search tree.
     */
    private BinarySearchTree() {
        root = null;
        size = 0;
    }
    
    @Override
    public void add(T t) {
        size++;
        BinaryTreeNode<T> currNode = root();
        while (currNode != null) {
            if (t.compareTo(currNode.element()) < 0) { // more expensive/"lesser" laptop
                if (currNode.left() == null) { // empty slot found
                    BinaryTreeNode<T> input = new BinaryTreeNode<>(t);
                    input.setParent(currNode);
                    currNode.setLeft(input);
                    return;
                }

                currNode = currNode.left(); // keep heading down the tree
            } else { // cheaper/"greater"
                if (currNode.right() == null) {
                    BinaryTreeNode<T> input = new BinaryTreeNode<>(t);
                    input.setParent(currNode);
                    currNode.setRight(input);
                    return;
                }

                currNode = currNode.right();
            }
        }

        root = new BinaryTreeNode<>(t); // never entered while loop in the first place, tree must be empty
    }
    
    @Override
    public void remove(T t) {
        BinaryTreeNode<T> currNode = root();
        BinaryTreeNode<T> parentNode = root(); // I would use null here but Intellij wouldn't stop screaming at me

        while (currNode != null) {
            if (t.compareTo(currNode.element()) < 0) {
                parentNode = currNode;
                currNode = currNode.left();
            } else if (t.compareTo(currNode.element()) > 0) {
                parentNode = currNode;
                currNode = currNode.right();
            } else { // node found
                size--;

                if (currNode.left() == null && currNode.right() == null) { // 0 children
                    if (currNode == root()) {
                        root = null; // edge case: only 1 element in BST
                        return;
                    }

                    currNode.setParent(null); // I don't think this is required, but putting it in as per assignment specs.
                    if (parentNode.left() == currNode) parentNode.setLeft(null);
                    else parentNode.setRight(null);
                } else if (currNode.left() != null && (currNode.right() != null)) { // 2 children
                    BinaryTreeNode<T> successor = currNode.right();
                    BinaryTreeNode<T> parentSuccessor = currNode.right();
                    while (successor.left() != null) { // keep looking for the immediate largest element
                        parentSuccessor = successor;
                        successor = successor.left(); // minimum value must be the bottom-leftmost node in the right subtree
                    }

                    if (parentSuccessor.left() == successor) parentSuccessor.setLeft(null);
                    else parentSuccessor.setRight(null);
                    successor.setParent(parentNode);
                    currNode = successor;
                } else { // 1 child
                    if (currNode == root()) { // edge case: need to remove the root, make sole child the new root
                        if (currNode.left() != null) root = currNode.left();
                        else root = currNode.right();
                    }

                    currNode.setParent(null);

                    if (currNode.left() != null) { // single child is on left branch
                        if (parentNode.left() == currNode) parentNode.setLeft(currNode.left());
                        else parentNode.setRight(currNode.left());
                    } else { // single child is on right branch
                        if (parentNode.left() == currNode) parentNode.setLeft(currNode.right());
                        else parentNode.setRight(currNode.right());
                    }
                }
            }
        }
    }
    
    /**
     * Returns the search path that starts at the root node of the tree, and ends at the node containing the specified
     * item. If such a node exists in the tree, it is the last object in the returned list. Otherwise, this method will
     * still return the path corresponding to the search for this item, but append a <code>null</code> element at the
     * end of the list.
     *
     * @param t the specified item
     * @return the search path, with a node containing the specified item as the last object in the list if the item is
     * found in the tree, and the <code>null</code> node if item is not found in the tree.
     */
    @Override
    public List<BinaryTreeNode<T>> find(T t) {
        List<BinaryTreeNode<T>> output = new ArrayList<>();

        BinaryTreeNode<T> currNode = root();
        while (currNode != null) {
            if (t.compareTo(currNode.element()) < 0) {
                currNode = currNode.left();
                output.add(currNode);
            } else if (t.compareTo(currNode.element()) > 0) {
                currNode = currNode.right();
                output.add(currNode);
            } else { // node found
                output.add(currNode);
                return output;
            }
        }

        output.add(null); // currNode reached null and not found, add null and return
        return output;
    }
    
    /**
     * !!DO NOT MODIFY THIS CODE!!
     */
    @Override
    public void print() {
        root.print();
    }
    
    /**
     * !!DO NOT MODIFY THIS CODE!!
     *
     * @return the root node of this tree
     */
    @Override
    public BinaryTreeNode<T> root() {
        return root;
    }
    
    /**
     * !!DO NOT MODIFY THIS CODE!!
     *
     * @return the size, i.e., the number of nodes in this tree
     */
    @Override
    public int size() {
        return size;
    }
}