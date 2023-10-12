package week1;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao chieu cao cua tam giac: ");
        int n = sc.nextInt();
        for(int i = 1;i<=n;i++)
        {
            for (int j = 1;j<=n-i;j++){
                System.out.print(" ");
            }
            for (int j = 1;j<=2*i-1;j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
