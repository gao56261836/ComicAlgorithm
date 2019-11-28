package Chapter1_Array;

public class ArrayExpansion {
    private int[] array;
    private int size;

    public ArrayExpansion(int capacity) {
        this.array = new int[capacity];
        size = 0;
    }

    public void insert(int element, int index) throws Exception {
        // 判断下标是否超出范围
        if (index<0 || index>size){
            throw new ArrayIndexOutOfBoundsException("超出数组实际元素范围");
        }

        if (size >= array.length)
            resize();

        for (int i = size -1; i >=index ; i--) {
            array[i+1] = array[i];
        }

        array[index] = element;
        size++;
    }

    private void resize() {
        int[] arrayNew = new int[array.length *2];
        // 从旧数组 复制到新数组
        System.arraycopy(array,0,arrayNew,0,array.length);
        array = arrayNew;
    }

    public void output(){
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%2d",array[i]);

        }
    }

    public static void main(String[] args) throws Exception {
        ArrayExpansion AE = new ArrayExpansion(4);
        AE.insert(3,0);
        AE.insert(7,1);
        AE.insert(9,2);
        AE.insert(5,3);
        AE.insert(0,1);

        AE.output();
    }


}
