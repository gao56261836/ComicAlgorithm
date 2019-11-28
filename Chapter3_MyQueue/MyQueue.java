package Chapter3_MyQueue;

public class MyQueue {
    // 定义循环队列, 基于数组实现
    private int[] array;
    private int front;      // 队头
    private int rear;       // 队尾

    public MyQueue(int capacity) {
        this.array = new int[capacity];
    }

    /*
        @param element   入队的元素
     */

    public void enQueue(int element) throws Exception {
        // 判断队满的情况
        if ((rear + 1) % array.length == front)
            throw new Exception("队列已满!");

        // 将值赋值给队尾
        array[rear] = element;
        // 队尾指针+1
        rear = (rear + 1) % array.length;

    }

    public int deQueue() throws Exception {
        if (rear == front)
            throw new Exception("队列为空队列!");

        // 将队头元素的值赋值给deElement
        int deElement = array[front];
        // 队头指针+1
        front = (front + 1) % array.length;

        System.out.println("出队元素为" + deElement);
        return deElement;
    }


    /*
        输出队列
     */
    public void output() {
        for (int i = front; i != rear; i = (i + 1) % array.length) {
            System.out.printf("%3d", array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        MyQueue myQueue = new MyQueue(6);

        myQueue.enQueue(3);
        myQueue.enQueue(5);
        myQueue.enQueue(6);
        myQueue.enQueue(8);
        myQueue.enQueue(1);
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.enQueue(2);
        myQueue.enQueue(4);
        myQueue.enQueue(9);
        myQueue.output();

    }

}
