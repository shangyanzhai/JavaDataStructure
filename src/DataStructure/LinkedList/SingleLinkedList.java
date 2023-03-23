package DataStructure.LinkedList;

// 1、无头单向非循环链表实现
public class SingleLinkedList {
    public ListNode node;
    public int size;
    

    public SingleLinkedList(){
        node = null;
        size = 0;
    }
    //头插法
    public void addFirst(int data){
        ListNode list = new ListNode((long)data);
        if(size == 0){
            list.next = null;
        }else{
            list.next = node;
        }
        size++;
    }
    //尾插法
    public void addLast(int data) {
        ListNode list = new ListNode((long)data);
        if(size == 0){
            node = list;
        }else{
            while(node.next != null){
                node = node.next;
            }
            node.next = list;
        }
        size++;
    }
    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data) {
        //首先先判断下标不合法的情况
        //下标不合法的情况分为: index > size ; index < 0;
        if(index > size || index < 0){return false;}
        
        //此时，下标合法，他现在存在三种情况
        //情况一 : index == 0 此时为头插
        if(index == 0){
            addFirst(data);
            return true;
        }
        //情况二 : index == size 此时为尾插
        if(index == size){
            addLast(data);
            return true;
        }
        //情况三 : 0 < index && index < size
        ListNode list1 = node.next;
        for (int i = 0; i < index - 1; i++) {
            node = node.next;
            list1 = list1.next;
        }
        ListNode list = new ListNode((long)data);
        node.next = list;
        list.next = list1;
        size++;
        return true;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        if(size == 0){
            return false;
        }
        if(size == 1) {
            if(node.val == key){
                return true;
            }
            return false;
        }

        while(node.next != null){
            if(node.val == key){
                return true;
            }
            node = node.next;
        }
        if(node.val == key){
            return true;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if(size == 0){
            return ;
        }
        if(size == 1){
            if(node.val == key){
                node = null;
                size--;
            }else{
                return;
            }
        }
        ListNode list = node;
        ListNode list1 = node.next;
        while(list1.next != null){

        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key) {


    }
    //得到单链表的长度
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "SingleLinkedList{" +
                "node=" + node +
                ", size=" + size +
                '}';
    }

    public void display(){
        System.out.println("SingleLinkedList{" +
                "node=" + node +
                ", size=" + size +
                '}');
    }
    //清除链表
    public void clear(){
        size = 0;
        node = null;
    }
}
