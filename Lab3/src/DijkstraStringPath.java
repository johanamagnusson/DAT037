import Lab3Help.*;
import java.util.*;

public class DijkstraStringPath implements Path<String> {

	private DijkstraPath<String> dPath;
	private Graph<String> graph;
	
	public DijkstraStringPath(List<BStop> nodeList, List<BLineTable> lineTable) {
		String[] nodeNameArray = new String[nodeList.size()];
		for(int i = 0; i<nodeList.size(); i++) {
			nodeNameArray[i] = nodeList.get(i).getName();
		}
		ArrayList<Edge> edgeList = new ArrayList<Edge>();
		BLineStop[] tmpBLineStops;
		for(int i=0; i < lineTable.size(); i++) {
			tmpBLineStops = lineTable.get(i).getStops();
			for(int j=0; j < tmpBLineStops.length-1; j++) {
				edgeList.add(new Edge<String>(tmpBLineStops[j].getName(),
									   tmpBLineStops[j+1].getName(),
									   tmpBLineStops[j+1].getTime()));
			}
		}
	    graph = new Graph<String>(nodeNameArray, edgeList.toArray(new Edge[edgeList.size()]));
		this.dPath = new DijkstraPath<String>(graph);
	}

	public void computePath(String from, String to) {
		this.dPath.computePath(from, to);
	}

	public Iterator<String> getPath() {
		return this.dPath.getPath();
	}

	public int getPathLength() {
		return this.dPath.getPathLength();
	}
}
