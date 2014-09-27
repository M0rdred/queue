
import java.util.Iterator;

/*----------------------------------------------------------------
 *  Author:        Dániel Szabó
 *  Written:       24/Sept/2014
 *
 *  Compilation:   javac Subset.java
 *  Execution:     java Subset intParam
 *
 *  Reads in strings from StdIn and gives "intParam" number of them back
 *  in random order
 *----------------------------------------------------------------*/
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
