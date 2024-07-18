public class MaxConsecutiveChar {

    public static char findMaxConsecutiveChar(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Input string must not be null or empty");
        }

        char maxChar = str.charAt(0);
        int maxCount = 1;

        char currentChar = str.charAt(0);
        int currentCount = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == currentChar) {
                currentCount++;
            } else {
                currentChar = str.charAt(i);
                currentCount = 1;
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
                maxChar = currentChar;
            }
        }

        return maxChar;
    }

    public static void main(String[] args) {
        String str = "aaaabbcbbb";
        System.out.println("The character with the maximum consecutive repetitions is: " + findMaxConsecutiveChar(str));
    }
}
