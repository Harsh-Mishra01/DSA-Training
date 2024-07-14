import java.util.Scanner;

public class MissingNumber {

    public static int findMissingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements (n): ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter " + n + " elements in the range [0, " + n + "] with one missing:");

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int missingNumber = findMissingNumber(nums);
        System.out.println("The missing number is: " + missingNumber);

        scanner.close();
    }
}
