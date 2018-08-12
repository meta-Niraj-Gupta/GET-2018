package Graph;

/**
 * @author Niraj Gupta
 * Class to represent the edge which connects two node in a graph.
 *
 */
public class Edge{
	private Integer weight;
	private Integer from;
	private Integer to;

	/**
	 * Creates an edge from one node to another. Also assigns a weight to it.
	 * @param weight : Cost of traversing the node
	 * @param from : Index of node edge starts from
	 * @param to : Index of node edge ends to
	 */
	public Edge(Integer weight, Integer from, Integer to){
		this.weight = weight;
		this.from = from;
		this.to = to;
	}

	/**
	 * Generates information of the string containing all the attributes.
	 * @return  string containing edge information
	 */
	@Override
	public String toString(){
		return "Edge [weight=" + weight + ", from=" + from + ", to=" + to + "]";
	}

	// GETTERS AND SETTERS

	public Integer getWeight(){
		return weight;
	}

	public void setWeight(Integer weight){
		this.weight = weight;
	}

	public Integer getTo(){
		return to;
	}

	public void setTo(Integer to){
		this.to = to;
	}

	public Integer getFrom(){
		return from;
	}

	public void setFrom(Integer from){
		this.from = from;
	}	
}
