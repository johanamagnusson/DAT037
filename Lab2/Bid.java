public class Bid {

    private String name;
    private String op;
    private int value;
    private int oldValue;

    public void Bid(String name, String op, int value) {
        this.name = name;
        this.op = op;
        this.value = value;
    }
    
    public void Bid(String name, String op, int oldValue, int newValue) {
        this.name = name;
        this.op = op;
        this.oldValue = oldValue;
        this.value = newValue;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
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
