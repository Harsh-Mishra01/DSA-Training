import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        
        // Initialize the hashmap with 0 sum having one occurrence
        sumMap.put(0, 1);
        
        for (int num : nums) {
            sum += num;
            
            // Check if there is a prefix sum that we can subtract to get k
            if (sumMap.containsKey(sum - k)) {
                count += sumMap.get(sum - k);
            }
            
            // Update the sumMap with the current cumulative sum
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println("Total number of subarrays with sum " + k + ": " + subarraySum(nums, k));
    }
}
