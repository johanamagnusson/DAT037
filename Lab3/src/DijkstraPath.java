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

        @Override
        public boolean equals(Object obj) {
            return this.node.equals(obj);
        }

        @Override
        public int hashCode() {
            return this.node.hashCode();
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
		ArrayList<Edge> edgeList;
		BLineStop[] tmpBLineStops;
		for(i=0; i < nodeLines.size(); i++) {
			tmpBLineStops = nodeLines.get(i).getStops();
			for(j=0; j < tmpBlineStops.length-1; j++) {
				edgeArray.add(new Edge(tmpBLineStops[j].getName(),
									   tmpBLineStops[j+1].getName(),
									   tmpBLineStops[j+1].getTime()));
			}
		}
		graph = new Graph(nodeNameArray, edgeList.toArray());
    }

    public void computePath(E from, E to) {
        
        HashMap<E, Integer> d = new HashMap<E, Integer>();
        HashMap<E, E> p = new HashMap<E, E>();
        HashSet<E> k = new HashSet<E>();
        PriorityQueue<QueueNode> q = new PriorityQueue<QueueNode>(new QueueNodeComparator());

        for (int i = 0; i < this.graph.size(); i++) {
            d.put(graph.getIdArray()[i], Integer.MAX_VALUE);
        }
        
        d.put(from, 0);
        q.add(new QueueNode(from, 0));
        
        QueueNode v;
        ArrayList<E> adj;
        while (!q.isEmpty()) {
            v = q.remove();
            if (k.add(v.getNode())) {
                adj = graph.getNeighbours(v.getNode());
                for (int i = 0; i < adj.size(); i++) {
                    if (!k.contains(adj.get(i)) && d.get(adj.get(i)) > d.get(v.getNode()) + graph.getWeight(v.getNode(), adj.get(i))) {
                        d.put(adj.get(i), d.get(v.getNode()) + graph.getWeight(v.getNode(), adj.get(i)));
                        p.put(adj.get(i), v.getNode());
                        q.add(new QueueNode(adj.get(i), d.get(adj.get(i))));
                    }
                }

            }
            
        } // End of while

        E u = from;
        while (p.containsValue(u)) {
            this.path.add(u);
            u = p.get(from);
        this.path.add(u);
        }
        Collections.reverse(this.path);
        
    }

    public Iterator<E> getPath() {
        return this.path.iterator();
    }

    public int getPathLength() {
        return this.path.size();
    }
    
}
