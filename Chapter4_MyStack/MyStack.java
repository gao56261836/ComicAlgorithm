package Chapter4_MyStack;

public class MyStack {
    // 栈容量
    private int[] arrayStack;
    // 栈中指针
    private int top;

    // 栈的构造方法
    public MyStack(int capacity) {
        arrayStack = new int[capacity];
        top = -1;
    }

    public void push(int elem) throws Exception {
        arrayStack[++top] = elem;

        System.out.println("入栈的值为"+elem);
    }

    public int pop() throws Exception {
        if (top == -1)
            throw new Exception("该栈为空栈!");
        int popElement = arrayStack[top--];

        System.out.println("出栈的值为"+popElement);

        return popElement;
    }

    public void output(){
        for (int i = 0; i <=top ; i++) {
            System.out.println("栈中值为"+arrayStack[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        MyStack myStack = new MyStack(6);
        myStack.push(0);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        System.out.println("=================================");
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();

        myStack.output();

    }
}
