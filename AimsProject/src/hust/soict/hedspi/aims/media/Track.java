package AimsProject.src.hust.soict.hedspi.aims.media;

public class Track{

    private String title;
    private int length;
    public Track() {
        // TODO Auto-generated constructor stub
    }
    public Track(String title, int length) {
        this.setLength(length);
        this.setTitle(title);
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

}
