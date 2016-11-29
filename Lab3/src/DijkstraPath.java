import Lab3Help.*;
import java.util.*;

public class DijkstraPath<E> implements Path<E> {
    
    private class QueueNode {

        private E node;
        private int distFromSource;
        
        protected QueueNode(E node, int distFromSource) {
            this.node = node;
            this.distFromSource = distFromSource;
        }

        protected int getDistFromSource() {
            return this.distFromSource;
        }

        @Override
        public boolean equals(Object obj) {
            return this.node.equals(obj);
        }

        @Override
        public int hashCode() {
            return this.node.hashCode;
        }

    }

    private class QueueNodeComparator implements Comparator<QueueNode> {
        
        @Override
        public int compare(QueueNode item1, QueueNode item2) {
            if (item1.getDistFromSource() > item2.getDistFromSource()) {
                return 1;
            } else if (item1.getDistFromSource() == item2.getDistFromSource()) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    private ArrayList<E> path;
    private Graph graph;
    
    public DijkstraPath(List<BStop> nodeList, List<BLineTable> nodeLines) {
        path = new ArrayList<E>();
	    String[] nodeNameArray = new String[nodeList.size()-1];
		for(int i = 0;  i< nodeList.size(); i++) {
			nodeNameArray[i] = nodeList.get(i).getName();
		}
        graph = new Graph(nodeNameArray, nodeLines);
    }

    public void computePath(E from, E to) {
        
        int[] d = new int[this.graph.size()];
        E[] p = (E[]) new Object[this.graph.size()];
        int[] k = new int[this.graph.size()];
        PriorityQueue<QueueNode> q = new PriorityQueue<QueueNode>();

        for (int i = 0; i < this.graph.size(); i++) {
            d[i] = Integer.MAX_VALUE;
        }


    }

    public Iterator<E> getPath() {
        return path.iterator();
    }

    public int getPathLength() {
        
    }
    
}
