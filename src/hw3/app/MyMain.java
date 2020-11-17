package hw3.app;

import hw3.datastructures.BinaryTreeNode;
import hw3.datastructures.BinarySearchTree;
import hw3.datastructures.ChainedHashSet;
import hw3.datastructures.Set;
import hw3.products.Laptop;

import java.util.ArrayList;
import java.util.List;

public class MyMain {
    public static void main(String[] args) {
        List<Laptop> laptops = new ArrayList<>();
        Laptop laptop1 = Laptop.fromString("hitachi,2.33,4,499,13");
        Laptop laptop2 = Laptop.fromString("hp,1.6,2,379,15");
        Laptop laptop3 = Laptop.fromString("apple,2.66,8,1250,14");
        Laptop laptop4 = Laptop.fromString("apple,3.33,8,1600,14");
        Laptop laptop5 = Laptop.fromString("microsoft,2.66,8,999,14");
        Laptop laptop6 = Laptop.fromString("hitachi,2.33,4,499,13");
        laptops.add(laptop1);
        laptops.add(laptop2);
        laptops.add(laptop3);
        laptops.add(laptop4);
        laptops.add(laptop5);

        System.out.println("Testing Laptop.equals method");
        System.out.println("Laptop 1 equals laptop 2: " + laptops.get(0).equals(laptops.get(1)));
        System.out.println("Laptop 3 equals laptop 3: " + laptops.get(2).equals(laptops.get(2)));
        System.out.println("Laptop 1 has the same specs/price as laptop 6. Laptop 1 equals laptop 6: " +
                laptops.get(0).equals(laptop6));

        System.out.println("========================================");

        System.out.println("Testing BinaryTreeNode.equals method");
        BinaryTreeNode<Laptop> node1 = new BinaryTreeNode<>(laptops.get(0));
        node1.setLeft(new BinaryTreeNode<>(laptops.get(1)));
        node1.setRight(new BinaryTreeNode<>(laptops.get(2)));
        BinaryTreeNode<Laptop> node2 = new BinaryTreeNode<>(laptops.get(0));
        node2.setLeft(new BinaryTreeNode<>(laptops.get(3)));
        node2.setRight(new BinaryTreeNode<>(laptops.get(2)));
        System.out.println("Node 1 and node 2 have different left children. Are they equal: " +
                node1.equals(node2));

        System.out.println("Setting the left child of node 2 to be the same as the left child of node 1.");
        node2.setLeft(new BinaryTreeNode<>(laptops.get(1)));
        System.out.println("Are they equal now: " + node1.equals(node2));

        System.out.println("========================================");

        System.out.println("Testing other BinarySearchTree methods");
        BinarySearchTree<Laptop> laptopTree = new BinarySearchTree<>(laptops);
        System.out.println("Tree initially looks like this: ");
        laptopTree.print();
        System.out.println();
        System.out.println("Attempting to remove a laptop with these specs: spacex,69ghz,420gb,$69420,13in");
        laptopTree.remove(Laptop.fromString("spacex,69,420,69420,13"));
        System.out.println("Does the tree change?");
        laptopTree.print();
        System.out.println();
        System.out.println("Now remove laptop 1 (the hitachi one) from the tree: ");
        laptopTree.remove(laptop1);
        laptopTree.print();
        System.out.println();
        System.out.println("Now remove laptop 3 (the $1250 Apple one) from the tree: ");
        laptopTree.remove(laptop3);
        laptopTree.print();
        System.out.println();

        System.out.println("Path to laptop 4: " + laptopTree.find(laptop4));
        System.out.println("Path to laptop 1 (should end in null as the laptop no longer exists): " + laptopTree.find(laptop1));
        System.out.println("Size of tree (should be 3): " + laptopTree.size());

        System.out.println("========================================");
        System.out.println("Testing hashtable methods");

        Set<Laptop> laptopSet = new ChainedHashSet<>();
        System.out.println("Adding laptops 1 through 5 into the hashtable: ");
        laptopSet.add(laptop1);
        laptopSet.add(laptop2);
        laptopSet.add(laptop3);
        laptopSet.add(laptop4);
        laptopSet.add(laptop5);

        System.out.println("What does the hashtable look like?");
        System.out.println(laptopSet);
        System.out.println();

        System.out.println("Now remove both laptops 1 (Hitachi) and 6 (not already added).");
        laptopSet.remove(laptop1);
        laptopSet.remove(laptop6);
        System.out.println("Now what does the hashtable look like?");
        System.out.println(laptopSet);
    }
}
