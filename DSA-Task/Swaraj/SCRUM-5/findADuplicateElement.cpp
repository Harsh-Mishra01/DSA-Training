#include <iostream>
#include <vector>

using namespace std;

int fun(vector<int>& nums) {
    int slow = nums[0];
    int fast = nums[0];

    // Phase 1: Finding the intersection point of the two runners.
    do {
        slow = nums[slow];
        fast = nums[nums[fast]];
    } while (slow != fast);

    // Phase 2: Finding the entrance to the cycle.
    slow = nums[0];
    while (slow != fast) {
        slow = nums[slow];
        fast = nums[fast];
    }

    return fast;
}

int main() {
    vector<int> nums = {1, 3, 4, 2, 2};
    int duplicate = fun(nums);
    cout << "The duplicate element is: " << duplicate << endl;
    return 0;
}
