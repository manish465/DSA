package question.tree_breadth_first_search;

// Given a binary tree, populate an array to represent its level-by-level traversal.
// You should populate the values of all nodes of each level from left to right in separate sub-arrays.

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        System.out.println(solution(root));
    }

    public static List<List<Integer>> solution(TreeNode root){
        List<List<Integer>> output = new ArrayList<>();

        if(root == null)
            return output;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for(int i = 0; i < levelSize; i++){
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                if(currentNode.left != null)
                    queue.offer(currentNode.left);
                if(currentNode.right != null)
                    queue.offer(currentNode.right);
            }

            output.add(currentLevel);
        }

        return output;
    }
}
