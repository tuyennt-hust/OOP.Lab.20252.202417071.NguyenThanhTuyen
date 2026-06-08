package hust.soict.dsai.aims.screen;

import javax.swing.JLabel;
import javax.swing.JTextField;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
private JTextField tfTitle;
private JTextField tfCategory;
private JTextField tfDirector;
private JTextField tfLength;
private JTextField tfCost;

public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
    super(store, cart);
    setTitle("Add DVD to Store");
    
    centerPanel.add(new JLabel("Title: "));
    tfTitle = new JTextField(10);
    centerPanel.add(tfTitle);
    
    centerPanel.add(new JLabel("Category: "));
    tfCategory = new JTextField(10);
    centerPanel.add(tfCategory);
    
    centerPanel.add(new JLabel("Director: "));
    tfDirector = new JTextField(10);
    centerPanel.add(tfDirector);
    
    centerPanel.add(new JLabel("Length: "));
    tfLength = new JTextField(10);
    centerPanel.add(tfLength);
    
    centerPanel.add(new JLabel("Cost: "));
    tfCost = new JTextField(10);
    centerPanel.add(tfCost);
}

@Override
protected void addItem() {
    String title = tfTitle.getText();
    String category = tfCategory.getText();
    String director = tfDirector.getText();
    
    int length = 0;
    if (!tfLength.getText().isEmpty()) {
        length = Integer.parseInt(tfLength.getText());
    }
    
    float cost = 0.0f;
    if (!tfCost.getText().isEmpty()) {
        cost = Float.parseFloat(tfCost.getText());
    }
    
    DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
    store.addMedia(dvd);
}
}