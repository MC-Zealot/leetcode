package com.leetcode_2th;

import java.util.HashMap;
import java.util.Map;

import com.leetCode.CommonStructure.UndirectedGraphNode;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list
 * of its neighbors.
 * 
 * @author Zealot
 * @date 2016年5月29日 下午1:19:30
 *
 */
public class Clonegraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode graph) {
		if (graph == null)
			return null;
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		return DFS(graph, map);
	}

	private UndirectedGraphNode DFS(UndirectedGraphNode graph,
			Map<UndirectedGraphNode, UndirectedGraphNode> map) {
		if (map.containsKey(graph)) {
			return map.get(graph);
		}
		UndirectedGraphNode graphCopy = new UndirectedGraphNode(graph.label);
		map.put(graph, graphCopy);
		for (UndirectedGraphNode neighbor : graph.neighbors) {
			graphCopy.neighbors.add(DFS(neighbor, map));
		}
		return graphCopy;
	}
}
