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

        protected E getNode() {
            return this.node;
        }

        protected int getDistFromSource() {
            return this.distFromSource;
        }

        public int hashCode() {
            return node.hashCode();
        }

        @Override
        public boolean equals(final Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            final QueueNode other = (QueueNode) obj;
            if (this.node == null) {
                if (other.getNode() != null) {
                    return false;
                }
            } else if (!this.node.equals(other.getNode())) {
                return false;
            }
            return true;
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
		for(i=0; i<nodeList.size(); i++) {
			nodeNameArray[i] = nodeList(i).getName();
		}
        graph = new Graph(nodeNameArray, BLineTable);
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
