import java.util.Scanner;

public class NextPermutation {
    
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n <= 1) return;


        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // If the entire array is non-increasing, reverse it to the smallest permutation
        if (i >= 0) {
            // Step 2: Find the pivot (first element to the left of the suffix)
            int j = n - 1;
            // Step 3: Find the rightmost element in the suffix that is greater than the pivot
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            // Step 4: Swap the pivot with this element
            swap(nums, i, j);
        }
        // Step 5: Reverse the suffix
        reverse(nums, i + 1, n - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        nextPermutation(nums);

        System.out.println("The next permutation is:");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
