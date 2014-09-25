
import java.util.Arrays;
import java.util.Iterator;

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
        int k = Integer.parseInt(args[0]);
        int printed = 0;

       while (!StdIn.isEmpty()) {
            randomizedQueue.enqueue(StdIn.readString());
        }

        Iterator queueIt = randomizedQueue.iterator();

        while (queueIt.hasNext()) {
            if (k <= printed) {
                break;
            }
            System.out.println(queueIt.next());
            printed++;
        }
    }
}
