
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        // Construct the binary tree
        TreeNode root = new TreeNode(8,
                new TreeNode(1, null, new TreeNode(4, new TreeNode(3), null)),
                new TreeNode(9, null, new TreeNode(10)));

        // Call the bottomView function to print the bottom view of the tree
        bfs(root);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        // Constructors
        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Function to print the bottom view of a binary tree
    public static void bfs(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int levelsize = queue.size();
            for (int i = 0; i < levelsize; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            System.out.println();

        }}    }