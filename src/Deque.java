
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mordred
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item> {

    private Node first, last;
    private int size;

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return first == null && last == null && size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // insert the item at the front
    public void addFirst(Item item) {
        if (item != null) {
            if (isEmpty()) {
                first = new Node(item);
                last = new Node(item);
                size++;
                print(last);
            } else {
                Node node = new Node(item);
                node.next = first;
                first.previous = node;
                first = node;
                size++;
                print(first);
            }
        } else {
            throw new NullPointerException();
        }
    }

    // insert the item at the end
    public void addLast(Item item) {
        if (item != null) {
            if (isEmpty()) {
                first = new Node(item);
                last = new Node(item);
                size++;
                print(first);
            } else {
                Node node = new Node(item);
                node.previous = last;
                last.next = node;
                last = node;
                size++;
                print(first);
            }
        } else {
            throw new NullPointerException();
        }
    }

    // delete and return the item at the front
    public Item removeFirst() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        first = first.next;

        if (first != null) {
            first.previous = null;
            size--;
            print(first);
            return first.item;
        } else {
            size = 0;
            return null;
        }

    }

    // delete and return the item at the end
    public Item removeLast() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        last = last.previous;

        if (last != null) {
            last.next = null;
            size--;
            print(first);
            return last.item;
        } else {
            size = 0;
            return null;
        }
    }

    // return an iterator over items in order from front to end
    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
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

    private class DequeIterator<Item> implements Iterator<Item> {

        private Node cursor;

        public DequeIterator() {
            cursor = first;
        }

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public Item next() {
            if (hasNext()) {
                Item item = (Item) cursor.item;
                cursor = cursor.next;
                return item;
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    private class Node {

        private Item item;
        private Node previous, next;

        public Node(Item item) {
            this.item = item;
            this.previous = null;
            this.next = null;
        }
    }

}
