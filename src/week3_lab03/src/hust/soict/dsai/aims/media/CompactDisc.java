package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks; 
    

    private static int nbCompactDiscs = 0; 


    public CompactDisc(String title) {
        super(++nbCompactDiscs, title, null, null, 0, 0.0f);
        this.tracks = new ArrayList<Track>(); 
    }


    public CompactDisc(String title, String category, String artist, float cost) {
        super(++nbCompactDiscs, title, category, null, 0, cost);
        this.artist = artist;
        this.tracks = new ArrayList<Track>();
    }


    public CompactDisc(String title, String category, String director, String artist, float cost) {
        super(++nbCompactDiscs, title, category, director, 0, cost);
        this.artist = artist;
        this.tracks = new ArrayList<Track>();
    }


    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Đã thêm track: " + track.getTitle());
        } else {
            System.out.println("Track " + track.getTitle() + " đã tồn tại trong CD!");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Đã xóa track: " + track.getTitle());
        } else {
            System.out.println("Không tìm thấy track " + track.getTitle() + " trong CD!");
        }
    }


    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength; 
    }


    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        System.out.println("===============================");
        for (Track track : tracks) {
            track.play(); 
        }
    }
    public String toString() {
        return "CD - " + this.getTitle() + " - " + this.getCategory() + " - " 
               + this.getArtist() + " - " + this.getLength() + " mins: " + this.getCost() + " $";
    }
}