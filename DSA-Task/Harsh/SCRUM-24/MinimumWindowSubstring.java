import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinimumWindowSubstring {
    
    public static String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> dictT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            dictT.put(c, dictT.getOrDefault(c, 0) + 1);
        }

        int required = dictT.size();

        int l = 0, r = 0;

        int formed = 0;

        Map<Character, Integer> windowCounts = new HashMap<>();

        int[] ans = {-1, 0, 0};

        while (r < s.length()) {
            char c = s.charAt(r);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            while (l <= r && formed == required) {
                c = s.charAt(l);
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }

                l++;
            }

            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String s = scanner.nextLine();

        System.out.print("Enter the second string: ");
        String t = scanner.nextLine();

        String result = minWindow(s, t);
        System.out.println("The minimum window substring is: " + result);

        scanner.close();
    }
}
