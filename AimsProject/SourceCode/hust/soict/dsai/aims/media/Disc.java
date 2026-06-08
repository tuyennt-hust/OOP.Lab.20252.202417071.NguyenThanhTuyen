package hust.soict.dsai.aims.media;

public abstract class Disc extends Media {
    private int length;
    private String director;


    public Disc() {
        super();
    }


    public Disc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, cost); // Đẩy 4 thuộc tính định danh lên lớp cha Media
        this.director = director;
        this.length = length;
    }


    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
    

}