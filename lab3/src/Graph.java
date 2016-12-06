import Lab3Help.*;
import java.util.*;

/**
 * The Graph class represents a graph with nodes and edges.
 * @author Carl Smedstad, Andreas Magnusson
 * @version 1.0 2016-12-05
 */
public class Graph<E> {

    private final Map<E, Node> nodeMap;

    /**
     * Constructor.
     * @param idArray an array of node ID:s
     * @param edgeArray an array of edge objects
     */
    @SuppressWarnings("unchecked")  
    public Graph(E[] idArray, Edge<E>[] edgeArray) {
        nodeMap = new HashMap<E, Node>(idArray.length);
        for(E id : idArray) {
            nodeMap.put(id, new Node(id));
        }
        for(Edge e : edgeArray) {
            if(!nodeMap.get(e.id1).isAdj((E)e.id2)) {
                nodeMap.get(e.id1).addAdj((E)e.id2, e.weight);
            }
            if(!nodeMap.get(e.id2).isAdj((E)e.id1)) {
                nodeMap.get(e.id2).addAdj((E)e.id1, e.weight);
            }
        }
    }

    /**
     * The size method returns the amout of nodes in the graph.
     * @return the amount of nodes in the graph
     */
    public int size() {
        return nodeMap.size();
    }

    /**
     * The getNeighbours method returns an array of the neighbour-node ID:s of the
     * node given in the input. 
     * @param id node ID
     * @return an array of the node ID:s of the neighbours
     */
    public E[] getNeighbours(E id) {
        return nodeMap.get(id).getAdj();
    }

    /**
     * The getWeight method returns the weight of the edge between the two given
     * nodes.
     * @param id1 node ID of first node
     * @param id2 node ID of second node
     * @return the weight of the edge between the nodes
     */
    public int getWeight(E id1, E id2) {
        return nodeMap.get(id1).getWeight(id2);
    }

    /**
     * The getIdArray method returns an array of node ID:s of all the nodes in the graph.
     * @return an array of node ID:s of all the nodes in the graph
     */
    @SuppressWarnings("unchecked")
    public E[] getIdArray() {
        Set<E> idSet = nodeMap.keySet();
        return (E[])idSet.toArray(new Object[idSet.size()]);
    }

    /**
     * The Node class is only used in the Graph class and stores an id and an adjacency list.
     */
    private class Node {
        
        private final E id;
        private final Map<E, Integer> adjMap = new HashMap<>();

        /**
         * Constructor.
         * @param id ID of the node
         */
        public Node(E id) {
            this.id = id;
        }

        /**
         * The addAdj method adds a node and a weight to the adjacency list.
         * @param id ID of the node to add
         * @param weight the weight of the edge
         */
        public void addAdj(E id, int weight) {
            if(this.id != id) {
                adjMap.put(id, weight);
            }
        }

        /**
         * The getAdj returns an array of the ID:s of all the neighbour nodes.
         * @return an arrau of all the neighbour node ID:s.
         */
        @SuppressWarnings("unchecked")
        public E[] getAdj() {
            Set<E> adjSet = adjMap.keySet();
            return (E[])adjSet.toArray(new Object[adjSet.size()]);
        }

        /**
         * The isAdj method checks if a node is in the adjacency list.
         * @param otherId the node to test
         * @return <code>true</code> if the node is in the adjacency list, <code>false</code>
         *         otherwise
         */
        public boolean isAdj(E otherId) {
            return adjMap.containsKey(otherId);
        }

        /**
         * The getWeight method returns the weight of the edge between this node and the
         * one given in the input. 
         * @param otherId the ID of the other node
         * @return the weight of the edge between the nodes
         */
        public int getWeight(E otherId) {
            return adjMap.get(otherId);
        }
        
    }
        
}
