package question.tree_depth_first_search;

// Given a binary tree and a number ‘S’,
// find if the tree has a path from root-to-leaf such that the sum of all the node values of that path equals ‘S’.


public class BinaryTreePathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        System.out.println(solution(root,23));
        System.out.println(solution(root,16));
    }

    public static boolean solution(TreeNode root, int sum){
        if(root == null)
            return false;

        if(root.val == sum && root.left == null && root.right == null)
            return true;

        return solution(root.left, sum - root.val) || solution(root.right, sum - root.val);
    }
}
