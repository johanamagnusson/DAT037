// Inspiration:
// http://courses.cs.washington.edu/courses/cse373/11wi/homework/5/

import java.io.*;
import java.util.*;


public class PriorityQueue<E> {

    private ArrayList<E> a;
    private int size;
    private Comparator<? super E> comp;
    private HashMap<E, Integer> h;
    
    public PriorityQueue(ArrayList<E> inputArray, Comparator<? super E> comp) {
        this.a = new ArrayList<E>();
        this.size = inputArray.size();
        this.comp = comp;
        this.h = new HashMap<E, Integer>();
        for (int i = 0; i <  size; i++) {
            a.add(i, inputArray.get(i));
        }
        buildHeap();
    }

    public PriorityQueue(Comparator<? super E> comp) {
        this.a = new ArrayList<E>();
        this.size = 0;
        this.comp = comp;
        this.h = new HashMap<E, Integer>();
    }

    private void buildHeap () {
        for (int i = size / 2; i > 0; i--) {
            bubbleDown(i);
        }
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
        h.put(a.get(index), index);
        int parentIndex;
        while(hasParent(index)) {
            parentIndex = index / 2;
            if(comp.compare(a.get(index), a.get(parentIndex)) < 0) {
                swap(index, parentIndex);
                h.put(a.get(index), index);
                h.put(a.get(parentIndex), parentIndex);
                index = parentIndex;
            } else {
                h.put(a.get(index), index);
                break;
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
                h.put(a.get(index), index);
                h.put(a.get(smallestChild), smallestChild);
                index = smallestChild;
            } else {
                h.put(a.get(index), index);
                break;
            }
        }
    }
    
    /** 
     * Adds a value to the priority queue.
     */      
    public void add(E element) {
        a.add(element);
        size++;
        bubbleUp(size-1);
        //System.out.println(h.get(element));
    }
    
    public int findElementIndex(E element) {
        /* DEBUG:
        for (E name: h.keySet()){  
            int key =name.hashCode();
            int value = h.get(name);
            System.out.println(key + " " + value + " " + h.get(element));
        } 
        System.out.println("findElementIndex: " + element.hashCode() +
                           " " + h.get(element));
        */
        int elementIndex = h.get(element);
        return elementIndex;
    }
    
    public void replace(E oldItem, E newItem) { 
        int oldIndex = findElementIndex(oldItem);
        a.set(oldIndex, newItem);
        bubbleUp(oldIndex);
        bubbleDown(oldIndex);
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
