class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        r, c = len(matrix), len(matrix[0])
        l, r = 0, r * c - 1

        while l <= r:
            m = l + (r - l) // 2
            row = m // c
            col = m % c

            if matrix[row][col] == target:
                return True
            elif matrix[row][col] < target:
                l = m + 1
            else:
                r = m - 1

        return False