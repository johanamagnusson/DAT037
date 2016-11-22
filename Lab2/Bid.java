public class Bid {

    private String name;
    private String op;
    private int value;
    private int oldValue;

    public Bid(String name, String op, int value) {
        this.name = name;
        this.op = op;
        this.value = value;
    }
    
    public Bid(String name, String op, int oldValue, int newValue) {
        this.name = name;
        this.op = op;
        this.oldValue = oldValue;
        this.value = newValue;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

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
    
    public String getName() {
        return name;
    }

    public String getOp() {
        return op;
    }

    public int getValue() {
        return value;
    }

    public int getOldValue() {
        return oldValue;
    }
    
}
