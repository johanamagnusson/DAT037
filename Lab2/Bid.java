public class Bid {

    private String name;
    private String op;
    private int value;
    private int oldValue;
    private int newValue;
    
    public void Bid(String name, String op, int value) {
        this.name = name;
        this.op = op;
        this.value = value;
    }
    
    public void Bid(String name, String op, int oldValue, int newValue) {
        this.name = name;
        this.op = op;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }
    
    public String getName(Bid b) {
        return name;
    }

    public String getOp(Bid b) {
        return op;
    }

    public int getValue(Bid b) {
        return value;
    }

    public int getOldValue(Bid b) {
        return oldValue;
    }

    public int getNewValue(Bid b) {
        return newValue;
    }
    
}
