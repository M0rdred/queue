/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mordred
 */
public class Subset {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();

        randomizedQueue.enqueue("0");
        randomizedQueue.enqueue("1");
        randomizedQueue.enqueue("2");
        randomizedQueue.enqueue("3");
        randomizedQueue.enqueue("4");
        randomizedQueue.enqueue("5");

        randomizedQueue.enqueue("a");
        randomizedQueue.enqueue("b");
        randomizedQueue.enqueue("c");
        randomizedQueue.enqueue("d");
        randomizedQueue.enqueue("e");

        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
    }
}
