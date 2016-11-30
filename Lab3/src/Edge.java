public class Edge<T> {
	
	public final T id1, id2;
	public final int weight;
	
	public Edge(T id1, T id2, int weight) {
		this.id1 = id1;
		this.id2 = id2;
		this.weight = weight;
	}
	
}
