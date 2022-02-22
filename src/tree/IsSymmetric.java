package tree;

import dto.TreeNode;

/**
 *
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 *
 *
 *
 */
public class IsSymmetric {


    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return false;
        }

        // 这个题目不需要去依次以根结点再做判断,所以不需要调用本身
        return tric(root.left,root.right);
    }



    public boolean tric(TreeNode root1,TreeNode root2){

        // 判断条件
        if(root1 == null && root2 !=null){
            return false;
        }

         if(root1 != null && root2==null){
            return false;
        }

         if(root1 == null && root2 == null){
            return true;
        }

         if(root1.val != root2.val){
             return false;
         }

         // 如果为真的话继续判断下面子树是否对称
        return tric(root1.left,root2.right) && tric(root1.right,root2.left);
    }
}
