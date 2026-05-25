package hust.soict.dsai.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberGrid extends JFrame {

    private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete, btnReset;
    private JTextField tfDisplay;

    public NumberGrid() {

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        tfDisplay = new JTextField("0");
        cp.add(tfDisplay, BorderLayout.NORTH);

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(4, 3));

        ButtonListener listener = new ButtonListener();

        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton(i + "");
            panelButtons.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(listener);
        }

        btnReset = new JButton("C");
        panelButtons.add(btnReset);
        btnReset.addActionListener(listener);

        btnNumbers[0] = new JButton("0");
        panelButtons.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(listener);

        btnDelete = new JButton("DEL");
        panelButtons.add(btnDelete);
        btnDelete.addActionListener(listener);

        cp.add(panelButtons, BorderLayout.CENTER);

        setTitle("Number Grid");
        setSize(300, 400);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent evt) {

            JButton source = (JButton) evt.getSource();

            for (int i = 0; i <= 9; i++) {
                if (source == btnNumbers[i]) {

                    if (tfDisplay.getText().equals("0")) {
                        tfDisplay.setText(i + "");
                    } else {
                        tfDisplay.setText(tfDisplay.getText() + i);
                    }
                }
            }

            if (source == btnDelete) {

                String current = tfDisplay.getText();

                if (current.length() > 1) {
                    tfDisplay.setText(
                            current.substring(0, current.length() - 1)
                    );
                } else {
                    tfDisplay.setText("0");
                }
            }

            if (source == btnReset) {
                tfDisplay.setText("0");
            }
        }
    }

    public static void main(String[] args) {
        new NumberGrid();
    }
}