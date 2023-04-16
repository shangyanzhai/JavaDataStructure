package Leetcode.DataStructrue.Stack_Deque_LinkedList;

/**
 *   20  有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {
    private char ExpectedReturn(char s){
        if(s == ')'){
            return '(';
        }
        if(s == '}'){
            return '{';
        }
        return '[';
    }
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();

        char[] sArray = s.toCharArray();

        for(int i = 0; i < sArray.length;i++){
            if(sArray[i] == '(' || sArray[i] == '{' || sArray[i] == '['){
                stack.push(sArray[i]);
            }else{//此时代表值不为左括号，则需要考虑几种情况
                //第一种情况 栈中为空 此时遍历的值为右括号，则此时直接返回false
                //第二种情况 栈中取的值与实际遍历的值 并不匹配，则返回 false
                //第三种情况 遍历完以后，左括号还有剩余，即栈空间不为空，则此时返回 false

                if(stack.isEmpty()){
                    return false;
                }
                char left = stack.pop();
                if(ExpectedReturn(sArray[i]) != left){
                    return false;
                }

            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "([])";
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid(s));
    }
}