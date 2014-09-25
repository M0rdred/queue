
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mordred
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Node last;
    private int size;

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
            print(last);
        }
    }

    // delete and return a random item
    public Item dequeue() {
        int random = StdRandom.uniform(size);
        Node randomNode = last;
        Node bridgeNode = null;
        for (int i = 0; i < random; i++) {
            if (i == random - 1) {
                bridgeNode = randomNode;
            }
            randomNode = randomNode.next;
        }

        bridgeNode.next = randomNode.next;
        Item item = randomNode.item;
        randomNode = null;
        size--;
        System.out.println("Returned: " + item);
        print(last);
        return item;
    }

    // return (but do not delete) a random item
    public Item sample() {
        int random = StdRandom.uniform(size);
        Node randomNode = last;
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

    private void print(Node node) {
        System.out.print(node.item + " ");
        if (node.next != null) {
            print(node.next);
        } else {
            System.out.println("");
        }
    }

    private class RandomIterator<Item> implements Iterator<Item> {

        private Map<Double, Node> randomMap = new TreeMap<Double, Node>();
        private Node node, cursor;
        private Queue<Node> iteratorQueue;

        public RandomIterator() {

            node = last;

            for (int i = 0; i < size; i++) {
                randomMap.put(StdRandom.uniform(), node);
                node = node.next;
            }

            for (Node n : randomMap.values()) {
                try {
                    iteratorQueue.enqueue(n);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            cursor = iteratorQueue.dequeue();
        }

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public Item next() {
            Item item = (Item) cursor.item;
            cursor = cursor.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private class Node {

        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;
            this.next = null;
        }
    }

}
