package str;

/***
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * 
 */
public class reverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        if(s == null){
            return s;
        }

        char[] chars = s.toCharArray();

        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        for(int i =0;i<s.length();i++){
            if(i<n){
                sb1.append(chars[i]);
            }else{
                sb2.append(chars[i]);
            }
        }

        return sb2.toString() + sb1.toString();
    }
}
