package Chapter1_Array;


public class DeleteElement {
    private int[] array;
    private int size;

    public DeleteElement(int capacity) {
        this.array = new int[capacity];
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

    public int delete(int index) throws Exception {
        // 判断访问下标是否超出数组范围
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("数组越界异常");

        int deletedElement = array[index];

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;

        return deletedElement;
    }

    public void output() {
        for (int i = 0; i < size; i++) {
            System.out.printf("%2d", array[i]);
            if (i == size-1)
                System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        DeleteElement DE = new DeleteElement(5);

        // 先进行向数组里面插入值
        DE.insert(1, 0);
        DE.insert(2, 1);
        DE.insert(3, 2);
        DE.insert(4, 3);
        DE.insert(5, 4);
        // 进行赋值调用, 将 return deletedElement; 赋值给de
        int de = DE.delete(3);

        DE.output();

        System.out.println(de);

    }
}
