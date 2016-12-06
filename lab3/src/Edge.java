/**
 * The Edge class represents a weighted edge in a graph.
 * @author Carl Smedstad, Andreas Magnusson
 * @version 1.0 2016-12-05
 */
public class Edge<E> {
    
    public final E id1, id2;
    public final int weight;

    /**
     * Constructor.
     * @param id1 ID of the first node
     * @param id2 ID of the second node
     * @param weight weight of the edge
     */
    public Edge(E id1, E id2, int weight) {
        this.id1 = id1;
        this.id2 = id2;
        this.weight = weight;
    }

    /**
     * Getter for the first node ID.
x    * @return the first node ID
     */
    public E getId1() {
        return id1;
    }

    /**
     * Getter for the first node ID.
     * @return the first node ID
     */
    public E getId2() {
        return id2;
    }
}
