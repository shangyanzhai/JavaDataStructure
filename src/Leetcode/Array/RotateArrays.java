package Leetcode.Array;
import java.util.Arrays;

/**189  轮换数组
 *
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *
 *
 * 进阶：
 *
 * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotateArrays {
    public void rotate(int[] nums, int k) {
//        if(nums == null || nums.length == 0){
//            return;
//        }
        //如果k的大小大于数组长度，则采取取余
        if(k >= nums.length){
            k = k % nums.length;
        }
//        for(int i = 0;i < k;i++){//根据传进来的k值来判断需要执行几次
//            //此时我只需要写向右转移一步的方法
//            int temp = nums[nums.length - 1];
//            int a = 0;
//            for(int j = 0; j < nums.length;j++){
//                a = nums[j];
//                nums[j] = temp;
//                temp = a;
//            }
//        }
        //创建一个新的数组，然后将原数组复制一份到新数组上面
        //然后在复制的时候转换
        int[] num = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            num[i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = num[i];
        }
    }
    public static void main(String[] args) {
        RotateArrays rot = new RotateArrays();
        int[] a = {-1,-100,3,99};
        System.out.println(Arrays.toString(a));
        rot.rotate(a,2);
        System.out.println(Arrays.toString(a));
    }
}


