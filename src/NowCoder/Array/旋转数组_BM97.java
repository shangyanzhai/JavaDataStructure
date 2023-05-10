package NowCoder.Array;

/**
 *   BM97   旋转数组
 *
 * 描述
 * 一个数组A中存有 n 个整数，在不允许使用另外数组的前提下，将每个整数循环向右移 M（ M >=0）个位置，即将A中的数据由（A0 A1 ……AN-1 ）变换为（AN-M …… AN-1 A0 A1 ……AN-M-1 ）（最后 M 个数循环移至最前面的 M 个位置）。如果需要考虑程序移动数据的次数尽量少，要如何设计移动的方法？
 *
 * 数据范围：
 * 0
 * <
 * �
 * ≤
 * 100
 * 0<n≤100，
 * 0
 * ≤
 * �
 * ≤
 * 1000
 * 0≤m≤1000
 * 进阶：空间复杂度
 * �
 * (
 * 1
 * )
 * O(1)，时间复杂度
 * �
 * (
 * �
 * )
 * O(n)
 * 示例1
 * 输入：
 * 6,2,[1,2,3,4,5,6]
 * 复制
 * 返回值：
 * [5,6,1,2,3,4]
 * 复制
 * 示例2
 * 输入：
 * 4,0,[1,2,3,4]
 * 复制
 * 返回值：
 * [1,2,3,4]
 * 复制
 * 备注：
 * (1<=N<=100,M>=0)
 */
public class 旋转数组_BM97 {
    /**
     * 旋转数组
     * @param n int整型 数组长度
     * @param m int整型 右移距离
     * @param a int整型一维数组 给定数组
     * @return int整型一维数组
     */
    public int[] solve (int n, int m, int[] a) {
        // write code here

        if(n == 0 || n == 1){
            return a;
        }

        //因为 m 存在大于 n 的情况
        m = m % n;

        //先把0~(n-m)处的数组翻转，再把(n-m)~n处的数组翻转，最后把整个数组翻转，整个时间复杂度为O（n），空间复杂度为O(1)
        //首先是左边 0~(n-m) [0,n - m)
        int left = 0;
        int right = n - m - 1;
        while(left < right){
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }

        //首先是左边 0~(n-m) [n - m,n - 1]
        left = n - m;
        right = n - 1;
        while(left < right){
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }

        //最后将整个数组进行翻转
        left = 0;
        right = n - 1;
        while(left < right){
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }

        return a;
    }
}