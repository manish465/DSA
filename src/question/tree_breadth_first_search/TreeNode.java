package question.tree_breadth_first_search;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode next;

    public TreeNode(int x){

        val = x;
        left = right = next = null;
    }

    void printLevelOrder(){
        TreeNode nextLevelRoot = this;

        while (nextLevelRoot != null){
            TreeNode current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null){
                System.out.println(current.val + " ");
                if(nextLevelRoot == null){
                    if(current.left != null)
                        nextLevelRoot = current.left;
                    else if(current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
}
