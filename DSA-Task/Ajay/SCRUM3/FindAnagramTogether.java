import java.util.*;

public class FindAnagramTogether{
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
    
    public static void main(String[] args) {
        FindAnagramTogether ga = new FindAnagramTogether();
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = ga.groupAnagrams(input);
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
