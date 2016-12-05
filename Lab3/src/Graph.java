import Lab3Help.*;
import java.util.*;

public class Graph<T> {

	private final Map<T, Node> nodeMap;
	private ArrayList<Node> nodeList;
	
	public Graph(T[] idArray, Edge[] edgeArray) {
		nodeMap = new HashMap<T, Node>(idArray.length);
		for(T id : idArray) {
			nodeMap.put(id, new Node(id));
			nodeList.add(nodeMap.get(id));
		}
		for(Edge e : edgeArray) {
			if(!nodeMap.get(e.v1).isAdj(e.v2)) {
				nodeMap.get(e.v1).addAdj(e.v2, e.weight);
			}
			if(!nodeMap.get(e.v2).isAdj(e.v1)) {
				nodeMap.get(e.v2).addAdj(e.v1, e.weight);
			}
		}
	}
	
	public int size() {
		return nodeMap.size();
	}

	public ArrayList<Node> getNodeList() {
		return nodeList;
	}

	public ArrayList<Node> getAdjacencyList(Node node) {
		ArrayList<Node> AdjancencyList;
		T[] idArray = node.getAdj();
		for(T  id : idArray) {
			AdjancencyList.add(nodeMap.get(id));
		}
		return AdjancencyList;
	}
	
	public T[] getNeighbours(T id) {
		Set<T> neighbourSet = nodeMap.get(id).getAdj();
		return neighbourSet.toArray(new T[neighbourSet.size()]);
	}

	public int getWeight(Node node1, Node node2) {
		return node1.getWeight(node2);
	}
	
	public int getWeight(T id1, T id2) {
		return nodeMap.get(id1).getWeight(id2);
	}

	public T[] getIdArray() {
		Set<T> idSet = nodeMap.keySet();
		return idSet.toArray(new T[idSet.size()]);
	}
	
}
