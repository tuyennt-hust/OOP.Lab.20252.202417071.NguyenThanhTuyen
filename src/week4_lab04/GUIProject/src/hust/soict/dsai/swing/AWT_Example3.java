package hust.soict.dsai.swing; // Thêm dòng này

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWT_Example3 {
    public static void main(String[] args) {
        Frame frame = new Frame("OOP class - Lab04");
        Label label = new Label("AWT Example");
        Button button = new Button("Submit");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Button Clicked!");
            }
        });

        frame.setLayout(new FlowLayout());
        frame.add(label);
        frame.add(button);
        frame.setSize(500, 300);
        frame.setVisible(true);
    }
}