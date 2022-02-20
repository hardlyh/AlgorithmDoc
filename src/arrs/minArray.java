package arrs;


/**
 *
 *
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * tip:
 *  注意一下相等和小于时的判断条件
 *
 */
public class minArray {
    public int minArray(int[] numbers) {
        int i =0,j=numbers.length -1;

        while(i<=j){
            int mid = (i + j) / 2;
            if(numbers[mid] > numbers[j]){
                i = mid + 1;
            }

            else if(numbers[mid] < numbers[j]){
                j = mid;
            }
            else
                j--;

        }

        return numbers[i];
    }

}
