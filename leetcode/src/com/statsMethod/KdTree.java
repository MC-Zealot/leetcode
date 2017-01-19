package com.statsMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 给定二维数据集，
 * 输入目标点，找到其最近邻数据点
 * 
 * @author Zealot
 * @date 2017年1月19日 下午6:44:20 
 *
 */
public class KdTree {
	private KdTreeNode buildTree(List<PairWiseNode> list, int depth) {
		if(list==null|| list.size()==0){
			return null;
		}
		int zuobiao = depth % 2 + 1;
		PairWiseNode midNode = new PairWiseNode();
		if(zuobiao==2){
			midNode = findMediumX(list);
		}else {
			midNode=findMediumY(list);
		}
		KdTreeNode kdTreeNode = new KdTreeNode();
		kdTreeNode.node = midNode;
		
		kdTreeNode.left = buildTree(list.subList(0, list.size()/2), depth+1);
		kdTreeNode.right = buildTree(list.subList(list.size()/2 + 1, list.size()), depth+1);
		return kdTreeNode;
	}
	private PairWiseNode findMediumX(List<PairWiseNode> list) {
		//排序
		Collections.sort(list, new Comparator<PairWiseNode>(){

			@Override
			public int compare(PairWiseNode p1, PairWiseNode p2) {
				if(p1.x > p2.x){
					return 1;
				}else if(p1.x < p2.x){
					return -1;
				}else{
					return 0;
				}
			}
			
		});
		//找到mid，删除该节点
		int size = list.size();
		
		return list.get(size/2);
	}
	private PairWiseNode findMediumY(List<PairWiseNode> list) {
		if(list.size()==1){
			list.get(0);
		}
		//排序
		Collections.sort(list, new Comparator<PairWiseNode>(){

			@Override
			public int compare(PairWiseNode p1, PairWiseNode p2) {
				if(p1.y > p2.y){
					return 1;
				}else if(p1.y < p2.y){
					return -1;
				}else{
					return 0;
				}
			}
			
		});
		//找到mid，删除该节点
		int size = list.size();
		
		return list.get(size/2);
	}
	
	public static void main(String[] args) {
		KdTree kdTree = new KdTree();
		List<PairWiseNode> list = new ArrayList<PairWiseNode>();
		list.add(new PairWiseNode(2, 3));
		list.add(new PairWiseNode(5, 4));
		list.add(new PairWiseNode(9, 6));
		list.add(new PairWiseNode(4, 7));
		list.add(new PairWiseNode(8, 1));
		list.add(new PairWiseNode(7, 2));
		
		KdTreeNode root = kdTree.buildTree(list, 1);
		System.out.println(root.node);
		System.out.println(root.left.node);
		System.out.println(root.right.node);
		System.out.println(root.left.left.node);
		System.out.println(root.left.right.node);
		System.out.println(root.right.left.node);
		
	}
	
}
