#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>


using namespace std;

int fun(vector<int>& arr, int k) {
    unordered_map<int, int> mp;
    int cumSum = 0;
    int maxLength = 0;

    for (int i = 0; i < arr.size(); i++) {
        cumSum += arr[i];

        // If cumSum is equal to k, update maxLength
        if (cumSum == k) {
            maxLength = i + 1;
        }

        // If cumSum - k exists in the map, update maxLength
        if (mp.find(cumSum - k) != mp.end()) {
            maxLength = max(maxLength, i - mp[cumSum - k]);
        }

        // If cumSum is not in the map, add it with the current index
        if (mp.find(cumSum) == mp.end()) {
            mp[cumSum] = i;
        }
    }

    return maxLength;
}

int main() {
    vector<int> arr = {10, 5, 2, 7, 1, 9};
    int k = 15;
    int result = fun(arr, k);
    cout << "Length of the longest sub-array with sum " << k << " is " << result << endl;
    return 0;
}
