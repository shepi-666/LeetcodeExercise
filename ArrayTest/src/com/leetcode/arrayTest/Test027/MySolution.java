package com.leetcode.arrayTest.Test027;

import org.junit.Test;

import java.util.Arrays;

//27.移除元素
public class MySolution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 7, 7, 2, 4};
        int length = removeElement(nums, 7);
        for (int i = 0; i < length; i++) {
            System.out.printf("%d\t", nums[i]);
        }
    }

    // 下面这段程序的思路就是逆序遍历，将数组中元素值等于value的元素交换到数组的末尾
    // 为什么使用逆序遍历？
    // 因为只用正序遍历的话，在最后处理末尾元素的值的时候，很难判断出是否是交换而来的重复元素
    /*
    public static int removeElement(int[] nums, int value) {
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == value) {
                count++;
                int temp = nums[i];
                nums[i] = nums[nums.length-count];
                nums[nums.length-count] = temp;
            }
        }
        return nums.length - count;
    }
    */

    // 下面这个方法直接选择覆盖重复元素
    public static int removeElement(int[] nums, int value) {
        // 这里的count记录的是与目标数不相同的元素个数
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != value) {
                nums[count++] = nums[i];
            }


        }
        return count;
    }

    public int remove(int[] nums, int val) {
        int count = 0;
        int j = nums.length - 1;
        int temp = 0;
        for (int i = nums.length-1; i >=0; i--) {
            if (nums[i] == val ) {
                count++;
                if(i != j) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                j--;
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums.length - count;
    }

    @Test
    public void test() {
        int[] nums = {3,2,2,3};
        int val = 3;
        System.out.println(remove(nums, val));
    }
}
