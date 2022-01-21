/**
  * 题目Id：912
  * 题目：Sort an Array
  * 日期：2021-12-04 21:53:08
*/
//Given an array of integers nums, sort the array in ascending order. 
//
// 
// Example 1: 
// Input: nums = [5,2,3,1]
//Output: [1,2,3,5]
// Example 2: 
// Input: nums = [5,1,1,2,0,0]
//Output: [0,0,1,1,2,5]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 433 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class SortAnArray {
    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();
        System.out.println("Hello world");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

//    private Random random = new Random();

    public int[] sortArray(int[] nums) {
//        quickSort(0, nums.length-1, nums);
//        heapSort(nums);
        mergeSort(nums);
        return nums;
    }

    // Merge Sort
    public void mergeSort(int []arr) {
        doMerge(arr, 0, arr.length-1);
    }

    public void doMerge(int []arr, int l, int r) {
        if (l >= r) return;
        int m = (r + l)/2;
        doMerge(arr, l, m);
        doMerge(arr, m + 1, r);
        doCombine(arr, l, m, r);
    }

    public void doCombine(int []arr, int l, int m, int r) {
        int[] temp = new int[r-l+1];
        int i = l;
        int j = m + 1;
        int index = 0;
        while (i <= m && j <= r){
            if (arr[i] < arr[j]){
                temp[index++] = arr[i++];
            } else {
                temp[index++] = arr[j++];
            }
        }

        while(i <= m) {
            temp[index++] = arr[i++];
        }

        while(j <= r) {
            temp[index++] = arr[j++];
        }

        for (int z = 0; z < temp.length; z++) {
            arr[l + z] = temp[z];
        }
    }

    // Heap Sort
//    public void heapSort(int []arr){
//        //1.构建大顶堆
//        for (int i = arr.length / 2 - 1; i >= 0; i--){
//            //从第一个非叶子结点从下至上，从右至左调整结构
//            adjustHeap(arr, i, arr.length);
//        }
//        //2.调整堆结构 + 交换堆顶元素与末尾元素
//        for (int j = arr.length - 1; j > 0; j--){
//            swap(arr, 0, j);//将堆顶元素与末尾元素进行交换
//            adjustHeap(arr, 0, j);//重新对堆进行调整
//        }
//    }
//
//    public void ())
//        int temp = arr[i];//先取出当前元素i
//        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {//从i结点的左子结点开始，也就是2i+1处开始
//            if (k + 1 < length && arr[k] < arr[k+1]) {//如果左子结点小于右子结点，k指向右子结点
//                k++;
//            }
//            if (arr[k] > temp) {//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
//                arr[i] = arr[k];
//                i = k;
//            } else {
//                break;
//            }
//        }
//        arr[i] = temp;//将temp值放到最终的位置
//    }


//    //快排
//    public void quickSort(int l, int r, int[] nums) {
//        if (l > r) {
//            return;
//        }
//        int p = partition(l, r, nums);
//        quickSort(l, p-1, nums);
//        quickSort(p+1, r, nums);
//    }
//
//    public int partition(int l, int r, int[] nums) {
//        //快排随机Pivot
//        if (r > l) {
//            int idx = random.nextInt(r - l) + l;
//            swap(nums, l, idx);
//        }
//        int p = nums[l];
//        while(l < r) {
//            while(l < r && nums[r] >= p){
//                --r;
//            }
//            nums[l] = nums[r];
//            while (l < r && nums[l] <= p) {
//                ++l;
//            }
//            nums[r] = nums[l];
//        }
//        nums[l] = p;
//        return l;
//    }

//    private void swap(int[] nums, int i, int j) {
//        // 以下位运算 等同于 交换 双方值
////        nums[i] = nums[i] ^ nums[j] ^ (nums[j] = nums[i]);
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }

}
//leetcode submit region end(Prohibit modification and deletion)

} 
