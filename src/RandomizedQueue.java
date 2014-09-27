
import java.util.Iterator;
import java.util.NoSuchElementException;

/*----------------------------------------------------------------
 *  Author:        Dániel Szabó
 *  Written:       24/Sept/2014
 *
 *  Compilation:   javac RandomizedQueue.java
 *  Execution:     use through Subset class
 *
 *  randomized queue implementation with linked list
 *----------------------------------------------------------------*/
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Node last;  //most recently added node
    private int size;   //size of list

    // construct an empty randomized queue
    public RandomizedQueue() {
        this.last = null;
        this.size = 0;
    }

    // is the queue empty?
    public boolean isEmpty() {
        return last == null && size == 0;
    }

    // return the number of items on the queue
    public int size() {
        return size;

    }

    // add the item
    public void enqueue(Item item) {
        if (item != null) {
            Node node = new Node(item);
            node.next = last;
            last = node;
            size++;
        } else {
            throw new NullPointerException();
        }
    }

    // delete and return a random item
    public Item dequeue() {
        if (!isEmpty()) {
            throw new NoSuchElementException();
        }
        int random = StdRandom.uniform(size);
        Node randomNode = last;  //randomly chosen node
        Node bridgeNode = null;  //crosses the gap left by deleted node
        for (int i = 0; i < random; i++) {
            if (i == random - 1) {
                bridgeNode = randomNode;
            }
            randomNode = randomNode.next;
        }

        bridgeNode.next = randomNode.next;
        Item item = randomNode.item;    //item of randomly chosen node
        randomNode = null;
        size--;
        return item;
    }

    // return (but do not delete) a random item
    public Item sample() {
        if (!isEmpty()) {
            throw new NoSuchElementException();
        }
        int random = StdRandom.uniform(size);
        Node randomNode = last; //randomly chosen node
        for (int i = 0; i < random; i++) {

            randomNode = randomNode.next;
        }

        return randomNode.item;

    }

    // return an independent iterator over items in random order
    @Override
    public Iterator<Item> iterator() {
        return new RandomIterator<>();
    }

    // unit testing
    public static void main(String[] args) {

    }

    private class RandomIterator<Item> implements Iterator<Item> {

        private int cursor; //pointer used in iteratorArray
        private Node node;  //node to be dealt with
        private int[] iteratorArray;    //random order of node indexes

        public RandomIterator() {

            cursor = 0;
            node = last;
            iteratorArray = new int[size];

            for (int i = 0; i < size; i++) {
                iteratorArray[i] = i;
            }

            StdRandom.shuffle(iteratorArray);
        }

        @Override
        public boolean hasNext() {
            return cursor < iteratorArray.length;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            node = last;
            for (int i = 0; i < iteratorArray[cursor]; i++) {
                node = node.next;
            }
            cursor++;
            return (Item) node.item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    private class Node {

        private Item item;  //stored item
        private Node next;  //pointer to next element

        public Node(Item item) {
            this.item = item;
            this.next = null;
        }
    }

}
