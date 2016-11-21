import java.util.*;


public class MinComparator implements Comparator<Bid> {

    @Override
    public int compare(Bid item1, Bid item2) {
       
       if (item1.getValue() > item2.getValue()) {
           return 1;
       } else if (item1.getValue() == item2.getValue()) {
           return 0;
       } else {
           return -1;
       }
    }

}
