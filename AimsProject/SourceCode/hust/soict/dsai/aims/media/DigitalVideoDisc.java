package hust.soict.dsai.aims.media;
import hust.soict.dsai.aims.exception.PlayerException;
public class DigitalVideoDisc extends Disc implements Playable {

    private static int nbDigitalVideoDiscs = 0; 

    public DigitalVideoDisc(String title) {
        super(++nbDigitalVideoDiscs, title, null, null, 0, 0.0f);
    }
    
    public DigitalVideoDisc(String category, String title, float cost) {
        super(++nbDigitalVideoDiscs, title, category, null, 0, cost);
    }
    
    public DigitalVideoDisc(String director, String category, String title, float cost) {
        super(++nbDigitalVideoDiscs, title, category, director, 0, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(++nbDigitalVideoDiscs, title, category, director, length, cost);
    }

    public boolean isMatch(String title) {
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }
    
   public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
  }

    public String toString() {
        return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " 
               + this.getDirector() + " - " + this.getLength() + " mins: " + this.getCost() + " $";
    }
}