import java.util.*;
import Lab3Help.*;

public class DijkstraPath<E> implements Path<E> {
	
	private Map<E, QNode> qNodeMap = new HashMap<E, QNode>();
	private final Graph<E> graph;
	private E[] idArray;
	private ArrayList<E> path;
	private boolean pathExists = false;
	
	public DijkstraPath(Graph<E> graph) {
		this.graph = graph;
		idArray = graph.getIdArray();
	}
	
	public void computePath(E from, E to) {

		QNode sourceNode = new QNode(from, 0);		
		unvisitedQueue.add(sourceNode);
	    qNodeMap.put(from, sourceNode);
		for(int i=0; i<idArray.length; i++) {
			if(idArray[i] != from) {
				qNodeMap.put(idArray[i], new QNode(idArray[i], Integer.MAX_VALUE));
			}
		}
	    
		PriorityQueue<QNode> unvisitedQueue = new PriorityQueue<QNode>(new QNodeComp());
		HashSet<E> visitedNodes = new HashSet<E>();
		QNode current;
		QNode neighbour;
		int alt;
		unvisitedQueue.add(qNodeMap.get(from));
		while(!unvisitedQueue.isEmpty()) {
			current = unvisitedQueue.remove();
			if(visitedNodes.add(current.id)) {
				for(E neighbourId : (E[])graph.getNeighbours(current.id)) {				
					neighbour = qNodeMap.get(neighbourId);
					alt = current.distance + graph.getWeight(current.id, neighbour.id);
					if(alt < neighbour.distance && !visitedNodes.contains(neighbour)) {
						neighbour.distance = alt;
						neighbour.prevId = current.id;
						unvisitedQueue.add(neighbour);
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
	
	public Iterator<E> getPath() {
		if(pathExists) {
			return path.iterator();
		} else {
			return null;
		}
	}
	
	public int getPathLength() {
		if(pathExists) {
			return qNodeMap.get(path.get(0)).distance;
		} else {
			return Integer.MAX_VALUE;
		}
	}
	
	private class QNode {
		
		private final E id;
		private int distance;
		private E prevId;
		
		public QNode(E id, int distance) {
			this.id = id;
			this.distance = distance;
		}
		
	}

	private class QNodeComp implements Comparator<QNode> {
		
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
