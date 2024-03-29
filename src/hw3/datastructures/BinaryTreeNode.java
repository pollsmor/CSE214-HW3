package hw3.datastructures;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ritwik Banerjee
 */
public class BinaryTreeNode<E> {
    
    private E element;
    
    private BinaryTreeNode<E> left   = null;
    private BinaryTreeNode<E> right  = null;
    private BinaryTreeNode<E> parent = null;
    
    public BinaryTreeNode(E element) {
        this.element = element;
    }
    
    public E element() { return element; }
    
    public BinaryTreeNode<E> left() { return left; }
    
    public BinaryTreeNode<E> right() { return right; }
    
    public BinaryTreeNode<E> parent() { return parent; }
    
    public void setElement(E element) { this.element = element; }
    
    public void setLeft(BinaryTreeNode<E> node) { this.left = node; }
    
    public void setRight(BinaryTreeNode<E> node) { this.right = node; }
    
    public void setParent(BinaryTreeNode<E> node) { this.parent = node; }
    
    /**
     * Checks equality between two nodes such that it extends to checking for equality between two trees rooted at these nodes.
     *
     * @param o The object to be checked for equality
     * @return  Whether the specified object is equal to the current object.
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // check addresses are the same first
        if (!(o instanceof BinaryTreeNode)) return false; // not even the correct type
        BinaryTreeNode<E> that = (BinaryTreeNode<E>) o;

        boolean elementEquality = (this.element.equals(that.element));
        // Need to make sure the children aren't null first
        boolean childrenEquality = (this.left() == null ? that.left() == null : this.left.equals(that.left)) &&
                (this.right() == null ? that.right() == null : this.right.equals(that.right));

        return elementEquality && childrenEquality;
    }

    /**
     * !!DO NOT MODIFY THIS CODE!!
     *
     * @return
     */
    @Override
    public int hashCode() {
        int result = element.hashCode();
        result = 31 * result + (left != null ? left.hashCode() : 0);
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }
    
    /** !!DO NOT MODIFY THIS CODE!! */
    private void print(String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "'-- " : "|-- ") + element.toString());
        List<BinaryTreeNode<E>> children = Arrays.asList(left, right);
        for (int i = 0; i < children.size() - 1; i++) {
            if (children.get(i) != null)
                children.get(i).print(prefix + (isTail ? "    " : "|   "), false);
        }
        if (children.size() > 0 && children.get(children.size() - 1) != null) {
            children.get(children.size() - 1).print(prefix + (isTail ? "    " : "|    "), true);
        }
    }
    
    /** !!DO NOT MODIFY THIS CODE!! */
    public void print() {
        print("", true);
    }
}
