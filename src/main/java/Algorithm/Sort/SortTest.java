package Algorithm.Sort;

public class SortTest {
    public static void main(String[] args) {


        // 测试排序算法辅助函数
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SelectionSort.sort( arr );
        SortTestHelper.printArray(arr);
    }
}
