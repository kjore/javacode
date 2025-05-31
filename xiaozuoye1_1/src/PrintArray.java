import java.util.Arrays;

public class PrintArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        // 使用Arrays.toString()方法
        System.out.println("使用Arrays.toString()打印: " + Arrays.toString(arr));

        // 使用for循环手动遍历打印
        System.out.print("使用for循环打印: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}