package tree;
/**
 *  从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *  https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 *
 *
 *  tip:
 *      树的打印一般都是借助于队列,
 *      熟悉队列的声明方法
 */

import com.sun.deploy.util.ArrayUtil;
import dto.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder {

    public int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        ArrayList<Integer> arr = new ArrayList<>();

        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();

            arr.add(poll.val);

            if(poll.left != null){
                queue.add(poll.left);
            }

            if(poll.right != null){
                queue.add(poll.right);
            }
        }

        int[] result = new int[arr.size()];
        for(int i =0;i<arr.size();i++){
            result[i] = arr.get(i);
        }

        return result;
    }

    /**
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> arr = new ArrayList<>();


        if(root != null){
            queue.add(root);
        }

        while (!queue.isEmpty()){

            ArrayList<TreeNode> temp = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                temp.add(poll);
            }

            for(TreeNode t : temp){
            if(t.left != null){
                queue.add(t.left);
            }
            list.add(t.val);
            if(t.right != null){
                queue.add(t.right);
            }
            }

            arr.add(list);
        }

        return arr;

    }


    /**
     * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
     *
     *    。
     * tip:
     *   打印的双端队列， LinkedList双端队列 addFirst addLast
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> arr = new ArrayList<>();


        if(root != null){
            queue.add(root);
        }
        Boolean tag = true;

        while (!queue.isEmpty()){

            LinkedList<Integer> list = new LinkedList<>();
            int size = queue.size();
            for(int i =0;i<size;i++){
                TreeNode t = queue.poll();
                if(tag){
                    list.addFirst(t.val);
                }else{
                    list.addLast(t.val);
                }
                if(t.left != null){
                    queue.add(t.left);
                }
                if(t.right != null){
                    queue.add(t.right);
                }
            }

            tag = !tag;
            arr.add(list);
        }

        return arr;

    }
}
