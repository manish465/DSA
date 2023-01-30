package question.tree_depth_first_search;

// Given a binary tree where each node can only have a digit (0-9) value,
// each root-to-leaf path will represent a number.
// Find the total sum of all the numbers represented by all paths.

public class SumOfPathNumbers {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println(solution(root));
    }

    public static int solution(TreeNode root){
        int[] totalDigitsum = new int[]{0};

        helper(root, 0, totalDigitsum);

        return helper2(root,0);
    }

    private static void helper(TreeNode root, int digitSum, int[] totalDigitsum){
        if(root == null)
            return;

        digitSum = (digitSum * 10) + root.val;

        if(root.left == null && root.right == null)
            totalDigitsum[0] += digitSum;

        helper(root.left, digitSum, totalDigitsum);
        helper(root.right, digitSum, totalDigitsum);
    }

    private static int helper2(TreeNode root, int digitSum){
        if(root == null)
            return 0;

        digitSum = (digitSum * 10) + root.val;

        if(root.right == null && root.left == null)
            return digitSum;

        return helper2(root.left, digitSum) + helper2(root.right, digitSum);
    }
}
