package DataStructure.Sort;

public class Sort {
    public static void bubbleSort(long[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean sorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    sorted = false;
                    swap(array, j, j + 1);
                }
            }
            if (sorted) {
                return;
            }
        }
    }

    public static void selectSort(long[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int maxIdx = 0;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] > array[maxIdx]) {
                    maxIdx = j;
                }
            }
            swap(array, maxIdx, array.length - i - 1);
        }
    }

    public static void insertSort(long[] array) {
        for (int i = 1; i < array.length; i++) {
            long key = array[i];
            int j;
            for (j = i - 1; j >= 0 && key < array[j]; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = key;
        }
    }


    public static void heapSort(long[] array) {
        // 1. 由于要排升序，把整个无序区间（一开始整个 array 都是无序区间）都建成大堆
        createLargeHeap(array, array.length);   // O(n) ~ O(n * log(n))

        // 开始堆选择过程      // O(n * log(n))
        for (int i = 0; i < array.length - 1; i++) {    // n 次
            // 无序区间: [0, array.length - i)
            // 由于无序区间已经是大堆了，所以最大的元素在 [0] 下标
            // 把最大的元素和无序区间的最后一个元素 [array.length - i - 1] 交换
            swap(array, 0, array.length - i - 1);   // O(1)
            // 随着这次交换发生，无序区间少了一个元素，所以新的无序区间还剩 array.length - i - 1
            // 现在新的无序区间暂时不是大堆了，堆顶元素位置破坏了
            // 所以需要进行一次向下调整操作，调整的下标是 [0]
            shiftDown(array, array.length - i - 1, 0);  // O(log(n))
        }
    }

    private static void createLargeHeap(long[] array, int size) {
        int lastIdx = size - 1;
        int lastParentIdx = (lastIdx - 1) / 2;
        for (int i = lastParentIdx; i >= 0; i--) {
            shiftDown(array, size, i);
        }
    }

    // O(log(n))
    private static void shiftDown(long[] array, int size, int index) {
        while (true) {
            int leftIdx = 2 * index + 1;
            if (leftIdx >= size) {
                return;
            }

            int maxIdx = leftIdx;
            if (maxIdx + 1 < size && array[maxIdx + 1] > array[maxIdx]) {
                maxIdx++;
            }

            if (array[index] >= array[maxIdx]) {
                return;
            }

            swap(array, maxIdx, index);

            index = maxIdx;
        }
    }

    // 10 个元素
    // 第一次：5组
    // 第二次：2组
    // 第三次：1组
    // 结束排序
    public static void shellSort(long[] array) {
        int group = array.length / 2;
        while (true) {
            insertSortWithGroup(array, group);
            if (group == 1) {
                return;
            }
            group = group / 2;
        }
    }

    private static void insertSortWithGroup(long[] array, int group) {
        for (int i = group; i < array.length; i++) {
            // 1. 找到要插入的元素
            long key = array[i];
            int j;
            for (j = i - group; j >= 0 && key < array[j]; j = j - group) {
                array[j + group] = array[j];
            }
            array[j + group] = key;
        }
    }

    public static void quickSort(long[] array) {
        quickSortRange(array, 0, array.length - 1);
    }

    // [fromIdx, toIdx]
    private static void quickSortRange(long[] array, int fromIdx, int toIdx) {
        // 求出本次处理的无序区间内的元素个数
        int size = toIdx - fromIdx + 1;
        if (size <= 1) {
            return;
        }

        // pivotIdx 是 partition 之后，pivot 所在的下标
//        int pivotIdx = partition3(array, fromIdx, toIdx);
        int[] borderIdxes = partition4(array, fromIdx, toIdx);
        int ltIdx = borderIdxes[0];
        int gtIdx = borderIdxes[1];

        // 整个 [fromIdx, toIdx] 的区间被 pivot 分成两部分
        // 左边: [fromIdx, pivotIdx - 1]
        // 右边: [pivotIdx + 1, toIdx]
        quickSortRange(array, fromIdx, ltIdx);
        quickSortRange(array, gtIdx, toIdx);
    }

    // hover 法
    private static int partition1(long[] array, int fromIdx, int toIdx) {
        int leIdx = fromIdx;
        int geIdx = toIdx;
        long pivot = array[toIdx];
        // 小于等于基准值的区间: [fromIdx, leIdx)  区间 1
        // 大于等于基准值的区间：[geIdx, toIdx]    区间 2
        // 没有和基准值比较的区间: [leIdx, geIdx)  区间 3
        // 停止条件： 区间 3 的元素个数是 0 个
        while (geIdx > leIdx) {
            // 基准值在右侧，先动左边
            while (geIdx > leIdx && array[leIdx] <= pivot) {
                leIdx++;    // leIdx 在变化，变化过程中，geIdx > leIdx 条件可能会被破坏
            }

            // 左侧遇到一个大于基准值的元素了

            while (geIdx > leIdx && array[geIdx] >= pivot) {
                geIdx--;
            }

            // 右侧遇到一个小于基准值的元素了

            swap(array, leIdx, geIdx);
        }

        swap(array, leIdx, toIdx);

        return leIdx;
    }

    // 挖坑法
    private static int partition2(long[] array, int fromIdx, int toIdx) {
        int leIdx = fromIdx;
        int geIdx = toIdx;
        long pivot = array[toIdx];
        // 小于等于基准值的区间: [fromIdx, leIdx)  区间 1
        // 大于等于基准值的区间：[geIdx, toIdx]    区间 2
        // 没有和基准值比较的区间: [leIdx, geIdx)  区间 3
        // 停止条件： 区间 3 的元素个数是 0 个
        while (geIdx > leIdx) {
            // 基准值在右侧，先动左边
            while (geIdx > leIdx && array[leIdx] <= pivot) {
                leIdx++;    // leIdx 在变化，变化过程中，geIdx > leIdx 条件可能会被破坏
            }

            // 左侧遇到一个大于基准值的元素了
            array[geIdx] = array[leIdx];

            while (geIdx > leIdx && array[geIdx] >= pivot) {
                geIdx--;
            }

            // 右侧遇到一个小于基准值的元素了
            array[leIdx] = array[geIdx];
        }

        array[leIdx] = pivot;

        return leIdx;
    }

    private static int partition3(long[] array, int fromIdx, int toIdx) {
        int ltIdx = fromIdx;
        int geIdx = fromIdx;
        // 小于基准值: [fromIdx, ltIdx)
        // 大于等于基准值: [ltIdx, geIdx)
        // 未比较元素区间: [geIdx, toIdx)
        long pivot = array[toIdx];

        while (geIdx < toIdx) {
            if (array[geIdx] >= pivot) {
                geIdx++;
            } else {
                swap(array, ltIdx, geIdx);
                ltIdx++;
                geIdx++;
            }
        }

        swap(array, ltIdx, toIdx);
        return ltIdx;
    }

    private static int[] partition4(long[] array, int fromIdx, int toIdx) {
        int ltIdx = fromIdx;
        int eqIdx = fromIdx;
        int gtIdx = toIdx;
        long pivot = array[toIdx];

        // 小于: [fromIdx, ltIdx)
        // 等于: [ltIdx, eqIdx)
        // 未比较: [eqIdx, gtIdx]
        // 大于: (gtIdx, toIdx]
        while (eqIdx <= gtIdx) {
            if (array[eqIdx] == pivot) {
                eqIdx++;
            } else if (array[eqIdx] < pivot) {
                swap(array, ltIdx, eqIdx);
                ltIdx++;
                eqIdx++;
            } else {
                swap(array, eqIdx, gtIdx);
                gtIdx--;
            }
        }

        return new int[] { ltIdx - 1, gtIdx + 1 };
    }

    private static void swap(long[] array, int i, int j) {
        long t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}