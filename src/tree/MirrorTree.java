package tree;

import dto.TreeNode;
import sun.reflect.generics.tree.Tree;

public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {

        if(root == null){
            return null;
        }
        TreeNode tree = new TreeNode(root.val);
        TreeNode treeNode = mirrorTree(root.right);
        tree.left = treeNode;

        TreeNode treeNode1 = mirrorTree(root.left);
        tree.right = treeNode1;


        return tree;
    }
}
