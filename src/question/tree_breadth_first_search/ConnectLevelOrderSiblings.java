package question.tree_breadth_first_search;

// Given a binary tree, connect each node with its level order successor.
// The last node of each level should point to a null node.

import java.util.LinkedList;
import java.util.Queue;


public class ConnectLevelOrderSiblings {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        solution(root);

        root.printLevelOrder();
    }

    public static void solution(TreeNode root){
        if(root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode prevNode = null;
            int levelSize = queue.size();

            for (int i=0; i < levelSize; i++){
                TreeNode currentNode = queue.poll();
                if(prevNode != null)
                    prevNode.next = currentNode;
                prevNode = currentNode;

                if(currentNode.left != null)
                    queue.offer(currentNode.left);
                if(currentNode.right != null)
                    queue.offer(currentNode.right);
            }
        }
    }
}
