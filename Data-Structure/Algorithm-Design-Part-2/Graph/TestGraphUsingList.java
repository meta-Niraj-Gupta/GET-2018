package Graph;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestGraphUsingList{

	@Test
	public void creationOfGraphObject_HappyFlow(){
		new GraphUsingList(5);
		new GraphUsingList(5, Arrays.asList(new Edge(1,2,3), new Edge(1,4,3)));
	}

	@Test
	public void orderOfGraph_HappyFlow(){
		assertTrue((new GraphUsingList(5)).order().equals(5));
		assertTrue(new GraphUsingList(5, Arrays.asList(new Edge(1,2,3), new Edge(1,4,3))).order().equals(5));
	}

	@Test
	public void size_HappyFlow(){
		assertTrue((new GraphUsingList(5)).size().equals(0));
		assertTrue((new GraphUsingList(5, Arrays.asList(new Edge(1,2,3), new Edge(1,4,3))).size().equals(2)));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void creation_Failure(){
		new GraphUsingList(5);
		new GraphUsingList(5, Arrays.asList(new Edge(1,2,3), new Edge(1,5,3)));
	}

	@Test
	public void addEdge_HappyFlow(){
		GraphUsingList graph = new GraphUsingList(5);
		graph.addEdge(5, 1, 2);
		graph.addEdge(5, 1, 2);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void addEdge_Failure(){
		GraphUsingList graph = new GraphUsingList(5);
		graph.addEdge(3, 3, 8);
	}

	@Test
	public void mst_HappyFlow() {
		new GraphUsingList(5);
		GraphUsingList mst = (GraphUsingList) (new GraphUsingList(5,Arrays.asList(new Edge(5,0,1),new Edge(5,2,1),new Edge(10,2,3),new Edge(5,2,3),new Edge(5,3,4),new Edge(500,0,4)))).mst();
		Assert.assertTrue(mst.size().equals(4));
		Assert.assertTrue(mst.order().equals(5));
		for (List<Edge> edgeList: mst.getEdgeList())
			for (Edge edge: edgeList)
				System.out.println("=>"+edge);
	}

	@Test
	public void shortestPath_HappyFlow(){
		List<Integer> path = (new GraphUsingList(5,Arrays.asList(new Edge(5,0,1),new Edge(5,2,1),new Edge(10,2,3),new Edge(5,2,3),new Edge(5,3,4),new Edge(500,0,4)))).shortestPath(0, 4);
		for (Integer nodeIndex: path)
			System.out.println("=<"+nodeIndex);
	}

	@Test
	public void shortestPath_Failure(){
		List<Integer> path = (new GraphUsingList(5,Arrays.asList(new Edge(5,0,1),new Edge(5,2,1),new Edge(10,2,3),new Edge(5,2,3)))).shortestPath(0, 4);
		Assert.assertTrue(path == null);	
	}

	@Test
	public void mst_NoSolution() {
		new GraphUsingList(5);
		UndirectedWeightedGraph mst = (new GraphUsingList(5,Arrays.asList(new Edge(10,2,3),new Edge(5,2,3),new Edge(5,3,4),new Edge(500,0,4)))).mst();
		Assert.assertTrue(mst == null);
	}

	@Test
	public void isConnected_False() {
		new GraphUsingList(5);
		UndirectedWeightedGraph graph = new GraphUsingList(5,Arrays.asList(new Edge(10,2,3),new Edge(5,2,3),new Edge(5,3,4),new Edge(500,0,4)));
		Assert.assertFalse(graph.isConnected());
	}
}
