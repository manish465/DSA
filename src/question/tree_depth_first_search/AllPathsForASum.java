package question.tree_depth_first_search;

// Given a binary tree and a number ‘S’,
// find all paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’.

import java.util.ArrayList;
import java.util.List;

public class AllPathsForASum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        System.out.println(solution(root,23));
    }

    public static List<List<Integer>> solution(TreeNode root, int sum){
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> onePath = new ArrayList<>();

        helper(root, sum, output, onePath);

        return output;
    }

    private static void helper(TreeNode root, int sum, List<List<Integer>> output, List<Integer> onePath){
        if(root == null)
            return;

        onePath.add(root.val);

        if(root.val == sum && root.left == null && root.right == null){
            output.add(new ArrayList<Integer>(onePath));
        }else {
            helper(root.left, sum - root.val, output, onePath);
            helper(root.right, sum - root.val, output, onePath);
        }

        onePath.remove(onePath.size() - 1);
    }
}
