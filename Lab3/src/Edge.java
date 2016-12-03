public class Edge<E> {
	
	public final E id1, id2;
	public final int weight;
	
	public Edge(E id1, E id2, int weight) {
		this.id1 = id1;
		this.id2 = id2;
		this.weight = weight;
	}

	public E getId1() {
		return id1;
	}

	public E getId2() {
		return id2;
	}
}
