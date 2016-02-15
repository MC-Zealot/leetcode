package com.leetCode._2th;

import java.util.ArrayList;
import java.util.List;

import com.leetCode.CommonStructure.TreeNode;

/**
 *
 * @Description:
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

1         3     3      2      1
\       /     /      / \      \
3     2     1      1   3      2
/     /       \                 \
2     1         2                 3
 * @author Zealot
 * @date 2016年2月15日 下午12:26:22
 *
 */
public class UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> res = generateTrees(1, n);
		if (n == 0) {
			res.clear();
		}
		return res;
	}

	public List<TreeNode> generateTrees(int from, int to) {
		List<TreeNode> res = new ArrayList<>();
		if (from > to) {
			res.add(null);
			return res;
		}
		for (int i = from; i <= to; i++) {
			List<TreeNode> left = generateTrees(from, i - 1);
			List<TreeNode> right = generateTrees(i + 1, to);
			int sizeL = left.size();
			int sizeR = right.size();
			for (int p = 0; p < sizeL; p++) {
				for (int q = 0; q < sizeR; q++) {
					TreeNode root = new TreeNode(i);
					root.left = left.get(p);
					root.right = right.get(q);
					res.add(root);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		UniqueBinarySearchTreesII q = new UniqueBinarySearchTreesII();
		List<TreeNode> res = q.generateTrees(0);
	}
}
