package week1;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

public class SortAndAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao so phan tu cua mang: ");
        int n = sc.nextInt();
        long sum=0;
        int arr[]= new int[1000];
        for (int i =0; i<n; i++){
            System.out.print("arr["+i+"]=");
            arr[i]= sc.nextInt();
            sum+=arr[i];
        }
        double average=(double) sum/n;
        System.out.println("Tong mang la: "+sum);
        System.out.println("Trung binh mang la: "+average);
        for(int i=0;i<n-1;i++)
        {
            for (int j=i;j<n;j++){
                if(arr[i]>arr[j]){
                    int tam = arr[i];
                    arr[i]=arr[j];
                    arr[j]=tam;
                }
            }
        }
        for (int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
