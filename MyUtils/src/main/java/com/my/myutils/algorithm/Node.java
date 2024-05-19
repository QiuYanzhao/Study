package com.my.myutils.algorithm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义链表节点
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Node {

    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
    }
}
