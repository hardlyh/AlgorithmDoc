package arrs;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * tip:
 *   二分,核心就是找到最后一个i == nums[i] + 1的地方,二分法查找即可
 */
public class missingNumber {
    public int missingNumber(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        int i = 0, j =nums.length - 1;

        while (i <= j){
            int mid = (i + j) / 2;
            if(nums[mid] == mid){
                i = mid + 1;
            }else{
                j = mid - 1;
            }
        }

        if(j < 0){
            return 0;
        }

        if(i > nums.length - 1){
            return nums.length;
        }

        return i  ;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0};
        int missingNumber = new missingNumber().missingNumber(arr);
        System.out.println(missingNumber);
    }
}
