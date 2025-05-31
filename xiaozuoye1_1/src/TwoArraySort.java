import java.util.Arrays;

public class TwoArraySort {
    public static void main(String[] args) {

        int[][] arr = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i][j] = (int) (Math.random() * 100);
            }
        }

        System.out.println("排序前的二维数组:");

        printArray(arr);

        // 方法1: 将二维数组转为一维数组，然后排序
        int[] arrtoOneDimension = new int[100];
        int k = 0;

        // 复制到一维数组
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arrtoOneDimension[k++] = arr[i][j];
            }
        }

        // 排序一维数组
        Arrays.sort(arrtoOneDimension);

        // 复制回二维数组
        int [][]arr2= new int[10][10];
        k = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arr2[i][j] = arrtoOneDimension[k++];
            }
        }

        System.out.println("\n排序后的二维数组:");
        printArray(arr2);



        // 方法2: 冒泡排序

        bubbleSort(arr2);
        System.out.println("\n冒泡排序后的二维数组:");
        printArray(arr2);

    }

    // 打印二维数组
    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
   //通过将二维数组"虚拟"为一维数组来进行冒泡排序
    //通过 getValueAt 方法将一维索引转换为二维数组的行列坐标
   //行 = 索引 / 列数
   //列 = 索引 % 列数
    public static void bubbleSort(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int n = rows * cols;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int value1 = getValue(arr, j);
                int value2 = getValue(arr, j + 1);

                if (value1 > value2) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    // 根据一维索引获取二维数组中的值
    private static int getValue(int[][] arr, int index) {
        int cols = arr[0].length;
        int row = index / cols;
        int col = index % cols;
        return arr[row][col];
    }

    // 根据一维索引交换二维数组中的两个值
    private static void swap(int[][] arr, int index1, int index2) {
        int cols = arr[0].length;
        int row1 = index1 / cols;
        int col1 = index1 % cols;
        int row2 = index2 / cols;
        int col2 = index2 % cols;

        int temp = arr[row1][col1];
        arr[row1][col1] = arr[row2][col2];
        arr[row2][col2] = temp;
    }

}