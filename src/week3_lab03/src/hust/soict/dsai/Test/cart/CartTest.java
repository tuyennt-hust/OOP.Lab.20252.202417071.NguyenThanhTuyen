package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();
        
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);
        
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);
        
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        cart.addMedia(dvd3);
        
        System.out.println("\n--- Testing Print Method ---");
        cart.print();
        
        System.out.println("\n--- Testing Search Methods ---");
        System.out.println("Search by ID 1:");
        cart.searchById(1);
        
        System.out.println("Search by ID 99:");
        cart.searchById(99);
        
        System.out.println("\nSearch by Title 'Star Wars':");
        cart.searchByTitle("Star Wars");
        
        System.out.println("Search by Title 'Titanic':");
        cart.searchByTitle("Titanic");
    }
    public void sortByTitle() {
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Giỏ hàng đã được sắp xếp theo Title - Cost.");
    }

    public void sortByCost() {
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Giỏ hàng đã được sắp xếp theo Cost - Title.");
    }

}