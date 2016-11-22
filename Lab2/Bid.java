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

    public int getHashCode() {
        int hash = 7;
        for(int i = 0; i < this.name.length(); i++) {
            hash = hash*31 + this.name.charAt(i);
        } // Found from
          // http://stackoverflow.com/questions/2624192/good-hash-function-for-strings
        return hash;
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
