package com.leetCode.CommonStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for undirected graph.
 * 
 * @author Zealot
 * @date 2016年3月20日 下午2:19:42
 *
 */
public class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}
