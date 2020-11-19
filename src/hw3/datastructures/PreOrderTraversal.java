package hw3.datastructures;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Ritwik Banerjee
 */
public class PreOrderTraversal<E> extends Traversal<E> {

    /**
     * The method that jumpstarts the process of traversing through the tree.
     *
     * @param tree  The given tree to be traversed through
     * @return      The list of nodes traversed through using preorder traversal
     */
    @Override
    public List<E> of(BinaryTree<E> tree) {
        List<E> output = new ArrayList<>();
        if (tree.root() != null) // check if tree isn't empty
            buildList(tree.root(), output);

        return output;
    }

    /**
     * A helper method that helps build the list using preorder traversal.
     *
     * @param node  The node that the traversal is currently working on
     * @param list  The list that has been built that this function will add on to
     */
    private void buildList(BinaryTreeNode<E> node, List<E> list) {
        list.add(node.element());

        if (node.left() != null) buildList(node.left(), list);
        if (node.right() != null) buildList(node.right(), list);
    }
}
