import java.util.Arrays;

public class CopyArray {
    public static void main(String[] args) {
        // 创建原始数组
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("原始数组: " + Arrays.toString(arr));

        //  使用自己实现的方法进行数组复制
        int[] myArrayCopy = myArrayCopy(arr, 2, 7);
        System.out.println("自己实现的数组复制(从索引2到6): " +Arrays.toString(myArrayCopy));

        // 使用Arrays.copyOfRange方法Arrays.
        // copyOfRange 的第3个参数（to）表示结束索引，但不包含该索引，
        // 即左闭右开区间 [from, to)，复制时会包含 from 索引的元素，但不包含 to 索引的元素。
        int[] copyOfRangeArray = Arrays.copyOfRange(arr, 2, 7);
        System.out.println("使用Arrays.copyOfRange(从索引2到6): " +Arrays.toString(copyOfRangeArray));

        // 使用Arrays.copyOf方法
        int[] copyOfArray = Arrays.copyOf(arr, 5);
        System.out.println("使用Arrays.copyOf(复制前5个元素): " +Arrays.toString(copyOfArray));

        //  使用System.arraycopy方法
        int[] systemArrayCopy = new int[5]; // 需要提前分配空间
        //arr：源数组（要复制的数据来源）
        //2：源数组的起始索引（从第2个索引位置开始复制）
        //systemArrayCopy：目标数组（复制到这里）
        //0：目标数组的起始索引（从第0个索引位置开始放置复制的数据）
        //5：要复制的元素个数（复制5个元素）
        System.arraycopy(arr, 2, systemArrayCopy,0, 5);
        System.out.println("使用System.arraycopy(从索引2复制5个元素): " +Arrays.toString(systemArrayCopy));
    }

    // 自己实现的数组复制方法
    public static int[] myArrayCopy(int[] source, int from, int to) {
        int[] result = new int[to - from];
        for (int j=0; j+from<to;j++) {
            result[j] = source[j+from];
        }
        return result;
    }
}