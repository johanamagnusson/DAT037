import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.lang.Integer.*;

/**
 * The Lab2 class reads a text file or command line input to get a list of
 * stockmarket bids. It then matches these bids with eachother and performs trades.
 * Lastly it prints which trades has been performed and which bids are left in the
 * orderbook.
 *
 * @author Andreas Magnusson, Carl Smedstad
 * @version 1.0
 * @since 16-11-23
 */
public class Lab2 {

    /**
     * The trade method iterates through all bids and sorts them into four categories 
     * (buy, sell, new buy price and new sell price). In the iteration each bid is
     * checked if it can be traded right away with a previously iterated bid, if not
     * the bid is saved in a PriorityQueue.
     * 
     * @param bids list of bids to trade
     */
    public static void trade(List<Bid> bids) {
        
        PriorityQueue<Bid> sellQueue = new PriorityQueue<Bid>(new MinComparator());
        PriorityQueue<Bid> buyQueue = new PriorityQueue<Bid>(new MaxComparator());
        int size = bids.size();
        
        for(int i = 0; i < size; i++) {
            Bid tmpBid = bids.get(i);
            switch (tmpBid.getOp()) {
            case "S":
                if(!buyQueue.isEmpty()) {
                    if(buyQueue.peek().getValue() >= tmpBid.getValue()) {
                        System.out.println(buyQueue.peek().getName() + " köper från " +
                                           tmpBid.getName() + " för " +
                                           buyQueue.remove().getValue() + " kr");
                    } else {
                        sellQueue.add(tmpBid);
                    }
                } else {
                    sellQueue.add(tmpBid);
                    // DEBUG: System.out.println("Added: " + tmpBid.getValue());
                }
                break;
            case "K":
                if(!sellQueue.isEmpty()) {
                    if(sellQueue.peek().getValue() <= tmpBid.getValue()) {
                        System.out.println(tmpBid.getName() + " köper från " +
                                           sellQueue.remove().getName() + " för " +
                                           tmpBid.getValue() + " kr");
                    } else {
                        buyQueue.add(tmpBid);
                    }
                } else {
                    buyQueue.add(tmpBid);
                }
                break;
            case "NS":
                sellQueue.replace(tmpBid, tmpBid);
                if(!buyQueue.isEmpty()) {
                    if(buyQueue.peek().getValue() >= tmpBid.getValue()) {
                        System.out.println(buyQueue.peek().getName() + " köper från " +
                                           sellQueue.remove().getName() + " för " +
                                           buyQueue.remove().getValue() + " kr");
                    }
                }
                break;
            case "NK":
                // DEBUG: System.out.println(tmpBid.getName() + " " +
                //        buyQueue.peek().getName() + " " + tmpBid.hashCode() + " " +
                //        buyQueue.peek().hashCode());
                buyQueue.replace(tmpBid, tmpBid);
                if(!sellQueue.isEmpty()) {
                    if(sellQueue.peek().getValue() <= tmpBid.getValue()) {
                        System.out.println(tmpBid.getName() + " köper från " +
                                           sellQueue.remove().getName() + " för " +
                                           buyQueue.remove().getValue() + " kr");
                    }
                }
                break;
            default: break;
            }
            // DEBUG: printOrderBook(buyQueue, sellQueue);
        }
        printOrderBook(buyQueue, sellQueue);
    }

    /**
     * The printOrderBook method recieves two PriorityQueues and prints an orderbook
     * consisting of buy and sell bids.
     *
     * @param buyQueue a PriorityQueue of buy bids
     * @param sellQueue a PriorityQueue of sell bids
     */
    public static void printOrderBook(PriorityQueue<Bid> buyQueue,
                                      PriorityQueue<Bid> sellQueue) {
        System.out.println("Orderbok:");
        String sellStr = "Säljare:";
        String buyStr = "Köpare:";
        while(!sellQueue.isEmpty()) {
            sellStr = sellStr + " " + sellQueue.peek().getName() + " " +
                sellQueue.remove().getValue();
            if(!sellQueue.isEmpty()) {
                sellStr = sellStr + ",";
            }
        }
        while(!buyQueue.isEmpty()) {
            buyStr = buyStr + " " + buyQueue.peek().getName() + " " +
                buyQueue.remove().getValue();
            if(!buyQueue.isEmpty()) {
                buyStr = buyStr + ",";
            }
        }
        System.out.println(sellStr);
        System.out.println(buyStr);
    }
    
    /**
     * Parses a bid.
     *
     * @param s the string that should be parsed
     * @return a bid object
     * @throws MalformedBid if the bid cannot be parsed
     */
    public static Bid parseBid(String s) throws MalformedBid {
        Matcher m = Pattern.compile(
                      "\\s*(\\S+)\\s+" +
                      "(?:(K|S)\\s+(\\d+)|(NS|NK)\\s+(\\d+)\\s+(\\d+))" +
                      "\\s*").matcher(s);

        if (m.matches()) {
            if (m.group(2) == null) {
                String name = m.group(1); // The name of the buyer/seller.
                String op = m.group(4); // NK or NS.
                int oldValue = Integer.parseInt(m.group(5)); // Old value.
                int newValue = Integer.parseInt(m.group(6)); // New value.
                return new Bid(name, op, oldValue, newValue);
            } else {
                String name =  m.group(1); // The name of the buyer/seller.
                String op =  m.group(2); // K or S.
                int value = Integer.parseInt(m.group(3)); // The value.
                return new Bid(name, op, value);
            }
        } else {
            throw new MalformedBid(s);
        }
    }

    /**
     * Parses line-separated bids from the given Readable thing.
     *
     * @param input the character stream that should be parsed
     * @return a list of bid objects
     * @throws MalformedBid if some bid couldn't be parsed
     */
    public static List<Bid> parseBids(Readable input) throws MalformedBid {
        ArrayList<Bid> bids = new ArrayList<Bid>();
        Scanner s = new Scanner(input);

        while (s.hasNextLine()) {
            bids.add(parseBid(s.nextLine()));
        }

        return bids;
    }

    /**
     * Exception class for malformed bids.
     */
    public static class MalformedBid extends Exception {
        MalformedBid(String bid) {
            super("Malformed bid: " + bid + ".");
        }
    }

    /**
     * Prints usage info.
     */
    public static void usageInfo() {
        System.err.println("Usage: java Aktiehandel [<file>]");
        System.err.println("If no file is given, then input is " +
                           "read from standard input.");
    }

    /**
     * Main function. Reads a text file or command line input to get a list of bids and
     * perform and print trades.
     *
     * @param args argument that has to be a path to a text file
     */
    public static void main(String[] args) {
        if (args.length >= 2) {
            usageInfo();
        } else {
            try {
                BufferedReader r;
                if (args.length == 0) {
                    // Read from stdin.
                    r = new BufferedReader(new InputStreamReader(System.in));
                } else {
                    // Read from a named file.
                    r = new BufferedReader(new FileReader(args[0]));
                }

                try {
                    List<Bid> bids = parseBids(r);
                    trade(bids);
                } finally {
                    r.close();
                }
            } catch (MalformedBid e) {
                System.err.println(e.getMessage());
                usageInfo();
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + args[0] + ".");
                usageInfo();
            } catch (IOException e) {
                System.err.println(e.getMessage());
                usageInfo();
            }
        }
    }
}
