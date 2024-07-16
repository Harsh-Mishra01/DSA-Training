
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            if (charIndexMap.containsKey(currentChar)) {
                // Move the left pointer to the right of the previous occurrence of the current character
                left = Math.max(left, charIndexMap.get(currentChar) + 1);
            }
            
            // Update the most recent index of the current character
            charIndexMap.put(currentChar, right);
            
            // Calculate the length of the current substring and update the max length if needed
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solver = new LongestSubstringWithoutRepeatingCharacters();
        String input = "abcabcbb";
        int result = solver.lengthOfLongestSubstring(input);
        System.out.println("Length of the longest substring without repeating characters: " + result); // Output: 3
    }
}

