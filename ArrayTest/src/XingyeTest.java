import org.junit.Test;

import java.util.Arrays;

/**
 * @author: DongShaowei
 * @create: 2024-09-18 20:31
 * @description:
 */
public class XingyeTest {

    /**
     * 想要切出 k 根水管，请问长度最大为多少？
     *
     *
     * @param nums int整型一维数组 数组中的每个元素表示每根水管的长度
     * @param k int整型 需要切割出的水管数量
     * @return int整型
     */
    public int maxLength (int[] nums, int k) {
        // write code here

        Arrays.sort(nums);
        int n = nums.length;
        int maxLen = 0;
        for (int i = 1; i <= nums[n - 1]; i++) {
            int counts = 0;
            for (int pipe : nums) {
                counts += pipe / i;
            }
            if (counts >= k) {
                maxLen = Math.max(maxLen, i);
            }
        }

        return maxLen;

    }

    @Test
    public void testSolution() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;
        System.out.println(maxLength(nums, k));
    }
}
