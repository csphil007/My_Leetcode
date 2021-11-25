package leetcode;

import java.util.Arrays;

public class Sort_8 {
    /**
     * https://www.cnblogs.com/morethink/p/8419151.html
     *
     * @param nums
     * @return 思路：直接插入排序
     * 1. 从第一个元素开始，该元素可以认为已经被排序
     * 2. 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 3. 如果该元素（已排序）大于新元素，将该元素移到下一位置
     * 4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * 5. 将新元素插入到该位置后
     * 6. 重复步骤2~5
     * <p>
     * 平均时间复杂度	最好情况	最坏情况	空间复杂度
     * O(n²)	   O(n²)	  O(n²)	    O(1)
     */
    private int[] Direct_insertion_sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
        return nums;
    }

    /**
     * 思路：希尔排序(实质是插入)
     * 希尔排序，也称 递减增量排序算法，是插入排序的一种更高效的改进版本。希尔排序是 非稳定排序算法。
     * 将待排序数组按照步长gap进行分组，然后将每组的元素利用直接插入排序的方法进行排序；每次再将gap折半减小，循环上述操作；当gap=1时，利用直接插入，完成排序。
     * 1. 选择一个增量序列 t1，t2，……，tk，其中 ti > tj, tk = 1；
     * 2. 按增量序列个数 k，对序列进行 k 趟排序；
     * 3. 每趟排序，根据对应的增量 ti，将待排序列分割成若干长度为 m 的子序列，分别对各子表进行直接插入排序。仅增量因子为 1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     * 平均时间复杂度	最好情况	最坏情况	空间复杂度
     * O(nlog2 n)	O(nlog2 n)	O(nlog2 n)	O(1)
     */
    private int[] Hill_Sorting(int[] nums) {
        int length = nums.length;
        int h = 1;
        while (h < length / 3) h = 3 * h + 1;
        for (; h >= 1; h /= 3) {
            for (int i = 0; i < nums.length - h; i += h) {
                for (int j = i + h; j > 0; j -= h) {
                    if (nums[j] < nums[j - h]) {
                        int temp = nums[j];
                        nums[j] = nums[j - h];
                        nums[j - h] = temp;
                    }
                }
            }
        }
        return nums;
    }

    /**
     * 思路：简单选择排序
     * 选择排序（Selection sort）是一种简单直观的排序算法。它的工作原理如下。首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
     * <p>
     * 选择排序的主要优点与数据移动有关。如果某个元素位于正确的最终位置上，则它不会被移动。选择排序每次交换一对元素，它们当中至少有一个将被移到其最终位置上，因此对 n个元素的表进行排序总共进行至多 n-1 次交换。在所有的完全依靠交换去移动元素的排序方法中，选择排序属于非常好的一种。
     * 1. 从未排序序列中，找到关键字最小的元素
     * 2. 如果最小元素不是未排序序列的第一个元素，将其和未排序序列第一个元素互换
     * 3. 重复1、2步，直到排序结束。
     * <p>
     * 平均时间复杂度	最好情况	最坏情况	空间复杂度
     * O(n²)	O(n²)	O(n²)	O(1)
     */
    private int[] Selection_Sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            //选出之后待排序中值最小的位置
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            //最小值不等于当前值时进行交换
            if (min != i) {
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }
        return nums;
    }

    /**
     * 思路：冒泡排序
     * 冒泡排序（Bubble Sort）是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，
     * 如果他们的顺序错误就把他们交换过来。走访数列的工作是重复地进行直到没有再需要交换，
     * 也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端
     * 1. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 2. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     * 3. 针对所有的元素重复以上的步骤，除了最后一个。
     * 4. 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     *
     * 平均时间复杂度	最好情况	最坏情况	空间复杂度
     * O(n²)	O(n)	O(n²)	O(1)
     */
    private int[] Bubble_Sort(int[] nums) {
        //外层循环控制比较的次数
        for (int i = 0; i < nums.length - 1; i++) {
            //内层循环控制到达位置
            for (int j = 0; j < nums.length - i - 1; j++) {
                //前面的元素比后面大就交换
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }
    /**
     * 思路：快速排序
     * 快速排序是由东尼·霍尔所发展的一种排序算法。在平均状况下，排序 n 个项目要 Ο(nlogn) 次比较。
     * 在最坏状况下则需要 Ο(n2) 次比较，但这种状况并不常见。事实上，快速排序通常明显比其他 Ο(nlogn) 算法更快，
     * 因为它的内部循环（inner loop）可以在大部分的架构上很有效率地被实现出来。
     *
     *1. 从数列中挑出一个元素，称为"基准"（pivot）。
     *2. 重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任一边）。在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
     *3. 递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     *
     * 平均时间复杂度	最好情况	最坏情况	空间复杂度
     * O(nlog₂n)	O(nlog₂n)	O(n²)	O(1)（原地分区递归版）
     */
    private void Quick_Sort(int[] nums,int low, int high) {
        //已经排完
        if(low > high)
            return ;
        int i ,j, temp ,t;
        i = low;
        j = high;
        temp = nums[low];
        while(i<j){
            //先看右边，依次网左递减
            while(temp < nums[j] && i< j)
                j--;
            //再看左边，依次往右递增
            while(temp >= nums[i] && i < j){
                i++;
            }
            if(i<j) {
                t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
            }
        }
        nums[low] = nums[i];
        nums[i] = temp;
        Quick_Sort(nums, low, j-1);
        Quick_Sort(nums, j+1, high);
    }

    /**
     * 堆排序
     * 思想：二维数组看成一个完全二叉树。那么堆的含义就是：完全二叉树中任何一个非叶子节点的值均不大于（或不小于）其左，右孩子节点的值。
     * 由上述性质可知大顶堆的堆顶的关键字肯定是所有关键字中最大的，小顶堆的堆顶的关键字是所有关键字中最小的。
     * 因此我们可使用大顶堆进行升序排序, 使用小顶堆进行降序排序。
     *此处以大顶堆为例，堆排序的过程就是将待排序的序列构造成一个堆，选出堆中最大的移走，再把剩余的元素调整成堆，找出最大的再移走，重复直至有序
     *
     *
     * 堆排序需要两个过程，一是建立堆，二是堆顶与堆的最后一个元素交换位置。
     * 所以堆排序有两个函数组成。一是建堆函数，二是反复调用建堆函数以选择出剩余未排元素中最大的数来实现排序的函数。
     * 1.最大堆调整（Max_Heapify）：将堆的末端子节点作调整，使得子节点永远小于父节点
     * 2.创建最大堆（Build_Max_Heap）：将堆所有数据重新排序
     * 3.堆排序（HeapSort）：移除位在第一个数据的根节点，并做最大堆调整的递归运算
     *
     *
     * 平均时间复杂度	最好情况	最坏情况	空间复杂度
     * O(nlog2n)	O(nlog2n)	O(nlog2n)	O(1)
     *
     *理解：堆排序，利用建立大根堆，选出最大值放在第一个位置，之后将第一个与最后一个位置进行互换，每次都选出当前剩余最大的
     */
    public static void Heap_sort(int[] a) {

        for (int i = a.length - 1; i > 0; i--) {
            max_heapify(a, i);

            //堆顶元素(第一个元素)与Kn交换
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
        }
    }
    /***
     *
     *  将数组堆化
     *  i = 第一个非叶子节点。
     *  从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。
     *  叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己以下值为最大。
     *
     * @param a
     * @param n
     */
    public static void max_heapify(int[] a, int n) {
        int child;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            //左子节点位置
            child = 2 * i + 1;
            //右子节点存在且大于左子节点，child变成右子节点
            if (child != n && a[child] < a[child + 1]) {
                child++;
            }
            //交换父节点与左右子节点中的最大值
            if (a[i] < a[child]) {
                int temp = a[i];
                a[i] = a[child];
                a[child] = temp;
            }
        }
    }


    /**
     *归并排序
     * 思想：归并排序算法是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
     * 自上而下的递归
     * 自下而上的迭代
     *
     * 1.将序列每相邻两个数字进行归并操作，形成 floor(n/2)个序列，排序后每个序列包含两个元素；
     * 2.将上述序列再次归并，形成 floor(n/4)个序列，每个序列包含四个元素；
     * 3.重复步骤2，直到所有元素排序完毕。
     *
     *
     * 平均时间复杂度	最好情况	最坏情况	空间复杂度
     * O(nlog₂n)	O(nlog₂n)	O(nlog₂n)	O(n)
     */
    private static int[] aux;

    public static void Merge_sort(int[] a) {
        //一次性分配空间
        aux = new int[a.length];
        ssort(a, 0, a.length - 1);
    }
    public static void ssort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        //将左半边排序
        ssort(a, low, mid);
        //将右半边排序
        ssort(a, mid + 1, high);
        merge(a, low, mid, high);
    }
    /**
     * 该方法先将所有元素复制到aux[]中，然后在归并会a[]中。方法咋归并时(第二个for循环)
     * 进行了4个条件判断：
     * - 左半边用尽(取右半边的元素)
     * - 右半边用尽(取左半边的元素)
     * - 右半边的当前元素小于左半边的当前元素(取右半边的元素)
     * - 右半边的当前元素大于等于左半边的当前元素(取左半边的元素)
     * @param a
     * @param low
     * @param mid
     * @param high
     */
    public static void merge(int[] a, int low, int mid, int high) {
        //将a[low..mid]和a[mid+1..high]归并
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > high) {
                a[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }


    /**
     *基数排序
     * 思想：将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。
     * 然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后，数列就变成一个有序序列。
     *
     * 基数排序：通过序列中各个元素的值，对排序的N个元素进行若干趟的“分配”与“收集”来实现排序。
     * 分配：我们将L[i]中的元素取出，首先确定其个位上的数字，根据该数字分配到与之序号相同的桶中
     * 收集：当序列中所有的元素都分配到对应的桶中，再按照顺序依次将桶中的元素收集形成新的一个待排序列L[]。对新形成的序列L[]重复执行分配和收集元素中的十位、百位...直到分配完该序列中的最高位，则排序结束
     *
     *
     */
    public static void Radix_sort(int[] arr) {
        if (arr.length <= 1) return;

        //取得数组中的最大数，并取得位数
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int maxDigit = 1;
        while (max / 10 > 0) {
            maxDigit++;
            max = max / 10;
        }
        //申请一个桶空间
        int[][] buckets = new int[10][arr.length];
        int base = 10;

        //从低位到高位，对每一位遍历，将所有元素分配到桶中
        for (int i = 0; i < maxDigit; i++) {
            int[] bktLen = new int[10];        //存储各个桶中存储元素的数量

            //分配：将所有元素分配到桶中
            for (int j = 0; j < arr.length; j++) {
                int whichBucket = (arr[j] % base) / (base / 10);
                buckets[whichBucket][bktLen[whichBucket]] = arr[j];
                bktLen[whichBucket]++;
            }

            //收集：将不同桶里数据挨个捞出来,为下一轮高位排序做准备,由于靠近桶底的元素排名靠前,因此从桶底先捞
            int k = 0;
            for (int b = 0; b < buckets.length; b++) {
                for (int p = 0; p < bktLen[b]; p++) {
                    arr[k++] = buckets[b][p];
                }
            }
            System.out.println("Sorting: " + Arrays.toString(arr));
            base *= 10;
        }
    }
}
