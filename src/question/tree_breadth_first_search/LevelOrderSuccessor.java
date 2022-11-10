package question.tree_breadth_first_search;

// Given a binary tree and a node, find the level order successor of the given node in the tree.
// The level order successor is the node that appears right after the given node in the level order traversal.

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        TreeNode output = solution(root, 12);
        if(output == null)
            System.out.println("NULL");
        System.out.println(output.val);

        output = solution(root, 9);
        if(output == null)
            System.out.println("NULL");
        System.out.println(output.val);
    }

    public static TreeNode solution(TreeNode root, int key){
        if(root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean found = false;

        while (!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i < size; i++){
                TreeNode curr = queue.poll();
                if(found)
                    return curr;
                if(curr.val == key)
                    found = true;

                if(curr.left != null)
                    queue.offer(curr.left);
                if(curr.right != null)
                    queue.offer(curr.right);
            }
        }

        return null;
    }
}
