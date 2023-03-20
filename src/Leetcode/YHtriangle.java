package Leetcode;

/**
 * 118 杨辉三角
 *
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 *
 *
 *  
 *
 * 示例 1:
 *
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 *
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.List;

public class YHtriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> row = new ArrayList<>();

        //首先判断两种特殊情况
        //当 numRows == 1时
        if(numRows == 1){
            row.add(1);
            list.add(row);
            return list;
        }
        //当 numRows == 2时
        if(numRows == 2){
            row.add(1);
            list.add(row);
            row = new ArrayList<>();
            row.add(1);
            row.add(1);
            list.add(row);
            return list;
        }
        //此时说明 numRows > 2时
        row.add(1);
        list.add(row);
        row = new ArrayList<>();
        row.add(1);
        row.add(1);
        list.add(row);
        for(int i = 2;i < numRows ; i++){
            List<Integer> row1 = list.get(i - 1);
            row = new ArrayList<>();
            row.add(1);
            for(int j = 1;j < i;j++){
                int a = row1.get(j);
                int b = row1.get(j - 1);
                int c = a + b;
                row.add(c);
            }
            row.add(1);
            list.add(row);
        }
        return list;
    }
}
