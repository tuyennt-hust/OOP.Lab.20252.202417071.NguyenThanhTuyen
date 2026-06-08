
package hust.soict.dsai.aims.screen;

import javax.swing.JLabel;
import javax.swing.JTextField;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
private JTextField tfTitle;
private JTextField tfCategory;
private JTextField tfDirector;
private JTextField tfLength;
private JTextField tfCost;
private JTextField tfArtist;

public AddCompactDiscToStoreScreen(Store store, Cart cart) {
    super(store, cart);
    setTitle("Add CD to Store");
    
    centerPanel.add(new JLabel("Title: "));
    tfTitle = new JTextField(10);
    centerPanel.add(tfTitle);
    
    centerPanel.add(new JLabel("Category: "));
    tfCategory = new JTextField(10);
    centerPanel.add(tfCategory);
    
    centerPanel.add(new JLabel("Director: "));
    tfDirector = new JTextField(10);
    centerPanel.add(tfDirector);
    
    centerPanel.add(new JLabel("Artist: "));
    tfArtist = new JTextField(10);
    centerPanel.add(tfArtist);
    
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
    String artist = tfArtist.getText();
    
    int length = 0;
    if (!tfLength.getText().isEmpty()) {
        length = Integer.parseInt(tfLength.getText());
    }
    
    float cost = 0.0f;
    if (!tfCost.getText().isEmpty()) {
        cost = Float.parseFloat(tfCost.getText());
    }
    
    CompactDisc cd = new CompactDisc(title, category, director, artist, cost);
    store.addMedia(cd);
}
}