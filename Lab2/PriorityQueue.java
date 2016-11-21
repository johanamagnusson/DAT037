// Inspiration:
// http://courses.cs.washington.edu/courses/cse373/11wi/homework/5/

import java.io.*;
import java.util.*;


public class PriorityQueue<E> {

    private ArrayList<E> a;
    private int size;
    private Comparator<? super E> comp;
    private HashMap h;
    
    public PriorityQueue(ArrayList<E> a, Comparator<? super E> comp) {
        this.a = a;
        this.size = a.size();
        this.comp = comp;
        this.h = new HashMap();
    }

    private int hashCode(String str) {
        int hash = 7;
        for(int i = 0; i < str.length(); i++) {
            hash = hash*31 + str.charAt(i);
        } // Found from
          // http://stackoverflow.com/questions/2624192/good-hash-function-for-strings
        return hash;
    }
    
    private void swap(int i1, int i2) {
        E tmp = a.get(i1);
        a.set(i1, a.get(i2));
        a.set(i2, tmp);
    }

    private boolean hasParent(int i) {
        return i != 0;
    }

    private boolean hasLeftChild(int i) {
        return leftChildIndex(i) <= size - 1;
    }

    private boolean hasRightChild(int i) {
        return rightChildIndex(i) <= size - 1;
    }

    private int leftChildIndex(int i) {
        return 2 * i + 1;
    }

    private int rightChildIndex(int i) {
        return 2 * i + 2;
    }
    
    private void bubbleUp(int startIndex) {
        int index = startIndex;
        int parentIndex;
        while(hasParent(index)) {
            parentIndex = index / 2;
            if(comp.compare(a.get(index), a.get(parentIndex)) > 0) {
                swap(index, parentIndex);
                index = parentIndex;
            }
        }
    }

    private void bubbleDown(int startIndex) {
        int index = startIndex;
        int smallestChild;
        int r;
        while(hasLeftChild(index)) {
            
            smallestChild = leftChildIndex(index);
            if (hasRightChild(index)) {
                r = rightChildIndex(index);
                if (comp.compare(a.get(smallestChild), a.get(r)) > 0) {
                    smallestChild = r;
                }
            }

            if (comp.compare(a.get(index), a.get(smallestChild)) > 0) {
                swap(index, smallestChild);
                index = smallestChild;
            }
        }
    }
    
    /** 
     * Adds a value to the priority queue.
     */      
    public void add(E value) {
        a.add(value);
        size++;
        int index = bubbleUp(size-1);
        h.put(hashCode(E.getName()), index);
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
    public E peek() {
        return a.get(0);
    }

    /**
     * Deletes and returns the element at the top of the priority queue.
     * @return the element at the top of the priority queue
     * @throws IllegalStateException if priority queue is empty
     */       
    public E remove() {
        E temp = a.get(0);
        a.set(0, a.get(size-1));
        a.remove(size-1);
        size--;
        bubbleDown(0);
        return temp;
    }
    
}
