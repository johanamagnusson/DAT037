import Lab3Help.*;
import java.util.*;

public class Graph<E> {

	private final Map<E, Node> graph;
	
	public Graph(E[] idArray, Edge<E>[] edgeArray) {
		graph = new HashMap<E, Node>(idArray.length);
		for(E id : idArray) {
			graph.put(id, new Node<E>(id));
		}
		for(Edge e : edgeArray) {
			if(!graph.get(e.id1).isAdj(e.id2)) {
				graph.get(e.id1).addAdj(e.id2, e.weight);
			}
			if(!graph.get(e.id2).isAdj(e.id1)) {
				graph.get(e.id2).addAdj(e.id1, e.weight);
			}
		}
	}
	
	public int size() {
		return graph.size();
	}

	public E[] getNeighbours(E id) {
		return (E[])graph.get(id).getAdj();
	}

	public int getWeight(E id1, E id2) {
		return graph.get(id1).getWeight(id2);
	}

	public E[] getIdArray() {
		Set<E> idSet = graph.keySet();
		return (E[])idSet.toArray(new Object[idSet.size()]);
	}

	private class Node<E> {
		
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
