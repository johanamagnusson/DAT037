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

		PriorityQueue<QNode> unvisitedQueue = new PriorityQueue<QNode>(new QNodeComp());

		QNode sourceNode = new QNode(from, 0);		
		unvisitedQueue.add(sourceNode);
	    qNodeMap.put(from, sourceNode);
		for(int i=0; i<idArray.length; i++) {
			if(idArray[i] != from) {
				qNodeMap.put(idArray[i], new QNode(idArray[i], Integer.MAX_VALUE));
				unvisitedQueue.add(qNodeMap.get(idArray[i]));
			}
		}
		
		QNode current;
		QNode neighbour;
		int alt;
		while(!unvisitedQueue.isEmpty()) {
			current = unvisitedQueue.remove();
			if(current.id == to) {
				pathExists = true;
				break;
			}
			for(E neighbourId : (E[])graph.getNeighbours(current.id)) {				
				neighbour = qNodeMap.get(neighbourId);
				alt = current.distance + graph.getWeight(current.id, neighbour.id);
				if(alt < neighbour.distance) {
					QNode tmp = new QNode(neighbour.id, neighbour.distance);
					neighbour.distance = alt;
					neighbour.prevId = current.id;
					unvisitedQueue.replace(tmp, neighbour);
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
