package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors; 
    

    private static int nbBooks = 0;


    public Book(String title) {
        super(++nbBooks, title, null, 0.0f);
        this.authors = new ArrayList<String>(); 
    }


    public Book(String title, String category, float cost) {
        super(++nbBooks, title, category, cost);
        this.authors = new ArrayList<String>();
    }


    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Đã thêm tác giả: " + authorName);
        } else {
            System.out.println("Tác giả " + authorName + " đã tồn tại trong danh sách!");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Đã xóa tác giả: " + authorName);
        } else {
            System.out.println("Không tìm thấy tác giả " + authorName + " trong danh sách!");
        }
    }
    public String toString() {
        return "Book - " + this.getTitle() + " - " + this.getCategory() + " - " 
               + this.authors + ": " + this.getCost() + " $";
    }
}