package com.czp.leetcode.code1_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Code1_10 {
    /**
     * No.1
     * 求两数之和，返回数组下标
     * 思路：从头到尾构建一个hashMap，每次操作先计算target-current的值
     * 然后检查是否在map中，如果在，直接返回
     * 如果不在，就把current和currentIdx放入map
     * 注意：这种构建方式，不会使用自己两次，并且会在第二个满足的数字被发现时返回
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (numMap.containsKey(sub)) {
                return new int[]{i, numMap.get(sub)};
            }
            numMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("not have an answer");
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * No.2
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     * 链表反向存储数字，输出两个数的和
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        int flag = 0;
        ListNode result = new ListNode(0);
        ListNode current = result;

        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + flag;
            if (sum > 9) {
                sum = sum - 10;
                flag = 1;
            } else {
                flag = 0;
            }
            current.next = new ListNode(sum);
            current = current.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (flag > 0) {
            current.next = new ListNode(flag);
        }
        return result.next;
    }

    /**
     * No.3
     * 最长序列
     * Input: "abcabcbb"
     * Output: 3
     * Input: "bbbbb"
     * Output: 1
     * Input: "pwwkew"
     * Output: 3
     * 思路：每次遇到相同的字符，就将相同的字符的下标替换，然后删去相同字符前面的字符
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> charSet = new HashMap<>();
        int last = 0;
        int len = chars.length;
        char[] idxSet = new char[len];
        int count = 0;
        int max = count;
        for (int i = 0; i < len; i++) {
            char aChar = chars[i];
            if (charSet.containsKey(aChar)) {
                Integer idx = charSet.get(aChar);

                if (count > max) {
                    max = count;
                }
                count = i - idx - 1;
                while (last <= idx) {
                    charSet.remove(idxSet[last]);
                    last++;
                }

            }
            charSet.put(aChar, i);
            idxSet[i] = aChar;
            count++;
        }
        return count > max ? count : max;
    }
}
