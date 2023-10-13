package week1;

import java.util.Scanner;

public class AddTwoMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a[][] = new int[20][20];
        int b[][] = new int[20][20];
        System.out.println("Cong hai ma tran cung kich thuoc:");
        System.out.print("Nhap vao so hang: ");
        int m = sc.nextInt();
        System.out.print("Nhap vao so cot: ");
        int n = sc.nextInt();
        System.out.println("Nhap ma tran thu nhat:");
        for (int i = 0; i<m; i++){
            for (int j = 0; j<n; j++){
                System.out.print("a["+i+"]["+j+"]=");
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println("Nhap ma tran thu hai:");
        for (int i = 0; i<m; i++){
            for (int j = 0; j<n; j++){
                System.out.print("b["+i+"]["+j+"]=");
                b[i][j] = sc.nextInt();
            }
        }
        System.out.println("Ma tran thu nhat la: ");
        for (int i = 0; i<m; i++){
            for (int j = 0; j<n; j++){
                System.out.print(a[i][j]+"\t");
            }
            System.out.println(" ");
        }
        System.out.println("Ma tran thu hai la: ");
        for (int i = 0; i<m; i++){
            for (int j = 0; j<n; j++){
                System.out.print(b[i][j]+"\t");
            }
            System.out.println(" ");
        }
        System.out.println("Tong hai ma tran la: ");
        for (int i = 0; i<m; i++){
            for (int j = 0; j<n; j++){
                System.out.print(a[i][j]+b[i][j]+"\t");
            }
            System.out.println(" ");
        }
    }
}
