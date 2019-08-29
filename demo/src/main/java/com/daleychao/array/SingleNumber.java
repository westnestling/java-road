package com.daleychao.algorithm.array;

/**
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * @author Daniel
 */
public class SingleNumber {
    public static void main(String[] args) {
        System.out.print(singleNumber(new int[]{2, 2, 1}));
    }


    /**
     * 思路：利用异或运算符（^） 时间复杂度 O（n）
     * 异或运算符（^）
     * 参加运算的两个数据，按二进制位进行“异或”运算。
     * <p>
     * 运算规则：0^0=0；  0^1=1；  1^0=1；   1^1=0；
     * <p>
     *    即：参加运算的两个对象，如果两个相应位为“异”（值不同），则该位结果为1，否则为0。
     * <p>
     *  
     * <p>
     * “异或运算”的特殊作用：
     * <p>
     * （1）使特定位翻转找一个数，对应X要翻转的各位，该数的对应位为1，其余位为零，此数与X对应位异或即可。
     * <p>
     * 例：X=10101110，使X低4位翻转，用X ^0000 1111 = 1010 0001即可得到。
     * <p>
     *  
     * <p>
     * （2）与0相异或，保留原值 ，X ^ 00000000 = 1010 1110。
     * (3)A ^ A = 0
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int n = 0;
        for (int num : nums) {
            n = n ^ num;
        }
        return n;
    }

}
