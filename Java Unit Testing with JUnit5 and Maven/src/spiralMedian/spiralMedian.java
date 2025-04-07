package spiralMedian;
public class spiralMedian {
    public void printspiralMedian(int[][] matrix, int m, int n) throws InvalidMatrixException {    // m - liczba wierszy, n - liczba kolumn
        if (matrix == null || matrix.length != m || matrix[0].length != n) {
            throw new InvalidMatrixException("Invalid matrix dimensions or structure.");
        }
        // Print matrix elements in a clockwise spiral order starting from top left corner
        int direction = 1; // Initial direction: 1 - down
        int i = 0, j = 0; // Start from top left corner
        int visited = 0;
        int totalElements = m * n; // Total number of elements in the matrix
        while (visited < totalElements) {
            switch (direction) {
                case 1:
                    while (i < m && matrix[i][j] != -1) {
                        System.out.print(matrix[i++][j] + " ");
                        visited++;
                        matrix[i - 1][j] = -1; // Mark visited element
                    }
                    i--;
                    j++;
                    direction = 2;
                    break;
                case 2:
                    while (j < n && matrix[i][j] != -1) {
                        System.out.print(matrix[i][j++] + " ");
                        visited++;
                        matrix[i][j - 1] = -1; // Mark visited element
                    }
                    i--;
                    j--;
                    direction = 3;
                    break;
                case 3:
                    while (i >= 0 && matrix[i][j] != -1) {
                        System.out.print(matrix[i--][j] + " ");
                        visited++;
                        matrix[i + 1][j] = -1; // Mark visited element
                    }
                    i++;
                    j--;
                    direction = 4;
                    break;
                case 4:
                    while (j >= 0 && matrix[i][j] != -1) {
                        System.out.print(matrix[i][j--] + " ");
                        visited++;
                        matrix[i][j + 1] = -1; // Mark visited element
                    }
                    i++;
                    j++;
                    direction = 1;
                    break;
            }
        }
    }
}