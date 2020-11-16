package hw3.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ritwik Banerjee
 */
public class InOrderTraversal<E> extends Traversal<E> {
    
    @Override
    public List<E> of(BinaryTree<E> tree) {
        List<E> output = new ArrayList<>();
        if (tree.root() != null) // check if tree isn't empty
            buildList(tree.root(), output);

        return output;
    }

    public void buildList(BinaryTreeNode<E> node, List<E> list) {
        if (node.left() != null) buildList(node.left(), list);

        list.add(node.element());

        if (node.right() != null) buildList(node.right(), list);
    }
}
