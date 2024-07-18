#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int candy(vector<int>& ratings) {
    int n = ratings.size();
    vector<int> candies(n, 1);  

    // Left to Right Pass
    for (int i = 1; i < n; i++) {
        if (ratings[i] > ratings[i - 1]) {
            candies[i] = candies[i - 1] + 1;
        }
    }

    // Right to Left Pass
    for (int i = n - 2; i >= 0; i--) {
        if (ratings[i] > ratings[i + 1]) {
            candies[i] = max(candies[i], candies[i + 1] + 1);
        }
    }

    // Sum up the candies
    int totalCandies = 0;
    for (int candyCount : candies) {
        totalCandies += candyCount;
    }

    return totalCandies;
}

int main() {
    vector<int> ratings = {1, 0, 2};
    cout << "Total candies needed: " << candy(ratings) << endl;  

    vector<int> ratings2 = {1, 2, 2};
    cout << "Total candies needed: " << candy(ratings2) << endl;

    return 0;
}
