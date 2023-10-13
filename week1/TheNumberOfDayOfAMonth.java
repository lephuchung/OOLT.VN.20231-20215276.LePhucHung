package week1;

import javax.swing.*;

public class TheNumberOfDayOfAMonth {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Chuong trinh tim so ngay cua mot thang");
        loop: do {
            String str1 = JOptionPane.showInputDialog(null,"Nhap vao thang/nam muon tim: ", "Nhap");
            String arr[] = str1.split("/");
            int nam = Integer.parseInt(arr[1]);
            switch (arr[0]){
                case "1":
                case "Jan.":
                case "Jan":
                case "January":
                case "3":
                case "March":
                case "Mar.":
                case "Mar":
                case "5":
                case "May":
                case "7":
                case "July":
                case "Jul":
                case "8":
                case "August":
                case "Aug.":
                case "Aug":
                case "10":
                case "October":
                case "Oct.":
                case "Oct":
                case "12":
                case "December":
                case "Dec.":
                case "Dec":{
                    JOptionPane.showMessageDialog(null,"Thang nay co 31 ngay");
                    break loop;
                }
                case "4":
                case "April":
                case "Apr.":
                case "Apr":
                case "6":
                case "June":
                case "Jun":
                case "9":
                case "September":
                case "Sept.":
                case "Sep":
                case "11":
                case "November":
                case "Nov.":
                case "Nov":{
                    JOptionPane.showMessageDialog(null,"Thang nay co 30 ngay");
                    break loop;
                }
                case "2":
                case "February":
                case "Feb.":
                case "Feb":{
                    if (nam%400==0||(nam%4==0&&nam%100!=0)){
                        JOptionPane.showMessageDialog(null, "Thang nay co 29 ngay");
                    }
                    else JOptionPane.showMessageDialog(null, "Thang nay co 28 ngay");
                    break loop;
                }
                default:{
                    JOptionPane.showMessageDialog(null,"Nhap loi");
                    int option = JOptionPane.showConfirmDialog(null,"Ban co muon nhap lai khong?");
                    if (option == JOptionPane.YES_OPTION) continue;
                    else break loop;
                }
            }
        }
        while (true);
    }
}
