package tree;

import dto.TreeNode;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 *tip:
 *  将整个问题拆分为两个部分,即第一个函数是以A树的每个节点作为头结点,先去判断是否可以作为头结点,如果可以再去判断子树.
 *  如何将A树的每个节点都遍历,即递归调用isSubStructure函数, 并且最后结果是||  因为左右节点只要返回一个即可.
 *  注意||  即递归中只要有一个递归循环为true即可
 *  && 递归所有的都必须为true
 *
 */
public class IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null || B==null){
            return false;
        }

        if(A.val == B.val && cure(A.left,B.left) && cure(A.right,B.right)){
            return true;
        }


        // 判断左右子树中是否有符合的
        return isSubStructure(A.left,B) || isSubStructure(A.right,B);

    }

    public boolean cure(TreeNode A,TreeNode B){
        // 此时已经判断了两个都为null的情况
        if(B== null){
            return true;
        }

        if(A==null){
            return false;
        }

        if(A.val != B.val){
            return false;
        }

        return cure(A.left,B.left) && cure(A.right,B.right);

    }
}
