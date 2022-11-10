package question.tree_breadth_first_search;

// Find the minimum depth of a binary tree.
// The minimum depth is the number of nodes along the shortest path from the root node to the nearest leaf node.

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfABinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        System.out.println(solution(root));

        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);

        System.out.println(solution(root));
    }

    public static int solution(TreeNode root){
        if(root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        int minDepth = Integer.MAX_VALUE;

        while (!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i < size; i++){
                TreeNode currentNode = queue.poll();

                if(currentNode.left == null && currentNode.right == null)
                    minDepth = Math.min(minDepth,depth);

                if(currentNode.left != null)
                    queue.offer(currentNode.left);
                if(currentNode.right != null)
                    queue.offer(currentNode.right);
            }

            depth++;
        }

        return minDepth;
    }
}
