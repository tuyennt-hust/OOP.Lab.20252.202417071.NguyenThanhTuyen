import java.util.Scanner;

public class ArraySort {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n;
        System.out.print("Nhap n: ");
        n = sc.nextInt();

        int[] A = new int[n];

        for(int i = 0; i < n; i++){
            A[i] = sc.nextInt();
        }
        
        // sap xep
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(A[i] > A[j]){
                    int tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                }
            }
        }

        // tinh tong va trung binh
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += A[i];
        }
        double average_value = (double) sum / n;

        // in ket qua
        System.out.print("Mang sau khi sap xep: ");
        for(int i = 0; i < n; i++){
            System.out.print(A[i] + " ");
        }

        System.out.println("\nSum = " + sum);
        System.out.println("Average Value = " + average_value);

        sc.close();
    }
}