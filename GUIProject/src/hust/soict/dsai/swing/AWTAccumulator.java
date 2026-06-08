package hust.soict.dsai.swing;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWTAccumulator extends Frame {
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0; // Accumulated sum, init to 0 [cite: 308, 309]

    // Constructor to setup the GUI components and event handlers [cite: 322]
    public AWTAccumulator() {
        setLayout(new GridLayout(2, 2)); [cite: 323]
        add(new Label("Enter an Integer: ")); [cite: 324]
        tfInput = new TextField(10); [cite: 325]
        add(tfInput); [cite: 326]
        tfInput.addActionListener(new TFInputListener()); [cite: 327]
        
        add(new Label("The Accumulated Sum is: ")); [cite: 328]
        tfOutput = new TextField(10); [cite: 331]
        tfOutput.setEditable(false); [cite: 333]
        add(tfOutput); [cite: 335]
        
        setTitle("AWT Accumulator"); [cite: 338]
        setSize(350, 120); [cite: 340]
        setVisible(true); [cite: 342]
    }

    public static void main(String[] args) {
        new AWTAccumulator(); [cite: 349]
    }

    private class TFInputListener implements ActionListener { [cite: 357]
        @Override
        public void actionPerformed(ActionEvent evt) { [cite: 358]
            int numberIn = Integer.parseInt(tfInput.getText()); [cite: 359]
            sum += numberIn; [cite: 361]
            tfInput.setText(""); [cite: 363]
            tfOutput.setText(sum + ""); [cite: 365]
        }
    }
}