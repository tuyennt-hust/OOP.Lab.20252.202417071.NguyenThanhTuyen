import java.util.Scanner;

public class VeHinh {
    public static void main(String args[]) {
        Scanner nhap = new Scanner(System.in);

        System.out.print("Nhap n: ");
        int n = nhap.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        nhap.close();
    }
}