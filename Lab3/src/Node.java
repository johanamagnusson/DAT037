public class Node {
	
	private String nodeName;
	private ArrayList<Node> adjList;
	private ArrayList<Integer> weightList;
	
	public Node(String nodeName) {
		this.nodeName = nodeName;
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
	
	public String getName() {
		return nodeName;
	}
	
	public boolean isAdjacent(Node other) {
		return adjList.contains(other);
	}
	
	public int getWeight(Node other) {
		return weightList.get(getAdjIndex(other));
	}
	
	private int getAdjIndex(Node other) {
		return adjList.indexOf(other);
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
		if(this.name == null) {
			if(other.getName() != null) {
				return false;
			}
		} else if(!(this.name.equals(other.getName()))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	
	@Override
	public String toString() {
		return name;
	}
}
