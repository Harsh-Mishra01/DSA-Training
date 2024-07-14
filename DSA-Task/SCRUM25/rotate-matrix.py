import math

class Solution:
    def rotate(self, matrix):
        n = len(matrix)
        for row in range(math.ceil(n / 2)):
            for col in range(int(n - n / 2)):
                (
                    matrix[row][col],
                    matrix[~col][row],
                    matrix[~row][~col],
                    matrix[col][~row],
                ) = (
                    matrix[~col][row],
                    matrix[~row][~col],
                    matrix[col][~row],
                    matrix[row][col],
                )
        return matrix

matrix = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]

solution = Solution()
solution.rotate(matrix)
for row in matrix:
    print(row)
