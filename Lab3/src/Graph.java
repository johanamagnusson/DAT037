import Lab3Help.*;
import java.util.*;

public class Graph<E> {

	private final Map<E, Node> nodeMap;

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
	
	public int size() {
		return nodeMap.size();
	}

	public E[] getNeighbours(E id) {
		return nodeMap.get(id).getAdj();
	}

	public int getWeight(E id1, E id2) {
		return nodeMap.get(id1).getWeight(id2);
	}

	@SuppressWarnings("unchecked")
	public E[] getIdArray() {
		Set<E> idSet = nodeMap.keySet();
		return (E[])idSet.toArray(new Object[idSet.size()]);
	}

	private class Node {
		
		private final E id;
		private final Map<E, Integer> adjMap = new HashMap<>();
	
		public Node(E id) {
			this.id = id;
		}

		public void addAdj(E id, int weight) {
			if(this.id != id) {
				adjMap.put(id, weight);
			}
		}

		@SuppressWarnings("unchecked")
		public E[] getAdj() {
			Set<E> adjSet = adjMap.keySet();
			return (E[])adjSet.toArray(new Object[adjSet.size()]);
		}
		
		public boolean isAdj(E other) {
			return adjMap.containsKey(other);
		}
		
		public int getWeight(E other) {
			return adjMap.get(other);
		}
		
	}
		
}
