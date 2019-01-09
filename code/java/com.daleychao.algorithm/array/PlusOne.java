package com.daleychao.algorithm.array;

/**
 * 加一
 * <p>
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * @author Daniel
 */
public class PlusOne {
    public static void main(String[] args) {
        for (int n : plusOne(new int[]{1, 2, 3})) {
            System.out.print(n);
        }
    }

    public static int[] plusOne(int[] digits) {
        int n = 1;
        int tempValue;
        int[] newArray = new int[digits.length+1];
        for (int i = digits.length - 1; i >= 0 && n != 0; i--) {
            tempValue = digits[i] + n;
            n = tempValue /10;
            digits[i] = tempValue % 10;
            newArray[i + 1] = digits[i];
            if (i == 0 && n == 1) {
                newArray[0] = 1;
                return newArray;
            }
        }

        return digits;
    }
}
