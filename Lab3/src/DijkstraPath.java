import Lab3Help.*;
import java.util.*;

public class DijkstraPath implements Path {

    private ArrayList<E> path;
    private Graph graph;
    
    public DijkstraPath(List<BStop> nodeList, List<BLineTable> nodeLines) {
        path = new ArrayList<E>();
        graph = new Graph(nodeList, BLineTable);
    }

    public void computePath(E from, E to) {
        
        int[] d = new int[this.graph.getSize()];
        E[] p = (E[]) new Object[this.graph.getSize()];


    }

    public Iterator<E> getPath() {
        return path.iterator();
    }

    public int getPathLength() {
        
    }
    
}
