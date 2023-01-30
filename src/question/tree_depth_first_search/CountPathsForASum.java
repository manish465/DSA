package question.tree_depth_first_search;

// Given a binary tree and a number ‘S’,
// find all paths in the tree such that the sum of all the node values of each path equals ‘S’.
// Please note that the paths can start or end at any node but all paths must
// follow direction from parent to child (top to bottom).

public class CountPathsForASum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        System.out.println(solution(root,11));
    }

    public static int solution(TreeNode root, int S){

    }
}
