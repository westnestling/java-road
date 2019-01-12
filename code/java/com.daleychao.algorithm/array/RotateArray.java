package com.daleychao.algorithm.array;

/**
 * 旋转数组
 * <p>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的原地算法。
 *
 * @author Daniel
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        long beginOne = System.currentTimeMillis();
        rotateOne(array, 6);
        System.out.println(System.currentTimeMillis() - beginOne);
        for (int each : array) {
            System.out.print(each + " ");
        }
        System.out.println();
        int[] arrayTwo = new int[]{1, 2, 3, 4, 5, 6, 7};
        long beginTwo = System.currentTimeMillis();
        rotateTwo(arrayTwo, 6);
        System.out.println(System.currentTimeMillis() - beginTwo);
        for (int each : arrayTwo) {
            System.out.print(each + " ");
        }
    }

    public static void rotateOne(int[] nums, int k) {
        for (int j = 0; j < (k % nums.length); j++) {
            int temp = nums[nums.length - 1];
            for (int i = nums.length - 1; i >= 0; i--) {
                if (i == 0) {
                    nums[i] = temp;
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }
    }

    public static void rotateTwo(int[] nums, int k) {
        int temp;
        for (int i = nums.length - 1; i > 0; i--) {
            temp = nums[i];
            if (i > (nums.length / 2 )) {
                nums[i] = nums[i - k];
                nums[i - k] = temp;
            } else if (k % 2 == 0) {
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            } else {
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
        }
    }

    public static void rotateThree(int[] nums, int k) {
        if (nums.length <= 1) {
            return;
        }

        // 先小于 nums.length
        int kk = k % nums.length;

        if (kk==0) {
            return;
        }
        if (kk < nums.length / 2) {
            // 右移
            reverse(nums, nums.length-kk, nums.length-1);
            reverse(nums, 0, nums.length-kk-1);
            reverse(nums, 0, nums.length-1);
        } else {
            int  kkk = nums.length - kk;
            // 左移kkk位
            reverse(nums, 0, kkk-1);
            reverse(nums, kkk, nums.length-1);
            reverse(nums, 0, nums.length-1);
        }
    }

    static void reverse(int [] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
