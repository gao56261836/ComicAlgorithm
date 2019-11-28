package Chapter2_LinkedList;

public class MyLinkedList {
    // 结点类型 , 分为data域 和 指针域
    // 链表节点
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // 头节点指针
    private Node head;
    // 尾节点指针
    private Node last;
    // 链表实际长度
    private int size;

    /*
        链表插入元素
        @param data 插入元素
        @param index 插入位置
     */
    public void insert(int data, int index) throws Exception {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("超出链表节点范围!");

        Node insertNode = new Node(data);


        if (size == 0) {
            // 空链表
            head = insertNode;
            last = insertNode;
        } else if (index == 0) {
            // 插入头部
            insertNode.next = head;
            head = insertNode;
        } else if (index == size) {
            // 插入尾部
            last.next = insertNode;
            last = insertNode;
        } else {
            // 插入中间
            Node prevNode = get(index - 1);
            insertNode.next = prevNode.next;
            prevNode.next = insertNode;
        }

        size++;
    }


    /*
        链表删除元素
        @param index 插入位置
     */

    public Node remove(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围!");
        }

        Node removeNode = null;

        if (index == 0) {
            // 删除头结点
            removeNode = head;
            head = head.next;
        } else if (index == size - 1) {
            // 删除尾节点
            Node prevNode = get(index - 1);
            removeNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
        } else {
            Node prevNode = get(index - 1);
            Node nextNode = prevNode.next.next;
            removeNode = prevNode.next;
            prevNode.next = nextNode;
        }

        size--;
        return removeNode;
    }



    /*
        链表查找元素

        @param index  查找的位置
     */

    public Node get(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表节点范围!");
        }

        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    /*
         输出链表
     */
    public void output() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

    }

    public static void main(String[] args) throws Exception {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insert(1,0);
        myLinkedList.insert(2,1);
        myLinkedList.insert(3,2);
        myLinkedList.insert(4,3);
        myLinkedList.insert(5,4);
        myLinkedList.insert(6,5);

        myLinkedList.remove(2);     // 移除3
        myLinkedList.remove(3);     // 移除4

        myLinkedList.output();

    }


}
