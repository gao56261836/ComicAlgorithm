package Chapter1_Array;

public class MyArray {
    private int[] array;
    private int size;

    // 构造方法, 其中, 构造方法名应与Java的类名相同, 这个方法是Java的带参构造,
    // 带的参数实际上是创建对象时 MyArray myArray = new MyArray(10); ()里面的参数
    public MyArray(int capcacity) {
        this.array = new int[capcacity];
        size = 0;
    }

    public void insert(int element, int index) throws Exception {
        // 判断访问下标是否超出范围
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("超出数组实际元素范围!");

        // 从右向左循环, 将元素逐个向右挪一位
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }

        array[index] = element;
        size++;
    }

    public void output() {
        for (int i = 0; i < size; i++) {
            System.out.printf("%2d", array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        MyArray myArray = new MyArray(10);
        myArray.insert(3, 0);
        myArray.insert(7, 1);
        myArray.insert(9, 2);
        myArray.insert(5, 3);
        myArray.insert(6, 4);
        myArray.output();

    }

}
