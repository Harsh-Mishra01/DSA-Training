#include <iostream>
#include <vector>
#include <string>

using namespace std;

string convert(string s, int numRows) {
    if (numRows == 1) return s;

    vector<string> rows(min(numRows, int(s.size())));
    int currentRow = 0;
    bool goingDown = false;

    for (char c : s) {
        rows[currentRow] += c;
        if (currentRow == 0 || currentRow == numRows - 1) {
            goingDown = !goingDown;
        }
        currentRow += goingDown ? 1 : -1;
    }

    string result;
    for (string row : rows) {
        result += row;
    }
    return result;
}

int main() {
    string s = "PAYPALISHIRING";
    int numRows = 3;
    cout << "Input: " << s << ", numRows = " << numRows << endl;
    cout << "Output: " << convert(s, numRows) << endl; 
    return 0;
}
