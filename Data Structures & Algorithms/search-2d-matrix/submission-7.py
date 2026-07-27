class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        ROWS, COLS = len(matrix), len(matrix[0])
        l, r = 0, ROWS * COLS - 1

        while l <= r:
            m = l + (r - l) // 2
            
            #记得分母是column, 不是row
            row = m // COLS
            col = m % COLS

            if matrix[row][col] == target:
                return True
            elif matrix[row][col] < target:
                l = m + 1
            else:
                r = m - 1

        return False