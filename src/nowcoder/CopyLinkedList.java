package nowcoder;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，
 * 一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * */


public class CopyLinkedList {

    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null)
            return null;

        RandomListNode head = pHead;
        while(head != null){
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.next = head.next;
            head.next = newNode;
            head = newNode.next;
        }

        head = pHead;
        while(head != null){
            if (head.random != null){
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }

        head = pHead;
        RandomListNode newHead = pHead.next;
        RandomListNode result = newHead;

        while(newHead.next != null){
            head.next = newHead.next;
            newHead.next = newHead.next.next;
            head = head.next;
            newHead = newHead.next;
        }
        head.next = null;

        return result;


    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
