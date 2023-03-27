package NowCoder.Stack;

/**
 *  栈的压入、弹出序列
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * 1. 0<=pushV.length == popV.length <=1000
 * 2. -1000<=pushV[i]<=1000
 * 3. pushV 的所有数字均不相同
 */

import java.util.*;

public class PushPopOfTheStack {
    private List<Integer> ArrayToList(int[] A){
        List<Integer> list = new ArrayList();
        for(int i : A){
            list.add(i);
        }
        return list;
    }

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        List<Integer> pushlist = ArrayToList(pushA);
        List<Integer> poplist = ArrayToList(popA);

        if (pushlist.size() != poplist.size()) {
            return false;
        }

        Deque<Integer> stack = new LinkedList<>();

        while(!poplist.isEmpty()){
            int num = poplist.remove(0);
            while(stack.isEmpty() || stack.peek() !=  num){
                if(pushlist.isEmpty()){
                    return false;
                }
                stack.push(pushlist.remove(0));
            }
            stack.pop();
        }

        return true;
    }
}
