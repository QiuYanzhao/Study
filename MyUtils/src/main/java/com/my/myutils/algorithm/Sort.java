package com.my.myutils.algorithm;

import java.util.List;
import java.util.Random;

/**
 * 排序算法合集
 */


/**
 * 排序算法	最好情况时间复杂度	平均情况时间复杂度	最坏情况时间复杂度	空间复杂度	稳定性
 *
 * 冒泡排序	O(n)	        O(n^2)	        O(n^2)	        O(1)	    稳定
 * 插入排序	O(n)	        O(n^2)	        O(n^2)	        O(1)	    稳定
 * 选择排序	O(n^2)	        O(n^2)	        O(n^2)	        O(1)	    不稳定
 * 快速排序	O(nlogn)	    O(nlogn)	    O(n^2)	        O(logn)	    不稳定
 * 归并排序	O(nlogn)	    O(nlogn)	    O(nlogn)	    O(n)	    稳定
 * 堆排序	O(nlogn)	    O(nlogn)	    O(nlogn)	    O(1)	    不稳定
 * 希尔排序	O(nlogn)	    取决于间隔序列	O(n^2)	        O(1)	    不稳定
 * 计数排序
 */

public class Sort {

    private static int[] list = new int[10];

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list[i] = random.nextInt(10);
        }
        printList(list);
        System.err.println();
        // 使用排序算法进行排序
        shellSort(list);

        printList(list);
    }

    /**
     * 冒泡排序
     * 依次比较相邻的两个元素，如果顺序不对则交换它们，直到没有需要交换的元素。这样每一趟排序都能将最大（或最小）的元素移动到正确的位置。时间复杂度为O(n^2)。
     */
    private static void test1(int[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length - 1; j++) {
                int temp = list[j];
                if (list[j + 1] < temp) {
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
        printList(list);
    }

    /**
     * 选择排序
     * 每次从未排序部分选择最小（或最大）的元素，放到已排序部分的末尾。时间复杂度为O(n^2)，无论数组是否有序，每次都需要查找最小（或最大）元素。
     */
    private static void test2(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int max = list[0];
            int stamp = 0;
            for (int j = 0; j < list.length - i; j++) {
                if (list[j] > max) {
                    max = list[j];
                    stamp = j;
                }
            }
            list[stamp] = list[list.length - 1 - i];
            list[list.length - 1 - i] = max;
        }
        printList(list);
    }

    /**
     * 插入排序
     * 将数组分为已排序和未排序两部分，每次从未排序部分取出一个元素插入到已排序部分的正确位置。时间复杂度为O(n^2)，但在实际应用中对于小规模或基本有序的数组表现较好。
     */
    private static void test3(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int temp = list[i];
            int j = i - 1;
            // while 循环的部分是将已排序的部分向后移动，直到找到合适的位置插入
            while (j >= 0 && list[j] > temp) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = temp;
        }
        printList(list);
    }

    /**
     * 快速排序
     * 通过选择一个基准元素，将数组分为两个子数组，其中一个子数组的所有元素都比基准元素小，另一个子数组的所有元素都比基准元素大。然后对子数组进行递归排序。时间复杂度为平均情况下O(nlogn)，最坏情况下为O(n^2)。
     */
    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(arr, left, right); // 划分数组并获取基准元素的索引
        quickSort(arr, left, pivot - 1); // 对左子数组进行快速排序
        quickSort(arr, pivot + 1, right); // 对右子数组进行快速排序
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left]; // 选择第一个元素作为基准元素
        int i = left + 1; // 左指针
        int j = right; // 右指针

        while (i <= j) {
            if (arr[i] <= pivot) {
                i++;
            } else if (arr[j] >= pivot) {
                j--;
            } else {
                swap(arr, i, j); // 交换不符合条件的元素
                i++;
                j--;
            }
        }
        swap(arr, left, j); // 将基准元素放到正确的位置
        return j; // 返回基准元素的索引
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * 归并排序
     * 将数组不断地二分，直到每个子数组只有一个元素，然后将相邻的子数组合并成一个有序的子数组，最终得到排序后的数组。时间复杂度为O(nlogn)，需要额外的存储空间来合并子数组。
     */
    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp); // 对左子数组进行归并排序
            mergeSort(arr, mid + 1, right, temp); // 对右子数组进行归并排序
            merge(arr, left, mid, right, temp); // 合并左右子数组
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left; // 左子数组的起始索引
        int j = mid + 1; // 右子数组的起始索引
        int k = left; // 临时数组的起始索引

        // 将左右子数组中的元素按照顺序合并到临时数组
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // 将左子数组中剩余的元素复制到临时数组
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        // 将右子数组中剩余的元素复制到临时数组
        while (j <= right) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        // 将临时数组中的元素复制回原始数组
        for (k = left; k <= right; k++) {
            arr[k] = temp[k];
        }
    }

    /**
     * 堆排序
     * 将数组构建成一个二叉堆，然后不断地从堆顶取出最大（或最小）元素，并调整堆，直到所有元素都被取出。时间复杂度为O(nlogn)，堆排序是一种不稳定的排序算法。
     * https://www.bilibili.com/video/BV1AF411G7cA/?spm_id_from=333.337.search-card.all.click&vd_source=4e893339a2395d319b395a3492043311
     * https://www.bilibili.com/video/BV1e8411M7Lr/?spm_id_from=pageDriver&vd_source=4e893339a2395d319b395a3492043311
     */
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        buildMaxHeap(arr); // 构建最大堆
        int heapSize = arr.length;
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i); // 将最大元素与数组末尾交换
            heapSize--;
            maxHeapify(arr, 0, heapSize); // 调整堆
        }
    }
    private static void buildMaxHeap(int[] arr) {
        int heapSize = arr.length;
        // 从最后一个非叶子节点开始调整构建大顶堆，最后一个非叶子节点的索引是arr.length / 2 - 1
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, i, heapSize);
        }
    }
    private static void maxHeapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1; // 左子节点索引
        int right = 2 * index + 2; // 右子节点索引
        int largest = index; // 最大值索引

        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != index) {
            swap(arr, index, largest);
            maxHeapify(arr, largest, heapSize);
        }
    }


    /**
     * 希尔排序
     * 将数组分组，对每组使用插入排序，然后逐步减小分组的间隔，最终完成排序。希尔排序的时间复杂度取决于分组的间隔序列，一般为O(nlogn)。
     */
    public static void shellSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int n = arr.length;
        // 初始步长为数组长度的一半，逐步缩小步长
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // 对每个步长(gap)进行插入排序
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                // 在当前步长下，对元素进行插入排序
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }



    private static void printList(int[] list) {
        for (int i = 0; i < list.length; i++) {
            System.err.print(list[i] + " ");
        }
    }
}
