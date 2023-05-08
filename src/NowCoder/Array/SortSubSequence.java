package NowCoder.Array;

import java.util.*;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/2d3f6ddd82da445d804c95db22dcc471
 * 来源：牛客网
 *
 * 牛牛定义排序子序列为一个数组中一段连续的子序列,并且这段子序列是非递增或者非递减排序的。牛牛有一个长度为n的整数数组A,他现在有一个任务是把数组A分为若干段排序子序列,牛牛想知道他最少可以把这个数组分为几段排序子序列.
 * 如样例所示,牛牛可以把数组A划分为[1,2,3]和[2,2,1]两个排序子序列,至少需要划分为2个排序子序列,所以输出2
 *
 * 输入描述:
 * 输入的第一行为一个正整数n(1 ≤ n ≤ 10^5)
 *
 * 第二行包括n个整数A_i(1 ≤ A_i ≤ 10^9),表示数组A的每个数字。
 *
 *
 * 输出描述:
 * 输出一个整数表示牛牛可以将A最少划分为多少段排序子序列
 * 示例1
 * 输入
 * 6
 * 1 2 3 2 2 1
 * 输出
 * 2
 */
public class SortSubSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            sc.nextLine();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            // 用一个标志来区分
            int flag = 0;
            int count = 1;// 统计能够划分的数组的个数
            for (int i = 1; i < n; i++) {
                if (nums[i] > nums[i - 1]) {// 递增情况：flag==1表示递增，不做任何动作
                    if (flag == 0) {
                        flag = 1;
                    }

                    if (flag == -1) {// 由递减变递增，count加1
                        flag = 0;
                        count++;
                    }
                } else if (nums[i] < nums[i - 1]) {// 递减情况：flag==-1，表示递减，不做任何动作
                    if (flag == 0) {
                        flag = -1;
                    }

                    if (flag == 1) {// 此时有递增变递减，需要count加1
                        flag = 0;
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}
