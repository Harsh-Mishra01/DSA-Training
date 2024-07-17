def reverse_inplace(nums, lo, hi):
    while lo < hi:
        nums[lo], nums[hi] = nums[hi], nums[lo]
        lo += 1
        hi -= 1

class Solution:
    def rotate(self, nums, k) -> None:
        k %= len(nums)
        reverse_inplace(nums, 0, len(nums) - 1)
        reverse_inplace(nums, 0, k - 1)
        reverse_inplace(nums, k, len(nums) - 1)

nums = [1, 2, 3, 4, 5, 6, 7]
k = 3
sol = Solution()
sol.rotate(nums, k)
print(nums)
