package hust.soict.dsai.swing;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SwingAccumulator extends JFrame {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0; // Accumulated sum, init to 0 [cite: 397, 398]

    // Constructor to setup the GUI components and event handlers [cite: 404]
    public SwingAccumulator() {
        Container cp = getContentPane(); [cite: 405]
        cp.setLayout(new GridLayout(2, 2)); [cite: 406]
        
        cp.add(new JLabel("Enter an Integer: ")); [cite: 409]
        tfInput = new JTextField(10); [cite: 412]
        cp.add(tfInput); [cite: 414]
        tfInput.addActionListener(new TFInputListener()); [cite: 416]
        
        cp.add(new JLabel("The Accumulated Sum is: ")); [cite: 419]
        tfOutput = new JTextField(10); [cite: 422]
        tfOutput.setEditable(false); [cite: 424]
        cp.add(tfOutput); [cite: 433]
        
        setTitle("Swing Accumulator"); [cite: 434]
        setSize(350, 120); [cite: 435]
        setVisible(true); [cite: 436]
    }

    public static void main(String[] args) {
        new SwingAccumulator(); [cite: 439]
    }

    private class TFInputListener implements ActionListener { [cite: 450]
        @Override
        public void actionPerformed(ActionEvent evt) { [cite: 451]
            int numberIn = Integer.parseInt(tfInput.getText()); [cite: 452]
            sum += numberIn; [cite: 453]
            tfInput.setText(""); [cite: 454]
            tfOutput.setText(sum + ""); [cite: 455]
        }
    }
}