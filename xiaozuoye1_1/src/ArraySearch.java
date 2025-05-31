import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ArraySearch {
    public static void main(String[] args) {
        int[] arr = new int[100];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }


        //使用一个哈希表存储原来数组和索引的映射关系
        // 使用一个哈希表存储原数组元素与索引的映射关系
        HashMap<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            valueToIndex.put(arr[i], i);
        }

        System.out.println("原始数组: " + Arrays.toString(arr));
        System.out.println("请输入要搜索的目标值: ");
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        // 1. 线性搜索
        int res = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                res = i;
            }
        }
        System.out.println("线性搜索结果: " + res);

        // 2. 使用binarySearch
        // 排序后的数组用于二分查找
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        int bires = Arrays.binarySearch(sortedArr, target);
        System.out.println("二分查找结果:(排序后) " + (bires >=0  ? bires : -1));
        System.out.println("二分查找结果:(原数组) " + (bires >= 0 ? valueToIndex.get(sortedArr[bires]) : -1));


    }
}