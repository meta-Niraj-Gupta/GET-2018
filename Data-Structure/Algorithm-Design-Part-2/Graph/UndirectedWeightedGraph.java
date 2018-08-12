package Graph;

import java.util.List;

/**
 * @author Niraj Gupta
 * interface to implement the undirected weighted graph which can perform functions likes
 * finding if two edges are connected or not, to check if one edge is reachable from another,
 * to find the minimum spanning tree and to find the shortest path using Dijkstra’s algorithm.
 *
 */
public interface UndirectedWeightedGraph{

	/**
	 * Determines if all nodes are connected to each other.
	 * @return : true is graph is connected, false otherwise
	 */
	boolean isConnected();

	/**
	 * Determines the nodes reachable from the given node
	 * @param nodeIndex : Index of the node whose reachable nodes are to be found
	 * @return : List of nodes reachable
	 */
	List<Integer> reachable(Integer nodeIndex);

	/**
	 * Generates minimum spanning tree of a graph
	 * @return : UndirectedWeightedGraph containing only edges in the minimum spanning tree
	 */
	UndirectedWeightedGraph mst();

	/**
	 * Finds the shortest path from one node to another
	 * @param firstNodeIndex : Index of the starting node
	 * @param secondNodeIndex : Index of the ending node
	 * @return : List of nodes appearing in path in order
	 */
	List<Integer> shortestPath(Integer firstNodeIndex, Integer secondNodeIndex);
}
