package hw3.datastructures;

import java.util.Collection;
import java.util.List;

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
        // TODO: implement the insert algorithm for binary search trees
    }
    
    @Override
    public void remove(T t) {
        // TODO: implement the delete algorithm for binary search trees
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
        return null; // TODO: implement the search/find algorithm for binary search trees
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