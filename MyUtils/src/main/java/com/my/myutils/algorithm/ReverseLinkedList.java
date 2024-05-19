package com.my.myutils.algorithm;

/**
 * 反转链表
 */

public class ReverseLinkedList {

    public static void main(String[] args) {
        // 初始化链表
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        System.err.println(node1);
        System.err.println(reverseLinkedList2(node1));
    }

    /**
     * 反转链表--迭代
     */
    private static Node reverseLinkedList(Node head) {
        Node node = new Node();
        Node curr = head;
        while (curr != null) {
            // 保存下一个节点
            Node next = curr.getNext();
            curr.setNext(node.getNext());
            node.setNext(curr);
            // 指针后移
            curr = next;
        }

        return node;
    }

    /**
     * 反转链表--递归
     */
    private static Node reverseLinkedList2(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node node = reverseLinkedList2(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return node;
    }
}
