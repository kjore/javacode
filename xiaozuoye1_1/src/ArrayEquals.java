import java.util.Arrays;

public class ArrayEquals {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] arr3 = {1, 2, 3, 4, 6};

        System.out.println("比较 arr1 和 arr2: " + arrayEquals(arr1, arr2));
        System.out.println("比较 arr1 和 arr3: " + arrayEquals(arr1, arr3));

    }

    public static boolean arrayEquals(int[] arr1, int[] arr2) {
        // 首先判断长度是否相同
        if (arr1.length != arr2.length) {
            return false;
        }

        // 逐一比较元素
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }
}