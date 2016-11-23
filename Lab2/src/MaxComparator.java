import java.util.*;

/**
 * The MaxComparator class compares two Bid objects and returns a 1 if the
 * second one is greater than the first. If they are equal it returns 0 and -1 if
 * the second one is lesser than the first.
 *
 * @author Andreas Magnusson, Carl Smedstad
 * @version 1.0
 * @since 16-11-23
 */
public class MaxComparator implements Comparator<Bid> {

    /**
     * The compare method compares two Bid objects.
     *
     * @param item1 first Bid object to compare
     * @param item2 second Bid object to compare
     * @return 1 if the second object is greater than the first, -1 if it is lesser
     *         and 0 if they are equal
     */
    @Override
    public int compare(Bid item1, Bid item2) {
       if (item1.getValue() < item2.getValue()) {
           return 1;
       } else if (item1.getValue() == item2.getValue()) {
           return 0;
       } else {
           return -1;
       }
    }

}
