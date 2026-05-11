import javax.swing.JOptionPane;
public class PtBac2 {
    public static void main(String[] args){
        
        //Nhap du lieu
        String str1 = JOptionPane.showInputDialog("Nhap a: ");
        String str2 = JOptionPane.showInputDialog("Nhap b: ");
        String str3 = JOptionPane.showInputDialog("Nhap c: ");

        double a = Double.parseDouble(str1);
        double b = Double.parseDouble(str2);
        double c = Double.parseDouble(str3);

        if(a == 0) JOptionPane.showMessageDialog(null, "Khong ton tai phuong trinh bac 2");
        else{
            double delta = b*b - 4*a*c;
            if(delta < 0) JOptionPane.showMessageDialog(null, "Phuong trinh vo nghiem");
            else if(delta == 0){
                double x = -b/(2*a);
                JOptionPane.showMessageDialog(null, "Phuong trinh co nghiem duy nhat la x = " +x);
            }
            else{
                double x1 = (-b - Math.sqrt(delta))/(2*a);
                double x2 = (-b + Math.sqrt(delta))/(2*a);
                JOptionPane.showMessageDialog(null, "Phuong trinh co 2 nghiem phan biet x1 = " + x1 + "x2 = " + x2);
            }
        }
    }
}
