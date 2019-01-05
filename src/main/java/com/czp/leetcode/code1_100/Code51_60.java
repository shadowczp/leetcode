package com.czp.leetcode.code1_100;

public class Code51_60 {

    /**
     * NO.53
     * 找到数组中和最大的一段序列，输出最大值
     * Input: [-2,1,-3,4,-1,2,1,-5,4],
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     * 思路：lastSum[i]表示以num[i]为结尾的子序列的数组的和的最大值
     * 那么我们要求的结果必然是lastSum的最大值(因为我们的结果是从num[m]到num[n]，肯定等于lastSum[n])
     * lastSum[i]<0时，lastSum[i+1]=num[i+1]，否则lastSum[i+1]=num[i+1]+lastSum[i]
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int lastSum = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            lastSum = lastSum < 0 ? nums[i] : nums[i] + lastSum;
            max = max < lastSum ? lastSum : max;
        }
        return max;
    }

    /**
     * No.55
     * 每个数字表示当前位置能走的最大距离，判断是否能走到数组的最后一个位置
     * Input: [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * Input: [3,2,1,0,4]
     * Output: false
     * Explanation: You will always arrive at index 3 no matter what. Its maximum
     * jump length is 0, which makes it impossible to reach the last index.
     * 思路：求能走的最大距离，等于1加上下一步的最大距离与当前最大距离的较大值
     * maxLen = Math.max(maxLen, i + nums[i]);
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int maxIndex = nums.length - 1;
        int maxLen = nums[0];
        for (int i = 0; i <= maxLen; i++) {
            maxLen = Math.max(maxLen, i + nums[i]);
            if (maxLen >= maxIndex) {
                return true;
            }
        }
        return false;
    }

}
