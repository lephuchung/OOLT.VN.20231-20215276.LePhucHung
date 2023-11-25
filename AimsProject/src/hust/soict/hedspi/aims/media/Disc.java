package AimsProject.src.hust.soict.hedspi.aims.media;

public class Disc extends Media {
    String director;
    int length;

    public Disc() {
    }

    public Disc(String director, String category, String title, float cost){
        super(title,category,cost);
        this.setDirector(director);
    }

    public Disc(String title, String category, String director, int length, float cost){
        this(director,category,title,cost);
        this.setLength(length);
    }

    public Disc(String director, int length) {
        super();
        this.setDirector(director);
        this.setLength(length);
    }

    public Disc(String title) {
        super(title);
    }

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

}