package hust.soict.dsai.aims.cart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import hust.soict.dsai.aims.media.Media;

public class Cart {
private ObservableList itemsOrdered = FXCollections.observableArrayList();

public ObservableList<Media> getItemsOrdered() {
    return itemsOrdered;
}

public void addMedia(hust.soict.dsai.aims.media.Media m) throws hust.soict.dsai.aims.exception.LimitExceededException {
if (itemsOrdered.size() < 20) {
itemsOrdered.add(m);
System.out.println(m.getTitle() + " da duoc them vao gio.");
} else {
throw new hust.soict.dsai.aims.exception.LimitExceededException("ERROR: The number of media has reached its limit");
}
}

public void removeMedia(Media media) {
    if (itemsOrdered.contains(media)) {
        itemsOrdered.remove(media);
        System.out.println(media.getTitle() + " da bi xoa khoi gio hang.");
    } else {
        System.out.println("Khong tim thay " + media.getTitle() + " trong gio hang.");
    }
}

public float totalCost() {
    float total = 0;
    for (Media media : itemsOrdered) {
        total += media.getCost();
    }
    return total;
}

public void searchById(int id) {
    boolean found = false;
    for (Media media : itemsOrdered) {
        if (media.getId() == id) {
            System.out.println("Found: " + media.toString());
            found = true;
            break; 
        }
    }
    if (!found) {
        System.out.println("No match found for ID: " + id);
    }
}

public void searchByTitle(String title) {
    boolean found = false;
    for (Media media : itemsOrdered) {
        if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
            System.out.println("Found: " + media.toString());
            found = true;
        }
    }
    if (!found) {
        System.out.println("No match found for title: " + title);
    }
}

public void print() {
    System.out.println("***********************CART***********************");
    System.out.println("Ordered Items:");
    for (int i = 0; i < itemsOrdered.size(); i++) {
        System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
    }
    System.out.println("Total cost: " + totalCost() + " $");
    System.out.println("***************************************************");
}
}