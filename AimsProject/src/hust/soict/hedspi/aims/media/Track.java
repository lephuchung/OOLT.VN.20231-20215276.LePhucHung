package AimsProject.src.hust.soict.hedspi.aims.media;

public class Track implements Playable{

    private String title;
    private int length;
    public Track() {
        // TODO Auto-generated constructor stub
    }
    public Track(String title, int length) {
        this.setLength(length);
        this.setTitle(title);
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Track) {
            Track track = (Track) obj;
            if ((title == track.getTitle()) && (length == track.getLength())) {
                return true;
            }
        }
        return false;
    }


}
