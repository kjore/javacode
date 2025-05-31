import java.util.Arrays;

public class ArrayFill {
    public static void main(String[] args) {
        int[] arr = new int[10];

        // 使用Arrays.fill方法填充数组
        Arrays.fill(arr, 88);

        System.out.println("填充后的数组: " + Arrays.toString(arr));

        // 只填充部分区间
        int[] arr2 = new int[10];
        Arrays.fill(arr2, 2, 7, 99); // 将索引2到6的元素填充为99
        System.out.println("部分填充的数组: " + Arrays.toString(arr2));
    }
}