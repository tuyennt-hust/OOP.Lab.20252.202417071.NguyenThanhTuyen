package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Aims {
private static Store store = new Store();
private static Cart cart = new Cart();
private static Scanner scanner = new Scanner(System.in);

public static void main(String[] args) {

    initSampleData();

    int choice;
    while (true) {
        showMenu();
        choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
                viewStore();
                break;
            case 2:
                updateStore();
                break;
            case 3:
                viewCart();
                break;
            case 0:
                System.out.println("Cảm ơn bạn đã sử dụng AIMS. Tạm biệt!");
                System.exit(0);
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
        }
    }
}


private static void initSampleData() {
    store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
    store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f));
    store.addMedia(new Book("Java Programming", "Education", 29.99f));
    
    CompactDisc cd = new CompactDisc("Chopin Nocturnes", "Music", "Classical", "Rubinstein", 15.0f);
    cd.addTrack(new Track("Nocturne Op.9 No.1", 5));
    cd.addTrack(new Track("Nocturne Op.9 No.2", 4));
    store.addMedia(cd);
}


public static void showMenu() {
    System.out.println("\nAIMS: ");
    System.out.println("--------------------------------");
    System.out.println("1. View store");
    System.out.println("2. Update store");
    System.out.println("3. See current cart");
    System.out.println("0. Exit");
    System.out.println("--------------------------------");
    System.out.print("Please choose a number: 0-1-2-3: ");
}


private static void viewStore() {
    System.out.println("\n--- ITEMS IN STORE ---");

    int choice;
    while (true) {
        storeMenu();
        choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1: 
                seeMediaDetails();
                break;
            case 2: 
                addMediaToCart();
                break;
            case 3: 
                playMediaStore();
                break;
            case 0: 
                return;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }
    }
}

public static void storeMenu() {
    System.out.println("\nOptions: ");
    System.out.println("--------------------------------");
    System.out.println("1. See media details");
    System.out.println("2. Add a media to cart");
    System.out.println("3. Play a media");
    System.out.println("0. Back");
    System.out.println("--------------------------------");
    System.out.print("Please choose a number: 0-1-2-3: ");
}

private static void seeMediaDetails() {
    System.out.print("Nhập tiêu đề sản phẩm muốn xem: ");
    String title = scanner.nextLine();
}

private static void addMediaToCart() {
    System.out.print("Nhập tiêu đề sản phẩm muốn thêm vào giỏ: ");
    String title = scanner.nextLine();

}

private static void playMediaStore() {
    System.out.print("Nhập tiêu đề sản phẩm muốn phát: ");
    String title = scanner.nextLine();
    
    for (Media m : store.getItemsInStore()) {
        if (m.getTitle().equalsIgnoreCase(title)) {
            if (m instanceof Playable) {
                try {
                    ((Playable) m).play();
                } catch (PlayerException e) {
                    System.err.println(e.toString());
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi phát Media", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                System.out.println("Sản phẩm này không hỗ trợ phát nhạc/video.");
            }
            return;
        }
    }
    System.out.println("Không tìm thấy sản phẩm trong cửa hàng.");
}

private static void updateStore() {
    System.out.println("\n--- UPDATE STORE ---");
    System.out.println("1. Add a media to store");
    System.out.println("2. Remove a media from store");
    System.out.println("0. Back");
    System.out.print("Your choice: ");
    int choice = scanner.nextInt();
    scanner.nextLine();
    
    if (choice == 1) {
        System.out.print("Nhập tiêu đề mặt hàng mới: ");
        String title = scanner.nextLine();
        store.addMedia(new Book(title, "General", 0.0f)); 
        System.out.println("Đã thêm vào cửa hàng.");
    } else if (choice == 2) {
        System.out.print("Nhập tiêu đề mặt hàng muốn xóa: ");
        String title = scanner.nextLine();

    }
}

private static void viewCart() {
    System.out.println("\n--- CURRENT CART ---");
    cart.print(); 

    int choice;
    while (true) {
        cartMenu();
        choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1: 
                System.out.println("Tính năng lọc đang được phát triển...");
                break;
            case 2:
                sortCartMenu();
                break;
            case 3: 
                System.out.print("Nhập tiêu đề muốn xóa khỏi giỏ: ");
                String title = scanner.nextLine();
                break;
            case 4: 
                System.out.print("Nhập tiêu đề muốn phát nhạc: ");
                String playTitle = scanner.nextLine();
                break;
            case 5: 
                System.out.println("Đơn hàng đã được đặt thành công! Giỏ hàng đã được làm trống.");
                cart = new Cart(); 
                return;
            case 0: 
                return;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }
    }
}

public static void cartMenu() {
    System.out.println("\nOptions: ");
    System.out.println("--------------------------------");
    System.out.println("1. Filter medias in cart");
    System.out.println("2. Sort medias in cart");
    System.out.println("3. Remove media from cart");
    System.out.println("4. Play a media");
    System.out.println("5. Place order");
    System.out.println("0. Back");
    System.out.println("--------------------------------");
    System.out.print("Please choose a number: 0-1-2-3-4-5: ");
}

private static void sortCartMenu() {
    System.out.println("1. Sort by Title - Cost");
    System.out.println("2. Sort by Cost - Title");
    System.out.print("Chọn kiểu sắp xếp: ");
    int type = scanner.nextInt();
    scanner.nextLine();
    if (type == 1) {
        cart.sortByTitle(); 
    } else if (type == 2) {
        cart.sortByCost();  
    }
    cart.print();
}
}