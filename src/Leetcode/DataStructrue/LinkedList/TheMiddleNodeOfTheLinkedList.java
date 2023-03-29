package Leetcode.DataStructrue.LinkedList;


/**
 *     876. 链表的中间结点
 *
 *给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[3,4,5]
 * 解释：链表只有一个中间结点，值为 3 。
 * 示例 2：
 *
 *
 * 输入：head = [1,2,3,4,5,6]
 * 输出：[4,5,6]
 * 解释：该链表有两个中间结点，值分别为 3 和 4 ，返回第二个结点。
 *  
 *
 * 提示：
 *
 * 链表的结点数范围是 [1, 100]
 * 1 <= Node.val <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/middle-of-the-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class TheMiddleNodeOfTheLinkedList {
    /*
    public int sizeof(ListNode head){
        int num = 0;
        for(ListNode cur = head;cur != null;cur = cur.next){
            num++;
        }
        return num;
    }
    public ListNode middleNode(ListNode head) {
        //首先先对头节点指向的链表进行判空操作，当该链表为空活着该链表长度为1 ，则直接返回该链表；
        if(head == null || head.next == null){
            return head;
        }
        int num = sizeof(head);
        num = num / 2 + 1 -1;

        ListNode list = head;
        for(int i = 0;i < num; i++){
            list = list.next;
        }
        return list;
    }
    */
    public ListNode middleNode(ListNode head) {
        //首先先对头节点指向的链表进行判空操作，当该链表为空活着该链表长度为1 ，则直接返回该链表；
        if(head == null || head.next == null){
            return head;
        }
        //使用双引用 + 快慢指针的方法，如果采用先求长度的情况，
        //如果该链表长度长的话，需要先遍历完再干正事，相对而言会比较耗时

        ListNode fastlist = head;
        ListNode slowlist = head;
        //此时分为两种情况，
        //情况一 该链表长度为奇数的情况，即当快的节点到尾结点的时候，此时慢节点正巧在中间节点上
        //情况二 该链表长度为偶数的情况，即当快的节点为 null 的时候，此时慢节点才正巧在第二个中间节点上
        while(fastlist != null){
            fastlist = fastlist.next;
            if(fastlist == null){
                break;
            }else{
                fastlist = fastlist.next;
            }
            slowlist = slowlist.next;
        }
        return slowlist;
    }
}
