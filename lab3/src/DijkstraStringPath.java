import Lab3Help.*;
import java.util.*;

/**
 * The DijkstraStringPath is a wrapper class for the generic DijkstraPath class that
 * to is of the type String.
 * @author Carl Smedstad, Andreas Magnusson
 * @version 1.0 2016-12-05
 */
public class DijkstraStringPath implements Path<String> {

    private DijkstraPath<String> dPath;
    private Graph<String> graph;

    /**
     * Constructor.
     * @param nodeList a list of BStop objects
     * @param lineTable a list of BLineTable objects
     */
    @SuppressWarnings("unchecked")
    public DijkstraStringPath(List<BStop> stopList, List<BLineTable> lineTableList) {
        ArrayList<String> nodeList = new ArrayList<String>(stopList.size());
        for(BStop stop : stopList) {
            nodeList.add(stop.getName());
        }
        ArrayList<Edge<String>> edgeList = new ArrayList<Edge<String>>();
        ArrayList<BLineStop> tmpBLineStops;
        for(BLineTable lineTable : lineTableList) {
            tmpBLineStops = new ArrayList<BLineStop>(Arrays.asList(lineTable.getStops()));
            for(int i=0; i < tmpBLineStops.size()-1; i++) {
                edgeList.add(new Edge<String>(tmpBLineStops.get(i).getName(),
                                       tmpBLineStops.get(i+1).getName(),
                                       tmpBLineStops.get(i+1).getTime()));
            }
        }
        graph = new Graph<String>(nodeList, edgeList);
        this.dPath = new DijkstraPath<String>(graph);
    }

    /**
     * The computePath method calls the computePath method in DijkstraPath to calculate
     * the shortest path between the nodes given in the input.
     * @param from starting node
     * @param to target node
     */
    public void computePath(String from, String to) {
        this.dPath.computePath(from, to);
    }

    /**
     * The getPath method uses the getPath method in DijkstraPath to get an iterator of
     * the path.
     * @return an iterator of the path
     */
    public Iterator<String> getPath() {
        return this.dPath.getPath();
    }

    /**
     * The getPathLength method uses the getPathLength method in DijkstraPath to return
     * the length of the shortest path.
     * @return the length of the path
     */
    public int getPathLength() {
        return this.dPath.getPathLength();
    }
}
