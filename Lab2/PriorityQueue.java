// Inspiration:
// http://courses.cs.washington.edu/courses/cse373/11wi/homework/5/

public class PriorityQueue<E extends Comparable<? super E>> {

    private ArrayList<E> a;
    private int sign;
    private int size;
    
    public PriorityQueue(ArrayList<E> a, Comparator<? super E> comp, int sign) {
        this.a = a;
        this.sign = sign;
    }

    /*
    private ArrayList merge(ArrayList<E> a1, ArrayList<E> a2) {

        ArrayList<E> hLeft;
        ArrayList<E> hRight;
        
        if(a1.isEmpty()) {return a2;}
        else if(a2.isEmpty()) {return a1;}
        if(a1[0].compareTo(a2[0]) <= 0) {
            hLeft = a1; hRight = a2;
        } else {
            hLeft = a2; hRight = a1;
        }
        
    }
    */

    private int parentIndex(int i) {
        return i/2;
    }

    
    
    private void bubbleUp() {

        
        
    }

    private void bubbleDown() {

        
        
    }
    
    /** 
     * Adds a value to the priority queue.
     */      
    private void add(E) {
        
    }
    
    /**
     * Tests if the priority queue is empty.
     */     
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Returns, but does not delete the element at the top of the priority
     * queue.
     * @return the element at the top of the priority queue
     * @throws IllegalStateException if priority queue is empty
     */
    public T peek() {

    }

    /**
     * Deletes and returns the element at the top of the priority queue.
     * @return the element at the top of the priority queue
     * @throws IllegalStateException if priority queue is empty
     */       
    public T remove() {

    }
    
}
