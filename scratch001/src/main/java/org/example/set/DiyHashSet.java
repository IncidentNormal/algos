package org.example.set;

public class DiyHashSet {

    private static final int START_SIZE = 16;

    private DiyLinkedList[] array;
    private int lastIndex;

    public DiyHashSet() {
        this.array = new DiyLinkedList[START_SIZE];
        this.lastIndex = 0;
    }

    public boolean add(Character toAdd) {
//        if (lastIndex == this.array.length - 1) {
//            array = expandArray(array);
//        }
        int index = toIndex(toAdd);
        DiyLinkedList diyLinkedList = this.array[index];
        if (diyLinkedList == null) {
            DiyLinkedList newList = new DiyLinkedList();
            newList.add(toAdd);
            this.array[index] = newList;
        } else {
            DiyLinkedList.ListNode next = diyLinkedList.getHead();
            while (next != null && next.getPayload() != null) {
                Character payload = next.getPayload();
                if (toAdd.equals(payload)) {
                    return false;
                }
                next = next.getNext();
            }
            diyLinkedList.add(toAdd);
        }
        return true;
//        this.lastIndex++;
    }

//    private DiyLinkedList[] expandArray(DiyLinkedList[] array) {
//        int newLength = array.length * 2;
//        DiyLinkedList[] newArray = new DiyLinkedList[newLength];
//        System.arraycopy(array, 0, newArray, 0, array.length);
//        return newArray;
//    }

    public Iterator iterator() {
        return new Iterator(array);
    }

    public static class Iterator {

        private final DiyLinkedList[] array;
        private DiyLinkedList.ListNode currentListNode;
        private int currentIndex;

        public Iterator(DiyLinkedList[] array) {
            this.array = array;
            this.currentIndex = 0;
        }

        public boolean hasNext() {
            if (currentListNode != null) {
                DiyLinkedList.ListNode next = currentListNode.getNext();
                if (next != null && next.getPayload() != null) {
                    return true;
                }
            }
            return currentIndex < array.length - 1;
        }

        public Character next() {
            if (currentListNode != null) {
                DiyLinkedList.ListNode next = currentListNode.getNext();
                if (next != null && next.getPayload() != null) {
                    Character payload = next.getPayload();
                    currentListNode = next;
                    return payload;
                } else {
                    currentIndex++;
                }
            }
            DiyLinkedList diyLinkedList = array[currentIndex];
            currentListNode = diyLinkedList.getHead();
            return currentListNode.getPayload();
        }
    }

    private int toIndex(Character c) {
       return c.hashCode() % array.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int counter = 0;
        for (DiyLinkedList diyLinkedList : array) {
            sb.append(counter).append("=[");
            DiyLinkedList.ListNode next = diyLinkedList.getHead();
            while (next != null && next.getPayload() != null) {
                sb.append(next.getPayload());
                if (next.getNext() != null && next.getNext().getPayload() != null) {
                    sb.append(", ");
                }
                next = next.getNext();
            }
            sb.append("]");
            if (counter < array.length - 1) {
                sb.append(", ");
            }
            counter++;
        }
        sb.append("]");
        return sb.toString();
    }

}
