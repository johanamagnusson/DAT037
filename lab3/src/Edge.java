/**
 * The Edge class represents a weighted edge in a graph.
 * @author Carl Smedstad, Andreas Magnusson
 * @version 1.0 2016-12-05
 */
public class Edge<E> {

    public final E fromId, toId;
    public final int weight;

    /**
     * Constructor.
     * @param fromId ID of the first node
     * @param toId ID of the second node
     * @param weight weight of the edge
     */
    public Edge(E fromId, E toId, int weight) {
        this.fromId = fromId;
        this.toId = toId;
        this.weight = weight;
    }

    /**
     * Getter for the first node ID.
x    * @return the first node ID
     */
    public E getFromId() {
        return fromId;
    }

    /**
     * Getter for the first node ID.
     * @return the first node ID
     */
    public E getToId() {
        return toId;
    }
}
