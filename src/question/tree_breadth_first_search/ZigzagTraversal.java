package question.tree_breadth_first_search;

// Given a binary tree, populate an array to represent its zigzag level order traversal.
// You should populate the values of all nodes of the first level from left to right,
// then right to left for the next level and keep alternating in the same manner for the following levels.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);

        System.out.println(solution(root));
    }

    public static List<List<Integer>> solution(TreeNode root){
        List<List<Integer>> output = new ArrayList<>();

        if(root == null)
            return output;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToTight = true;

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>(size);

            for(int i = 0; i < size; i++){
                TreeNode currentNode = queue.poll();

                if(leftToTight)
                    levelList.add(currentNode.val);
                else
                    levelList.add(0,currentNode.val);

                if(currentNode.left != null)
                    queue.offer(currentNode.left);
                if(currentNode.right != null)
                    queue.offer(currentNode.right);
            }

            output.add(levelList);
            leftToTight = !leftToTight;
        }

        return output;
    }
}
