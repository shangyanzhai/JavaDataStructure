package DataStructure.BinaryHeap;

public class HeapOperations {
    // O(log(n))
    // 需要的参数：
    // 1. 堆（数组）     long[] array, int size
    // 2. 要调整的位置   int index
    public static void shiftDown(long[] array,int size,int index){
        while(true){
            // 1. 判断这个位置是否已经满足堆的性质
            // 1.1 只要该位置已经是叶子了，就不需要做处理
            //     逻辑：叶子 <-> 一个孩子都没有 <-> 没有左孩子
            //     物理上是数组：左孩子的下标越界 <-> 没有左孩子
            int leftIdx = index * 2 + 1;
            if(leftIdx >= size){
                //代表该结点是叶子结点
                return;
            }
            //如果最大的是左孩子
            //不成立的情况 ：存在右孩子，且右孩子大于左孩子
            int maxIdx = leftIdx;
            if (leftIdx + 1 < size && array[leftIdx + 1] > array[leftIdx]) {
                maxIdx = leftIdx + 1;
            }

            if (array[index] >= array[maxIdx]) {
                // 满足堆的性质
                return;
            }

            long t = array[index];
            array[index] = array[maxIdx];
            array[maxIdx] = t;

            // 交换之后不算完
            index = maxIdx;
        }
    }
    public static void shiftUp(long[] array,int index){
        if(index == 0){
            throw  new RuntimeException();
        }
        int parent = (index - 1) / 2;

        if(array[parent] > array[index]){
            return;
        }
        long t = array[index];
        array[index] = array[parent];
        array[parent] = t;
    }
}
