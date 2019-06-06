package nowcoder;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class DeleteRepeatNode {
    public ListNode deleteDuplication(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode current = newHead;
        ListNode next = head;

        while (next != null && next.next != null) {
            if (next.val == next.next.val) {
                while (next != null && next.next != null && next.val == next.next.val) {
                    next = next.next;
                }
                current.next = next.next;
                next = current.next;
            } else {
                current = next;
                next = current.next;
            }
        }
        return newHead.next;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        ListNode newHead = deleteDuplication(head);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
