package hust.soict.dsai.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.cart.Cart;

public class MediaStore extends JPanel {
private Media media;

public MediaStore(Media media, Cart cart) {
    this.media = media;
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    
    JLabel title = new JLabel(media.getTitle());
    title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
    title.setAlignmentX(CENTER_ALIGNMENT);
    
    JLabel cost = new JLabel("" + media.getCost() + " $");
    cost.setAlignmentX(CENTER_ALIGNMENT);
    
    JPanel container = new JPanel();
    container.setLayout(new FlowLayout(FlowLayout.CENTER));
    
    JButton btnAddToCart = new JButton("Add to cart");
    btnAddToCart.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                cart.addMedia(media);
                JOptionPane.showMessageDialog(null, media.getTitle() + " da duoc them vao gio.");
            } catch (hust.soict.dsai.aims.exception.LimitExceededException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Loi gio hang", JOptionPane.ERROR_MESSAGE);
            }
        }
    });
    container.add(btnAddToCart);
    
    if (media instanceof Playable) {
    	JButton btnPlay = new JButton("Play");
    	btnPlay.addActionListener(new ActionListener() {
    	@Override
    	public void actionPerformed(ActionEvent e) {
    	try {
    	((Playable) media).play();
    	} catch (hust.soict.dsai.aims.exception.PlayerException ex) {
    	JOptionPane.showMessageDialog(null, ex.getMessage(), "loi phat media", JOptionPane.ERROR_MESSAGE);
    	}
    	}
    	});
    	container.add(btnPlay);
    	}
    
    this.add(Box.createVerticalGlue());
    this.add(title);
    this.add(cost);
    this.add(Box.createVerticalGlue());
    this.add(container);
    
    this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
}
}