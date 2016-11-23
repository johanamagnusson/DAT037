// Inspiration from: http://courses.cs.washington.edu/courses/cse373/11wi/homework/5/
import java.io.*;
import java.util.*;

/**
 * The PriorityQueue class generates, sorts and holds a binary heap. Provides 
 * functionality to peek, add, remove and replace elements aswell as to check if
 * the PriorityQueue is empty.
 *
 * @author Andreas Magnusson, Carl Smedstad
 * @version 1.0
 * @since 16-11-23
 */
public class PriorityQueue<E> {

    private ArrayList<E> a;
    private int size;
    private Comparator<? super E> comp;
    private HashMap<E, Integer> h;

    /**
     * Constructor. Constructs a priority queue from the ArrayList found in the input.
     *
     * @param inputArray array of unsorted objects
     * @param comp comparator used in sorting
     */
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

    /**
     * Constructor. Constructs an empty priority queue.
     *
     * @param comp comparator used the sorting
     */
    public PriorityQueue(Comparator<? super E> comp) {
        this.a = new ArrayList<E>();
        this.size = 0;
        this.comp = comp;
        this.h = new HashMap<E, Integer>();
    }

    /**
     * The buildHeap method sorts the ArrayList to form a binary heap.
     */
    private void buildHeap () {
        for (int i = size / 2; i > 0; i--) {
            bubbleDown(i);
        }
    }

    /**
     * The swap method swaps two elements in the priority queue.
     *
     * @param i1 index of the first element in the swap
     * @param i2 index of the second element in the swap
     */
    private void swap(int i1, int i2) {
        E tmp = a.get(i1);
        a.set(i1, a.get(i2));
        a.set(i2, tmp);
    }
    
    /**
     * The hasParent method checks if the element at the index has a parent.
     *
     * @param i index of element to check
     * @return <code>true</code> if the element at the index has a parent,
     *         <code>false</code> otherwise
     */
    private boolean hasParent(int i) {
        return i != 0;
    }

    /**
     * The hasLeftChild method checks if the element at the index has a left child.
     *
     * @param i index of element to check
     * @return <code>true</code> if the element at the index has a left child,
     *         <code>false</code> otherwise
     */
    private boolean hasLeftChild(int i) {
        return leftChildIndex(i) <= size - 1;
    }

    /**
     * The hasRightChild method checks if the element at the index has a right child.
     *
     * @param i index of element to check
     * @return <code>true</code> if the element at the index has a right child,
     *         <code>false</code> otherwise
     */
    private boolean hasRightChild(int i) {
        return rightChildIndex(i) <= size - 1;
    }

    /**
     * The leftChildIndex method finds the index of the left child.
     *
     * @param i index of element to check
     * @return index of left child in the binary heap
     */
    private int leftChildIndex(int i) {
        return 2 * i + 1;
    }

    /**
     * The rightChildIndex method finds the index of the right child.
     *
     * @param i index of element to check
     * @return index of right child in the binary heap
     */
    private int rightChildIndex(int i) {
        return 2 * i + 2;
    }

    /**
     * The bubbleUp method checks upwards if the element on the index is 
     * correctly placed. If not the element is moved up in the binary heap.
     *
     * @param startIndex the index to start the bubbling from
     */
    private void bubbleUp(int startIndex) {
        int index = startIndex;
        int parentIndex;
        while(hasParent(index)) {
            parentIndex = index / 2;
            if(comp.compare(a.get(index), a.get(parentIndex)) < 0) {
                swap(index, parentIndex);
                h.put(a.get(index), index);
                index = parentIndex;
            } else {
                break;
            }
        }
        h.put(a.get(index), index);
    }

    /**
     * The bubbleDown method checks downwards if the element on the index is 
     * correctly placed. If not the element is moved down in the binary heap.
     *
     * @param startIndex the index to start the bubbling from
     */
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
                index = smallestChild;
            } else {
                h.put(a.get(index), index);
                break;
            }
        }
        h.put(a.get(index), index);
    }
    
    /** 
     * Adds a value to the priority queue.
     *
     * @param element the element to be added
     */      
    public void add(E element) {
        a.add(element);
        size++;
        bubbleUp(size-1);
        // DEBUG: System.out.println(h.get(element));
    }

    /**
     * The findElementIndex method finds the index of a given element.
     *
     * @param element the element to be found
     * @return index of the found element
     */
    private int findElementIndex(E element) {
        int elementIndex = h.get(element);
        return elementIndex;
    }

    /**
     * The replace method finds and replaces an element with a new one.
     *
     * @param oldElement the element to be replaced
     * @param newElement the element to replace with
     */
    public void replace(E oldElement, E newElement) { 
        int oldIndex = findElementIndex(oldElement);
        // DEBUG: System.out.println("ArraySize: " + a.size());
        //        System.out.println("OldIndex: " + oldIndex);
        a.set(oldIndex, newElement);
        bubbleUp(oldIndex);
        bubbleDown(oldIndex);
    }

    /**
     * Tests if the priority queue is empty.
     *
     * @return <code>true</code> if the PriorityQueue is empty, 
     *         <code>false</code> otherwise
     */     
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Returns, but does not delete the element at the top of the priority
     * queue.
     *
     * @return the element at the top of the priority queue
     * @throws IllegalStateException if priority queue is empty
     */
    public E peek() {
        return a.get(0);
    }

    /**
     * Deletes and returns the element at the top of the priority queue.
     *
     * @return the element at the top of the priority queue
     * @throws IllegalStateException if priority queue is empty
     */       
    public E remove() {
        E tmp = a.get(0);
        h.remove(tmp);
        a.set(0, a.get(size-1));
        a.remove(size-1);
        size--;
        if (size != 0) {
            bubbleDown(0);
        }
        return tmp;
    }
    
}
