import java.util.*;
import Lab3Help.*;

/**
 * The DijkstraPath class is used to perform the Dijkstra algorithm to compute the shortest
 * path between two nodes in a given graph.
 * @author Carl Smedstad, Andreas Magnusson
 * @version 1.0 2016-12-05
 */
public class DijkstraPath<E> implements Path<E> {
    
    private Map<E, QNode> qNodeMap = new HashMap<E, QNode>();
    private final Graph<E> graph;
    private E[] idArray;
    private ArrayList<E> path = new ArrayList<E>();
    private boolean pathExists = false;

    /**
     * Constructor.
     * @param graph graph that the algorithm will be performed on
     */
    public DijkstraPath(Graph<E> graph) {
        this.graph = graph;
        idArray = graph.getIdArray();
    }

    /**
     * The computePath method preforms the Dijkstra algorithm between the nodes 
     * given in the input.
     * @param from starting node
     * @param to target node
     */
    public void computePath(E from, E to) {

        PriorityQueue<QNode> unvisitedQueue = new PriorityQueue<QNode>(new QNodeComp());
        for(int i=0; i<idArray.length; i++) {
            if(idArray[i] != from) {
                qNodeMap.put(idArray[i], new QNode(idArray[i], Integer.MAX_VALUE));
            }
        }
        QNode sourceNode = new QNode(from, 0);      
        unvisitedQueue.add(sourceNode);
        qNodeMap.put(from, sourceNode);
        //DEBUG: Prints sourceNode id and distance
        //System.out.println(unvisitedQueue.peek().id + " " + unvisitedQueue.peek().distance);
        
        HashSet<E> visitedNodes = new HashSet<E>();
        QNode current;
        QNode neighbour;
        int alt;
        while(!unvisitedQueue.isEmpty()) {
            current = unvisitedQueue.remove();
            if(current.id.equals(to)) {
                pathExists = true;
                //DEBUG: Prints to id if pathExists is changed
                //System.out.println(current.id);
            }
            if(visitedNodes.add(current.id)) {
                for(E neighbourId : (E[])graph.getNeighbours(current.id)) {
                    neighbour = qNodeMap.get(neighbourId);
                    alt = current.distance + graph.getWeight(current.id, neighbour.id);
                    if(alt < neighbour.distance && !visitedNodes.contains(neighbour)) {
                        neighbour.distance = alt;
                        neighbour.prevId = current.id;
                        unvisitedQueue.add(neighbour);
                        //DEBUG: Prints current and neighbour id:s if distance is compared
                        //System.out.println(current.id + " : " + neighbourId);
                    }       
                }
            }
        }
        E tmp = to;
        path.add(to);
        if(pathExists) {
            while(tmp != from) {
                path.add(qNodeMap.get(tmp).prevId);
                tmp = qNodeMap.get(tmp).prevId;
            }
        }
        Collections.reverse(path);
    }

    /**
     * The getPath method returns an iterator of the path computed.
     * @return iterator of path computed, <code>null</code> if no path exists
     */
    public Iterator<E> getPath() {
        if(pathExists) {
            return path.iterator();
        } else {
            return null;
        }
    }

    /**
     * The getPathLength method returns the length of the calculated path.
     * @return length of path, <code>MAX_VALUE</code> if no path exists
     */
    public int getPathLength() {
        if(pathExists) {
            return qNodeMap.get(path.get(path.size()-1)).distance;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    /**
     * The QNode class is only used in DijkstraPath and stores a node ID, a distance to
     * the starting node and the ID of the neighbour closests to the source.
     */
    private class QNode {
        
        private final E id;
        private int distance;
        private E prevId;

        /**
         * Constructor.
         * @param id ID of node
         * @param distance distance to starting node
         */
        public QNode(E id, int distance) {
            this.id = id;
            this.distance = distance;
        }
        
    }

    /**
     * The QNodeComp is a comperator for the QNode class.
     */
    private class QNodeComp implements Comparator<QNode> {

        /**
         * {@inheritDoc}
         */
        @Override
        public int compare(QNode node1, QNode node2) {
            if (node1.distance > node2.distance) {
                return 1;
            } else if (node1.distance == node2.distance) {
                return 0;
            } else {
                return -1;
            }
        }
    }
    
}
