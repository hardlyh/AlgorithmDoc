package str;

/***
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 *
 *
 *
 *  tip:
 *      1.字符串转化为char数组的方法 toCharArray
 *      2. 空格的char数据是 32
 *
 */
public class replaceSpace {

    public String replaceSpace(String s) {
        if(s == null){
            return s;
        }

        char[] chars = s.toCharArray();

        StringBuffer sb  = new StringBuffer();
        for(char c : chars){
            if(c == 32){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
