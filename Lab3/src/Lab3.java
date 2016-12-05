// Compile: javac -cp Lab3Help.jar Lab3.java
// Run:     java -cp Lab3Help.jar:. Lab3
import Lab3Help.*;
import java.util.*;
import java.io.*;

public class Lab3 {
    
    public static void main(String[] args) throws IOException {

        Lab3File fileReader = new Lab3File();
        List<BStop> nodeList = new ArrayList<BStop>();
        List<BLineTable> lineTable = new ArrayList<BLineTable>();
        try {
            nodeList = fileReader.readStops(args[0]);
            lineTable = fileReader.readLines(args[1]);
        } catch(MalformedData md) {
            System.out.println("MalformedData exception.");
        }
        String startNode = args[2];
        String stopNode = args[3];        

		DijkstraStringPath path = new DijkstraStringPath(nodeList, lineTable);
		path.computePath(startNode, stopNode);
		System.out.println(path.getPathLength());
		Iterator<String> itr = path.getPath();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}

		new GUI(nodeList, lineTable, new DijkstraStringPath(nodeList, lineTable));
        /*DEBUG: Print list of stop names
		  for(int i = 0; i < nodeList.size(); i++) {
		  System.out.println(nodeList.get(i).getName());
		  }
		*/

		
        
    }
    
}
