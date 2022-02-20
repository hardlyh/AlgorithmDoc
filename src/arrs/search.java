package arrs;

/***
 * 统计一个数字在排序数组中出现的次数。
 *
 * tip:
 *      排序数组, 一般都用二分法
 *      注意条件 都是  i<=j
 *       下标长度记得-1
 *       二分法找到左右界限,所以判断的时候是判断if(nums[m] <= target)
 */
public class search {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length == 0){
            return 0;
        }
        // 先找左边界
        int i =0; int j = nums.length-1;

        // 等于是一个优化操作,   在i=j时,j = i-1 如果有数据的话,
        while(i <= j ){
            int m = (i + j)/2;
            if(nums[m] <= target)
                i = m + 1;
            else
                j = m -1;
        }

        int right = i;

         i =0;  j = nums.length-1;
        // 等于是一个优化操作,   在i=j时,j = i-1 如果有数据的话,
        while(i <= j ){
            int m = (i + j)/2;
            if(nums[m] >= target)
                j = m - 1;
            else
                i = m + 1;
        }

        int left = j;

        int count = right - left -1;

        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5};
        int target = 5;
        int search = new search().search(arr, target);
        System.out.println(search);
    }

}
