package question.tree_breadth_first_search;

// Given a binary tree,
// populate an array to represent the averages of all of its levels.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelAveragesInABinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        System.out.println(solution(root));
    }

    public static List<Double> solution(TreeNode root){
        List<Double> output = new ArrayList<>();

        if(root == null)
            return output;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            int levelSum = 0;

            for(int i=0; i < size; i++){
                TreeNode currentNode = queue.poll();

                levelSum += currentNode.val;

                if(currentNode.left != null)
                    queue.offer(currentNode.left);
                if(currentNode.right != null)
                    queue.offer(currentNode.right);
            }

            output.add(((double)levelSum / size));
        }

        return output;
    }
}
