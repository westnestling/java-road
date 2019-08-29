package com.daleychao.algorithm.array;

/**
 * 移动零
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * @author Daniel
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] array = new int[]{0,1,0,3,12};
        moveZeroes(array);
        for (int each : array) {
            System.out.print(each + " ");
        }
    }

    /**
     * 双指针法
     * @param nums
     */
    private static void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++, j++) {
            while (j < nums.length && nums[j] == 0) {
                j++;
            }
            if (j > (nums.length - 1)) {
                nums[i] = 0;
            } else {
                nums[i] = nums[j];
            }
        }
    }
}
