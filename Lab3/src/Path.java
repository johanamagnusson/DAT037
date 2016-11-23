import java.util.*;

public interface Path<E> {

    public void computePath(E from, E to);

    public Iterator<E> getPath();

    public int getPathLength();
    
}
