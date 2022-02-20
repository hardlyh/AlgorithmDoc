package arrs;

import java.util.HashMap;

/**
 *
 *
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 *
 *
 */
public class firstUniqChar {
    public char firstUniqChar(String s) {
        if(s == null){
            return ' ';
        }
        HashMap<Character,Boolean> map = new HashMap<>();
        char[] chars = s.toCharArray();

        for(char c : chars){
            map.put(c,!map.containsKey(c));
        }

        for(char c : chars){
            if(map.get(c)){
                return c;
            }
        }

        return ' ';

    }

}
