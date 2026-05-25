package hust.soict.dsai.swing;

import java.awt.*;
import java.awt.event.*;
public class AWTExample extends Frame {
   public AWTExample() {
       Label label = new Label("This is AWT");
       Button button = new Button("Click Me");
       setLayout(new FlowLayout());
       add(label);
       add(button);
       button.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               label.setText("AWT Button Clicked!");
           }
       });
       setTitle("AWT Example");
       setSize(300, 150);
       setVisible(true);
       addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent e) {
               dispose();
           }
       });
   }
   public static void main(String[] args) {
       new AWTExample();
   }
}