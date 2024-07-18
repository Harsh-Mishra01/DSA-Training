#include <iostream>
#include <vector>
#include <climits> 

using namespace std;

int fun(vector<int>& nums) {
    int maxi = INT_MIN, maxi_ending = 0;

    for (int i = 0; i < nums.size(); i++) {
        maxi_ending = maxi_ending + nums[i];
        if (maxi < maxi_ending)
            maxi = maxi_ending;
        if (maxi_ending < 0)
            maxi_ending = 0;
    }
    return maxi;
}

int main() {
    vector<int> nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int max_sum = fun(nums);
    cout << "Maximum sum of contiguous subarray is " << max_sum << endl;
    return 0;
}