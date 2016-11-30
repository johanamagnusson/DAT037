import java.util.*;

public class Dijkstra<T> {

	private class QNode {
		
		private final T id;
		private final int distance;
		private T prevId;
		
		public QNode(T id, int distance) {
			this.id = id;
			this.distance = distance;
		}

		public T getId() {
			return id;
		}

		public void setDist(int distance) {
			this.distance = distance;
		}
		
		public int getDist() {
			return distance;
		}

		public void setPrev(T id) {
			this.prevId = id;
		}

		public T getPrev() {
			return prevId;
		}
		
	}

	private class QNodeComp implements Comparator<QNode> {
		
        @Override
        public int compare(QNode item1, QNode item2) {
            if (item1.getDist() > item2.getDist()) {
                return 1;
            } else if (item1.getDist() == item2.getDist()) {
                return 0;
            } else {
                return -1;
            }
        }
    }
	
	public DijkstrasAlgorithm(Graph graph, T source) {
		
		private T[] idArray = graph.getIdArray();
		private Map<T, QNode> qNodeMap = new HashMap<T, QNode>();
		private PriorityQueue<QNode> unvisitedQueue = new PriorityQueue<QNode>(new QNodeComp);

		private QNode sourceNode = new QNode(source, 0);
		unvisitedQueue.add(sourceNode);
	    qNodeMap.put(source, sourceNode);
		
		for(int i=0; i<idArray.length; i++) {
			if(idArray[i] != source) {
				QNode tmp = new QNode(idArray[i], Integer.MAX_DIST);
				unvisitedQueue.add(tmp);
				qNodeMap.put(idArray[i], tmp);
			}
		}
		
		private QNode current;
		private QNode neighbour;
		private int alt;
		while(!unvisitedQueue.isEmpty()) {

			current = unvisitedQueue.remove();
			
			for(T neighbourId : graph.getNeighbours(current.getId())) {

				neighbour = qNodeMap.get(neigbourId);
				alt = current.getDist() + graph.getWeight(current.getName(), neighbour);

				if(alt < neighbour.getDist()) {
					QNode tmp = new QNode(neighbour.getId(), neighbour.get);
					neighbour.setDist(alt);
					neighbour.setPrev(current.getId);
					unvisitedQueue.replace(tmp, neighbour);
				}

			}
		}
		
	}
	
}
