package test.Leetcode;

/**415  字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 *
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 2：
 *
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 示例 3：
 *
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 *
 *
 *
 *
 * 提示：
 *
 * 1 <= num1.length, num2.length <= 104
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StringAdd {
    public static void main(String[] args) {
        String num1 = "9";
        String num2 ="0";
        StringAdd stringAdd = new StringAdd();
        System.out.println(stringAdd.addStrings(num1,num2));
    }
    public String addStrings(String num1, String num2) {
        //给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
        int add = 0;//进位数字
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        StringBuffer stringBuffer1 = new StringBuffer();
//       for (int i = 0; i < (num1.length() > num2.length() ? num1.length() + 1:num2.length() + 1); i++)
        while(n1 >= 0 ||n2 >= 0 || add != 0){
            int x = n1 >= 0 ? num1.charAt(n1) - '0' : 0;
            int y = n2 >= 0 ? num2.charAt(n2) - '0' : 0;
            int tmp =  x + y + add ;
            stringBuffer1 .append(tmp % 10);
            add = tmp / 10;
            n1--;
            n2--;
        }
//        //边界条件，判断个位数
//        if(n1 == -1 && n2 == -1 && add > 0){
//            stringBuffer1.append(add);
//        }
        //循环以后是倒序，则需要倒序
        stringBuffer1 = stringBuffer1.reverse();
        String str1 = stringBuffer1.toString();
        //判断字符串第一个字符是否是'0'，是，则截取[1 , num.length() - 1]
//        if(str1.charAt(0) == '0' && str1.length() > 1){
//            str1 = str1.substring(1);
//        }
        return str1;
    }
}

