package AimsProject.src.hust.soict.hedspi.aims.media;

import AimsProject.src.hust.soict.hedspi.aims.exception.DataConstraintsException;
import AimsProject.src.hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

    private static int nbDigitalVideoDiscs=0;
    private String director;

    // Constructor

    public DigitalVideoDisc(String title) {
        super();
        this.title = title;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, float cost) throws DataConstraintsException {
        this(title);
        this.setCategory(category);
        this.setCost(cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // Getters and Setter

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String[] play() throws PlayerException {
        if (this.getLength() < 0) {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        } else {
            String str = "";
            str+="The total length of the DVD to add is: " + getLength();
            str+="/n";
            str+="Playing DVD: " + this.getTitle();
            str+="/n";
            str+="DVD length: " + getLength();
            return str.split("/n");
        }
    }

    @Override
    public String toString(){
        return ("DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + "$");
    }

}
