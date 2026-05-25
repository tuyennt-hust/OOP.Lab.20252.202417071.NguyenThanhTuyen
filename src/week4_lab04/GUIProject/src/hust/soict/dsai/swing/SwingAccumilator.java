package hust.soict.dsai.swing;

import javax.swing.*;     // Để dùng JFrame, JTextField, JLabel
import java.awt.*;       // Để dùng Container, GridLayout
import java.awt.event.*; // Để dùng ActionListener và ActionEvent
public class SwingAccumilator extends JFrame{
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0;

    public SwingAccumilator(){
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2));

        cp.add(new JLabel("Enter an Interger: "));

        tfInput = new JTextField(10);
        cp.add(tfInput);
        tfInput.addActionListener(new TFInputListener());

        cp.add(new JLabel("The Accimulated Sum is: "));

        tfOutput = new JTextField(10);
        tfOutput.setEditable(false);
        cp.add(tfOutput);

        setTitle("Swing Accumulator");
        setSize(350, 120);
        setVisible(true);
    }

    public static void main(String[] args){
        new SwingAccumilator();
    }

    private class TFInputListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;
            tfInput.setText("");
            tfOutput.setText(sum +"");
        }
    }
}