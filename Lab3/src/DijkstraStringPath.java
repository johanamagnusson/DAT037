import Lab3Help.*;
import java.util.*;
import java.io.*;

public class DijkstraStringPath implements Path<String> {

    private DijkstraPath<String> dPath;

    public DijkstraStringPath(List<BStop> nodeList, List<BLineTable> nodeLines) {
        this.dPath = new DijkstraPath<String>(nodeList, nodeLines);
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

