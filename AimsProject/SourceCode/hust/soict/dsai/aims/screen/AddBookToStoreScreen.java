package hust.soict.dsai.aims.screen;

import javax.swing.JLabel;
import javax.swing.JTextField;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
private JTextField tfTitle;
private JTextField tfCategory;
private JTextField tfCost;

public AddBookToStoreScreen(Store store, Cart cart) {
    super(store, cart);
    setTitle("Add Book to Store");
    
    centerPanel.add(new JLabel("Title: "));
    tfTitle = new JTextField(10);
    centerPanel.add(tfTitle);
    
    centerPanel.add(new JLabel("Category: "));
    tfCategory = new JTextField(10);
    centerPanel.add(tfCategory);
    
    centerPanel.add(new JLabel("Cost: "));
    tfCost = new JTextField(10);
    centerPanel.add(tfCost);
}

@Override
protected void addItem() {
    String title = tfTitle.getText();
    String category = tfCategory.getText();
    
    float cost = 0.0f;
    if (!tfCost.getText().isEmpty()) {
        cost = Float.parseFloat(tfCost.getText());
    }
    
    Book book = new Book(title, category, cost);
    store.addMedia(book);
}
}