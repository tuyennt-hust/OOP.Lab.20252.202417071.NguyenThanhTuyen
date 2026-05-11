import javax.swing.JOptionPane;

public class CalculateTwoNumbers {
    public static void main(String[] args){

        // Nhập dữ liệu dạng String
        String str1 = JOptionPane.showInputDialog("Nhap so thu nhat:");
        String str2 = JOptionPane.showInputDialog("Nhap so thu hai:");

        // Chuyển sang double
        double a1 = Double.parseDouble(str1);
        double a2 = Double.parseDouble(str2);

        // Tính toán
        double tong = a1 + a2;
        double hieu = a1 - a2;
        double tich = a1 * a2;

        // Hiển thị kết quả
        JOptionPane.showMessageDialog(null, "Tong: " + tong);
        JOptionPane.showMessageDialog(null, "Hieu: " + hieu);
        JOptionPane.showMessageDialog(null, "Tich: " + tich);

        // Tính thương
        if(a2 != 0){
            double thuong = a1 / a2;
            JOptionPane.showMessageDialog(null, "Thuong: " + thuong);
        } else {
            JOptionPane.showMessageDialog(null, "Khong chia duoc cho 0");
        }
    }
}