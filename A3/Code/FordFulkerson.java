import java.util.*;
import java.io.File;

public class FordFulkerson {

	public static ArrayList<Integer> pathDFS(Integer source, Integer destination, WGraph graph){
		ArrayList<Integer> path = new ArrayList<Integer>();
		int[] color = new int[graph.getNbNodes()];                            // 颜色表
		Hashtable<Integer,ArrayList<Integer>> adjList = new Hashtable<>();    // 邻接表

		for (int i = 0; i < graph.getNbNodes(); i++) {                        // 初始化邻接表
			adjList.put(i,new ArrayList<>());
		}

		for (Edge edge : graph.listOfEdgesSorted()){                      // 填充邻接表
			if(edge.weight != 0){
				adjList.get(edge.nodes[0]).add(edge.nodes[1]);
			}
		}

		boolean[] judge1 = new boolean[1];
		DFS_visit(color,adjList,source,destination, judge1);
		if(color[destination] == 0){return path;}
		boolean[] judge2 = new boolean[1];
		find_Path(color,adjList,path,source,destination,judge2);

		return path;
	}

	/**
	 * DFS 查找节点
	 */
	public static void DFS_visit(int[] color,Hashtable<Integer,ArrayList<Integer>> adjList,Integer node,Integer destination,boolean[] judge){
		if(judge[0]){ return; }
		color[node] = 1;
		for (Integer i : adjList.get(node)){
			if(i.equals(destination)){
				color[destination] = 1;
				judge[0] = true;
				return;
			}
			if(color[i] == 0){
				DFS_visit(color,adjList,i,destination,judge);
			}
		}
		if(judge[0]){ return; }
		color[node] = 2;
	}

	/**
	 * 按照颜色查找路径顺序
	 */
	public static void find_Path(int[] color,Hashtable<Integer,ArrayList<Integer>> adjList,ArrayList<Integer> path,Integer node,Integer destination,boolean[] judge){
		if(judge[0]){ return; }
		path.add(node);
		for (Integer i : adjList.get(node)){
			if(!path.contains(i)){
				if(judge[0]){ return; }
				if(i.equals(destination)){
					path.add(destination);
					judge[0] = true;
					return;
				}
				if(color[i] == 1){
					find_Path(color,adjList,path,i,destination,judge);
				}
			}

		}
	}



	public static String fordfulkerson( WGraph graph){
		String answer="";
		int maxFlow = 0;
		
		WGraph residual = new WGraph(graph);
		ArrayList<Integer> path = pathDFS(graph.getSource(), graph.getDestination(), residual);

		Hashtable<Edge,Integer> flowTable = new Hashtable<>();
		for (Edge e : graph.listOfEdgesSorted()){
			flowTable.put(e,0);
		}


		while (path.size() != 0){

			int min = 999;
			for (int i = 0; i < path.size() - 1; i++) {
				int tmp = residual.getEdge(path.get(i),path.get(i+1)).weight;
				if(tmp < min){
					min = tmp;
				}
			}

			for (int i = 0; i < path.size() - 1; i++) {
				Edge edge = residual.getEdge(path.get(i),path.get(i+1));
				if(edge.direction == 1){
					flowTable.put(graph.getEdge(path.get(i),path.get(i+1)),flowTable.get(graph.getEdge(path.get(i),path.get(i+1))) + min);
				}
				else {
					flowTable.put(graph.getEdge(path.get(i),path.get(i+1)),flowTable.get(graph.getEdge(path.get(i),path.get(i+1))) - min);
				}
			}

			residual = new WGraph(graph);
			for (Edge e : residual.listOfEdgesSorted()){
				int flow = flowTable.get(graph.getEdge(e.nodes[0],e.nodes[1]));
				if(flow > 0){
					residual.addEdge(new Edge(e.nodes[1],e.nodes[0],flow,2));
				}
				int difference = e.weight - flowTable.get(graph.getEdge(e.nodes[0],e.nodes[1]));
				if(difference >= 0){
					residual.setEdge(e.nodes[0],e.nodes[1],difference);
				}
			}
			path = pathDFS(graph.getSource(), graph.getDestination(), residual);
		}

		for (Edge e : flowTable.keySet()){
			if(e.nodes[1] == graph.getDestination()){
				maxFlow += flowTable.get(e);
			}
		}

		for (Edge e : flowTable.keySet()){
			graph.setEdge(e.nodes[0],e.nodes[1],flowTable.get(e));
		}

		answer += maxFlow + "\n" + graph.toString();	
		return answer;
	}
	

	 public static void main(String[] args){
		String file = args[0];
		File f = new File(file);
		WGraph g = new WGraph(file);
	    System.out.println(fordfulkerson(g));
	 }
}

