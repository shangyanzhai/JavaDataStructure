package NowCoder.DataStructrue.LinkedList;

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(){

    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val , ListNode next) {
        this.val = val;
        this.next = next;
    }
}
