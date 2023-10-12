package week1;

import javax.swing.*;

public class ProgramToSolve {
    public static void main(String[] args) {
        // Giai phuong trinh bac nhat
        JOptionPane.showMessageDialog(null, "Giai phuong trinh bac nhat: ax+b=0");
        String str1 = JOptionPane.showInputDialog(null,"Pleas input the a number: ","Input the a number",JOptionPane.INFORMATION_MESSAGE);
        String str2 = JOptionPane.showInputDialog(null,"Pleas input the b number: ","Input the b number",JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(str1);
        double b = Double.parseDouble(str2);
        if (a == 0){
            if (b == 0) JOptionPane.showMessageDialog(null,"Phuong trinh vo so nghiem");
            else JOptionPane.showMessageDialog(null,"Phuong trinh vo nghiem");
        }
        else JOptionPane.showMessageDialog(null,"Nghiem cua phuong trinh la: "+(-b/a));
        // Giai he phuong trinh bac nhat hai an
        JOptionPane.showMessageDialog(null, "Giai he phuong trinh bac nhat: \n a*x1 + b*x2 = e \n c*x1 + d*x2 = f");
        String str21 = JOptionPane.showInputDialog(null,"Pleas input the a number: ","Input the a number",JOptionPane.INFORMATION_MESSAGE);
        String str22 = JOptionPane.showInputDialog(null,"Pleas input the b number: ","Input the b number",JOptionPane.INFORMATION_MESSAGE);
        String str23 = JOptionPane.showInputDialog(null,"Pleas input the e number: ","Input the e number",JOptionPane.INFORMATION_MESSAGE);
        double a2 = Double.parseDouble(str21);
        double b2 = Double.parseDouble(str22);
        double e2 = Double.parseDouble(str23);
        String str24 = JOptionPane.showInputDialog(null,"Pleas input the c number: ","Input the c number",JOptionPane.INFORMATION_MESSAGE);
        String str25 = JOptionPane.showInputDialog(null,"Pleas input the d number: ","Input the d number",JOptionPane.INFORMATION_MESSAGE);
        String str26 = JOptionPane.showInputDialog(null,"Pleas input the f number: ","Input the f number",JOptionPane.INFORMATION_MESSAGE);
        double c2 = Double.parseDouble(str24);
        double d2 = Double.parseDouble(str25);
        double f2 = Double.parseDouble(str26);
        double x21 = (e2*d2-b2*f2)/(a2*d2-b2*c2);
        double x22 = (a2*f2-e2*c2)/(a2*d2-b2*c2);
        JOptionPane.showMessageDialog(null, "He co nghiem (x1;x2) la ("+x21+";"+x22+")");
        // Giai phuong trinh bac hai
        JOptionPane.showMessageDialog(null, "Giai phuong trinh bac hai: ax^2+bx+c=0");
        String str31 = JOptionPane.showInputDialog(null,"Pleas input the a number: ","Input the a number",JOptionPane.INFORMATION_MESSAGE);
        String str32 = JOptionPane.showInputDialog(null,"Pleas input the b number: ","Input the b number",JOptionPane.INFORMATION_MESSAGE);
        String str33 = JOptionPane.showInputDialog(null,"Pleas input the c number: ","Input the c number",JOptionPane.INFORMATION_MESSAGE);
        double a3 = Double.parseDouble(str31);
        double b3 = Double.parseDouble(str32);
        double c3 = Double.parseDouble(str33);
        if (a3 == 0){
            JOptionPane.showMessageDialog(null, "Day khong phai phuong trinh bac hai");
        }
        else {
            double delta = b3*b3 - 4*a3*c3;
            if (delta > 0){
                JOptionPane.showMessageDialog(null, "Phuong trinh co 2 nghiem phan biet la: "+((-b3+Math.sqrt(delta))/(2*a3))+" va "+((-b3-Math.sqrt(delta))/(2*a3)));
            }
            else if (delta == 0){
                JOptionPane.showMessageDialog(null, "Phuong trinh co nghiem kep la: "+((-b3)/(2*a3)));
            }
            else JOptionPane.showMessageDialog(null, "Phuong trinh vo nghiem");
        }
    }
}
