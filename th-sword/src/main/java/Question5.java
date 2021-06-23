import sun.java2d.pisces.PiscesRenderingEngine;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/7/2
 * Description:输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树
 */
public class Question5 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        int length = preorder.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, length -1, inorder, 0, length -1, indexMap);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> indexMap) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) {
            return treeNode;
        } else {
            int rootIndex = indexMap.get(preorder[preStart]);
            int leftNodes = rootIndex - inStart, rightNodes = inEnd - rootIndex;
            TreeNode leftNode = buildTree(preorder, preStart + 1, preStart + leftNodes, inorder, inStart, rootIndex -1, indexMap);
            TreeNode rightNode = buildTree(preorder, preEnd - rightNodes + 1, preEnd, inorder, rootIndex + 1, inEnd, indexMap);
            treeNode.left = leftNode;
            treeNode.right = rightNode;
            return treeNode;
        }
    }
}
