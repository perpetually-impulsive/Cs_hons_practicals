import java.util.*;
public class augmentedMatrix{
    public static void main(String[] args) {
        // matrix A is the matrix that will be inverted --> Ax= B
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of rows of the matrix A -->");
        int rowsA = sc.nextInt();
        System.out.print("Number of columns of the matrix A -->");
        int columnsA = sc.nextInt();
        //matrix B 
        int rowsB = rowsA;
        int columnsB = 1;
        System.out.println("Input matrix A -->");
        //input a 2d array
        int[][] matrixA = new int[rowsA][columnsA];
        for(int i = 0; i<rowsA; i++){
            for(int j= 0; j<columnsA; j++){
                int num = sc.nextInt();
                matrixA[i][j] = num;
            }
        }
        int[][] matrixB = new int[rowsB][columnsB]; 
        System.out.println("Input matrix B-->");
        for(int i=0; i<rowsB; i++){
            for(int j= 0; j<columnsB; j++){
                int num = sc.nextInt();
                matrixB[i][j] = num;
            }
        }
        //display both matrix
        //matrix A
        System.out.println("Matrix A -->");
        for(int i = 0; i<rowsA; i++){
            for(int j= 0; j< columnsA; j++){
                System.out.print(matrixA[i][j]+ " ");
            }
            System.out.println();
        }
        //matrix B
        System.out.println("Matrix B-->");
        for(int i = 0; i<rowsB; i++){
            for(int j= 0; j< columnsB; j++){
                System.out.print(matrixB[i][j]);
            }
            System.out.println();
        }
        inverseMatrix(matrixA, matrixB);
    }
    public static void inverseMatrix(int[][] nums, int[][] nums1){
        int rows = nums.length;
        int columns = nums[0].length + nums1[0].length;
        int[][] inverse = new int[rows][columns];
        //create a augmented matrix -->
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if (j<nums[0].length) {
                    inverse[i][j] = nums[i][j];
                }
                else{
                    inverse[i][j]= nums[i][j%(nums[0].length)];
                }
            }
        }
        //do elementry functions until matrix a turns to identity
        for(int i = 0; i<columns; i++){
            inverse[0][i] = inverse[0][i]/inverse[0][0];
        }
        for(int i = 0; i<columns; i++){
            inverse[1][i] = inverse[1][i]-(inverse[0][i]*inverse[1][0]);
        }
        for(int i = 0; i<columns; i++){
            inverse[1][i] = inverse[1][i]/inverse[1][1];
        }
        for(int i = 0; i<columns; i++){
            inverse[0][i] = inverse[0][i]-(inverse[1][i]*inverse[0][1]);
        }
        System.out.println("Inverted Matrix-->");
        System.out.println(inverse[0][columns-1]);
        System.out.print(inverse[1][columns-1]);
}
    
          }
