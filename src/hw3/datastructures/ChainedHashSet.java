package hw3.datastructures;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * This class implements the {@link Set} interface. It offers constant time performance (on average) for the basic
 * operations <code>add</code>, <code>remove</code>, <code>containt</code>, and <code>size</code>, under the simple
 * uniform hashing assumption (i.e., the hash function distributes elements uniformly across the slots in the backing
 * table).
 * There are two constructors given to you. You can modify them, or add new constructors. However, the signature of
 * these two constructors must not be changed. That is, the user must be able to create an instance of this class by
 * invoking <code>new ChainedHashSet()</code> and <code>new ChainedHashSet(int k)</code>.
 *
 * @param <E> the type of elements stored in this set
 */
public class ChainedHashSet<E> implements Set<E> {

    /**
     * Once an instance is created, this table size cannot change
     */
    private final int tablesize;
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection") // Intellij please
    private ArrayList<LinkedList<E>> table;
    private int numOfElements;

    // DO NOT MODIFY THIS METHOD
    public final int tablesize() { return this.tablesize; }

    // DO NOT MODIFY THIS METHOD
    public final double loadfactor() { return size() / (double) tablesize; }

    public ChainedHashSet() { this(10); }

    public ChainedHashSet(int tablesize) {
        if (tablesize < 1) tablesize = 1; // in case the argument is invalid
        this.tablesize = tablesize;

        numOfElements = 0;
        table = new ArrayList<>(tablesize);
        for (int i = 0; i < tablesize; i++) {
            table.add(new LinkedList<>()); // fill in each slot with an empty LinkedList
        }
    }

    @Override public int size() {
        return numOfElements;
    }

    @Override public boolean isEmpty() {
        return numOfElements == 0;
    }

    @Override public boolean contains(E element) {
        if (element == null) throw new NullPointerException();

        LinkedList<E> list = table.get(Math.abs(element.hashCode()) % tablesize);
        for (E item : list) {
            if (item.equals(element)) return true;
        }

        return false; // couldn't find item in list that it would've mapped to, must not exist
    }

    @Override public boolean add(E e) {
        if (e == null) throw new NullPointerException();
        if (contains(e)) return false; // set already contained el, don't add again

        LinkedList<E> list = table.get(Math.abs(e.hashCode()) % tablesize);
        list.addFirst(e);
        numOfElements++;
        return true;
    }

    @Override public boolean remove(E e) {
        if (e == null) throw new NullPointerException();
        if (contains(e)) {
            LinkedList<E> list = table.get(Math.abs(e.hashCode()) % tablesize);
            list.remove(e);
            numOfElements--;
            return true;
        }

        return false; // element nowhere to be found, nothing to remove
    }

    /**
     * This method returns a string showing the entire hash table structure of this set. The format must be as follows:
     * Suppose a table has four slots, with three elements 'a', 'b', 'c', hashed to the first slot and 'z' hashed to the
     * third slot. Printing out the returned string should show the following:
     *
     * 1 || a -> b -> c
     * 2 ||
     * 3 || z
     *
     * Note that the elements 'a', 'b', 'c', and 'z' must also be human-readable.
     *
     * @return a string representation of the entire set, showing the underlying hash table structure
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        int i = 1;
        for (LinkedList<E> list : table) {
            output.append(i); // slot number
            output.append(" || ");
            for (E element : list) {
                output.append(element);
                output.append(" -> ");
            }

            output.delete(output.length() - 4, output.length()); // remove last extra " -> "
            output.append("\n"); // add newline
            i++;
        }

        return output.toString();
    }
}
