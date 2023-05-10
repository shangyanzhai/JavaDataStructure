package NowCoder.DataStructrue.LinkedList;

/**
 *    OR36 链表的回文结构
 *
 *
 * 对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
 *
 * 给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
 *
 * 测试样例：
 * 1->2->2->1
 * 返回：true
 */

import java.util.Deque;
import java.util.LinkedList;

public class 链表的回文结构_OR36 {
    public int sizeof(ListNode head){
        int num = 0;

        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            num++;
        }

        return num;
    }

    public boolean chkPalindrome(ListNode A) {
        if(A == null){
            return false;
        }
        // write code here
        Deque<Integer> stack = new LinkedList<>();

        int num = sizeof(A);

        if(num == 0){
            return false;
        }

        if(num == 1){
            return true;
        }

        int a = num % 2;
        num = num / 2;

        for(int i = 0;i < num;i++){
            stack.push(A.val);
            A = A.next;
        }

        if(a == 0){//此时代表是偶数个长度
            while(A != null){
                if(A.val != stack.pop()){
                    return false;
                }
                A = A.next;
            }
        }else{
            A = A.next;
            while(A != null){
                if(A.val != stack.pop()){
                    return false;
                }
                A = A.next;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode list1= new ListNode();
//        ListNode list2 = new ListNode(2,list1);
////        ListNode list3 = new ListNode(2,list2);
//        ListNode list = new ListNode(3,list2);//{1,2,2,1}
        链表的回文结构_OR36 palindromeList = new 链表的回文结构_OR36();
        System.out.println(palindromeList.chkPalindrome(list1));
    }
}
