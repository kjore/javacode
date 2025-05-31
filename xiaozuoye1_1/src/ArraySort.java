import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
        int[] arr1 = new int[100];
        int[] arr2 = new int[100];
        int[] arr3 = new int[100];

        // 填充随机数
        for (int i = 0; i < 100; i++) {
            int randomNum = (int) (Math.random() * 100);
            arr1[i] = randomNum;
            arr2[i] = randomNum;
            arr3[i] = randomNum;
        }

        System.out.println("排序前: " + Arrays.toString(arr1));

        // 1. 使用Arrays.sort()
        Arrays.sort(arr1);
        System.out.println("Arrays.sort()结果: " + Arrays.toString(arr1));

        // 2. 选择排序

        selectionSort(arr2);
        System.out.println("选择排序结果: " + Arrays.toString(arr2));

        // 3. 冒泡排序
        bubbleSort(arr3);
        System.out.println("冒泡排序结果: " + Arrays.toString(arr3));
    }

    // 选择排序
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}