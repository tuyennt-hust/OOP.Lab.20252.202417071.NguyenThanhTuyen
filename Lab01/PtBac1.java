import javax.swing.JOptionPane;

public class PtBac1 {
    public static void main(String[] args){
        String str1 = JOptionPane.showInputDialog("Nhap a: ");
        String str2 = JOptionPane.showInputDialog("Nhap b: ");

        double a = Double.parseDouble(str1);
        double b = Double.parseDouble(str2);

        if(a == 0){
            if(b == 0) JOptionPane.showMessageDialog(null, "Phuong trinh vo so nghiem");
            else JOptionPane.showMessageDialog(null, "Phuong trinh vo nghiem");
        }

        else{
            double x = -b/a;
            JOptionPane.showMessageDialog(null, "Nghiem cua phuong trinh la: "+ x);
        }
    }
}
