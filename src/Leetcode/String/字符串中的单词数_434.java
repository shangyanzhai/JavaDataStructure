package Leetcode.String;

import java.util.Arrays;

/**
 * 434  字符串中的单词数
 *
 *
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 *
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/number-of-segments-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 字符串中的单词数_434 {
    public static void main(String[] args) throws NoSuchMethodException {
        String str = new String("Hello, my  name is John");
        字符串中的单词数_434 str1 = new 字符串中的单词数_434();
        System.out.println(str1.countSegments(str));
    }
    public int countSegments(String s){
        //边界条件
        if(s == null || s.length() == 0){
            return 0;
        }
        //首先去除字符串中两端的空格（制表符，换行符）
        s = s.trim();
        String[] s1 = s.split(" ");
        System.out.println(Arrays.toString(s1));
        int tmp = s1.length;
        for (int i = 0; i < s1.length; i++) {
            if(s1[i].equals("")){
                tmp--;
            }
            if(tmp == 1){
                break;
            }
        }
        return tmp;
    }
    public String toLowerCase(String s) {
        s = s.toLowerCase();
        return s;
    }
}
