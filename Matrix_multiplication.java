package Algorithm;
public class Matrix_multiplication {
    public static void main(String[] args) {
        int[][] A = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        int[][] B = { {9, 8, 7}, {6, 5, 4}, {3, 2, 1} };
        
        int n = A.length;
        int[][] C = new int[n][n];
        
        strassenMultiply(A, B, C);
        
        System.out.println("Matrix C:");
        printMatrix(C);
    }
    
    public static void strassenMultiply(int[][] A, int[][] B, int[][] C) {
        int n = A.length;
        
        if (n == 1) {
            C[0][0] = A[0][0] * B[0][0];
            return;
        }
        
        // Divide A, B, and C into submatrices
        int ns = n / 2;
        
        int[][] A1 = new int[ns][ns];
        int[][] A2 = new int[ns][ns];
        int[][] A3 = new int[ns][ns];
        int[][] A4 = new int[ns][ns];
        
        int[][] B1 = new int[ns][ns];
        int[][] B2 = new int[ns][ns];
        int[][] B3 = new int[ns][ns];
        int[][] B4 = new int[ns][ns];
        
        int[][] C1 = new int[ns][ns];
        int[][] C2 = new int[ns][ns];
        int[][] C3 = new int[ns][ns];
        int[][] C4 = new int[ns][ns];
        
        // Divide A, B, and C into submatrices
        divideMatrix(A, A1, 0, 0);
        divideMatrix(A, A2, 0, ns);
        divideMatrix(A, A3, ns, 0);
        divideMatrix(A, A4, ns, ns);
        
        divideMatrix(B, B1, 0, 0);
        divideMatrix(B, B2, 0, ns);
        divideMatrix(B, B3, ns, 0);
        divideMatrix(B, B4, ns, ns);
        
        divideMatrix(C, C1, 0, 0);
        divideMatrix(C, C2, 0, ns);
        divideMatrix(C, C3, ns, 0);
        divideMatrix(C, C4, ns, ns);
        
        // Compute the seven Strassen products
        int[][] P1 = new int[ns][ns];
        int[][] P2 = new int[ns][ns];
        int[][] P3 = new int[ns][ns];
        int[][] P4 = new int[ns][ns];
        int[][] P5 = new int[ns][ns];
        int[][] P6 = new int[ns][ns];
        int[][] P7 = new int[ns][ns];
        
        // P1 = A1 * (B2 - B4)
        subtractMatrix(B2, B4, P1);
        strassenMultiply(A1, P1, P1);
        
        // P2 = (A1 + A2) * B4
        addMatrix(A1, A2, P2);
        strassenMultiply(P2, B4, P2);
        
        // P3 = (A3 + A4) * B1
        addMatrix(A3, A4, P3);
        strassenMultiply(P3, B1, P3);
        
        // P4 = A4 * (B3 - B1)
        subtractMatrix(B3, B1, P4);
        strassenMultiply(A4, P4, P4);
        
        // P5 = (A1 + A4) * (B1 + B4)
        addMatrix(A1, A4, P5);
        addMatrix(B1, B4, P5);
        strassenMultiply(P5, P5, P5);
        
        // P6 = (A2 - A4) * (B3 + B4)
        subtractMatrix(A2, A4, P6);
        addMatrix(B3, B4, P6);
        strassenMultiply(P6, P6, P6);
        
        // P7 = (A1 - A3) * (B1 + B2)
        subtractMatrix(A1, A3, P7);
        addMatrix(B1, B2, P7);
        strassenMultiply(P7, P7, P7);
        
        // Combine the submatrices to get the result
        // C1 = P5 + P4 - P2 + P6
        addMatrix(P5, P4, C1);
        subtractMatrix(C1, P2, C1);
        addMatrix(C1, P6, C1);
        
        // C2 = P1 + P2
        addMatrix(P1, P2, C2);
        
        // C3 = P3 + P4
        addMatrix(P3, P4, C3);
        
        // C4 = P5 + P1 - P3 - P7
        addMatrix(P5, P1, C4);
        subtractMatrix(C4, P3, C4);
        subtractMatrix(C4, P7, C4);
        
        // Combine the submatrices into the resulting matrix C
        combineMatrix(C1, C, 0, 0);
        combineMatrix(C2, C, 0, ns);
        combineMatrix(C3, C, ns, 0);
        combineMatrix(C4, C, ns, ns);
    }
    
    public static void divideMatrix(int[][] matrix, int[][] submatrix, int rowStart, int colStart) {
        int subSize = submatrix.length;
        
        for (int i = 0; i < subSize; i++) {
            for (int j = 0; j < subSize; j++) {
                submatrix[i][j] = matrix[rowStart + i][colStart + j];
            }
        }
    }
    
    public static void combineMatrix(int[][] submatrix, int[][] matrix, int rowStart, int colStart) {
        int subSize = submatrix.length;
        
        for (int i = 0; i < subSize; i++) {
            for (int j = 0; j < subSize; j++) {
                matrix[rowStart + i][colStart + j] = submatrix[i][j];
            }
        }
    }
    
    public static void addMatrix(int[][] A, int[][] B, int[][] C) {
        int n = A.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
    }
    
    public static void subtractMatrix(int[][] A, int[][] B, int[][] C) {
        int n = A.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
    }
    
    public static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
