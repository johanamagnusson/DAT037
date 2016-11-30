import java.util.*;

public class Node<T> {
	
	private final T id;
	private final Map<Node, Integer> adjMap = new HashMap<>();
	
	public Node(T id) {
		this.id = id;
	}

	public T getId() {
		return id;
	}

	public void addAdj(Node node, int weight) {
		adjMap.put(node, weight);
	}

	public T[] getAdj() {
		Set<T> adjSet = adjMap.keySet();
		return adjSet.toArray(new T[adjSet.size()]);
	}

	public boolean isAdj(T other) {
		return adjMap.containsKey(other);
	}

	public int getWeight(T other) {
		return adjMap.get(other);
	}
	
}

    /*
    public Map<Node, Integer> getAdjMap() {
        return adjMap;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj==null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		Node other = (Node) obj;
		if(this.id == null) {
			if(other.getId() != null) {
				return false;
			}
		} else if(!(this.id.equals(other.getId()))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return this.id.hashCode();
	}

	public void addAdjacency(Node other, int weight) {
		if(!(adjList.contains(other) && this == other)) {
			adjList.add(other);
			weightList.add(weight);
			other.addAdjacency(this, weight);
		} else {
			System.out.println("addAdjanceny: Invalid node.");
		}
	}
	*/
