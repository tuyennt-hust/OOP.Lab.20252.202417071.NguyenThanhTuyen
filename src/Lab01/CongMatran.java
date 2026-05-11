import java.util.Scanner;

public class CongMatran {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int rows, cols;

        // Nhập kích thước ma trận
        System.out.print("Nhap so hang: ");
        rows = sc.nextInt();
        System.out.print("Nhap so cot: ");
        cols = sc.nextInt();

        int[][] A = new int[rows][cols];
        int[][] B = new int[rows][cols];
        int[][] C = new int[rows][cols];

        //nhap ma tran A
        System.out.println("Nhap ma tran A:");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                A[i][j] = sc.nextInt();
            }
        }

        // Nhap ma tran B
        System.out.println("Nhap ma tran B:");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                B[i][j] = sc.nextInt();
            }
        }

        // Cong
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        // In 
        System.out.println("Ma tran tong C = A + B:");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}