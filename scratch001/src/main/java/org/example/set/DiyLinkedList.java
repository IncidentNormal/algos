package org.example.set;

public class DiyLinkedList {

    public DiyLinkedList() {
        this.head = new ListNode(null);
        this.tail = new ListNode(null);
    }

    private ListNode head;
    private ListNode tail;

    public void add(Character c) {
        ListNode listNode = new ListNode(c);
        listNode.setNext(this.head);
        this.head.setPrev(listNode);
        this.head = listNode;
    }

    public void remove(ListNode n) {
        ListNode prev = n.prev;
        ListNode next = n.next;
        prev.setNext(next);
        next.setPrev(prev);
    }

    public ListNode getHead() {
        return this.head;
    }

    public static class ListNode {

        private final Character payload;

        public ListNode(Character payload) {
            this.payload = payload;
        }

        private ListNode next;
        private ListNode prev;

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public ListNode getPrev() {
            return prev;
        }

        public void setPrev(ListNode prev) {
            this.prev = prev;
        }

        public Character getPayload() {
            return payload;
        }
    }

}
