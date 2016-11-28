import Lab3Help.*;
import java.util.*;

public class Graph {

	private ArrayList<Node> nodeList;
	
    public Graph(String[] nodeNameArray, List<BLineTable> edgeTable) {
		
		for(int i=0; i<nodeNameArray.length; i++) {
			nodeList.add(new Node(nodeNameArray[i]));
		}

		for(int i=0; i<edgeTable.size(); i++) {
			BLineStop[] lineStops = edgeTable.get(i).getStops();
			for(int j=0; i<lineStops.length-1; i++) {
				getNode(lineStops[j].getName()).addAdjacency(getNode(lineStops[j+1].getName()),
															 lineStops[j+1].getTime());
			}
		}
	}
	
	private Node getNode(String name) {
		for(int i=0; i<nodeList.size(); i++) {
			if(name == nodeList.get(i).getName()) {
				return nodeList.get(i);
			}
		}
		return null;
	}

	private class Node {

		private String nodeName;
		private ArrayList<Node> adjList;
		private ArrayList<Integer> weightList;

		protected Node(String nodeName) {
			this.nodeName = nodeName;
		}
		
		protected void addAdjacency(Node other, int weight) {
			if(!(adjList.contains(other) && this == other)) {
				adjList.add(other);
				weightList.add(weight);
				other.addAdjacency(this, weight);
			} else {
				System.out.println("addAdjanceny: Invalid node.");
			}
		}

		protected String getName() {
			return nodeName;
		}

		protected boolean isAdjacent(Node other) {
			return adjList.contains(other);
		}

		protected int getWeight(Node other) {
			return weightList.get(getAdjIndex(other));
		}

		private int getAdjIndex(Node other) {
			return adjList.indexOf(other);
		}

	}

}
