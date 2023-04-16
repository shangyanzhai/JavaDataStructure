package Leetcode.Array;

public class MinimiseOperationIncreasesTheArray {
    /**1827 最少操作使数组递增
     * 作者：LeetCode-Solution
     *     链接：https://leetcode.cn/problems/minimum-operations-to-make-the-array-increasing/solution/zui-shao-cao-zuo-shi-shu-zu-di-zeng-by-l-sjr6/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *     给你一个整数数组 nums （下标从 0 开始）。每一次操作中，你可以选择数组中一个元素，并将它增加 1 。
     *
     * 比方说，如果 nums = [1,2,3] ，你可以选择增加 nums[1] 得到 nums = [1,3,3] 。
     * 请你返回使 nums 严格递增 的 最少 操作次数。
     *
     * 我们称数组 nums 是 严格递增的 ，当它满足对于所有的 0 <= i < nums.length - 1 都有 nums[i] < nums[i+1] 。一个长度为 1 的数组是严格递增的一种特殊情况。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [1,1,1]
     * 输出：3
     * 解释：你可以进行如下操作：
     * 1) 增加 nums[2] ，数组变为 [1,1,2] 。
     * 2) 增加 nums[1] ，数组变为 [1,2,2] 。
     * 3) 增加 nums[2] ，数组变为 [1,2,3] 。
     * 示例 2：
     *
     * 输入：nums = [1,5,2,4,1]
     * 输出：14
     * 示例 3：
     *
     * 输入：nums = [8]
     * 输出：0
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 5000
     * 1 <= nums[i] <= 104
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/minimum-operations-to-make-the-array-increasing
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int minOperations(int[] nums) {
        int pre = nums[0] - 1, res = 0;
        for (int num : nums) {
            pre = Math.max(pre + 1, num);
            res += pre - num;
        }
        return res;
    }
//    public static int maxsub(int[] nums){//该数组的目的是求（第一个）最大值的下标
//        //首先先进行判断，判断该数组是否为空，或长度为0
//        if(nums == null || nums.length == 0){
//            System.err.println("出现错误,该数组为空");
//            return -1;
//        }
//        int temp = 0;
//        //此时该数组不为空且长度不为0
//        for(int i = 0; i <= nums.length - 1;i++){
//            if(nums[i] > nums[temp]){
//                temp = i;
//            }
//        }
//        return temp;
//    }

    public static void main(String[] args) {
        int[] num = {10,2,5};
        System.out.println(minOperations(num));
    }
}
