package AimsProject.src.hust.soict.hedspi.aims.media;

import AimsProject.src.hust.soict.hedspi.aims.exception.DataConstraintsException;
import AimsProject.src.hust.soict.hedspi.aims.exception.PlayerException;

import java.util.ArrayList;
//import hust.soict.dsai.aims.media.Track;

public class CompactDisc extends Disc implements Playable{

    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc(String title, String artist) {
        this(title);
        this.setArtist(artist);
    }


    public CompactDisc(String title){
        super(title);
    }

    public CompactDisc(String title, String category, float cost){
        this(title);
        this.setCategory(category);
        this.setCost(cost);
    }

    public CompactDisc(String director, String category, String title, float cost){
        this(category,title,cost);
        this.setDirector(director);
    }

    public void addTrack(Track newTrack) {
        if(this.tracks.contains(newTrack)) {
            System.out.println("Track already exists!");
            return ;
        }
        this.tracks.add(newTrack);
        System.out.println("Track is added!");
    }
    public void removeTrack(Track track) {
        if(this.tracks.contains(track)) {
            this.tracks.remove(track);
            System.out.println("Track is removed!");
            return ;
        }
        System.out.println("Track does not exist!");
    }

    @Override
    public int getLength() {
        int sum = 0;
        for(Track track: tracks) {
            sum += track.getLength();
        }
        return sum;
    }

    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
//	public ArrayList<Track> getTrack() {
//		return track;
//	}
//	public void setTrack(ArrayList<Track> track) {
//		this.track = track;
//	}
    public String[] play() throws PlayerException {
        if (this.getLength() > 0){
            System.out.println("CD contains " + this.tracks.size() + " tracks!");
            System.out.println("Tracks:");
            int i=0;
            for(Track track: tracks) {
                System.out.println(i++ + ". " + track.getTitle());
            }
            for(Track track: tracks) {
                track.play();
            }
            java.util.Iterator iterator = tracks.iterator();
            Track nextTrack;
            while (iterator.hasNext()) {
                nextTrack = (Track) iterator.next();
                nextTrack.play();
            }
        }
        else{
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
        return new String[0];
    }

    @Override
    public String toString() {
        return ("CD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + "$");
    }


}