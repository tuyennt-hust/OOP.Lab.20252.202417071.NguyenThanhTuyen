import javax.swing.JOptionPane;
public class HptBac1 {
    public static void main(String[] args){
        //Nhap dữ liệu
        String str11 = JOptionPane.showInputDialog("Nhap a11: ");
        String str12 = JOptionPane.showInputDialog("Nhap a12: ");
        String str1  = JOptionPane.showInputDialog("Nhap b1: ");
        String str21 = JOptionPane.showInputDialog("Nhap a21: ");
        String str22 = JOptionPane.showInputDialog("Nhap a22: ");
        String str2  = JOptionPane.showInputDialog("Nhap b2: ");
        double a11 = Double.parseDouble(str11);
        double a12 = Double.parseDouble(str12);
        double b1  = Double.parseDouble(str1);
        double a21 = Double.parseDouble(str21);
        double a22 = Double.parseDouble(str22);
        double b2  = Double.parseDouble(str2);

        //tính định thức
        double D = a11*a22 - a12*a21;
        double D1 = b1*a22 - a12*b2;
        double D2 = a11*b2 - b1*a21;

        //Xét trường hợp
        if(D == 0){
            if(D1 == 0 && D2 == 0) JOptionPane.showMessageDialog(null, "He phuong trinh co vo so nghiem");
            else JOptionPane.showMessageDialog(null, "He phuong trinh vo nghiem");
        }
        else{
            double x = D1/D;
            double y = D2/D;
            JOptionPane.showMessageDialog(null, "He co nghiem duy nhat la x = " + x + " y = " +y);
        }
    }
}
