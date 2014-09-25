
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

        for (String string : Arrays.copyOfRange(args, 1, args.length)) {
            randomizedQueue.enqueue(string);
        }

        Iterator queueIt = randomizedQueue.iterator();

        while (queueIt.hasNext()) {
            if (printed >= k) {
                break;
            }
            System.out.println(queueIt.next());
            printed++;
        }
    }
}
