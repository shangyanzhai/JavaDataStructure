package DataStructure.LinkedList;

// 不带头（工具结点）
// 不循环
// 双向

// if size == 0 then  head == null &&  last == null
// if size == 1 then  head != null &&  head == last
// if size >= 1 then  head.prev == null &&  last.next == null
// if size > 1 除了 head 和 last 之外  任意 node   node.prev.next == node && node.next.prev == node
//                 head.next.prev == head    last.prev.next == last
// 无论合适 size == 遍历得到的链表结点个数

import java.util.ArrayList;
import java.util.List;

// 备注：这个链表类，不是结点类
public class MyLinkedList {
    private ListNode head;
    private ListNode last;
    private int size;

    public MyLinkedList() {
        head = null;
        last = null;
        size = 0;
    }

    // 尾插
    public boolean add(Long e) {
        ListNode node = new ListNode(e);

        if (size == 0) {
            head = node;
            last = node;
            size = size + 1;
        } else {
            // 把新的结点尾插到链表上，记得双向链表
            last.next = node;
            node.prev = last;
            // 更新尾结点
            last = node;
            size = size + 1;
        }

        return true;
    }

    public void add(int index, Long e) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        ListNode node = new ListNode(e);

        // 下标一定合法
        if (size == 0) {
            head = node;
            last = node;
            size = size + 1;
            return;
        }

        if (size == 1) {
            if (index == 0) {
                // 双向链表
                node.next = head;
                head.prev = node;
                // 更新头结点
                head = node;
            } else {
                // 把新的结点尾插到链表上，记得双向链表
                node.prev = last;
                last.next = node;
                // 更新尾结点
                last = node;
            }
            size = size + 1;
            return;
        }

        // size > 1
        if (index == 0) {
            // 双向链表
            node.next = head;
            head.prev = node;
            // 更新头结点
            head = node;
            size = size + 1;
        } else if (index == size - 1) {
            // 把新的结点尾插到链表上，记得双向链表
            node.prev = last;
            last.next = node;
            // 更新尾结点
            last = node;
            size = size + 1;
        } else {
            // size > 1 && index > 0 && index < size - 1
            ListNode cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;     // 需要考虑 cur == null 的情况么？
            }
            ListNode prev = cur.prev;
            // 把 node 插入到 prev 和 cur 之间
            node.prev = prev;
            node.next = cur;
            prev.next = node;
            cur.prev = node;

            size = size + 1;
        }
    }

    // 从这里往下的代码，大家能大概理解即可，不需要会写
    public void test() {
        if (size < 0) {
            throw new RuntimeException("size 小于 0 了");
        } else if (size == 0) {
            if (head != null) {
                throw new RuntimeException("size 为 0 时，head 不为 null");
            }

            if (last != null) {
                throw new RuntimeException("size 为 0 时，last 不为 null");
            }

            return;
        } else if (size == 1) {
            if (head == null) {
                throw new RuntimeException("size 为 1 时，head 为 null");
            }

            if (last != head) {
                throw new RuntimeException("size 为 1 时，head 和 last 不相等");
            }
        }


        if (head.prev != null) {
            throw new RuntimeException("head 的 prev 不为 null");
        }

        if (last.next != null) {
            throw new RuntimeException("last 的 next 不为 null");
        }

        // 判断除了 head 和 last 之外所有的结点 node.prev.next == node   node.next.prev == node
        for (ListNode cur = head.next; cur != null && cur != last; cur = cur.next) {
            if (cur.prev.next != cur) {
                throw new RuntimeException("cur.prev.next 不等于 cur");
            }

            if (cur.next.prev != cur) {
                throw new RuntimeException("cur.next.prev 不等于 cur");
            }

            int count = 0;
            for (ListNode c = head; c != null; c = c.next) {
                count++;
            }

            if (size != count) {
                throw new RuntimeException("size 不等于遍历链表得到的结点个数");
            }
        }
    }

    public void testElements(long[] elements) {
        if (size != elements.length) {
            throw new RuntimeException("元素个数不符合预期");
        }

        int i = 0;
        ListNode cur = head;

        while (i < elements.length) {
            long e1 = elements[i];
            long e2 = cur.val;
            if (e1 != e2) {
                throw new RuntimeException("元素不匹配: " + i);
            }

            i++;
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.test();
        list.testElements(new long[0]);

        list.add(10L);
        list.test();
        list.testElements(new long[]{10});

        list.add(20L);
        list.test();
        list.testElements(new long[]{10, 20});

        list.add(30L);
        list.test();
        list.testElements(new long[]{10, 20, 30});
    }
}
