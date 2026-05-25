package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Testpolymorphism {
    public static void main(String[] args) {

        List<Media> mediae = new ArrayList<Media>();


        CompactDisc cd = new CompactDisc("Tiêu đề CD");
        DigitalVideoDisc dvd = new DigitalVideoDisc("Tiêu đề DVD");
        Book book = new Book("Tiêu đề Sách");
        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);
        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}