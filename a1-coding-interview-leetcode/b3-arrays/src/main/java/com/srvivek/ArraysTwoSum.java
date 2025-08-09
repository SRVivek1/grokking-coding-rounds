package com.srvivek;

import java.util.HashMap;
import java.util.Map;

public class ArraysTwoSum {

  public int[] twoSum(int[] nums, int target) {
    if (nums == null || nums.length == 0)
      throw new ArrayIndexOutOfBoundsException("Null / Empty array.");

    final Map<Integer, Integer> data = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int diff = target - nums[i];
      if (data.containsKey(diff)) {
        return new int[] {data.get(diff), i};
      } else {
        data.put(nums[i], i);
      }
    }
    return null;
  }
}
