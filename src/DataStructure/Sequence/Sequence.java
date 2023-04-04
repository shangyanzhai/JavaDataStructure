package DataStructure.Sequence;

public class Sequence {
    /**
     * 冒泡排序
     * @param array
     * @param size
     */
    // 对 array 的前 size 个元素进行排序
    public static void bubbleSort(long[] array, int size) {
        // 外部的循环，写我们需要多次冒泡过程
        for (int i = 0; i < size - 1; i++) {
            // 无序区间: [0, size - i)
            // 有序区间: [size - i, size)

            // 内部的循环，通过两两比较并保证最大的元素在两个的后边
            // 冒泡过程
            // 只需要经历无序区间
            // j 代表黑色箭头
            boolean sorting = true;

            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    sorting = false;
                }
            }

            if (sorting) {
                break;
            }
        }
    }
    // 对 array 的 [fromIndex, toIndex)
    // fromIndex 和 toIndex 一定合法
    public static void bubbleSortRange(long[] array, int fromIndex, int toIndex) {
//        for(int i = fromIndex;i < toIndex - 1;i++){
//            boolean sorting = true;
//            for(int j = fromIndex; j < toIndex + fromIndex - i - 1;j++){
//                if (array[j] > array[j + 1]) {
//                    swap(array, j, j + 1);
//                    sorting = false;
//                }
//            }
//
//            if (sorting) {
//                break;
//            }
//        }
        int n = toIndex - fromIndex;
        for (int i = 0; i < n - 1; i++) {
            boolean sorting = true;
            // 无序区间: [fromIndex, toIndex - i)
            // 有序区间: [toIndex - i, toIndex)
            for (int j = fromIndex; j < toIndex - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    sorting = false;
                }
            }
        }


    }

    /**
     * 选择排序
     * @param array
     * @param size
     */
    public static void selectSort(long[] array, int size) {
        // 一共需要 size - 1 次选择过程
        for (int i = 0; i < size - 1; i++) {
            // 无序区间: [0, size - i)
            // 有序区间: [size - i, size)
            // 无序区间的最后一个位置的下标 [size - i - 1]

            // 进行选择过程，遍历整个无序区间，找到当前无序区间最大的元素下标
            int maxIdx = 0;
            for (int j = 1; j < size - i; j++) {
                if (array[j] > array[maxIdx]) {
                    maxIdx = j;
                }
            }
            // 无序区间的最大元素的下标 maxIdx
            swap(array, maxIdx, size - i - 1);
        }
    }

    // [有序区间][无序区间]
    // 找到无序区间最小的元素，交换到无序区间的最开始
    public static void selectSort1(long[] array, int size) {
        //有序区间[0, i)
        //无序区间[i,size)
        int minIdx = size - 1;
        for(int i = 0;i < size - 1;i++){
            for(int j = size - 2;j >= i;j--){
                if(array[j] < array[minIdx]){
                    minIdx = j;
                }
            }
            swap(array, minIdx, i);
        }
    }

    /**
     * 插入排序
     * @param array
     * @param
     * @param
     */
    public static void insertSort(long[] array, int size) {
        for (int i = 1; i < size; i++) {    // i 的含义，要插入的元素
            // 插入排序关注有序区间
            // 有序区间: [0, i)
            // 无序区间: [i, size)
            long key = array[i];
            // 倒着遍历有序区间，找到合适的位置
            // 合适的位置?
            // key < array[j]
            // key == array[j]      插入 [j + 1]
            // key > array[j]       插入 [j + 1]
            int j;
            for (j = i - 1; j >= 0 && key < array[j]; j--) {
                array[j + 1] = array[j];
            }
            // 循环结束，说明找到合适的位置
            array[j + 1] = key;
        }
    }

    public static void insertSortRange(long[] array, int fromIdx, int toIdx) {
        for (int i = fromIdx; i < toIdx; i++) {

        }
    }
    public static void swap(long[] array,int i,int j){
        long temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
