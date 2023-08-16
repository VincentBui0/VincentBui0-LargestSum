import java.util.List;


public class LargestSum {
    /**
     * Get the largest possible sum that can be obtained from a pair of values in the list.
     * A number can't be added to itself, unless there are duplicates.
     *
     * @param nums a list of ints.
     * @return the largest possible sum of separate numbers from nums.
     */
    public int bigSum(List<Integer> nums) {
        int largestSum = Integer.MIN_VALUE;
        int[] seen = new int[101]; // Assuming the range of values is between 0 and 100
        
        for (int num : nums) {
            if (seen[num] > 0) {
                largestSum = Math.max(largestSum, num * 2);
            } else {
                seen[num]++;
            }
        }
        for (int num1 = 0; num1 < seen.length; num1++) {
            if (seen[num1] > 0) {
                for (int num2 = 0; num2 < seen.length; num2++) {
                    if (seen[num2] > 0 && num1 != num2) {
                        largestSum = Math.max(largestSum, num1 + num2);
                    }
                }
            }
        }
        return largestSum;
    }
}