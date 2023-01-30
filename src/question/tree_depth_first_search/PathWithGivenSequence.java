package question.tree_depth_first_search;

// Given a binary tree and a number sequence,
// find if the sequence is present as a root-to-leaf path in the given tree.

public class PathWithGivenSequence {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println(solution(root, new int[]{1,0,7}));
        System.out.println(solution(root, new int[]{1,1,6}));
    }

    public static boolean solution(TreeNode root, int[] sequence){
        return helper(root, sequence, 1, 0);
    }

    private static boolean helper(TreeNode root, int[] sequence, int level, int match){
        if(root == null)
            return false;

        if(sequence[level - 1] == root.val)
            match++;

        if(root.left == null && root.right == null && match == sequence.length)
            return true;

        return helper(root.left, sequence, level + 1, match) || helper(root.right, sequence, level + 1, match);
    }
}
