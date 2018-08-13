package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class GraphUsingList implements UndirectedWeightedGraph{
	private List<List<Edge>> edgeList;
	private int size;

	/**
	 * Parameterized Constructor : To creates an UndirectedWeightedGraph, having number of nodes 
	 * 								as given in parameters 
	 * @param numberOfNodes : Order of the graph
	 */
	public GraphUsingList(Integer numberOfNodes){
		edgeList = new ArrayList<>(numberOfNodes);
		for(int index = 0; index < numberOfNodes; index++)
			edgeList.add(new LinkedList<>());
	}

	/**
	 * Parameterized Constructor : To creates an UndirectedWeightedGraph, having number of nodes 
	 * 								as given in parameters and adds
	 * given edges in the graph. 
	 * @param numberOfNodes : Number of nodes in graph
	 * @param edgesInGraph : List of edges in graph
	 */
	public GraphUsingList(Integer numberOfNodes, List<Edge> edgesInGraph){
		this(numberOfNodes);
		// Adds the edges to their respective edgeList 
		for(Edge edge: edgesInGraph){
			edgeList.get(edge.getFrom()).add(new Edge(edge.getWeight(), edge.getFrom(), edge.getTo()));
			edgeList.get(edge.getTo()).add(new Edge(edge.getWeight(), edge.getTo(), edge.getFrom()));
			size++;
		}
	}

	public boolean isConnected(){
		return order().equals(reachable(0).size());
	}

	public List<Integer> reachable(Integer nodeIndex){
		List<Integer> reachableNodes = new LinkedList<>();
		reachable(nodeIndex, new boolean[order()], reachableNodes);
		return reachableNodes;
	}

	/**
	 * Method to determines the nodes reachable from the given node
	 * @param nodeIndex : Index of current node
	 * @param visited : Arrays of boolean, having true for indices  which are visited. 
	 * @param visitedNodes : List of nodes visited already
	 */
	private void reachable(Integer nodeIndex, boolean[] visited,List<Integer> visitedNodes){
		visited[nodeIndex] = true;
		visitedNodes.add(nodeIndex);
		// Traverses each node one by one
		for(Edge edge: edgeList.get(nodeIndex)){
			// Only find reachable nodes from this node if it is not visited 
			if(!visited[edge.getTo()]){
				reachable(edge.getTo(),visited,visitedNodes);
			}
		}
	}

	public UndirectedWeightedGraph mst(){
		// If the graph is not connected, the mst cannot develop
		if(!isConnected()){
			return null;
		}
		PriorityQueue<Edge> minHeap = new PriorityQueue<>(size(),(firstEdge,secondEdge)->{return firstEdge.getWeight().compareTo(secondEdge.getWeight());});

		// Adding all edges of graph to minHeap
		for(List<Edge> listOfEdge: edgeList){
			for (Edge edge: listOfEdge)
				minHeap.add(edge);
		}

		List<List<Integer>> edgeGroup = new ArrayList<>(order());
		List<Edge> edgesInMST = new LinkedList<>();
		/* 
		 * Every edge belongs to a group, referenced by it's index
		 * initially only they themselves are part of their group
		 */
		for(int nodeIndex = 0; nodeIndex < order(); nodeIndex++){
			edgeGroup.add(new LinkedList<>());
			edgeGroup.get(nodeIndex).add(nodeIndex);
		}

		// Looping until a edge group has all nodes
		while(true){
			Edge edge = minHeap.poll();
			// Only traversing edge if they connect two unconnected groups
			if(edgeGroup.get(edge.getFrom()) != edgeGroup.get(edge.getTo())){
				// Merging both groups
				for(Integer nodeIndexInSecond: edgeGroup.get(edge.getTo())){
					edgeGroup.get(edge.getFrom()).add(nodeIndexInSecond);
					edgeGroup.set(nodeIndexInSecond, edgeGroup.get(edge.getFrom()));
				}
				edgesInMST.add(edge);
			}
			// Exiting loop if the edgeGroup formed has all nodes
			if(order().equals(edgeGroup.get(edge.getFrom()).size())){
				break;
			}
		}
		return new GraphUsingList(order(), edgesInMST);
	}

	public List<Integer> shortestPath(Integer firstNodeId, Integer secondNodeId){
		PriorityQueue<Edge> minHeap = new PriorityQueue<>(size(),(firstEdge,secondEdge)->{return firstEdge.getWeight().compareTo(secondEdge.getWeight());});

		Integer[] bestDistanceAchieved = new Integer[order()];
		for(int nodeIndex = 0; nodeIndex < bestDistanceAchieved.length; nodeIndex++){
			bestDistanceAchieved[nodeIndex] = Integer.MAX_VALUE;
		}

		Integer[] parentNode = new Integer[order()];
		// Adding edges of first edge to minHeap
		for(Edge edge: edgeList.get(firstNodeId)){
			minHeap.add(edge);
		}
		bestDistanceAchieved[firstNodeId] = 0;

		// Looping until any edge is left to be traversed
		while(!minHeap.isEmpty()){
			Edge edge = minHeap.poll();
			// If this edge takes to destination in less weight, update distance
			if(edge.getWeight() < bestDistanceAchieved[edge.getTo()]){
				bestDistanceAchieved[edge.getTo()] = edge.getWeight();
				// Adding edges from these node to our heap
				for(Edge edgesFromNode: edgeList.get(edge.getTo())){
					minHeap.add(new Edge(bestDistanceAchieved[edge.getTo()]+edgesFromNode.getWeight(),edgesFromNode.getFrom(),edgesFromNode.getTo()));
				}
				parentNode[edge.getTo()] = edge.getFrom();
			}
		}

		// If secondNode was never reached
		if(bestDistanceAchieved[secondNodeId] == Integer.MAX_VALUE){
			return null;
		}

		List<Integer> path = new LinkedList<Integer>();
		Integer thisNodeIndex = secondNodeId;
		// Forming the path by going through parents until firstNode is reached 
		while(thisNodeIndex != null){
			((LinkedList<Integer>)path).addFirst(thisNodeIndex);
			thisNodeIndex = parentNode[thisNodeIndex];
		}
		return path;
	}

	/**
	 * Method to determines the number of nodes in the graph
	 * @return : Number of nodes in graph
	 */
	public Integer order(){
		return edgeList.size();
	}

	/**
	 * Method to determines the number of edges in the graph
	 * @return : number of edges in graph
	 */
	public Integer size(){
		return size;
	}

	/**
	 * Method to add an edge between first and second node of the given weight
	 * @param weight : Weight of the edge
	 * @param firstNodeIndex : Index of first Node
	 * @param secondNodeIndex : Index of first Node
	 */
	public void addEdge(Integer weight, Integer firstNodeIndex, Integer secondNodeIndex){
		edgeList.get(firstNodeIndex).add(new Edge(weight, firstNodeIndex, secondNodeIndex));
		edgeList.get(secondNodeIndex).add(new Edge(weight, firstNodeIndex, secondNodeIndex));
		size++;
	}

	/**
	 * Method to gives access to edge list representation of the graph
	 * @return : list of edge lists
	 */
	public List<List<Edge>> getEdgeList(){
		return edgeList;
	}
}
