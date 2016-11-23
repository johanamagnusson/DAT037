/**
 * The Bid class represents a stock market bid with a trader name, an operation and
 * a price. It can also represents a change of an already existing bid, in which case
 * it has an old and a new price.
 *
 * @author Andreas Magnusson, Carl Smedstad
 * @version 1.0
 * @since 16-11-23
 */
public class Bid {

    private String name;
    private String op;
    private int value;
    private int oldValue;

    /**
     * Constructor.
     *
     * @param name the name of the trader
     * @param op code for the operation (either K for buy or S for sell)
     * @param value the price
     */
    public Bid(String name, String op, int value) {
        this.name = name;
        this.op = op;
        this.value = value;
    }

    /**
     * Constructor.
     *
     * @param name the name of the trader
     * @param op code for the operation (either NK for new buy price or NS 
     *           for new sell price)
     * @param oldValue the price of the old Bid object
     * @param newValue the new price
     */
    public Bid(String name, String op, int oldValue, int newValue) {
        this.name = name;
        this.op = op;
        this.oldValue = oldValue;
        this.value = newValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Bid other = (Bid) obj;
        if (this.name == null) {
            if (other.getName() != null) {
                return false;
            }
        } else if (!this.name.equals(other.getName())) {
            return false;
        }
        return true;
    }

    /**
     * Getter for the name. 
     *
     * @return name of the Bid object
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the opertation. 
     *
     * @return operation of the Bid object
     */
    public String getOp() {
        return op;
    }

    /**
     * Getter for the price or the old price denpending on the type of Bid object.
     *
     * @return price of the Bid object or the 
     */
    public int getValue() {
        return value;
    }

    /**
     * Getter for the price or the new price of Bid object.
     *
     * @return new price of the Bid object 
     */
    public int getOldValue() {
        return oldValue;
    }
    
}
